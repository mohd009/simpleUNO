/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Mohamed 
 */
public class gameView {
    public gameView(){
    
    }
    
    public int playerCount(String name){
        System.out.println("Welcome to the game: "+ name);
        System.out.print("Enter the number of players playing: ");
        Scanner input = new Scanner(System.in); 
        int playerCount = input.nextInt();
        return playerCount;
        
    }
    
    public String AskPlayerNames(int i){
         System.out.println("Enter player name");
         System.out.print("Player "+ (i+1) + " name: ");
         Scanner name = new Scanner(System.in);
         String name1  = name.nextLine();
         return name1;
         
    }
    
    public int numPlaying(){
            System.out.println("Game only allows maximum of 4 and minimum of 2");
            System.out.println("Try again");
            Scanner tryAgain =  new Scanner(System.in); 
            int playerCount = tryAgain.nextInt();
            return playerCount;
    }
    
    public String pickColor(){
         System.out.println("Choose color: red, blue, green, yellow");
         Scanner color = new Scanner(System.in);
         String colorChoice = color.nextLine();
         return colorChoice;
    }
    
    public String passPlay(){
        Scanner passOrplay = new Scanner(System.in);
         String ans = passOrplay.nextLine();
         return ans;
    }
    
    public String userPlayOrPick(){
       
       
        System.out.print("play or pick (card)");
        
        
        boolean input = false;
        
        while (input!=true){
            Scanner pick = new Scanner(System.in);
            String answer = pick.nextLine();
            if (answer.equals("pick")){
               //meaning user already picked card, won't be allowed to pick prompt
                     return "pick";
               
               
            
        }else if (answer.equals("play")){
          
                return "play";
            
        }else{
            // seeCards(); // make user see all cards in order to decide
             System.out.println("Invalid output--->Choose play or pick");
             //System.out.println("Look at Cards and decide");
             //seeCards();
          
             
        }
            
            
        }
        
        
       
        return null;
    }

public int chooseIndex(){
     Scanner user = new Scanner(System.in);
        int choice = Integer.parseInt(user.nextLine());
        return choice;
}
    public int tryAgain(){
           System.out.println("Invalid index, try again");
                  Scanner user = new Scanner(System.in);
                 int choice = Integer.parseInt(user.nextLine());
                 return choice;
}

 public boolean askToPlayAgain(){
        System.out.print("Want another game? y or n");
        Scanner s = new Scanner(System.in);
        String ans = s.nextLine();
        if (ans.equals("y")){
            return true;
            
        }else{
            System.out.println("BYEEEE!");
            return false;
        }
    }
}
    
