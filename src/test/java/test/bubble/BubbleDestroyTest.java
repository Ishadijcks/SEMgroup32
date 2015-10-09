package test.bubble;

import static org.junit.Assert.*;
import game.Settings;
import game.bubble.Bubble;
import game.bubble.Bubblex128;
import game.bubble.Bubblex16;
import game.bubble.Bubblex32;
import game.bubble.Bubblex64;
import game.bubble.Bubblex8;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public abstract class BubbleDestroyTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                { new Bubblex8(100,100,false,false), new ArrayList<Bubble>() }, 
                { new Bubblex16(100,100,false,false), new ArrayList<Bubble>(Arrays.asList(new Bubblex8(100,100,false,false), new Bubblex8(100,100,true,false))) }, 
                { new Bubblex32(100,100,false,false), new ArrayList<Bubble>(Arrays.asList(new Bubblex16(100,100,false,false), new Bubblex16(100,100,true,false))) }, 
                { new Bubblex64(100,100,false,false), new ArrayList<Bubble>(Arrays.asList(new Bubblex32(100,100,false,false), new Bubblex32(100,100,true,false))) }, 
                { new Bubblex128(100,100,false,false), new ArrayList<Bubble>(Arrays.asList(new Bubblex64(100,100,false,false), new Bubblex64(100,100,true,false))) }});
    }

    private ArrayList<Bubble> expectedList;
    private Bubble bubble;

    
    public BubbleDestroyTest(Bubble bub, ArrayList<Bubble> expectedList) {
        this.expectedList = expectedList;
        bubble = bub;
    }

    @Test
    public void test() {
          assertTrue(expectedList.equals(bubble.destroyBubble(100, 100)));
    }
}