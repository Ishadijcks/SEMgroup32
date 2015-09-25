package game;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.log.LogSettings;
import game.screens.StartScreen;

public class MainRunner {
	
	private static Driver driver;
	private static boolean driverIsSet;

	public MainRunner() {
		driverIsSet = false;
	}

	public static void main(String[] args) {
		driverIsSet = false;
		
		try {
			new StartScreen();
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(true){
			
			try{
				driver.driverHeart();
			}catch(Exception e){}

	        // 120 FPS
	        try {
				Thread.sleep(1000 / Settings.getFps());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        driver.totalFrames++;
	        if (LogSettings.isLogScreen() && driver.totalFrames % 500 == 0
	                && driver.game.inProgress()) {
	            LogSettings.getLogscreen().reloadData();
	        }
		}

	}
	
	public static void setDriver(Driver buildDriver) {
		driver = buildDriver;
		driverIsSet = true;
	}
	
	

}
