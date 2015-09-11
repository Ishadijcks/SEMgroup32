import static org.junit.Assert.*;
import game.Bubble;
import game.Level;
import game.Player;
import game.Powerup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PlayerPowerupCollisionTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ 100, 550, true }, { 1000, 0, false } });
    }

    public Level l;
    public Player player;
    public Powerup pow;
    public ArrayList<Player> p;
    private boolean expected;

    public PlayerPowerupCollisionTest(int x, int y, boolean exp) {
        player = new Player("Test", 100);
        p = new ArrayList<Player>();
        p.add(player);
        l = new Level(p);
        pow = new Powerup("speed", x, y);
        l.addPowerup(pow);
        this.expected = exp;
    }

    @Test
    public void testCheckCollisionRope() {
        l.checkCollisionRope();
        assertEquals(this.expected, l.checkPowerupCollision());
    }

}
