package test.player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.GameFactory;
import game.NormalDriver;
import game.Player;

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
        assertEquals(x - player.getStepSize(), player.getX());
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
        assertEquals(x + player.getStepSize(), player.getX());
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
        assertEquals(111, player.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(161, player.getHeight());
    }

    @Test
    public void testHasIceRopeNoIceRope() {
        NormalDriver.game = GameFactory.createSinglePlayer(player);
        assertFalse(player.hasIceRope());
    }

    @Test
    public void testSetName() {
        assertTrue(player.getName().equals("Isha"));
        player.setName("NietIsha");
        assertTrue(player.getName().equals("NietIsha"));
    }
    
    @Test
    public void testSetHasIceRope() {
    	assertFalse(player.hasIceRope());
    	player.setHasIceRope(true);
    	assertTrue(player.hasIceRope());
    }
    
    @Test
    public void testSetStepSize() {
    	assertTrue(player.getStepSize() != 1000);
    	player.setStepSize(1000);
    	assertTrue(player.getStepSize() == 1000);
    }
    
    @Test
    public void testGetCollisionX() {
    	assertTrue(player.getCollisionX() == player.getX() - 50);
    }
    
    @Test
    public void testGetCollisionY() {
    	assertTrue(player.getCollisionY() == 389 + 61);
    }
    
    @Test
    public void testGetPlayerNormalStepSize() {
    	assertTrue(player.getPlayerNormalStepSize() == 2);
    }
    
    @Test
    public void testGetPlayerPowerupStepSize() {
    	assertTrue(player.getPlayerPowerupStepSize() == 5);
    }
    
    @Test
    public void testIsRestrictMovingLeft() {
    	assertFalse(player.isRestrictMovingLeft());
    }
    
    @Test
    public void testIsRestrictMovingRight() {
    	assertFalse(player.isRestrictMovingRight());
    }

}
