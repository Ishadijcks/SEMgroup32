package test.screen;

import static org.junit.Assert.assertEquals;
import game.screens.LogScreen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

/**
 * Tests if the log screen is created correctly.
 * 
 * @author Isha
 *
 */
public class LogScreenTest {

    /**
     * Tests if the log screen opens correctly.
     */
    @Test
    public void testLogScreen() {
        try {
            LogScreen lsc = new LogScreen();
            assertEquals(1, lsc.getFrame().getComponentCount());
        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Tests if the game reloads the data correctly.
     * 
     * @throws UnsupportedAudioFileException UnsupportedAudioFileException
     * @throws IOException IOException
     * @throws LineUnavailableException LineUnavailableException
     */
    @Test
    public void testreloadData() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        LogScreen lsc = new LogScreen();
        lsc.reloadData();
        assertEquals(1, lsc.getFrame().getComponentCount());
    }

    /**
     * Tests if the horizontal panel is created correctly.
     * 
     * @throws UnsupportedAudioFileException UnsupportedAudioFileException
     * @throws IOException IOException
     * @throws LineUnavailableException LineUnavailableException
     */
    @Test
    public void testmakeHorizontalPanel() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        LogScreen lsc = new LogScreen();
        List<String> ll = new LinkedList<String>();
        ll.add("test1");
        ll.add("test2");
        ll.add("test3");
        ll.add("test4");
        ll.add("test5");
        lsc.makeHorizontalPanel(1, ll.get(0));
        lsc.makeHorizontalPanel(2, ll.get(1));
        lsc.makeHorizontalPanel(3, ll.get(2));
        lsc.makeHorizontalPanel(4, ll.get(3));
        lsc.makeHorizontalPanel(5, ll.get(4));
        assertEquals(1, lsc.getFrame().getComponentCount());
    }

}
