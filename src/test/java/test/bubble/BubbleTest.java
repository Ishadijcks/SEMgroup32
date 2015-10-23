package test.bubble;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.bubble.Bubble;
import game.bubble.Bubblex16;
import game.bubble.Bubblex8;

import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleConstructor() {
        Bubble bub = new Bubblex8(10, 10, true, true);
        assertTrue(bub.getX() == 10);
        assertTrue(bub.getY() == 10);
        assertTrue(bub.isDirectionH());
        assertTrue(bub.isDirectionV());

    }

    @Test
    public void testBubbleSetters() {
        Bubble bub = new Bubblex8(10, 10, true, true);
        assertTrue(bub.isDirectionH());
        assertTrue(bub.isDirectionV());
        bub.setDirectionH(false);
        bub.setDirectionV(false);
        assertFalse(bub.isDirectionH());
        assertFalse(bub.isDirectionV());

    }

    @Test
    public void testBounceX() {
        Bubble bub = new Bubblex8(
                75 + 850
                        - 5,
                50 + 500,
                true, true);
        assertTrue(bub.isDirectionH());

        for (int i = 0; i < 6; i++) {
            bub.move();
        }
        assertFalse(bub.isDirectionH());

    }

    @Test
    public void testBounceY() {
        Bubble bub = new Bubblex8(75,
                50 + 500
                        - 5, true, true);
        assertTrue(bub.isDirectionV());
        for (int i = 0; i < 100; i++) {
            bub.move();
        }
        assertFalse(bub.isDirectionV());

    }

    @Test
    public void testBounceMaxHeight() {
        Bubble bub = new Bubblex16(75, 75 + 5,
                true, false);

        assertFalse(bub.isDirectionV());
        for (int i = 0; i < 100; i++) {
            bub.move();
        }
        assertTrue(bub.isDirectionV());

    }

    @Test
    public void testMove2() {
        Bubble bub = new Bubblex8(
                75,
                50 + 500,
                true, true);

        bub.move();
        bub.move();
        bub.move();
        bub.move();
        bub.move();
        bub.move();

    }

    @Test
    public void testBounceH() {
        Bubble bubble = new Bubblex8(10, 10, true, true);
        assertTrue(bubble.isDirectionH());
        bubble.bounceH();
        assertFalse(bubble.isDirectionH());
    }

    @Test
    public void testBounceV() {
        Bubble bubble = new Bubblex8(10, 10, true, true);
        assertTrue(bubble.isDirectionV());
        bubble.bounceV();
        assertFalse(bubble.isDirectionV());
    }

}
