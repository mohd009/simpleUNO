/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cards;

import Cards.Card;
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

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public String getAbility() {
        return ability;
    }

    public String getWildcard() {
        return wildcard;
    }
   
    
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
    //Initializes the wildcard that allows to pick any color ,pick 4 and colorpicker
     public UNOCard(String wildcard){
        this.wildcard= wildcard;
   
        
        
    }
    public String cardType(){
        if(ability == null && wildcard == null){
            return "normal";
        }
        else if( ability!=null){
        
            return "ability";
            
        }else{
            if (wildcard.equals("PICK-4")){
               return "ability";
            }
            else{
            return "wildcard";
            }
        }
    } 

    @Override
    public String toString() {
     
        if (ability == null && wildcard == null){
                return ("("+ color +" " + number+")");}
        else if ((wildcard == null)){ 
          return ("("+ color + " "+ability+")");
                }
        else{
                 return ("("+ wildcard+")");
        }
       
    }
    
    
    
    /**
     * When called this will create a stack of cards for the specific
     * color given 
     * @param color 
     */
    
}
