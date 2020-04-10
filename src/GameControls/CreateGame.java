/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControls;

import Cards.CardsPerPlayer;
import Players.Game;
import View.gameView;
import java.util.ArrayList;

import java.util.Scanner;

/**
 *
 * @author Mohamed, player
 */
public class CreateGame extends Game{
    
    private gameView view; //VIEW OF THE GAME
   // private ArrayList<Player> gamePlayers; // store players in array
    private int playerCount; // used to check if number of players allowed in game valid.
    private boolean firstTime = true; //to initiate starting card by user and determine if it's the first time playing
    private boolean correctCard =false;//determine if card picked is right or loop and ask
    private String previousAbility=null; //check if an ability was used before the next user round
    private boolean passNext = false; //used to determine if play wants to pass and doesn't have card after picking card
    private String input = null;//Store user input
    
    public CreateGame(){
     super("UNO-GAME");
         view = new gameView();
     
    }
    /**
     * When this method called, it will ask for user input.
     * User selects number of players in games. Max is 4.
     * A player is created and stored in Player class.
     */
    
    // This mehod will check if count is valid then add players in arraylist
    @Override
    public void play(){
        playerCount = view.playerCount(super.getGameName());
        checkValidity(playerCount);
        }
    
    /**
     * Add players in an arraylist
     * @param playerSize total number of players
     */
    public void addPlayer(int playerSize){
        for (int i=0; i<playerSize;i++){
            String name = view.AskPlayerNames(i);
            // Create each player and add it to arraylist
            
           // GeneratePlayer player = new GeneratePlayer(name.nextLine());
           
            
        //Add the arraylist to the game
        while (!super.addplayersToGame(name)){
            //Game officially starts
            System.out.println("Name currently in use");
            System.out.println("try again..");
            super.addplayersToGame(name);
        }
     
    }
        //WHEN added players, start the logic of the game
        startGameLogic(super.getTotalPlayers());
        
    }
   
    
    /**
     * check if value entered is correct
     * @param i accept number of players
     */
    //use do while for enhanced
    public void checkValidity(int i){
        if (!(i <=4 && i>1)){
           
            playerCount = view.numPlaying();
            checkValidity(playerCount);
        
        }
       
        //if valid, then add player
        else{addPlayer(i);}
      
        
        
    }

