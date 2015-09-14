
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
                { 4, 180},
                { 8, 180 }, { 16, 100 }, { 32, 90}, 
                { 64, 40 }, { 128, 100}, { 23123123, 100},
                { -12, 100},{ 0, 100}, { Integer.MAX_VALUE, 100}});
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
