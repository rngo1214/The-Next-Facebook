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
    //instance variables
    Player player1;
    Player player2;
    Board gameBoard = new Board(3,3);
    boolean win;
    
    public TicTacToe(){
        super();
    }
    public void gameLoop() {
        while (win == false) {
            playerTurn(player1);         
            playerTurn(player2);
        }
    }
    
    public void playerTurn(Player player) {
        System.out.println();
        System.out.println(player.getName() + ", Choose Row (1-3):");
        int row = scan.nextInt() - 1;
        System.out.println(player.getName() + ", Choose Column (1-3):");
        int column = scan.nextInt() - 1;
        if (validInput(row) && validInput(column)) {
             markBoard(row, column, player);
        }
        else {
            System.out.println("Invalid input. Please retry:");
            playerTurn(player);
        }
        gameBoard.drawBoard();
        if (isWinner(player, row, column)) {
            System.out.println();
            win = true;
            endGame(player.getName());
        }
        
    }
    public boolean checkTie() {
        int x = 0;
        for (int i = 0; i < gameBoard.getBoard().length; i ++){
            for (int a = 0; a < gameBoard.getBoard()[i].length; a++) {
                if (!gameBoard.getBoard()[i][a].equals("")) {
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
}
