import static org.junit.Assert.*;
import game.Driver;
import game.GameCreator;
import game.Player;
import game.Powerup;
import game.Settings;

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
    public void testMoveRight() {
        int x = player.getX();
        player.movingRight();
        player.move();
        assertEquals(x + Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testSetPowerup() {
        player.setPowerup(new Powerup("speed", 100, 60));
        assertTrue(player.getPowerupList().get(0).getName().equals("speed"));
    }

    @Test
    public void testRemovePowerup() {
        Powerup speed = new Powerup("speed", 100, 60);
        player.setPowerup(speed);
        assertTrue(player.getPowerupList().get(0).getName().equals("speed"));
        player.removePowerUp(speed);
        assertEquals(0, player.getPowerupList().size());
    }

    @Test
    public void testMovePowerupLeft() {
        player.setPowerup(new Powerup("speed", 100, 60));
        int x = player.getX();
        player.movingLeft();
        player.move();
        assertEquals(x - Settings.getPlayerPowerupStepSize(), player.getX());
    }

    @Test
    public void testMovePowerupRight() {
        player.setPowerup(new Powerup("speed", 100, 60));
        int x = player.getX();
        player.movingRight();
        player.move();
        assertEquals(x + Settings.getPlayerPowerupStepSize(), player.getX());
    }

    @Test
    public void testShootRope() {
        Driver.game = GameCreator.createSinglePlayer(player);
        assertFalse(Driver.game.getCurrentLevel()
                .hasRope());
        player.shootRope();
        assertTrue(Driver.game.getCurrentLevel()
                .hasRope());
    }

    @Test
    public void testGetWidth() {
        assertEquals(Settings.getPlayerWidth(), player.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(Settings.getPlayerHeight(), player.getHeight());
    }

}
