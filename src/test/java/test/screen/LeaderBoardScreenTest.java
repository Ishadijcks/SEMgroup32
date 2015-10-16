package test.screen;

import static org.junit.Assert.assertFalse;
import game.EndScore;
import game.Leaderboard;
import game.screens.LeaderBoardScreen;

import org.junit.Test;

public class LeaderBoardScreenTest {

    @Test
    public void testLeaderBoardScreen() {
        Leaderboard lb = new Leaderboard();
        EndScore es = new EndScore("Tester", 500);
        lb.addScore(es);
        LeaderBoardScreen lsb = new LeaderBoardScreen(lb);
        lsb.addScoreList();
        assertFalse(lsb == null);
    }
}
