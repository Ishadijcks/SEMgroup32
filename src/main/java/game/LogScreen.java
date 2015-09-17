package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class LogScreen extends JFrame {

    JButton startButton;
    JButton button;
    private Graphics2D g2d;
    private Driver driver;
    private JList list;
    private Container pane;

    public LogScreen() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {

        driver = new Driver();
        String title = "Log Screen";

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Logging Screen");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Font boldFont = new Font("Serif", Font.BOLD, 18);
        Font basicFont = new Font("Serif", Font.PLAIN, 16);

        JLabel textLog = new JLabel("Log");
        textLog.setFont(boldFont);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JLabel textCategory = new JLabel("Category");
        textCategory.setFont(boldFont);
        rightPanel.add(textCategory);

        String[] cat = Logger.getCategory();
        for (int i = 0; i < cat.length; i++) {
            JLabel textCat = new JLabel(cat[i]);
            textCat.setFont(basicFont);
            rightPanel.add(textCat);
        }

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel mainInnerPanel = makeMainInnerPanel();

        JScrollPane scrollPane = new JScrollPane(mainInnerPanel);
        mainPanel.add(scrollPane);

        // mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        frame.add(textLog, BorderLayout.PAGE_START);
        frame.add(new JButton("Button 4"), BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.LINE_END);

        frame.add(mainPanel);
        frame.setVisible(true);
        /*
         * startButton.addActionListener(new ActionListener() { public void
         * actionPerformed(ActionEvent startGame) { driver.repaint(); } });
         * frame.add(startButton); pane.add(button, BorderLayout.PAGE_START);
         */

    }

    private JPanel makeHorizontalPanel(String... labelValues) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (String s : labelValues) {
            JLabel label = new JLabel(s);
            panel.add(label);
        }
        return panel;
    }

    private JPanel makeMainInnerPanel() {

        Font basicFont = new Font("Serif", Font.PLAIN, 16);
        ArrayList<Integer> category = new ArrayList<Integer>();
        category.add(1);
        category.add(2);
        category.add(3);
        LinkedList<LogObject> ll = Logger.getFilteredLogs(category, 5);
        int size = ll.size();
        ArrayList<JPanel> jPanels = new ArrayList<JPanel>();
        for (int i = 0; i < size; i++) {
            jPanels.add(makeHorizontalPanel(ll.pop().getMessage()));
        }
        JPanel mainInnerPanel = new JPanel();
        mainInnerPanel.setLayout(new BoxLayout(mainInnerPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < jPanels.size(); i++) {
            mainInnerPanel.add(jPanels.get(i));
        }
        return mainInnerPanel;
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
            g2d.drawString("Log: ", 50, 50);
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
}
