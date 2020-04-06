/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package Players;

import Cards.UNOCard;
import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public abstract class Player 
{
    //for this, we will just store their names
    private String playerID; //the unique ID for this player
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
    }
    /**
     * Constructor with no @params to call the class in order to create 
     * players.
     * Constructor allows to be used in the CreatePlayer class, so 
     * as GameStart class can call CreatePlayer class without initializer.
     * make 
     */
    

    
    
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    public abstract void addStack(ArrayList a);
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();
    
    //check if their cards stack is empty to declare them winner
    public abstract boolean noCards();
    
    //get a specific card and return the color
    public abstract String getCardColor(int index);
    //get a specific card and return the number of the card
    public abstract int getCardNumber(int index);
    //get a specific card and return its ability
    public abstract String getColorAbility(int index);
     public abstract String getCardAbility(int index);
    
    public abstract void removeCard(int index);
    
    
    public abstract ArrayList accessPlayerCards();
   
    /**
	 * 
	 * @param e
	 */
   public abstract void addCard(UNOCard e);
    

}