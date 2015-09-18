

import static org.junit.Assert.*;
import game.LogScreen;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

public class LogScreenTest {

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

	@Test
	public void testReloadData() {
		fail("Not yet implemented");
	}

}
