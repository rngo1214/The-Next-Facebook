/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.git;
/**
 *
 * @author 2006218
 */
public class TicTacToe extends Game{
    //instance variables, one for each potential player
    Player player1;
    Player player2;
    //utilizes board class
    Board gameBoard = new Board(3,3);
    //determines the state of the game, if it is completed and there is a winner or not
    boolean win;
    
    public TicTacToe(){
        super();
    }
    //this is the main loop, lets the players take their turns
    public void gameLoop() {
        while (win == false) {
            
            playerTurn(player1); 
            if (win == false){
                playerTurn(player2);
            }
        }
    }
    //all of the code for the player to take their turn
    public void playerTurn(Player player) {
        System.out.println();
        //takes in the player input for where they want to place their marker
        System.out.println(player.getName() + ", Choose Row (1-3):");
        int row = scan.nextInt() - 1; //subtracts one so the user input matches the array index
        System.out.println(player.getName() + ", Choose Column (1-3):");
        int column = scan.nextInt() - 1;
        if (validInput(row) && validInput(column)) {
            //checks to see if the user input a valid location before placing the marker
             markBoard(row, column, player);
        }
        else {
            //repeats the input recursively until the player inputs a valid location
            System.out.println("Invalid input. Please retry:");
            playerTurn(player);
        }
        //draws the board with the new marker in place
        gameBoard.drawBoard();
        if (isWinner(player, row, column)) {
            System.out.println();
            win = true;
            endGame(player.getName());
        }
        else {
            if (checkTie()) {
                //checks to see if all spaces on the board are full, then declares nobody as the winner
                endGame("Nobody");
            }
        }
        
    }
    public boolean checkTie() {
        int x = 0;
        for (int i = 0; i < gameBoard.getBoard().length; i ++){
            for (int a = 0; a < gameBoard.getBoard()[i].length; a++) {
                if (!gameBoard.getBoard()[i][a].equals(" ")) {
                    x++;
                }
            }
        }
        if (x == 9) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isWinner(Player player, int row, int col) {
        //String Player = gameBoard.getBoard()[row][col];
        int r = row;
        int c = col;

        boolean onDiagonal = (row == col) || (col == -1 * row + (gameBoard.getBoard().length-1));
        boolean HorizontalWin = true, VerticalWin = true;
        boolean DiagonalWinOne = true, DiagonalWinTwo = true;

        // Check the rows and columns
        for(int n = 0; n < gameBoard.getBoard().length; n++){
            if(!gameBoard.getBoard()[r][n].equals(player.getSymbol()))
                HorizontalWin = false;
            if(!gameBoard.getBoard()[n][c].equals(player.getSymbol()))
                VerticalWin = false;
        }

        // Only check diagonals if the move is on a diagonal
        if(onDiagonal){
            // Check the diagonals
            for(int n = 0; n < gameBoard.getBoard().length; n++){
                if(!gameBoard.getBoard()[n][n].equals(player.getSymbol()))
                    DiagonalWinOne = false;
                if(!gameBoard.getBoard()[n][-1*n+(gameBoard.getBoard().length-1)].equals(player.getSymbol()))
                    DiagonalWinTwo = false;
            }
        }
        else{
            DiagonalWinOne = false;
            DiagonalWinTwo = false;
        }
        
        boolean hasWon = (HorizontalWin || VerticalWin || DiagonalWinOne || DiagonalWinTwo);

        return hasWon;

    }
    
    public int numberPlayers() {
        System.out.println("1 or 2 players? (1/2)");
        return scan.nextInt();
    }
    
    public void startGame(String name){
        player1 = new Player(name, "X");
        player2 = new Opponent();
        gameBoard.drawBoard();
        gameLoop();
    }   
    
    public void startGame(String name, String name2){
        player1 = new Player(name, "X");
        player2 = new Player(name2, "O");
        gameBoard.initBoard();
        gameBoard.drawBoard();
        gameLoop();
    } 
    
    public void markBoard(int row, int col, Player player){
        if(gameBoard.getBoard()[row][col].equals(" ")) {
            gameBoard.getBoard()[row][col] = player.getSymbol();
        }
        else {
            System.out.println("Location occupied. Try again");
            playerTurn(player);
        }
    }
    
    public void newGame(){
        win = false;
        System.out.println("Players? (1/2)");
        int players = scan.nextInt();
        while (!validInput(players)){
            System.out.println("Please enter a valid input");
            players = scan.nextInt();
        }
        if (players == 1){
            System.out.println("Enter your name, Player 1");
            String playerName = scan.nextLine();
            startGame(playerName);
        }
        else if (players == 2){
            System.out.println("Enter your name, Player 1");
            String p1Name = "";
            while (p1Name.equals("")){
                p1Name = scan.nextLine(); //weird workaround
            }
            System.out.println("Enter your name, Player 2");
            String p2Name = scan.nextLine();
            startGame(p1Name, p2Name);
        }
    }     
}
