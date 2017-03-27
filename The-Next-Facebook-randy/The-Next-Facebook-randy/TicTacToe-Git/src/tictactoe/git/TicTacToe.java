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
    
    public TicTacToe(){
        super();
    }
    public void gameLoop() {
        while (!checkWinner(player1, player2)) {
            playerTurn(player1);
            gameBoard.drawBoard();
            playerTurn(player2);
            gameBoard.drawBoard();
        }
    }
    
    public void playerTurn(Player player) {
        System.out.println();
        System.out.println(player.getName() + ", Choose Row (1-3):");
        int row = scan.nextInt();
        System.out.println(player.getName() + ", Choose Column (1-3):");
        int column = scan.nextInt();
        gameBoard.markBoard(row, column, player.getSymbol());
    }
    
    public boolean checkWinner(Player player1, Player player2) {
        return false;
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
    
}
