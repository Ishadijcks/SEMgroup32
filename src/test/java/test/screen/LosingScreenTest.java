package test.screen;

import static org.junit.Assert.assertFalse;
import game.EndScore;
import game.NormalDriver;
import game.SurvivalDriver;
import game.screens.LosingScreen;

import org.junit.Test;
/**
 * Tests if the losing screen is created correctly.
 * @author Isha
 *
 */
public class LosingScreenTest {

    /**
     * Tests if the losing screen opens correctly in a normal game.
     */
    @Test
    public void testLosingScreenNormalDriver() {
        NormalDriver testDriver = new NormalDriver();
        EndScore testEs = new EndScore("Player", 500);
        LosingScreen ls = new LosingScreen(testEs);
        assertFalse(ls == null);
    }

    /**
     * Tests if the losing screen opens correctly in a survival game.
     */
    @Test
    public void testLosingScreenSurvivalDriver() {
        SurvivalDriver testDriver = new SurvivalDriver();
        EndScore testEs = new EndScore("Player", 500);
        LosingScreen ls = new LosingScreen(testEs);
        assertFalse(ls == null);
    }

}
