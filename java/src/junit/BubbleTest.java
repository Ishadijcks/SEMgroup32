package junit;

import static org.junit.Assert.*;

import java.awt.Color;

import game.Bubble;
import game.Settings;

import org.junit.Before;
import org.junit.Test;

public class BubbleTest {

    public double x;
    public double y;
    public Bubble bubble;

    @Before
    public void init() {
        x = 2;
        y = 2;
        int diameter = 8;

        bubble = new Bubble(diameter, x, y, true, true);
    }

    @Test
    public void testBubbleDefault() {
        int diameter = 10000;
        int x = -10;
        int y = 100000;

        Bubble bub = new Bubble(diameter, x, y, true, true);

        assertEquals(Settings.getBubbleDefaultDiameter(), bub.getDiameter());
        assertEquals(Settings.getBubbleDefaultX(), bub.getX());
        assertEquals(Settings.getBubbleDefaultY(), bub.getY());
        assertEquals(Color.MAGENTA, bub.getColor());
        assertTrue(bub.isDirectionH());
        assertTrue(bub.isDirectionV());
    }

    @Test
    public void testBubble8() {
        int diameter = 8;

        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(Settings.getDragonRed(), bub.getColor());
    }

    @Test
    public void testBubble16() {
        int diameter = 16;

        Bubble bub = new Bubble(diameter, x, y, true, true);

        assertEquals(Color.BLACK, bub.getColor());
        assertEquals(diameter, bub.getDiameter());
    }

    @Test
    public void testBubble32() {
        int diameter = 32;

        Bubble bub = new Bubble(diameter, x, y, true, true);

        assertEquals(Color.GREEN, bub.getColor());
    }

    @Test
    public void testBubble64() {
        int diameter = 64;

        Bubble bub = new Bubble(diameter, x, y, true, true);

        assertEquals(Color.CYAN, bub.getColor());
    }

    @Test
    public void testBubble128() {
        int diameter = 128;

        Bubble bub = new Bubble(diameter, x, y, true, true);

        assertEquals(Color.PINK, bub.getColor());

    }

    @Test
    public void testBubbleNegative() {
        int diameter = -8;

        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(16, bub.getDiameter());
    }

    @Test
    public void testMove4() {
        int diameter = 4;
        int x = 50;
        int y = 50;
        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals((int) (x + 1.4), bub.getX());
        bub.bounceH();
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
    }

    @Test
    public void testMove8() {
        int diameter = 8;
        int x = 50;
        int y = 50;
        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals((int) (x + 1.4), bub.getX());
        bub.bounceH();
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
    }

    @Test
    public void testMove16() {
        int diameter = 16;
        int x = 50;
        int y = 50;
        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals((int) (x + 1.4), bub.getX());
        bub.bounceH();
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
    }

    @Test
    public void testMove32() {
        int diameter = 32;
        int x = 50;
        int y = 50;
        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals( Math.round(x + 1.6), bub.getX());
        bub.bounceH();
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
    }

    @Test
    public void testMove64() {
        int diameter = 64;
        int x = 50;
        int y = 50;
        Bubble bub = new Bubble(diameter, x, y, true, true);
        assertEquals(x, bub.getX());
        assertEquals(y, bub.getY());
        bub.move(1000, 1000);
        bub.move(1000, 1000);
        assertEquals( Math.round(x + 1.8), bub.getX());
        bub.bounceH();
        bub.move(100, 100);
        bub.move(100, 100);
        assertEquals(x, bub.getX());
    }

    @Test
    public void testBounceH() {
        assertTrue(bubble.isDirectionH());
        bubble.bounceH();
        assertFalse(bubble.isDirectionH());
    }

    @Test
    public void testBounceV() {
        assertTrue(bubble.isDirectionV());
        bubble.bounceV();
        assertFalse(bubble.isDirectionV());
    }

}
