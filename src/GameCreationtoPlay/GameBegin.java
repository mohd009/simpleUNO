/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCreationtoPlay;


import GameControls.CreateGame;
import java.util.ArrayList;
import Players.Player;
import View.gameView;


/**
 *
 * @author User
 */
public class GameBegin {
    public static void main(String[] args) {
       CreateGame c = new CreateGame();
       c.instructions();
       c.play();
      
      //replay
      gameView v = new gameView();
      if (v.askToPlayAgain()){
          CreateGame again = new CreateGame();
          again.play();
      }
      else{
          System.out.println("Thanks for playing, please rate us..");
      }
        
      
       
        // cd.assignCards();         
         
         
         
         
         
        
        
        
    }
    
}
