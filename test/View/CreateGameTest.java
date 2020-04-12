/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GameControls.CreateGame;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
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
public class CreateGameTest {
    
    public CreateGameTest() {
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
     * Test of playerCount method, of class gameView.
     */
   
    @Test
    public void checkSizeTest(){
        CreateGame c = new CreateGame();
        boolean check = c.checkSize(2);
        boolean exp = true;
        assertEquals(exp,check);
        
    }
  
     @Test
    public void checkSizeTestNegative(){
        CreateGame c = new CreateGame();
        boolean check = c.checkSize(-6);
        boolean exp = false;
        assertEquals(exp,check);
        
        
    }
    @Test
    public void checkSizeTestZero(){
        CreateGame c = new CreateGame();
        boolean check = c.checkSize(0);
        boolean exp = false;
        assertEquals(exp,check);
        
        
    }
     @Test
    public void checkSizeTestAlphabet(){
        CreateGame c = new CreateGame();
        boolean check = c.checkSize(6);
        boolean exp = false;
        assertEquals(exp,check);
        
    }
    @Test
    public void checkColorTest(){
        CreateGame c = new CreateGame();
        boolean s = c.checkColor("red");
        boolean exp = true;
        assertEquals(exp,s);
        
    }
     @Test
    public void checkColorTestRandom(){
        CreateGame c = new CreateGame();
        boolean s = c.checkColor("pink");
        boolean exp = false;
        assertEquals(exp,s);
        
    }   
     @Test
    public void checkColorTest2(){
        CreateGame c = new CreateGame();
        boolean s = c.checkColor("blue");
        boolean exp = true;
        assertEquals(exp,s);
        
    }
     @Test
    public void checkColorTestNumber(){
        CreateGame c = new CreateGame();
        boolean s = c.checkColor("1");
        boolean exp = false;
        assertEquals(exp,s);
        
    }
     @Test
    public void checkColorTestUpperCase(){
        CreateGame c = new CreateGame();
        boolean s = c.checkColor("GREEN");
        boolean exp = false;
        assertEquals(exp,s);
        
    }
    @Test
    public void checkPassPlayTest(){
        CreateGame c = new CreateGame();
        boolean s = c.checkAnswer("pass");
        boolean exp = true;
        assertEquals(exp,s);
    }
     @Test
    public void NotcheckPassPlayTest(){
        CreateGame c = new CreateGame();
        boolean s = c.checkAnswer("PaSs");
        boolean exp = false;
        assertEquals(exp,s);
    }
    @Test
    public void NotcheckPlayTest(){
        CreateGame c = new CreateGame();
        boolean s = c.checkAnswer("play");
        boolean exp = true;
        assertEquals(exp,s);
    }
    @Test
    public void checkPlayTestRandom(){
        CreateGame c = new CreateGame();
        boolean s = c.checkAnswer("no");
        boolean exp = false;
        assertEquals(exp,s);
    }
     @Test
    public void checkPlayPassNumber(){
        CreateGame c = new CreateGame();
        boolean s = c.checkAnswer("1");
        boolean exp = false;
        assertEquals(exp,s);
    }
    
    @Test
    public void checkRightCardIndexTest(){
        CreateGame c = new CreateGame();
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(9);
        boolean s = c.checkRightCardIndex(0, a);
        boolean exp = true;
        assertEquals(exp,s);
    }
    @Test
    public void checkRightCardNegativeIndexTest(){
        CreateGame c = new CreateGame();
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(9);
        boolean s = c.checkRightCardIndex(-2, a);
        boolean exp = false;
        assertEquals(exp,s);
    }
    

    
}
