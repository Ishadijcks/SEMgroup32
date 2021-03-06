
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.GameFactory;
import game.MainRunner;
import game.MyKeyListener;
import game.NormalDriver;
import game.Player;
import game.StateManager;

import java.awt.event.KeyEvent;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

public class MyKeyListenerTest {

    private MyKeyListener key;
    private Player p;

    @Before
    public void init() {
        p = new Player("test", 0);
        NormalDriver.game = GameFactory.createSinglePlayer(p);
        key = new MyKeyListener(NormalDriver.game);
        MainRunner.setStateManager(new StateManager());
    }

    @Test
    public void testMyKeyListener() {
        assertTrue(key.getGame().equals(GameFactory.createSinglePlayer(p)));
    }

    @Test
    public void testKeyPressedKeyEventRight() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 39);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
        assertTrue(NormalDriver.game.getPlayerList().get(0).getMovingRight());
    }

    @Test
    public void testKeyPressedKeyEventLeft() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 37);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
        assertTrue(NormalDriver.game.getPlayerList().get(0).getMovingLeft());
    }

    @Test
    public void testKeyPressedKeyEventSpace() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 32);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
        assertTrue(NormalDriver.game.getCurrentLevel().hasRope());
    }

    @Test
    public void testKeyPressedKeyEventLog() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 76);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
    }

    @Test
    public void testKeyPressedKeyEventDefault() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 99);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
    }

    @Test
    public void testKeyReleasedKeyEventLeft() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 37);
        NormalDriver.game.gameStart();
        key.keyReleased(k);
        assertFalse(NormalDriver.game.getPlayerList().get(0).getMovingLeft());
    }

    @Test
    public void testKeyReleasedKeyEventRight() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 39);
        NormalDriver.game.gameStart();
        key.keyReleased(k);
        assertFalse(NormalDriver.game.getPlayerList().get(0).getMovingRight());
    }
    
    @Test
    public void testKeyPressedKeyEventEscape() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 27);
        NormalDriver.game.gameStart();
        assertTrue(NormalDriver.game.inProgress());
        key.keyPressed(k);
        assertFalse(NormalDriver.game.inProgress());
    }
    
    @Test
    public void testKeyPressedKeyEventUp() {
        @SuppressWarnings("deprecation")
        KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 38);
        NormalDriver.game.gameStart();
        key.keyPressed(k);
        assertTrue(NormalDriver.game.getCurrentLevel().hasRope());
    }

}
