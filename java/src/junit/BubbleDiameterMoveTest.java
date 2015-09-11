package junit;

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
                 { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },{ 6, 8 }  
           });
    }

    private int expectedMove;

    private int diameter;

    public BubbleDiameterMoveTest(int diameter, int expectedMove) {
        this.diameter = diameter;
        this.expectedMove = expectedMove;
    }

    @Test
    public void test() {
        assertEquals(expectedMove, Fibonacci.compute(fInput));
    }
}