
import static org.junit.Assert.*;
import game.Bubble;

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
                { 4, 0.5 }, { 8, 0.6 }, { 16, 0.7 }, 
                { 32, 0.8 }, { 64, 0.9 }, { 23123123, 0.7 },
                { -123, 0.7 }, { 0, 0.7 } });
    }

    private double expectedMove;
    private Bubble bubble;

    public BubbleDiameterMoveTest(int diameter, double expectedMove) {
        
        this.expectedMove = expectedMove;
        bubble = new Bubble(diameter, 100, 100, false, false);
    }

    @Test
    public void test() {
        assertTrue(expectedMove == bubble.calculateSpeedX(bubble.getDiameter()));
    }
}
