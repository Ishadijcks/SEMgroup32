
import static org.junit.Assert.*;
import game.collisions.CollisionFactory;
import game.collisions.PlayerBubbleCollision;
import game.collisions.PlayerPowerupCollision;
import game.collisions.RopeBubbleCollision;
import game.collisions.WallBubbleCollision;
import game.collisions.WallPlayerCollision;

import org.junit.Before;
import org.junit.Test;

public class CollisionsFactoryTest {
    PlayerBubbleCollision pbc;
    CollisionFactory cf;

    @Before
    public void init() {
        cf = new CollisionFactory();
        pbc = new PlayerBubbleCollision();
    }

    @Test
    public void buildCollisionStringEquals() {
        assertTrue(cf.buildPlayerBubbleCollision().toString().substring(0, 30)
                .equals(pbc.toString().substring(0, 30)));
    }

    @Test
    public void buildCollisionInstanceofcheck1() {
        assertTrue(cf.buildPlayerBubbleCollision() instanceof PlayerBubbleCollision);
    }

    @Test
    public void buildCollisionInstanceofcheck2() {
        assertTrue(cf.buildRopeBubbleCollision() instanceof PlayerPowerupCollision);
    }

    @Test
    public void buildCollisionInstanceofcheck3() {
        assertTrue(cf.buildWallBubbleCollision() instanceof RopeBubbleCollision);
    }

    @Test
    public void buildCollisionInstanceofcheck4() {
        assertTrue(cf.buildPlayerBubbleCollision() instanceof WallBubbleCollision);
    }
    
    @Test
    public void buildCollisionInstanceofcheck5() {
        assertTrue(cf.buildWallPlayerCollision() instanceof WallPlayerCollision);
    }
}
