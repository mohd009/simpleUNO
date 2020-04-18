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
    
    public int checkInt(){
        int num=-1;
    
         Scanner input = new Scanner(System.in);
        boolean check =false;
         while (!(check)){
            if (!(input.hasNextInt())){
                System.out.println("Enter integer");
                input = new Scanner(System.in);
        }else{
                num = input.nextInt();
                check = true;
                }
    }
         return num;
    }
    
    public String checkString(){
         Scanner name = new Scanner(System.in);
         boolean check =false;
         String n  = "";
         while (!(check)){
            if ((name.hasNextInt())){
                System.out.println("Enter String");
                name = new Scanner(System.in);
        }else{
                n = name.nextLine();
                check = true;
                }
    } 
       return n;
    
    
    }
    public int playerCount(String name){
     //
    // int playerCount=-1;
     //   boolean check =false;
        System.out.println("Welcome to the game: "+ name);
        System.out.print("Enter the number of players playing: ");
       
       int playerCount = checkInt();
       return playerCount;
        
        
    }
    
    public String AskPlayerNames(int i){
        System.out.println("Enter player name");
         System.out.print("Player "+ (i+1) + " name: ");
        return checkString();
         
    }
    
    public int numPlaying(){
            System.out.println("Game only allows maximum of 4 and minimum of 2");
            System.out.println("Try again");
            return checkInt();
           
    }
    
    public String pickColor(){
        String c;
         System.out.println("Choose color: red, blue, green, yellow");
         Scanner color = new Scanner(System.in);
         
         while (!(color.hasNext("red")|| color.hasNext("blue")|| color.hasNext("green")|| color.hasNext("yellow"))){
              System.out.println("Enter a color: red or green or blue or yellow");
              color = new Scanner(System.in);
              
         }
         c = color.nextLine();
         return c;
         
         
    }
    
    public String passPlay(){
        String val;
        
        Scanner passOrplay = new Scanner(System.in);
         //String ans = passOrplay.nextLine();
        while (!(passOrplay.hasNext("pass")|| passOrplay.hasNext("play"))){
            System.out.println("pass OR play");
            passOrplay = new Scanner(System.in);
        } 
        val = passOrplay.nextLine();
         return val;
    }
    
    public String userPlayOrPick(){
       
       
        System.out.print("play or pick (card)");
       String val;
        
        Scanner p = new Scanner(System.in);
         //String ans = passOrplay.nextLine();
        while (!(p.hasNext("play") || p.hasNext("pick"))){
            System.out.println("Choose pick OR play");
            p = new Scanner(System.in);
        } 
        val = p.nextLine();
         return val;
    }
        
        
       
       
    

public int chooseIndex(){
    int choice = checkInt();
    
        return choice;
}
    public int tryAgain(){
           System.out.println("Invalid index, try again");
                  int ans = checkInt();
                  return ans;
}

 public boolean askToPlayAgain(){
        System.out.print("Want another game? y or n");
        Scanner s = new Scanner(System.in);
        String val;
        
        //Scanner passOrplay = new Scanner(System.in);
         //String ans = passOrplay.nextLine();
        while (!(s.hasNext("y")|| s.hasNext("n"))){
            System.out.println("Choose y or n");
            s = new Scanner(System.in);
        } 
        val = s.nextLine();
       
  
    
       
        if (val.equals("y")){
            return true;
            
        }else{
            System.out.println("BYEEEE!");
            return false;
        }
    }
 
 
   public void gameInstructions(){
       System.out.println("_-------Rules/notes of the game-------");
       System.out.println("When prompted, you'll always be given option, please choose");
       System.out.println("Game has a max of 4 players and a minimum of 2 players");
       System.out.println(" 1- When you are given a PICK 4/ PICK 2, your turn will be skipped");
       System.out.println("    The next player can play any card color");
       System.out.println("2- First player can't start with special card or wildcard, pick if you have no normal card");
       System.out.println("3- Winner declared once person has no cards remaining");
       System.out.println("4- If player picks a card, they can't pick and they'll be denied");
       System.out.println("You'll always be displayed how your cards look like when you pick a card");
       System.out.println("------And finally enjoy the game!!!!!-----------");
       
   }
}
    
