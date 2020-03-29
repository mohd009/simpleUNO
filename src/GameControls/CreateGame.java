/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControls;

import Cards.CardsPerPlayer;
import Players.Game;

import java.util.Scanner;

/**
 *
 * @author Mohamed, player
 */
public class CreateGame extends Game{
  
   // private ArrayList<Player> gamePlayers; // store players in array
    private int playerCount; // used to check if number of players allowed in game valid.
    public CreateGame(){
        
        
       
        
        super("UNO-GAME");
   
       
    }
    /**
     * When this method called, it will ask for user input.
     * User selects number of players in games. Max is 4.
     * A player is created and stored in Player class.
     */
    
    // This mehod will check if count is valid then add players in arraylist
    @Override
    public void play(){
        System.out.println("Welcome to the game: "+ super.getGameName());
        System.out.print("Enter the number of players playing: ");
        Scanner input = new Scanner(System.in); 
        playerCount = input.nextInt();
        
        checkValidity(playerCount);
        
        
        
        
    }
    
    /**
     * Add players in an arraylist
     * @param playerSize total number of players
     */
    public void addPlayer(int playerSize){
        for (int i=0; i<playerSize;i++){
            System.out.println("Enter player name");
            System.out.print("Player "+ (i+1) + " name: ");
            Scanner name = new Scanner(System.in);
            // Create each player and add it to arraylist
            
           // GeneratePlayer player = new GeneratePlayer(name.nextLine());
           
            
        //Add the arraylist to the game
        while (!super.addplayersToGame(name.nextLine())){
            //Game officially starts
               System.out.println("Name currently in use");
            System.out.println("try again..");
            super.addplayersToGame(name.nextLine());
        }
     
    }
        //WHEN added players, start the logic of the game
        startGameLogic(super.getTotalPlayers());
        
    }
   
    
    /**
     * check if value entered is correct
     * @param i accept number of players
     */
    //use do while for enhanced
    public void checkValidity(int i){
        if (!(i <=4 && i>=1)){
            System.out.println("Game only allows maximum of 4 and minimum of 2");
            System.out.println("Try again");
            Scanner tryAgain =  new Scanner(System.in); 
            playerCount = tryAgain.nextInt();
            checkValidity(playerCount);
        
        }
       
        //if valid, then add player
        else{addPlayer(i);}
      
        
        
    }
    /**
     * Use play() method from player when a player is done their turn
     * Assign each player a stack of cards and controls for them 
     * p - pick card
     * n - go to next person after they pick and have none
     * players can see deck of other users but in format [*,*,*,*..] hidden
     * Use numbers on keyboard, to select the position of card to play
     * Card won't be played if choose wrong type
     * if play wildcard, prompt player to choose color
     * @param number of players in game
     */
    public void startGameLogic(int number){
        //add option for them to select the number of cards to
        // hand them each out
       
        CardsPerPlayer cards = new CardsPerPlayer(super.getTotalPlayers(),5);
        super.addCardsToPlayer(cards.HandCards());
        
    }
    
/**
 * Once done, game shows the winner
 */
    @Override
    public void declareWinner() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Used to ask user 
     * @return 
     */
    
    
    
    //now run method to give cards out
    
    
}
