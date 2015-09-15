package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LogScreen extends JFrame {

    JButton startButton;
    private Graphics2D g2d;
    private Driver driver;
    

    public LogScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

        
        setTitle("Log screen");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        URL location = LogScreen.class.getProtectionDomain().getCodeSource().getLocation();
        
        setVisible(true);

        setLayout(null);
        setResizable(false);
      
        setSize(699, 699);
        setSize(700, 700);
        createButton();

        driver = new Driver();
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent startGame) {
                driver.repaint();
            }
        });
        
        add(startButton);

    }
    /**
     * Create button method.
     */
    public void createButton() {
        startButton = new JButton("Start log");
        startButton.setBackground(Color.RED);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Calibri", Font.BOLD, 30));
        startButton.setOpaque(true);
        startButton.setBounds(55, 300, 250, 60);
    }
    @Override
    public void paint(Graphics graph) {
        try {
            super.paint(graph);
            System.out.println("aaa");
            g2d = (Graphics2D) graph;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.drawString("Score: ", 10,  10);
            Color black = new Color(0, 0, 0);
            g2d.setColor(black);
        } catch (IndexOutOfBoundsException e) {
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main called");
        while (true) {
        // 120 FPS
        Thread.sleep(1000 / Settings.getFps());
        }
    }
}
