package test.player;
import static org.junit.Assert.*;
import game.Level;
import game.NormalLevel;
import game.Player;
import game.bubble.Bubble;
import game.powerups.Powerup;
import game.powerups.SpeedPowerup;

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
        		{ 35, 550, true }, { 161, 550, true },
        		{ 34, 550, false }, { 162, 550, false },
        		{ 36, 550, true }, { 160, 550, true },
        		{ 50, 550, true }, { 146, 550, true },
        		{ 35, 440, true }, { 35, 550, true },
        		{ 35, 439, false }, { 35, 551, false},
        		{ 35, 450, true }, { 35, 540, true} });
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
        l = new NormalLevel(p);
        pow = new SpeedPowerup(x, y);
        l.addPowerup(pow);
        this.expected = exp;
    }

    @Test
    public void testCheckCollisionRope() {
        //assertEquals(this.expected, l.handlePowerupCollision());
    }

}
