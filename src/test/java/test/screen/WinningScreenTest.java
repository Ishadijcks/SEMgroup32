package test.screen;

import static org.junit.Assert.*;
import game.NormalDriver;
import game.screens.WinningScreen;



import org.junit.Test;


public class WinningScreenTest {

    @Test
    public void testLosingScreenNormalDriver() {
        NormalDriver testDriver = new NormalDriver();
        WinningScreen ls = new WinningScreen(testDriver);
        assertFalse(ls == null);
    }

}
