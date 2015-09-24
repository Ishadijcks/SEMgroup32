package game.screens;

import java.awt.Color;
import java.awt.Font;

import game.Leaderboard;
import game.Settings;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LeaderBoardScreen extends JFrame {
    
    Leaderboard lb;
    static JLabel[] allLabels = new JLabel[500];
    
    public LeaderBoardScreen(Leaderboard lb) {
        setTitle("Leaderboard");
        setSize(450, 450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        
        this.lb = lb;
        
        Font font = new Font("Calibri", Font.PLAIN, 30);
        
        for(int i = 0; i < lb.getScoreList().size(); i++) {
        allLabels[i] = new JLabel((i + 1) + ". " + lb.getScoreList().get(i).toString());
        allLabels[i].setFont(font);
        allLabels[i].setForeground(Color.BLACK);
        allLabels[i].setBounds(20, i * 42, 420, 35);
        add(allLabels[i]);
    }
        
    }

}
