

import static org.junit.Assert.*;

import java.util.Random;

import game.NormalDriver;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
	
	private NormalDriver driver;
	
	@Before
	public void init(){
		driver = new NormalDriver();
		driver.setupGame();
		driver.initDriver();
	}
}
