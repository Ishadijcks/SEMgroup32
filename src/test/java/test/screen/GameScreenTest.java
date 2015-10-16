package test.screen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import game.EndScore;
import game.Leaderboard;
import game.screens.GameScreen;
import game.screens.LeaderBoardScreen;

import org.junit.Test;

public class GameScreenTest {
    
    @Test
    public void testGameScreenStart() {
        GameScreen screen = new GameScreen();
        screen.startGame();
        assertFalse(screen == null);
    }
    
    @Test
    public void testGameScreenClose() {
        GameScreen screen = new GameScreen();
        screen.dispose();
        assertFalse(screen == null);
    }
    
}
