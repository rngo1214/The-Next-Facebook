/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.git;

import java.util.Scanner;
public class Game {
    Scanner scan = new Scanner(System.in);
    public void newGame(){
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
    public void startGame(String name){
        Player player1 = new Player(name, "X");
        Opponent player2 = new Opponent();
    }   
    
    public void startGame(String name, String name2){
        Player player1 = new Player(name, "X");
        Player player2 = new Player(name2, "O");
    }
    
    public void
        endGame(String name){
        System.out.println("Game over! The winner is: " + name);
        System.out.println("Play again? (Y/N)");
        String input = "";
        while (input.equals("")) {
            input = scan.nextLine();
            if (input.equals("Y")) {
                newGame();
                
            }
            else if (input.equals("N")){
                System.out.println("Thanks for playing!");
                
            }
        }
    }           

    public boolean validInput(int p){
        if (p <= 3 && p >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
