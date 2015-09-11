
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
                { 4, 1.4 }, { 8, 1.3 }, { 16, 1.2 }, 
                { 32, 1.1 }, { 64, 1.0 }, { 23123123, 1.2 },
                { -123, 1.2 }, { 0, 1.2 } });
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
