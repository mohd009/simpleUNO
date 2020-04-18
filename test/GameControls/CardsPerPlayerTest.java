/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameControls;

import Cards.CardsPerPlayer;
import Cards.UNOCard;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CardsPerPlayerTest {
    
    public CardsPerPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class CreateGame.
     */
   

    /**
     * Test of addPlayer method, of class CreateGame.
     */
    @Test
    public void checkUserGets4Cards() {
        System.out.println("add 4 cards");
        CardsPerPlayer c = new CardsPerPlayer(2,3);
        ArrayList check = c.pick4();
        assertEquals(4,check.size());
        // TODO review the generated test code and remove the default call to fail.
      
    }
    @Test
    public void checkUserGets2Cards(){
         System.out.println("add 2 cards");
        CardsPerPlayer c = new CardsPerPlayer(2,3);
        ArrayList check = c.pick2();
        assertEquals(2,check.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void checkUserGets1Card(){
         System.out.println("add 1 cards");
        CardsPerPlayer c = new CardsPerPlayer(2,3);
        ArrayList check = c.pick1();
        assertEquals(1,check.size());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void checkPlayerHasCards(){
        System.out.println("check cards");
        CardsPerPlayer c = new CardsPerPlayer(2,3);//where 2 represents the number of players
        ArrayList check = c.HandCards();
        assertEquals(2,check.size());
    }
    
    

    /**
     * Test of checkValidity method, of class CreateGame.
     */
//    @Test
//    public void testCheckValidity() {
//        System.out.println("checkValidity");
//        int i = 0;
//        CreateGame instance = new CreateGame();
//        instance.checkValidity(i);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of startGameLogic method, of class CreateGame.
//     */
//    @Test
//    public void testStartGameLogic() {
//        System.out.println("startGameLogic");
//        int number = 0;
//        CreateGame instance = new CreateGame();
//        instance.startGameLogic(number);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of seeSpecificPlayerCards method, of class CreateGame.
//     */
//    @Test
//    public void testSeeSpecificPlayerCards() {
//        System.out.println("seeSpecificPlayerCards");
//        int i = 0;
//        CreateGame instance = new CreateGame();
//        instance.seeSpecificPlayerCards(i);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of firstTimePlay method, of class CreateGame.
//     */
//    @Test
//    public void testFirstTimePlay() {
//        System.out.println("firstTimePlay");
//        CreateGame instance = new CreateGame();
//        instance.firstTimePlay();
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
//
//    /**
//     * Test of requestUserPlayNormal method, of class CreateGame.
//     */
//    @Test
//    public void testRequestUserPlayNormal() {
//        System.out.println("requestUserPlayNormal");
//        CreateGame instance = new CreateGame();
//        int expResult = 0;
//        int result = instance.requestUserPlayNormal();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of seeCards method, of class CreateGame.
//     */
//    @Test
//    public void testSeeCards() {
//        System.out.println("seeCards");
//        CreateGame instance = new CreateGame();
//        instance.seeCards();
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of PickCardToPlay method, of class CreateGame.
//     */
//    @Test
//    public void testPickCardToPlay() {
//        System.out.println("PickCardToPlay");
//        ArrayList nextPlayer = null;
//        String name = "";
//        CreateGame instance = new CreateGame();
//        int expResult = 0;
//        int result = instance.PickCardToPlay(nextPlayer, name);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
//
//    /**
//     * Test of declareWinner method, of class CreateGame.
//     */
//    @Test
//    public void testDeclareWinner() {
//        System.out.println("declareWinner");
//        String player = "";
//        CreateGame instance = new CreateGame();
//        instance.declareWinner(player);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
    
}
