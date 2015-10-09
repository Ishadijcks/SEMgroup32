package test.player;
import static org.junit.Assert.*;

import java.util.ArrayList;

import game.NormalDriver;
import game.GameFactory;
import game.Player;
import game.Settings;
import game.SurvivalDriver;
import game.SurvivalGame;
import game.powerups.Powerup;
import game.wall.Wall;

import org.junit.Test;

public class PlayerTest {

    Player player = new Player("Isha", 500);

    @Test
    public void testPlayerConstructor() {
        assertEquals("Isha", player.getName());
        assertEquals(500, player.getX());

    }

    @Test
    public void testMovingLeft() {
        assertFalse(player.getMovingLeft());
        player.movingLeft();
        assertTrue(player.getMovingLeft());
    }

    @Test
    public void testMovingRight() {
        assertFalse(player.getMovingRight());
        player.movingRight();
        assertTrue(player.getMovingRight());
    }

    @Test
    public void testStopMovingLeft() {
        player.movingLeft();
        assertTrue(player.getMovingLeft());
        player.stopMovingLeft();
        assertFalse(player.getMovingLeft());
    }

    @Test
    public void testStopMovingRight() {
        player.movingRight();
        assertTrue(player.getMovingRight());
        player.stopMovingRight();
        assertFalse(player.getMovingRight());
    }

    @Test
    public void testMoveLeft() {
        int x = player.getX();
        player.movingLeft();
        player.move();
        assertEquals(x - Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testMoveLeftBoundary() {
    	Player play = new Player("test", 0);
        int x = player.getX();
        play.movingLeft();
        play.move();
        assertEquals(x, player.getX());
    }

    @Test
    public void testMoveRight() {
        int x = player.getX();
        player.movingRight();
        player.move();
        assertEquals(x + Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testMoveRightBoundary() {
    	Player play = new Player("test", 10000);
        int x = player.getX();
        play.movingRight();
        play.move();
        assertEquals(x, player.getX());
    }

    @Test
    public void testGetWidth() {
        assertEquals(Settings.getPlayerWidth(), player.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(Settings.getPlayerHeight(), player.getHeight());
    }
    
    @Test
    public void testHasIceRopeNoIceRope(){
    	NormalDriver.game = GameFactory.createSinglePlayer(player);
    	assertFalse(player.hasIceRope());
    }
    
    @Test
    public void testSetName() {
    	assertTrue(player.getName().equals("Isha"));
    	player.setName("NietIsha");
    	assertTrue(player.getName().equals("NietIsha"));
    }

}
