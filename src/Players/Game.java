/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package Players;


import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public abstract class Game 
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    
    
    
    //attributes to stores previous card played by prevoius player
    //used to check if the current player card is valid
    private int oldNum = -1;
    private String oldColor;
  //  private String oldAbility;
    
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
    //the cardsize is the number of cards in the arraylist to give to playerToGive stack
    public void addPick2orPick4(ArrayList cardSize, int playerToGive){
        System.out.println(cardSize.size());
        this.players.get(playerToGive).addStack(cardSize);
        
        
    }
    //increase the card size of player by one
    public void givePlayerOneCard(ArrayList cardSize, int playerToGive){
        this.players.get(playerToGive).addStack(cardSize);
    }
    
    //reverse the order of game when reverse called
    public void reverseOrder(int currentPlayerIndex){
       ArrayList<Player> tempList = new ArrayList();
       int lastIndex = this.players.size()-1;
  
       if (currentPlayerIndex !=0 ){
           for (int i=currentPlayerIndex-1; i>=0;i--){
           tempList.add(this.players.get(i));
       }
       if (lastIndex == currentPlayerIndex){
           tempList.add(this.players.get(lastIndex));
       }
          
       }
       if (lastIndex != currentPlayerIndex ){
            for(int i = lastIndex; i>currentPlayerIndex-1;i--){
           tempList.add(this.players.get(i));
       }
       }
      
       this.players.clear();
       for (int i=0; i<tempList.size();i++){
           this.players.add(tempList.get(i));
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
    
   // Card game moves
    
    /**
     * Check the card type to determine move to make 
     * @param playerIndex
     * @param index 
     */
    public String checkCardType(int playerIndex,int index){
        //if null then it's wildcard
        if (players.get(playerIndex).getColorAbility(index) == null ){
            return "wildcard";
            //playWildCard();
        }//then the card is a normal card
        else if(players.get(playerIndex).getCardNumber(index) != -1 ){
           return "normal"; 
 
            
        }
        else{//then it's an ability card
            return "ability";
 
        }
        
        
    }
    
    public void playWildCard(String color){
        
        oldColor = color.toUpperCase();//because the answer is in lowercase
        
    }
    //return true if card played accepted
    public boolean playNormalCard(int num, String color){
     //color black represent pick 4 card and any card can be played
        if (num == oldNum || oldColor.equals("black")){ // then the new card played is valid
            //so number is valid and matches old one so replace it.//since same no need
           // oldNum = num;
           //but replace color
          

           oldColor = color;
           return true;
            
            
        }else if (color.equals(oldColor) || oldColor.equals("black"))//then new card matches old color, but replace number since new card has diff number
            
        {          
           

            oldNum = num;
            //remove the ability if there was
            //oldAbility=null;
            return true;
        }
        
        else{ //then card played is wrong
            return false;
           
        }
        
        
    }
    //return false if wrong ability card was played based on color
    public boolean playAbilityCard(String color){
        if (oldColor.equals(color)){ //ability cards only have to match colors
            //get rid of old num
            oldNum = -1;
            return true;
         }
        else if (color.equals("black")){//then its a pick 4
            oldNum=-1;
            oldColor="black";
            return true;
        }else if (oldColor.equals("black")){//another special card being played after
            oldNum=-1;
            oldColor = color;
            return true;
        }
        else{
            return false;
        }
                            
    }
    
    public void initiateFirstTime(int num, String color){
       //System.out.println("number---------"+num+"color----"+color);
        oldNum = num;
        oldColor = color;
        
    }
    
    // Remove card from specific player
    public void updatePlayerStack(int PlayerIndex, int cardIndex){
        
        players.get(PlayerIndex).removeCard(cardIndex);
        
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
     * @param player
     */
    public abstract void declareWinner(String player);

    

   
    
}//end class
