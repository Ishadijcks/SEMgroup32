package test.bubble;

import static org.junit.Assert.assertTrue;
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

/**
 * DOC..
 * 
 * @author flori
 *
 */
@RunWith(Parameterized.class)
public class BubbleDiameterGTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 8, new Bubblex8(100, 100, false, false), 1 },
                { 16, new Bubblex16(100, 100, false, false), 1.3 },
                { 32, new Bubblex32(100, 100, false, false), 1.2 },
                { 64, new Bubblex64(100, 100, false, false), 1.1 },
                { 128, new Bubblex128(100, 100, false, false), 1 } });
    };

    private double expectedG;
    private Bubble bubble;

    public BubbleDiameterGTest(int diameter, Bubble bub, double expectedG) {
        this.expectedG = expectedG;
        bubble = bub;
    }

    @Test
    public void test() {
        assertTrue(expectedG == bubble.getG());
    }
}
