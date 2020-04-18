/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import Cards.UNOCard;
import java.util.ArrayList;

/**
 *
 * @author User
 * each player will also be given an array-List to store their cards
 */
public class PlayerProfile extends Player {
   // private String name;
    private ArrayList<UNOCard> playerHand;
    public PlayerProfile(String name){
        
        super(name);
        playerHand = new ArrayList();
    }

    /**
     *
     * @return cards of player
     */
    
    @Override
    public ArrayList accessPlayerCards(){
        return playerHand;
    }
    @Override
    public void addCard(UNOCard e){
        playerHand.add(e);
    }
   
    @Override
    public void removeCard(int index){
        playerHand.remove(playerHand.get(index));
    }
    
    @Override
    public void addStack(ArrayList a){
        if (a.size() == 4 || a.size() == 2){
        playerHand.addAll(a);
        }
        //
        else if (a.size() == 3 || a.size() == 5) {
            a.remove(0);
             playerHand.addAll(a);
        }
    }
    
    
    //Method used by players when they are done their turn
    @Override
    public void play() {
        System.out.println("Picking.......");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
    }

    @Override
    public boolean noCards() {
       if (playerHand.isEmpty()){
           return true;
           
       }
       else{
           return false;
       }
       
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * return color, if no color then it's wildcard, return null
     * @param index of array
     * @return 
     */
    @Override
    public String getCardColor(int index) {
        UNOCard card = playerHand.get(index);
        //if not wildcard, then return color
        if (!card.cardType().equals("wildcard")){
            return card.getColor();
        }else{
            return null;
        }

    }
/**
 * Return card number of a regular card
 * @param index
 * @return 0 if card has no number, that means it's a wildcard/ability
 */
    @Override
    public int getCardNumber(int index) {
        UNOCard card = playerHand.get(index);
        //if not wildcard, then return color
        if (card.cardType().equals("normal")){
            return card.getNumber();
        }else{
            return -1;
        }

    }
   /**
    * Return the ability of card
    * @param index
    * @return 
    */
    @Override
    public String getColorAbility(int index) {
       UNOCard card = playerHand.get(index);
        //if not wildcard, then return color
        if (card.cardType().equals("ability")){
            if (card.getAbility()!=null){//then an ability
                 return card.getColor();}
            else{//then it's a PICK-4 card
                return "black";
            }
        }else if (card.cardType().equals("normal")){
            return "normal";
        }
        else{//then wildcard
               return null; 
                }
        
            
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public String getCardAbility(int index){
         UNOCard card = playerHand.get(index);
          if (card.cardType().equals("ability")){
            if (card.getAbility()!=null){//then an ability
                 return card.getAbility();}
            else{//then it's a PICK-4 card
                
                return card.getWildcard();
            }
        }else{
            return null;
        }
    }
   
    
    
}
