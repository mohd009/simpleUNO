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
    public void removeCard(UNOCard e){
        playerHand.remove(e);
    }
    
    @Override
    public void addStack(ArrayList a){
        playerHand = a;
    }
    
    
    //Method used by players when they are done their turn
    @Override
    public void play() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    
    }
    
    
}
