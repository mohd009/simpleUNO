/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package Players;

import Players.Player;
import java.util.ArrayList;
import Players.Player;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param p player to add
     * add iff the player is unique
     * modified this method to add players so as it can easily 
     * be accessed from the createGame class without calling Player class
     * @return true if success
     */
    public boolean addplayersToGame(String p) 
    {  
        
        PlayerProfile player = new PlayerProfile(p); 
        if (!checkDuplicate(player)){
            
        this.players.add(player);
        return true;
    }
        else{
            return false;
            
        }
    }
    /**
     * Add cards to player's profile arrayList
     * cards inside the inner arrayList
     * @param playerCards the arraylist holding the cards
     */
    public void addCardsToPlayer( ArrayList playerCards){
        for(int i=0; i<this.players.size();i++){
           
            
            this.players.get(i).addStack((ArrayList)playerCards.get(i));
        }
    }
    /**
     * Return the total number of players in game
     * @return  total players
     */
    public int getTotalPlayers(){
        return this.players.size();
    }
    /**
     * Check if duplicate players exist in array
     * @param given 
     * @return false if no duplicates
     */
    private boolean checkDuplicate(Player given){
        while ((this.players.contains(given))){
            System.out.println("Name exists, try another");
        }
        return false;
    }
    
  
   
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    
    //call this method when game starts, so make uno class(abstract) to call play
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();

    

   
    
}//end class
