/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CreatePlayers extends Player{
    private ArrayList<Player> gamePlayer;
    private int playerCount;
    public CreatePlayers(){
        super();
    }
    /**
     * When this method called, it will ask for user input.
     * User selects number of players in games. Max is 4.
     * A player is created and stored in Player class.
     */
    @Override
    public void play(){
        System.out.println("Welcome to the game");
        System.out.println("Enter the number of players playing");
        Scanner input = new Scanner(System.in); 
        playerCount = input.nextInt();
        checkValidity(playerCount);
        
        
    }
    public void addPlayer(int player){
        
    }
    
    /**
     * check if value entered is correct
     * @param i accept number of players
     */
    public void checkValidity(int i){
        while (!(i <=4 && i>=0)){
            Scanner tryAgain =  new Scanner(System.in); 
            checkValidity(tryAgain.nextInt());
        }
        
        
    }
    
    
}
