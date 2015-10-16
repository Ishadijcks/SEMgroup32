import static org.junit.Assert.*;
import game.MainRunner;
import game.NormalDriverFactory;

import org.junit.Before;
import org.junit.Test;

public class MainRunnerTest {
    MainRunner mr;

    @Before
    public void init() {
        mr = new MainRunner();
    }

    @Test
    public void SetDrivertest() {
        NormalDriverFactory driverFactory = new NormalDriverFactory();
        mr.setDriver(driverFactory.buildDriver());
        assertTrue(mr.toString() != null);
    }

}
