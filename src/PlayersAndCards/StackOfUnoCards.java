/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayersAndCards;

import java.util.ArrayList;


/**
 *4 wildcards
 *4 pick 4
 * 
 *4 pick 2
 *4 reverse
 *4 SKIP
 * @author User
 */


public  class StackOfUnoCards  {
    //The group of cards, stored in an ArrayList
    private final ArrayList <UNOCard> cards;
    private int size; // Size for number of cardsin game(60)
    private  final Integer [] number = {0,1,2,3,4,5,6,7,8,9};
    private final String [] colors = {"RED", "GREEN", "YELLOW", "BLUE"};
    private final String [] special = {"PICK-2","REVERSE","SKIP"};
    private final String [] wild = {"WILDCARD", "PICK-4"};    
    
    public StackOfUnoCards(){
       
        this.cards = new ArrayList();
        
        run();
     }
    
    
    // Make this method create stack of cards, and it's private becuase it 
    //can only be accessed from this class and it is run when initilaizor called 
    private void run(){
        for (Integer number1 : number) {
          
            for (String color : colors) {
                this.cards.add(new UNOCard(color, number1));
                
            }
        
        }
     
        //add special cards
        for (String color : colors) {
            for (String special1 : special) {
                this.cards.add(new UNOCard(color, special1));
            }
        }
        
        //add the wildcards
        for (int i=0; i<4;i++){
           
            this.cards.add(new UNOCard(wild[0]));// wildcard
            this.cards.add(new UNOCard(wild[1]));//pick 4
        }
        System.out.println("_______-----------------");
        System.out.println(this.cards);
    }
    
    /**
     * 
     * @return size of card stack
     */
    public int getSize(){
        size = cards.size();
        return size;
    }
    /**
     * 
     * @return Array-list of the stack of cards
     */
    public ArrayList getStack(){
        return this.cards ;
    }
    
    
    

   
    
}
