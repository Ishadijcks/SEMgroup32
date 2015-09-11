
import static org.junit.Assert.assertEquals;
import game.Bubble;
import game.Level;
import game.Player;
import game.Rope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RopeBubbleCollisionTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 20, 68, true }, { 29, 68, true },
                { 38, 68, true }, { 20, 59, true }, { 20, 50, true }, { 20, 30, true },
                { 24, 59, true }, { 35, 29, true }, { 19, 68, false }, { 20, 69, false },
                { 19, 69, false }, { 39, 68, false }, { 38, 69, false }, { 39, 69, false },
                { -10000, 20192, false }, { 100000, -129293, false } });
    }

    public Level l;
    public Bubble bubble;
    public ArrayList<Bubble> bubbleList;
    public ArrayList<Player> p;
    private boolean expected;

    public RopeBubbleCollisionTest(int x, int y, boolean exp) {
        bubble = new Bubble(18, 20, 50, true, true);
        p = new ArrayList<Player>();
        l = new Level(p);
        bubbleList = new ArrayList<Bubble>();
        Rope r = new Rope(x, y);
        l.setRope(r);
        l.addBubble(bubble);
        this.expected = exp;
    }

    @Test
    public void testCheckCollisionRope() {
    	System.out.println(bubble.getY());
    	System.out.println(bubble.getDiameter());
    	System.out.println(l.getRope().getY());
        assertEquals(this.expected, l.checkCollisionRope());
    }

}
