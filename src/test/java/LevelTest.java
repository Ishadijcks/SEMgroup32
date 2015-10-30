import static org.junit.Assert.*;
import game.DriverFactory;
import game.Level;
import game.NormalDriverFactory;
import game.NormalLevel;
import game.Player;
import game.Rope;
import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex8;
import game.powerups.IcePowerup;
import game.powerups.Powerup;
import game.powerups.SpeedPowerup;
import game.wall.DuoWall;
import game.wall.Wall;
import helperobjects.Coordinates;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {

    public Level l;
    public Bubble bubble;
    public Powerup powr;
    public ArrayList<Player> p;
    public ArrayList<Bubble> bubbleList;
    public ArrayList<Powerup> plist;
    public Random rand;

    @Before
    public void init() {
        bubble = new Bubblex16(2, 2, true, true);
        p = new ArrayList<Player>();
        l = new NormalLevel(p);
        bubbleList = new ArrayList<Bubble>();
        plist = new ArrayList<Powerup>();
        powr = new SpeedPowerup(0, 0);
        rand = new Random();
    }

    @Test
    public void testLevel() {
        assertTrue(l.getBubbleList().equals(bubbleList));
        assertTrue(l.getPlayerList().equals(p));
        assertTrue(l.getPowerupList().equals(plist));
    }

    @Test
    public void testAddBubble() {
        assertTrue(l.getBubbleList().isEmpty());
        l.addBubble(bubble);
        assertTrue(l.getBubbleList().contains(bubble));
    }

    @Test
    public void testAddPowerup() {
        assertTrue(l.getPowerupList().isEmpty());
        l.addPowerup(powr);
        assertTrue(l.getPowerupList().contains(powr));
    }

    @Test
    public void testSetRope() {
        Rope r = new Rope(0, 0);
        assertNull(l.getRope());
        l.setRope(r);
        assertEquals(r, l.getRope());
    }
    
    @Test
    public void testResetBubble() {
    	l.addBubble(bubble);
    	assertFalse(l.getBubbleList().isEmpty());
    	l.resetBubble();
    	assertTrue(l.getBubbleList().isEmpty());
    }
    
    @Test
    public void testHasEmptyWallList() {
    	assertFalse(l.hasWallList());
    }
    
    @Test
    public void testHasFilledWallList() {
    	l.addWall(new DuoWall(new Coordinates(0,0), 10, 10));
    	assertTrue(l.hasWallList());
    }
    
    @Test
    public void testSetPlayerList() {
    	Player player = new Player("things", 0);
    	ArrayList<Player> playerlist = new ArrayList<Player>();
    	playerlist.add(player);
    	assertFalse(l.getPlayerList().contains(player));
    	l.setPlayerList(playerlist);
    	assertTrue(l.getPlayerList().contains(player));
    }
    
    @Test
    public void testSetPowerupList() {
    	Powerup powerup = new IcePowerup(0,0);
    	plist.add(powerup);
    	assertFalse(l.getPowerupList().contains(powerup));
    	l.setPowerupList(plist);
    	assertTrue(l.getPowerupList().contains(powerup));
    }
    
    @Test
    public void testMoveBubbles() {
    	DriverFactory drf = new NormalDriverFactory();
    	drf.buildDriver();
    	l.addBubble(new Bubblex8(180, 180, true, true));
    	assertTrue(l.getBubbleList().get(0).getX() == 180);
    	l.moveBubbles();
    	assertTrue(l.getBubbleList().get(0).getX() != 180);
    }

}
