
import static org.junit.Assert.*;
import game.Bubble;
import game.Settings;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BubbleDiameterGTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { 4, 2.0},
                { 8, 2.1 }, { 16, 2.3 }, { 32,  2.5}, 
                { 64, 2.8 }, { 128, 3}, { 23123123, 2.3},
                { -12, 2.3},{ 0, 2.3}, { Integer.MAX_VALUE, 2.3}});
    }

    private double expectedG;
    private Bubble bubble;
    
    public BubbleDiameterGTest(int diameter, double expectedG) {
        this.expectedG = expectedG;
        bubble = new Bubble(diameter, 100, 100, false, false);
    }

    @Test
    public void test() {
          assertTrue(expectedG == bubble.calculateG(bubble.getDiameter()));
    }
}
