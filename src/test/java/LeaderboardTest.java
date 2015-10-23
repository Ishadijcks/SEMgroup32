import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.EndScore;
import game.Leaderboard;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LeaderboardTest {

    private ArrayList<EndScore> scoreList;
    private Leaderboard led;

    @Before
    public void init() {
        led = new Leaderboard();
        scoreList = new ArrayList<EndScore>();
    }

    @Test
    public void testAddScoreFromZero() {
        EndScore sc = new EndScore("Imeand", 100);
        assertTrue(led.getScoreList().isEmpty());
        led.addScore(sc);
        assertTrue(led.getScoreList().contains(sc));
    }

    @Test
    public void testAddScoreHighest() {
        EndScore sc = new EndScore("Imeand", 100);
        EndScore sc1 = new EndScore("Ding", 150);
        led.resetScoreList();
        assertTrue(led.getScoreList().isEmpty());
        led.addScore(sc);
        assertTrue(led.getScoreList().contains(sc));
        led.addScore(sc1);
        assertTrue(led.getScoreList().contains(sc1));
    }

    @Test
    public void testAddScoreFromN() {
        led = new Leaderboard();
        EndScore sc = new EndScore("Imeand", 100);
        EndScore sc1 = new EndScore("Uhu", 50);
        led.addScore(sc);
        assertTrue(led.getScoreList().contains(sc));
        led.addScore(sc1);
        assertTrue(led.getScoreList().contains(sc1));
    }

    @Test
    public void testSetScoreList() {
        EndScore sc = new EndScore("sodfj", 100);
        scoreList.add(sc);
        assertFalse(led.getScoreList().equals(scoreList));
        led.setScoreList(scoreList);
        assertTrue(led.getScoreList().equals(scoreList));
    }

    @Test
    public void testFullLeaderBoardEmpty() {
        led.resetScoreList();
        assertTrue(Leaderboard.fullLeaderBoard().equals(""));
    }

    @Test
    public void testFullLeaderBoardOne() {
        led.resetScoreList();
        EndScore sc = new EndScore("ddd", 101);
        led.addScore(sc);
        assertTrue(Leaderboard.fullLeaderBoard().equals("ddd:101\n"));
    }

    @Test
    public void testFullLeaderBoardN() {
        led.resetScoreList();
        EndScore sc = new EndScore("ddd", 101);
        EndScore sc1 = new EndScore("dddd", 20);
        led.addScore(sc);
        led.addScore(sc1);
        assertTrue(Leaderboard.fullLeaderBoard().equals("ddd:101\ndddd:20\n"));
    }

    @Test
    public void testResetScoreList() {
        led.resetScoreList();
        assertTrue(led.getScoreList().isEmpty());
        led.addScore(new EndScore("ding", 100));
        assertTrue(led.getScoreList().size() == 1);
        led.resetScoreList();
        assertTrue(led.getScoreList().isEmpty());
    }

    @Test
    public void testAppendToFile() {
        Leaderboard.appendToFile();
        File f = new File("leaderboard.txt");
        assertTrue(f.exists());
        assertFalse(f.isDirectory());
    }

}
