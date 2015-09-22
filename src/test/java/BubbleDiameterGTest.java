
import static org.junit.Assert.*;
import game.Bubble;
import game.Bubblex128;
import game.Bubblex16;
import game.Bubblex32;
import game.Bubblex64;
import game.Bubblex8;
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
                { 8, new Bubblex8(100,100,false,false), 1 }, { 16, new Bubblex16(100,100,false,false), 1.3 }, { 32, new Bubblex32(100,100,false,false),  1.2}, 
                { 64, new Bubblex64(100,100,false,false), 1.1 }, { 128, new Bubblex128(100,100,false,false), 1} });
    }

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
