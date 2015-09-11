
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
public class BubbleDiameterMaxHeightTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { 4, 120},
                { 8, 95 }, { 16, 75 }, { 32, 56}, 
                { 64, 40 }, { 128, 100}, { 23123123, 75},
                { -12, 75},{ 0, 75}, { Integer.MAX_VALUE, 75}});
    }

    

    private int expectedMaxHeight;
    private Bubble bubble;
    
    public BubbleDiameterMaxHeightTest(int diameter, int expectedMaxHeight) {
        this.expectedMaxHeight = expectedMaxHeight;
        bubble = new Bubble(diameter, 100, 100, false, false);
    }

    @Test
    public void test() {
          assertEquals(expectedMaxHeight, bubble.calculateMaxHeight(bubble.getDiameter()));
    }
}
