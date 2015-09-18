
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
                { 4, 40},
                { 8, 200 }, { 16, 150 }, { 32, 120}, 
                { 64, 80 }, { 128, 40}, { 23123123, 150},
                { -12, 150},{ 0, 150}, { Integer.MAX_VALUE, 150}});
    }



    private int expectedMaxHeight;
    private Bubble bubble;
    
    public BubbleDiameterMaxHeightTest(int diameter, int expectedMaxHeight) {
        this.expectedMaxHeight = expectedMaxHeight;
        bubble = new Bubble(diameter, 100, 100, false, false);
    }

    @Test
    public void test() {
    	System.out.println(bubble.getDiameter());
          assertEquals(expectedMaxHeight, bubble.calculateMaxHeight(bubble.getDiameter()));
    }
}
