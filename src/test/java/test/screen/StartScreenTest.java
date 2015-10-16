package test.screen;

import static org.junit.Assert.*;

import game.screens.StartScreen;

import org.junit.Test;


public class StartScreenTest {

    @Test
    public void testStartScreen() {
        StartScreen sc = new StartScreen();
        sc.addStopButton();
        assertFalse(sc == null);
    }

}
