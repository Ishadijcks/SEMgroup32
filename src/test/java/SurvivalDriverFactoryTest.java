import static org.junit.Assert.assertTrue;
import game.Driver;
import game.SurvivalDriverFactory;

import org.junit.Before;
import org.junit.Test;

public class SurvivalDriverFactoryTest {

    SurvivalDriverFactory ndf;

    @Before
    public void init() {
        ndf = new SurvivalDriverFactory();
    }

    @Test
    public void testFactory() {
        Driver driver = ndf.buildDriver();
        assertTrue(driver.toString() != null);
    }

}
