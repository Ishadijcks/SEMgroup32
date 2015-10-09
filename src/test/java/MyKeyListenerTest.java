

import static org.junit.Assert.*;
import game.GameCreator;
import game.MyKeyListener;
import game.NormalDriver;
import game.Player;

import org.junit.Before;
import org.junit.Test;

import java.awt.Component;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class MyKeyListenerTest {
	
	private MyKeyListener key;
	private Player p;

	@Before
	public void init() {
		p = new Player("test",0);
		NormalDriver.game = GameCreator.createSinglePlayer(p);
		key = new MyKeyListener(NormalDriver.game);
	}
	
	@Test
	public void testMyKeyListener() {
		assertTrue(key.getGame().equals(GameCreator.createSinglePlayer(p)));
	}

	@Test
	public void testKeyPressedKeyEventRight() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 39);
		NormalDriver.game.gameStart();
		key.keyPressed(k);
		assertTrue(NormalDriver.game.getPlayerList().get(0).getMovingRight());
	}
	
	@Test
	public void testKeyPressedKeyEventLeft() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 37);
		NormalDriver.game.gameStart();
		key.keyPressed(k);
		assertTrue(NormalDriver.game.getPlayerList().get(0).getMovingLeft());
	}
	
	@Test
	public void testKeyPressedKeyEventSpace() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 32);
		NormalDriver.game.gameStart();
		key.keyPressed(k);
		assertTrue(NormalDriver.game.getCurrentLevel().hasRope());
	}
	
	@Test
	public void testKeyPressedKeyEventLog() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 76);
		NormalDriver.game.gameStart();
		key.keyPressed(k);
	}
	
	@Test
	public void testKeyPressedKeyEventDefault() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 99);
		NormalDriver.game.gameStart();
		key.keyPressed(k);
	}

	@Test
	public void testKeyReleasedKeyEventLeft() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 37);
		NormalDriver.game.gameStart();
		key.keyReleased(k);
		assertFalse(NormalDriver.game.getPlayerList().get(0).getMovingLeft());
	}
	
	@Test
	public void testKeyReleasedKeyEventRight() {
		KeyEvent k = new KeyEvent(new JButton(), 0, 0, 0, 39);
		NormalDriver.game.gameStart();
		key.keyReleased(k);
		assertFalse(NormalDriver.game.getPlayerList().get(0).getMovingRight());
	}

}
