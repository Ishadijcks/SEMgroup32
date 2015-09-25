package test.player;
import static org.junit.Assert.*;

import java.util.ArrayList;

import game.NormalDriver;
import game.GameCreator;
import game.Player;
import game.Powerup;
import game.Settings;
import game.SurvivalDriver;
import game.SurvivalGame;
import game.wall.Wall;

import org.junit.Test;

public class PlayerTest {

    Player player = new Player("Isha", 500, true);

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
        player.move(new ArrayList<Wall>());
        assertEquals(x - Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testMoveLeftBoundary() {
    	Player play = new Player("test", 0, true);
        int x = player.getX();
        play.movingLeft();
        play.move(new ArrayList<Wall>());
        assertEquals(x, player.getX());
    }

    @Test
    public void testMoveRight() {
        int x = player.getX();
        player.movingRight();
        player.move(new ArrayList<Wall>());
        assertEquals(x + Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testMoveRightBoundary() {
    	Player play = new Player("test", 10000, true);
        int x = player.getX();
        play.movingRight();
        play.move(new ArrayList<Wall>());
        assertEquals(x, player.getX());
    }
    
    @Test
    public void testMoveDeactivatedSpeed() {
        int x = player.getX();
        player.movingRight();
    	player.setPowerup(new Powerup("speed", 100, 60, true));
    	player.getPowerupList().get(0).deActivate();
    	player.move(new ArrayList<Wall>());
        assertEquals(x + Settings.getPlayerStepSize(), player.getX());
    }
    
    @Test
    public void testMoveDeactivatedIceRope() {
        int x = player.getX();
        player.movingRight();
    	player.setPowerup(new Powerup("ice", 100, 60, true));
    	player.getPowerupList().get(0).deActivate();
    	player.move(new ArrayList<Wall>());
        assertEquals(x + Settings.getPlayerStepSize(), player.getX());
    }

    @Test
    public void testSetPowerup() {
        player.setPowerup(new Powerup("speed", 100, 60, true));
        assertTrue(player.getPowerupList().get(0).getName().equals("speed"));
    }

    @Test
    public void testRemovePowerup() {
        Powerup speed = new Powerup("speed", 100, 60, true);
        player.setPowerup(speed);
        assertTrue(player.getPowerupList().get(0).getName().equals("speed"));
        player.removePowerUp(speed);
        assertEquals(0, player.getPowerupList().size());
    }

    @Test
    public void testMovePowerupLeft() {
        player.setPowerup(new Powerup("speed", 100, 60, true));
        int x = player.getX();
        player.movingLeft();
        player.move(new ArrayList<Wall>());
        assertEquals(x - Settings.getPlayerPowerupStepSize(), player.getX());
    }

    @Test
    public void testMovePowerupRight() {
        player.setPowerup(new Powerup("speed", 100, 60, true));
        int x = player.getX();
        player.movingRight();
        player.move(new ArrayList<Wall>());
        assertEquals(x + Settings.getPlayerPowerupStepSize(), player.getX());
    }

    @Test
    public void testShootRopeNormalGame() {
        NormalDriver.game = GameCreator.createSinglePlayer(player);
        assertFalse(NormalDriver.game.getCurrentLevel()
                .hasRope());
        player.shootRope();
        assertTrue(NormalDriver.game.getCurrentLevel()
                .hasRope());
    }
    
    @Test
    public void testShootRopeSurvivalGame() {
    	Player play = new Player("Isha", 500, false);
    	SurvivalDriver.game = GameCreator.createSurvival(play);
        assertFalse(SurvivalDriver.game.getCurrentLevel()
                .hasRope());
        play.shootRope();
        assertTrue(SurvivalDriver.game.getCurrentLevel()
                .hasRope());
    }
    
    @Test
    public void testShootIceRope(){
        NormalDriver.game = GameCreator.createSinglePlayer(player);
        player.setPowerup(new Powerup("ice", 100, 60, true));
        assertFalse(NormalDriver.game.getCurrentLevel()
                .hasRope());
        player.shootRope();
        assertTrue(NormalDriver.game.getCurrentLevel()
                .hasRope());
    }
    
    @Test
    public void testShotIceRopeSurvivalGame() {
    	Player play = new Player("Isha", 500, false);
    	SurvivalDriver.game = GameCreator.createSurvival(play);
    	play.setPowerup(new Powerup("ice", 100, 60, true));
        assertFalse(SurvivalDriver.game.getCurrentLevel()
                .hasRope());
        play.shootRope();
        assertTrue(SurvivalDriver.game.getCurrentLevel()
                .hasRope());
    }
    
    @Test
    public void testShotDeactivatedIceRope() {
        NormalDriver.game = GameCreator.createSinglePlayer(player);
        player.setPowerup(new Powerup("ice", 100, 60, true));
        player.getPowerupList().get(0).deActivate();
        assertFalse(NormalDriver.game.getCurrentLevel()
                .hasRope());
        player.shootRope();
        assertTrue(NormalDriver.game.getCurrentLevel()
                .hasRope());
    }
    
    @Test
    public void testShotDeactivatedIceRopeSurvivalGame() {
    	Player play = new Player("Isha", 500, false);
    	SurvivalDriver.game = GameCreator.createSurvival(play);
    	play.setPowerup(new Powerup("ice", 100, 60, true));
    	play.getPowerupList().get(0).deActivate();
        assertFalse(SurvivalDriver.game.getCurrentLevel()
                .hasRope());
        play.shootRope();
        assertTrue(SurvivalDriver.game.getCurrentLevel()
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
    
    @Test
    public void testRemoveAllPowerUpsEmptyList(){
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	assertTrue(player.getPowerupList().isEmpty());
    	player.removeAllPowerUps();
    	assertTrue(player.getPowerupList().isEmpty());
    }
    
    @Test
    public void testRemoveAllPowerUps1Element(){
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	player.getPowerupList().add(new Powerup("ice", 100, 60, true));
    	assertEquals(1, player.getPowerupList().size());
    	player.removeAllPowerUps();
    	assertTrue(player.getPowerupList().isEmpty());
    }
    
    @Test
    public void testRemoveAllPowerUpsMultiElement(){
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	player.getPowerupList().add(new Powerup("ice", 100, 60, true));
    	player.getPowerupList().add(new Powerup("ice", 100, 60, true));
    	assertEquals(2, player.getPowerupList().size());
    	player.removeAllPowerUps();
    	assertTrue(player.getPowerupList().isEmpty());
    }
    
    @Test
    public void testHasIceRopeNoIceRope(){
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	assertFalse(player.hasIceRope());
    }
    
    @Test
    public void testHasIceRopeWithIceRope(){
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	player.getPowerupList().add(new Powerup("ice", 100, 60, true));
    	assertTrue(player.hasIceRope());
    }
    
    @Test
    public void testHasPowerup() {
    	NormalDriver.game = GameCreator.createSinglePlayer(player);
    	assertFalse(player.hasPowerup());
    	player.getPowerupList().add(new Powerup("ice", 100, 60, true));
    	assertTrue(player.hasPowerup());
    }
    
    @Test
    public void testSetName() {
    	assertTrue(player.getName().equals("Isha"));
    	player.setName("NietIsha");
    	assertTrue(player.getName().equals("NietIsha"));
    }

}
