import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import game.EndScore;

import org.junit.Before;
import org.junit.Test;

public class endScoreTest {

    private EndScore score;

    @Before
    public void init() {
        score = new EndScore("testPerson", 500);
    }

    @Test
    public void testEndScore() {
        assertTrue(score.getName().equals("testPerson"));
        assertTrue(score.getScore() == 500);
    }

    @Test
    public void testSetName() {
        assertTrue(score.getName().equals("testPerson"));
        score.setName("TestPerson");
        assertTrue(score.getName().equals("TestPerson"));
    }

    @Test
    public void testSetScore() {
        assertTrue(score.getScore() == 500);
        score.setScore(0);
        assertTrue(score.getScore() == 0);
    }

    @Test
    public void testToString() {
        assertEquals("testPerson:500", score.toString());
    }

}
