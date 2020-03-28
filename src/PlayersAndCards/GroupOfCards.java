/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package PlayersAndCards;

import PlayersAndCards.Card;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //for this case, size will used for the number of cards user will 
    //want to play with, cards will be shuffled and number of cards 
    // given to each user will be the size
    private int size;//the size of the grouping
    
    private final ArrayList<UNOCard> perStack; //Each user will receive a stack once method called
    
    private final StackOfUnoCards stack;// represents class which has bunch of cards.
    
   /**
    * This class create a stack of uno cards.
     * @param size to show how much each user gets
    */
    public GroupOfCards(int size)
    {
        this.size = size;
        stack = new StackOfUnoCards();
        perStack = new ArrayList<>();
        //check size in control part
        
    
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */ 
    public ArrayList<Card> showCards()
    {
        return stack.getStack();
    }
    /**
     * Method to shuffle stack of cards before assigning to users
     * Private, because it will b shuffled when assigning cards to users
     */
    private void shuffle()
    {
        Collections.shuffle(stack.getStack());
        
    }
    
    
    /**
     * Assign each user the number of cards given after shuffling
     
     */
    public void assignCards(){
       
            shuffle();
            //perStack arrayList is given random cards since it's shuffled
            for (int i=1; i<=this.size;i++){
                perStack.add((UNOCard) stack.getStack().get(i));
            }
            System.out.println("Cards handed out.");
            System.out.println(perStack);
            
            
        
        
    }
       

    /**
     * @return the size of the group of cards
     */
    public int getSizeForUser() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    
    //Code commented out, because my game won't require user to set the size
   // public void setSize(int givenSize) {
  //      size = givenSize;
   // }
    
}//end class
