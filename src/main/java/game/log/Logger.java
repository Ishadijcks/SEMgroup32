package game.log;

import game.Driver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
     * @param message
     * @param category
     * @param severity
     */
    public static void log(String message, int category, int severity,
            int frameRepeat) {
        if (Driver.totalFrames % frameRepeat == 0) {

            LogObject tempLog = new LogObject(message, category, severity);
            logList.add(tempLog);
            appendToFile(tempLog);
        }
    }

    /**
     * The logging method called to create a log object.
     * 
     * @param message
     * @param category
     * @param severity
     */
    public static void log(String message, int category, int severity) {
            LogObject tempLog = new LogObject(message, category, severity);
            logList.add(tempLog);
            appendToFile(tempLog);
    }

    /**
     * write a log object to a text file.
     * 
     * @param log
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
     * 
     * @param category
     * @param minSeverity
     */
    public static LinkedList<LogObject> getFilteredLogs(
            ArrayList<Integer> category, int minSeverity) {
        LinkedList<LogObject> filteredList = new LinkedList<LogObject>();
        LogObject lo;
            //System.out.println(logList);
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
	 * @return the logList
	 */
	public static LinkedList<LogObject> getLogList() {
		return logList;
	}

}
