import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StartScreen extends JFrame{

	JButton startButton;
	JButton settingsButton;
	JButton stopButton;
	
	    public StartScreen(){
	    	
	    setTitle("Start screen");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		URL location = StartScreen.class.getProtectionDomain().getCodeSource().getLocation();
		String imageLocation = location.getFile();
		
	    setLayout(new BorderLayout());
	    setContentPane(new JLabel(new ImageIcon(imageLocation + "Images/StartscreenBackground.png")));
	    setLayout(new FlowLayout());
	    
	    startButton = new JButton("Start game");
	    startButton.setBackground(Color.RED);
	    startButton.setForeground(Color.WHITE);
	    startButton.setFont(new Font("Calibri", Font.BOLD, 30));
	    startButton.setOpaque(true);
	    startButton.setPreferredSize(new Dimension(200, 50));
	    startButton.setLocation(50, 50);
	    
	    settingsButton = new JButton("Settings");
	    settingsButton.setBackground(Color.RED);
	    settingsButton.setForeground(Color.WHITE);
	    settingsButton.setFont(new Font("Calibri", Font.BOLD, 30));
	    settingsButton.setOpaque(true);
	    settingsButton.setPreferredSize(new Dimension(200, 50));
	    
	    stopButton = new JButton("Stop");
	    stopButton.setBackground(Color.RED);
	    stopButton.setForeground(Color.WHITE);
	    stopButton.setFont(new Font("Calibri", Font.BOLD, 30));
	    stopButton.setOpaque(true);
	    stopButton.setPreferredSize(new Dimension(200, 50));
	    
	    startButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent startGame)
	      {
	        setVisible(false);
	        dispose();
	        Driver driver = new Driver();
	      }
	    });

	    stopButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent closeScreen)
	      {
	        setVisible(false);
	        dispose();
	      }
	    });
	    
	    add(startButton);
	    add(settingsButton);
	    add(stopButton);

	    setSize(699,699);
	    setSize(700,700);
	    
	    }
	    
	    public static void main(String args[]){
	    	
	    new StartScreen();
	    
	    }
}
