package test.bubble;

import static org.junit.Assert.assertEquals;
import game.bubble.Bubble;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;

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
                { 8, new Bubblex8(100, 100, false, false), 200 },
                { 16, new Bubblex16(100, 100, false, false), 150 },
                { 32, new Bubblex32(100, 100, false, false), 120 },
                { 64, new Bubblex64(100, 100, false, false), 80 },
                { 128, new Bubblex128(100, 100, false, false), 40 } });
    }

    private int expectedMaxHeight;
    private Bubble bubble;

    public BubbleDiameterMaxHeightTest(int diameter, Bubble bub,
            int expectedMaxHeight) {
        this.expectedMaxHeight = expectedMaxHeight;
        bubble = bub;
    }

    @Test
    public void test() {
        assertEquals(expectedMaxHeight, bubble.getMaxheight());
    }
}
