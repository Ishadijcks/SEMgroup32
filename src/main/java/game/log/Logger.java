package game.log;

import game.NormalDriver;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class of the logger.
 * @author Boning
 *
 */
public class Logger {
    private static LinkedList<LogObject> logList = new LinkedList<LogObject>();
    public static String[] categoryString = { "Player Input", "Player",
            "Bubble Movement", "Bubble", "Collisions", "Rope", "Powerup",
            "Game", "Level", "UI" };
    public static String[] severityString = { "", "ERROR", "EXCEPTION",
            "WARNING", "INFO", "DETAIL" };

    private static java.util.Date date = new java.util.Date();
    private static SimpleDateFormat d = new SimpleDateFormat(
            "dd-M-yyyy hh-mm-ss");

    /**
     * The logging method called to create a log object.
     * 
     * @param message that will be logged
     * @param category of the message
     * @param severity of the logger
     * @param frameRepeat repeat it for x frames
     */
    public static void log(String message, int category, int severity,
            int frameRepeat) {
        if (NormalDriver.getTotalFrames() % frameRepeat == 0) {

            LogObject tempLog = new LogObject(message, category, severity);
            logList.add(tempLog);
            appendToFile(tempLog);
        }
    }

    /**
     * The logging method called to create a log object.
     * 
     * @param message that will be logged
     * @param category of the message
     * @param severity of the logger
     */
    public static void log(String message, int category, int severity) {
            LogObject tempLog = new LogObject(message, category, severity);
            logList.add(tempLog);
            appendToFile(tempLog);
    }

    /**
     * Write a log object to a text file.
     * 
     * @param log logger 
     */
    public static void appendToFile(LogObject log) {
        PrintWriter writer;
        try {

            writer = new PrintWriter(new FileWriter("Logs/log "
                    + d.format(date) + ".txt", true));
            writer.println(log.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns the list of logs filtered on category and severity.
     * @param category of the message
     * @param minSeverity of the logger
     * @return list of loggers
     */
    public static LinkedList<LogObject> getFilteredLogs(
            ArrayList<Integer> category, int minSeverity) {
        LinkedList<LogObject> filteredList = new LinkedList<LogObject>();
        LogObject lo;
        for (int i = 0; i < logList.size(); i++) {
            lo = logList.get(i);
            if (category.contains(lo.getCategory())
                    && lo.getSeverity() <= minSeverity) {
                filteredList.add(lo);
            }
        }
        return filteredList;
    }

	/**
	 * Getter for the log list.
	 * @return the logList
	 */
	public static LinkedList<LogObject> getLogList() {
		return logList;
	}

}
