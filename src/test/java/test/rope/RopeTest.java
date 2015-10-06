package test.rope;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import game.GameCreator;
import game.Level;
import game.NormalDriver;
import game.Player;
import game.Rope;
import game.SurvivalDriver;
import game.bubble.Bubble;
import game.powerups.Powerup;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class RopeTest {
    
    public int x;
    public int y;
    private Rope rope;
    private Rope survRope;
    
    @Before
    public void init() {
        x = 0;
        y = 0;
        rope = new Rope(x, y, true);
        survRope = new Rope(x,y,false);
    }
    
    @Test
    public void testgetX() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getX());
    }
    
    @Test
    public void testgetY() {
        int expectedXCoord = 0;
        assertEquals(expectedXCoord, rope.getY());
    }

    @Test
    public void testaddX() {
        rope.addX(50);
        int expectedXCoord = 50;
        assertEquals(expectedXCoord, rope.getX());
    }
    
    @Test
    public void testMoveNormal() {
        rope = new Rope(250, 100, true);
        rope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, rope.getY());
    }
    
    @Test
    public void testMoveRoofNormal() {
    	NormalDriver.game = GameCreator.createSinglePlayer(new Player("Test",0,true));
        rope = new Rope(250, 0, true);
        rope.move();
        int expectedYCoord = 0;
        assertEquals(expectedYCoord, rope.getY());
    }
    
    @Test
    public void testMoveSurvival() {
    	survRope = new Rope(250, 100, false);
        survRope.move();
        int expectedYCoord = 96;
        assertEquals(expectedYCoord, survRope.getY());
    }
    
    @Test
    public void testMoveRoofSurvival() {
    	SurvivalDriver.game = GameCreator.createSurvival(new Player("Test",0,true));
        rope = new Rope(250, 0, false);
        survRope.move();
        int expectedYCoord = 0;
        assertEquals(expectedYCoord, survRope.getY());
    }
    


}
