/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package Cards;

import java.util.ArrayList;
import java.util.List;


/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */

//COMPOSITION CLASS - because when called a stack of UNO cards are made 
// and assigned to each user in this class
public class CardsPerPlayer 
{
   
    
    private final int size;//number of cards for each player
    
   
    
    private final StackOfUnoCards stack;// represents class which has bunch of cards.
    private final int playerTotal; // number of playerd
    
    private final ArrayList allCards;
    
   /**
    * This class create a stack of uno cards.
     * @param playerTotal
     * @param size to show how much each user gets
    */
    public CardsPerPlayer(int playerTotal, int size)
    {
        this.playerTotal = playerTotal;
        this.size = size;
        stack = new StackOfUnoCards(size);
        allCards = new ArrayList();
       
        
        
        //give each player a hand based on size given
        
    
    }
    /**
     * Hand out each player a stack of UNOcards, it will return an 
     * array where the Game class will get this array and add the 
     * array to each players stash.
     * @return an arrayList that has a list of each person's cards
     * loop through each player and add cards to array for them
     */
    public ArrayList HandCards(){
        for (int i=0; i<playerTotal;i++){
            allCards.add(stack.assignCardsToPlayer()); // give stack to player 
            
            
        }
        return allCards;
    };
    
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */ 
    public ArrayList<Card> showCards()
    {
        return stack.getStack();
    }
    //return arraylist of cards played, will be used to return back to stack when run out
    public ArrayList storeCardsPlayed(){
        return stack.getCardsPlayed();
    }
    //after user picked 2/4, clear arraylist so as to use it later
    public void clearCards(){
        stack.clearGenerator();
    }
    //generate 2 
    public ArrayList pick2(){
       return stack.generate2();
    }
   
    //generate 4
    public ArrayList pick4(){
        return stack.generate4();
    }
    //pick one card from stack s
    public ArrayList pick1(){
        return stack.generateOne();
    }
    
    //take back played cards to stack
    public void returnPlayed(){
        stack.returnToStack();
    }
    

  


    
}//end class
