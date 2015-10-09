package test.player;
import static org.junit.Assert.*;
import game.Level;
import game.NormalLevel;
import game.Player;
import game.Rope;
import game.bubble.Bubble;
import game.bubble.Bubblex16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PlayerBubbleCollisionTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ 100, 450, true }, { 1000, 0, false } });
    }

    public Level l;
    public Player player;
    public Bubble bubble;
    public ArrayList<Bubble> bubbleList;
    public ArrayList<Player> p;
    private boolean expected;

    public PlayerBubbleCollisionTest(int x, int y, boolean exp) {
        bubble = new Bubblex16(x, y, true, true);
        player = new Player("Test", 100);
        p = new ArrayList<Player>();
        p.add(player);
        l = new NormalLevel(p);
        bubbleList = new ArrayList<Bubble>();
        l.addBubble(bubble);
        this.expected = exp;
    }

    @Test
    public void testCheckCollisionRope() {
        //assertEquals(this.expected, l.checkCollisionPlayer());
    }

}
