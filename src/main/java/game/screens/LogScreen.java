package game.screens;

import game.NormalDriver;
import game.log.LogFilters;
import game.log.LogObject;
import game.log.Logger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

/**
 * Class that will make a screen for the logger.
 * 
 * @author Boning
 *
 */
public class LogScreen extends JFrame {

    JButton startButton;
    JButton button;
    private LogFilters filters;
    private NormalDriver driver;
    private JList list;
    private Container pane;
    private ArrayList<JCheckBox> checkList;
    Font boldFont;
    Font basicFont;
    private ButtonGroup group;
    private JFrame frame;
    private JPanel mainPanel;

    /**
     * Constructor for the log screen class.
     * 
     * @throws UnsupportedAudioFileException
     *             exception
     * @throws IOException
     *             exception
     * @throws LineUnavailableException
     *             exception
     */
    public LogScreen() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {

        driver = new NormalDriver();
        filters = new LogFilters();
        boldFont = new Font("Serif", Font.BOLD, 18);
        basicFont = new Font("Serif", Font.PLAIN, 16);
        frame = new JFrame("Logging Screen");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        // Title top the screen
        JLabel textLog = new JLabel("Log");
        textLog.setFont(boldFont);
        // Right panel with category and Severity
        JPanel rightPanel = makeRightPanel();
        // Center Panel for the log self
        mainPanel = makeMainPanel();
        // Add every panel to the main frame
        add(textLog, BorderLayout.PAGE_START);
        add(mainPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
        setVisible(true);

    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Reload the log list for new content.
     */
    public void reloadData() {
        frame.remove(mainPanel);
        mainPanel = makeMainPanel();
        frame.add(mainPanel);
        frame.invalidate();
        frame.validate();
        frame.repaint();
    }

    /**
     * Makes the main panel.
     * 
     * @return main panel
     */
    private JPanel makeMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel mainInnerPanel = makeMainInnerPanel();
        JScrollPane scrollPane = new JScrollPane(mainInnerPanel);
        mainPanel.add(scrollPane);
        return mainPanel;
    }

    /**
     * Makes the right panel.
     * 
     * @return right panel
     */
    private JPanel makeRightPanel() {
        JPanel rightPanel = new JPanel();
        addCategory(rightPanel);    
        addTextSeverity(rightPanel);
        return rightPanel;
    }

    /**
     * Add the text severity labels and buttons.
     */
    private void addTextSeverity(JPanel rightPanel) {
        JLabel textSeverity = new JLabel("Severity");
        textSeverity.setFont(boldFont);
        rightPanel.add(textSeverity);
        ItemListener radioListener = radioButtonListener();
        String[] sev = LogObject.getSeverityNames();
        group = new ButtonGroup();
        for (int i = 1; i < sev.length; i++) {
            JRadioButton textSev = new JRadioButton(sev[i]);
            textSev.setFont(basicFont);
            textSev.setName(Integer.toString(i));
            rightPanel.add(textSev);
            textSev.addItemListener(radioListener);
            group.add(textSev);
        }
    }

    /**
     * Add the category box with text and checkbuttons.
     * 
     * @param rightPanel
     */
    private void addCategory(JPanel rightPanel) {
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JLabel textCategory = new JLabel("Category");
        textCategory.setFont(boldFont);
        rightPanel.add(textCategory);
        ItemListener checkboxListener = checkboxListener();
        checkList = new ArrayList<JCheckBox>();
        String[] cat = LogObject.getCategoryNames();
        for (int i = 0; i < cat.length; i++) {
            JCheckBox textCat = new JCheckBox(cat[i]);
            checkList.add(textCat);
            textCat.setFont(basicFont);
            rightPanel.add(textCat);
            textCat.addItemListener(checkboxListener);
        }
    }

    /**
     * Checks if a checkbox is clicked or not.
     * 
     * @return item listener
     */
    private ItemListener checkboxListener() {
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Object source = e.getItemSelectable();
                for (int i = 0; i < checkList.size(); i++) {
                    if (source == checkList.get(i)) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            filters.addCategory(i);
                        } else {
                            filters.removeCategory(i);
                        }
                    }
                }
            }
        };
        return itemListener;
    }

    /**
     * Checks if a radio button is clicked or not.
     * 
     * @return item listener
     */
    private ItemListener radioButtonListener() {
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                JRadioButton source = (JRadioButton) e.getItemSelectable();
                filters.setSeverity(Integer.parseInt(source.getName()));
            }
        };
        return itemListener;
    }

    /**
     * Makes the horizontal panel.
     * 
     * @param severity
     *            how many activities the logger will show
     * @param labelValues
     *            types of labels
     * @return horizontal panel
     */
    private JPanel makeHorizontalPanel(int severity, String... labelValues) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (String s : labelValues) {
            JLabel label = new JLabel(s);
            switch (severity) {
            case 1:
                label.setForeground(Color.red);
                break;
            case 2:
                label.setForeground(Color.orange);
                break;
            case 3:
                Color color = new Color(200, 150, 10);
                label.setForeground(color);
                break;
            case 4:
                label.setForeground(Color.blue);
                break;
            case 5:
                label.setForeground(Color.gray);
                break;
            default:
                break;
            }
            panel.add(label);
        }
        return panel;
    }

    /**
     * Makes the inner panel.
     * 
     * @return inner panel
     */
    private JPanel makeMainInnerPanel() {
        ArrayList<Integer> category = filters.getCategory();
        int severity = filters.getSeverity();
        LinkedList<LogObject> ll = Logger.getFilteredLogs(category, severity);
        ArrayList<JPanel> jPanels = new ArrayList<JPanel>();
        for (int i = ll.size() - 1; i > -1; i--) {
            jPanels.add(makeHorizontalPanel(ll.get(i).getSeverity(), ll.get(i)
                    .toStringShort()));
        }
        JPanel mainInnerPanel = new JPanel();
        mainInnerPanel
                .setLayout(new BoxLayout(mainInnerPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < jPanels.size(); i++) {
            mainInnerPanel.add(jPanels.get(i));
        }
        return mainInnerPanel;
    }

}
