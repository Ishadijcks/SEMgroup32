
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
public class BubbleDiameterColorTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { 8, Settings.getDragonRed() }, { 16, Color.BLACK }, { 32,  Color.GREEN}, 
                { 64, Color.CYAN }, { 128, Color.PINK }, { 23123123, Color.BLACK},
                { -12, Color.BLACK},{ 0, Color.BLACK}, { Integer.MAX_VALUE, Color.BLACK}});
    }

    private Color expectedColor;
    private Bubble bubble;


    

    
    
    public BubbleDiameterColorTest(int diameter, Color expectedColor) {
        this.expectedColor = expectedColor;
        bubble = new Bubble(diameter, 100, 100, false, false);
    }

    @Test
    public void test() {
          assertTrue(expectedColor.equals(bubble.calculateColor(bubble.getDiameter())));
    }
}
