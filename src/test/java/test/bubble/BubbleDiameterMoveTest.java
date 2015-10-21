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

@RunWith(Parameterized.class)
public class BubbleDiameterMoveTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 128, new Bubblex128(100, 100, false, false), 1 },
                { 8, new Bubblex8(100, 100, false, false), 0.9 },
                { 16, new Bubblex16(100, 100, false, false), 1 },
                { 32, new Bubblex32(100, 100, false, false), 1.1 },
                { 64, new Bubblex64(100, 100, false, false), 1.3 } });
    }

    private double expectedMove;
    private Bubble bubble;

    public BubbleDiameterMoveTest(int diameter, Bubble bub, double expectedMove) {

        this.expectedMove = expectedMove;
        bubble = bub;
    }

    @Test
    public void test() {
        assertTrue(expectedMove == bubble.getSpeedX());
    }
}
