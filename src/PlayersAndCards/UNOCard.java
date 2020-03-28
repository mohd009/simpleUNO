/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayersAndCards;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class UNOCard extends Card {
    private String color;
    private int number;
    private String ability;
    private String wildcard;
   
    
   //initializes a normal card
    public UNOCard(String color, int number){
        this.color = color;
        this.number = number;
        
    }
    //Initializes card with ability 
    public UNOCard(String color, String ability){
        this.color = color;
        this.ability = ability;
  
        
    }
    //Initializes the wildcard that allows to pick any color
     public UNOCard(String wildcard){
        this.wildcard= wildcard;
   
        
        
    }

    @Override
    public String toString() {
     
        if (ability == null && wildcard == null){
                return ("Card: "+ color +" " + number);}
        else if ((wildcard == null)){ 
          return ("Card: "+ color + " "+ability);
                }
        else{
                 return ("Card: "+ wildcard);
        }
       
    }
    
    
    
    /**
     * When called this will create a stack of cards for the specific
     * color given 
     * @param color 
     */
    
}
