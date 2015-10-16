
import static org.junit.Assert.*;

import java.util.Random;

import game.NormalDriver;
import game.Score;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {

    private Score score;
    private Score score2;

    @Before
    public void init() {
        score = Score.getInstance();
        score2 = Score.getInstance();
    }

    @Test
    public void testAddScoreAndSingelton() {
        score.addScore(2);
        assertEquals(score.getScore(), 2);
        assertEquals(score2.getScore(), score.getScore());
    }

}
