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

import java.util.*;
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
                try {
                    LogScreen.main(null);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("repaint");
                
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
            System.out.println("paint");
            g2d = (Graphics2D) graph;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            Color black = new Color(0, 0, 0);
            g2d.setFont(new Font("Calibri", Font.BOLD, 40));
            g2d.drawString("Log: ", 50,  50);
            g2d.setColor(black);
            g2d.drawRect(50, 50, 600, 400);

            ArrayList<Integer> category = new ArrayList<Integer>();
            category.add(1);
            category.add(2);
            category.add(3);
            LinkedList<LogObject> ll = Logger.getFilteredLogs(category, 5);
            g2d.setFont(new Font("Calibri", Font.PLAIN, 14));
            int size = ll.size();
            for (int i = 0; i < size; i++) {
            g2d.drawString(ll.pop().getMessage(), 65, 80 + 17 * i);
            }
            
        } catch (IndexOutOfBoundsException e) {
            
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main called");
        while (true) {
        Thread.sleep(1000);
        }
    }
}
