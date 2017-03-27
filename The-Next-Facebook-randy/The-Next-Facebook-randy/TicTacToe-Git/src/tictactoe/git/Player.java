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
public class Player {
    //instance variables
    private String name;
    private String symbol;
    
    public Player(String n, String s){
        name = n;
        symbol = s;
    }
    
    public String getName() {
        return this.name;
    }
    public String getSymbol() {
        return this.symbol;
    }    
}
