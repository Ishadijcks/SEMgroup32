package test.screen;

import static org.junit.Assert.assertFalse;
import game.EndScore;
import game.NormalDriver;
import game.SurvivalDriver;
import game.screens.LosingScreen;

import org.junit.Test;

public class LosingScreenTest {

    @Test
    public void testLosingScreenNormalDriver() {
        NormalDriver testDriver = new NormalDriver();
        EndScore testEs = new EndScore("Player", 500);
        LosingScreen ls = new LosingScreen(testDriver, testEs);
        assertFalse(ls == null);
    }

    @Test
    public void testLosingScreenSurvivalDriver() {
        SurvivalDriver testDriver = new SurvivalDriver();
        EndScore testEs = new EndScore("Player", 500);
        LosingScreen ls = new LosingScreen(testDriver, testEs);
        assertFalse(ls == null);
    }

}
