import static org.junit.Assert.*;
import game.Driver;
import game.NormalDriverFactory;

import org.junit.Before;
import org.junit.Test;

public class NormalDriverFactoryTest {

    NormalDriverFactory ndf;

    @Before
    public void init() {
        ndf = new NormalDriverFactory();
    }

    @Test
    public void testFactory() {
        Driver driver = ndf.buildDriver();
        assertTrue(driver.toString() != null);
    }

}