    public void startGameLogic(int number){
        //add option for them to select the number of cards to
        // hand them each out
        boolean gameDone=false;
        int thePlayers = super.getTotalPlayers();
        CardsPerPlayer cards = new CardsPerPlayer(thePlayers,5);
   
        //hand cards to players
       super.addCardsToPlayer(cards.HandCards());
     
   //loop through each players until game done
       while (!gameDone){
           //loop through each player array 
           for(int i=0;i<thePlayers;i++){
               seeCards();
               if (super.getPlayers().get(i).noCards()){
                   declareWinner(super.getPlayers().get(i).getPlayerID());
                   gameDone=true;
                   break;
               }
               //reset correct  card
               correctCard=false;
               int cardIndex;
               String card;
               
               System.out.println("--------------------------------------");
               System.out.println(super.getPlayers().get(i).getPlayerID()+" turn: ");
                   
                   
               if (firstTime){ //for first time player to initiate starting card
                   firstTimePlay();
                   cardIndex=PickCardToPlay(super.getPlayers().get(i).accessPlayerCards(),super.getPlayers().get(i).getPlayerID());
                   //check if user played normal card
                   if (!super.checkCardType(i, cardIndex).equals("normal")){
                       int correctIndex = requestUserPlayNormal();//make first time play normal card
                         //store card to put back
                             cards.storeCardsPlayed().add(super.getPlayers().get(i).accessPlayerCards().get(correctIndex));
                       super.updatePlayerStack(i, correctIndex); // remove card from player
                   }
                   //then its a normal
                   else{               
                        super.initiateFirstTime(super.getPlayers().get(0).getCardNumber(cardIndex), super.getPlayers().get(0).getCardColor(cardIndex));
                           //store card to put back
                             cards.storeCardsPlayed().add(super.getPlayers().get(i).accessPlayerCards().get(cardIndex));
                        super.updatePlayerStack(i, cardIndex); // remove card from player
 
                   }
               //to skip a user// also give them cards give pick2/4 //  
               //check if an abilty card was prevoisly used
               }
               else if (previousAbility != null){
                   if (previousAbility.equals("PICK-2")){
                       System.out.println("<----------2 CARDS GIVEN TO YOU AND SKIPPED---------->");
                       //cards.pick2()-makes 2 cards in array, then i is index of player
                       addPick2orPick4(cards.pick2(),i );
                       //after adding clear generator
                       cards.clearCards();
                      // seeSpecificPlayerCards(i);
                       //reset previuos ability for next player to use
                       previousAbility=null;
                      
                       
                       
                       
                       
                   }else if (previousAbility.equals("PICK-4")){
                       System.out.println("<----------4 CARDS GIVEN TO YOU AND SKIPPED---------->");
                       //cards.pick2()-makes 2 cards in array, then i is index of player
                       addPick2orPick4(cards.pick4(),i );
                       //after adding clear generator
                       cards.clearCards();
                       //reset previuos ability for next player to use
                       previousAbility=null;
                      // seeSpecificPlayerCards(i);
                       //now show the user the cards
                      // System.out.println("Your card stack looks like now-->");
                       //seeCards();
                       
                   }else if (previousAbility.equals("SKIP")){
                       //reset previuos ability for next player to use
                       previousAbility=null;
                       System.out.println("<-----------Your turn is skipped---------->");
                       //do nothing and loop continues
                       
                       
                       
                        
                   }else{//then it is a reverse card
                       System.out.println("<----------ORDER REVERSED---------->");
                       previousAbility=null;
                       super.reverseOrder(i);
                   }
                   
                   
               }
               else{
                   System.out.println("--------------------------------------");
                   System.out.println(super.getPlayers().get(i).getPlayerID()+" turn: ");
                   input = view.userPlayOrPick();
                  while(correctCard != true){//check if card is right and if picked card then end loop, go to next person(not added yet)!!
                       
                  if (input.equals("play")){
                       cardIndex=PickCardToPlay(super.getPlayers().get(i).accessPlayerCards(),super.getPlayers().get(i).getPlayerID());
                       card=super.checkCardType(i, cardIndex);//check type of card played
                     if (card.equals("normal")){
                        boolean validateCard = playNormalCard(super.getPlayers().get(i).getCardNumber(cardIndex), super.getPlayers().get(i).getCardColor(cardIndex));
                        if (validateCard){ //meaning cardChoice is right  
                              
                              //store card
                               cards.storeCardsPlayed().add(super.getPlayers().get(i).accessPlayerCards().get(cardIndex));
                               super.updatePlayerStack(i, cardIndex); // remove card from player
                               correctCard=true;
                              // System.out.println("yeppeee");
                             }
                        
                   //then card choice wrong make them pick or play
                    
                    }else if (card.equals("ability")){
                        boolean validateCard = playAbilityCard(super.getPlayers().get(i).getColorAbility(cardIndex));
                        if (validateCard){
                            previousAbility = super.getPlayers().get(i).getCardAbility(cardIndex); //stores the type of ability
                             
                            //store card to put back
                             cards.storeCardsPlayed().add(super.getPlayers().get(i).accessPlayerCards().get(cardIndex));
                             //remove that card
                            super.updatePlayerStack(i, cardIndex);
                            //then exit the loop the else if statement before the loop will do wat it wants
                            correctCard=true;
                        }
                       
                    }else{
                        boolean choose = false;
                        while(choose!=true){
                        
                            String colorChoice = view.pickColor();
                            if ((colorChoice.equals("red") || colorChoice.equals("blue") ||colorChoice.equals("green")|| colorChoice.equals("yellow")) ){
                                super.playWildCard(colorChoice);
                                System.out.println("Color changed to--->>: "+colorChoice.toUpperCase());
                                
                                
                                 //store card to put back
                               cards.storeCardsPlayed().add(super.getPlayers().get(i).accessPlayerCards().get(cardIndex));
                               //remove that card
                               super.updatePlayerStack(i, cardIndex); 
                                choose=true;
                                correctCard=true;//exit while loop
                                
                               }
                            else{
                                System.out.println("try again");
                            }
                        }
                        //its a wildcard
                   }
                }
                  
                  //______________________________________________________________________
                //then user wants to PICK!  
                  else {//(input.equals("pick")){
                      cards.clearCards();//clear generator
                      super.givePlayerOneCard(cards.pick1(), i);
                      
                      boolean checker=false;
                      
                      while(checker!=true){
                          System.out.println("CHOOSE to play OR pass:");
                        //  seeCards();
                         String ans = view.userPlayOrPick();
                          if (ans.equals("play")){
                              input="play";//then go to play statement
                              checker=true;
                              //passNext = true; 
                          }else if (ans.equals("pass")){//then end loop go to next player
                              correctCard = true;
                              
                              checker=true;
                          }
                          else{
                              System.out.println("Try again");
                          }
                      }       
                   } } 
               
               
             }
           }
           //after every loop, empty the cards played and put at bottom of stack
           cards.returnPlayed();//add played cards back to stack
       }
       
     
    }
    public void seeSpecificPlayerCards(int i){
        System.out.println("Your cards now look like --->"+super.getPlayers().get(i).accessPlayerCards());
    }
    public void firstTimePlay(){
        firstTime = false;
        
    }
    //user must play a normal card for first time, method will only run once, return the index of that card played
    public int requestUserPlayNormal(){
        System.out.println("Please begin with a regular card");
        int cardIndex=-1;
        boolean check=false;
        //loop until user picks normal card
        while(check != true){
            //0 = because always be first player
            //PickCardToPlay goes to a loop
           cardIndex=PickCardToPlay(super.getPlayers().get(0).accessPlayerCards(),super.getPlayers().get(0).getPlayerID());
           if (!super.checkCardType(0, cardIndex).equals("normal")){//if user still not picking normal
                      System.out.println("Please begin with a regular card");
           }
           else{ 
               super.initiateFirstTime(super.getPlayers().get(0).getCardNumber(cardIndex), super.getPlayers().get(0).getCardColor(cardIndex));

               check=true;
           }

        }return cardIndex;
        
    }
 
    /**
     * When invoked shows all the cards of the players, for now it's for testing to see their cards
     * 
     */
    public void seeCards(){
         for (int i=0; i<super.getTotalPlayers();i++){
           System.out.println(super.getPlayers().get(i).getPlayerID()+"-->"+super.getPlayers().get(i).accessPlayerCards());
       }
    }
    public int PickCardToPlay(ArrayList nextPlayer, String name){
        System.out.println("Okay "+name+", choose an index-->");
        int choice = view.chooseIndex();
        boolean indexCorrect=false;
        while (indexCorrect !=true){
            if (choice > nextPlayer.size()-1 || choice < 0){
                choice = view.tryAgain();
                
            }else{
                indexCorrect=true;
                System.out.println(name+" played: "+nextPlayer.get(choice));
            }
        }
       // check type of card played
                return choice;
    }
    
  
    
/**
 * Once done, game shows the winner
     * @param player the winner of the game
 */
    @Override
    public void declareWinner(String player) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       System.out.println("YAY and the winner is........"+ player);
       System.out.println("--------------------------GAME OVER----------------------------------------------------");
   
    
    }
    
   
    
    
}
