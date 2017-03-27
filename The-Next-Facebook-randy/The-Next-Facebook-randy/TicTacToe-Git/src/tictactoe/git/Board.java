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
public class Board extends Game{
    private int dim;
    private String[][] board;
    public Board(int rows, int columns){
        this.board = new String[rows][columns];
        
    }
    
    public void clearBoard(){
        //This loops through all of the rows
        for (int x = 0; x < board.length; x++){
            //This loops through all of the columns and sets all the values to null
            for (int y = 0; y < board[x].length; y++){
                board[x][y] = null;
            }
        }
    }
    public void initBoard() {
         for (int r = 0; r<this.board.length; r++){
            for (int c = 0; c<this.board[r].length; c++){
                board[r][c] = " ";
            }
        }      
    }
    public void drawBoard(){
        //loops through the board and prints all values to the console
        System.out.println();
        for (int r = 0; r<this.board.length; r++){
            System.out.print("|");
            for (int c = 0; c<this.board[r].length; c++){
                System.out.print(this.board[r][c]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public void markBoard(int row, int col, String symbol){
        if(this.board[row][col].equals(" ")) {
            this.board[row][col] = symbol;
        }
        else {
            System.out.println("Location occupied. Try again");
        }
    }
    

    
    public String[][] getBoard(){
        return this.board;
    }
}
