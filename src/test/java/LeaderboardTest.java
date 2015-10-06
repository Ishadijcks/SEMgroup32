

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import game.Leaderboard;
import game.endScore;

import org.junit.Before;
import org.junit.Test;

public class LeaderboardTest {
	
	private ArrayList<endScore> scoreList;
	private Leaderboard led;
	
	@Before
	public void init() {
		led = new Leaderboard();
		scoreList = new ArrayList<endScore>();
	}

	@Test
	public void testAddScoreFromZero() {
		endScore sc = new endScore("Imeand", 100);
		assertTrue(led.getScoreList().isEmpty());
		led.addScore(sc);
		assertTrue(led.getScoreList().contains(sc));
	}
	
	@Test
	public void testAddScoreHighest() {
		endScore sc = new endScore("Imeand", 100);
		endScore sc1 = new endScore("Ding", 150);
		led.resetScoreList();
		assertTrue(led.getScoreList().isEmpty());
		led.addScore(sc);
		assertTrue(led.getScoreList().contains(sc));
		led.addScore(sc1);
		assertTrue(led.getScoreList().contains(sc1));
	}
	
	@Test
	public void testAddScoreFromN() {
		endScore sc = new endScore("Imeand", 100);
		endScore sc1 = new endScore("Uhu", 50);
		assertTrue(led.getScoreList().isEmpty());
		led.addScore(sc);
		assertTrue(led.getScoreList().contains(sc));
		led.addScore(sc1);
		assertTrue(led.getScoreList().contains(sc1));
	}

	@Test
	public void testSetScoreList() {
		endScore sc = new endScore("sodfj", 100);
		scoreList.add(sc);
		assertFalse(led.getScoreList().equals(scoreList));
		led.setScoreList(scoreList);
		assertTrue(led.getScoreList().equals(scoreList));
	}

	@Test
	public void testFullLeaderBoardEmpty() {
		led.resetScoreList();
		assertTrue(led.fullLeaderBoard().equals(""));
	}
	
	@Test
	public void testFullLeaderBoardOne() {
		led.resetScoreList();
		endScore sc = new endScore("ddd", 101);
		led.addScore(sc);
		assertTrue(led.fullLeaderBoard().equals("ddd:101\n"));
	}
	
	@Test
	public void testFullLeaderBoardN() {
		led.resetScoreList();
		endScore sc = new endScore("ddd", 101);
		endScore sc1 = new endScore("dddd", 20);
		led.addScore(sc);
		led.addScore(sc1);
		assertTrue(led.fullLeaderBoard().equals("ddd:101\ndddd:20\n"));
	}
	
	@Test
	public void testResetScoreList() {
		led.resetScoreList();
		assertTrue(led.getScoreList().isEmpty());
		led.addScore(new endScore("ding",100));
		assertTrue(led.getScoreList().size() == 1);
		led.resetScoreList();
		assertTrue(led.getScoreList().isEmpty());
	}
	
	@Test
	public void testAppendToFile() {
		led.appendToFile();
		File f = new File("leaderboard.txt");
		assertTrue(f.exists());
		assertFalse(f.isDirectory());
	}

}
