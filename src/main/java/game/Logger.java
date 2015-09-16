package game;

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
    
    private static java.util.Date date= new java.util.Date();
    private static SimpleDateFormat d = new SimpleDateFormat("dd-M-yyyy hh-mm-ss"); 
    
    /**
     * The logging method called to create a log object.
     * @param message
     * @param category
     * @param severity
     */
    public static void log(String message, int category, int severity){
        
        LogObject tempLog = new LogObject(message,category,severity);
        logList.add(tempLog);
        appendToFile(tempLog);
    }

    /**
     * write a log object to a text file.
     * @param log
     */
    public static void appendToFile(LogObject log) {
        PrintWriter writer;
        try {
<<<<<<< HEAD
            
           
              writer = new PrintWriter(new FileWriter("Logs/log "+d.format(date)+".txt",true));
            writer.println(log.toString());
=======
            writer = new PrintWriter(new FileWriter("Logs/log " + d.format(date) + ".txt", true));
            writer.println("[" + categoryString[log.getCategory()] + "] " + log.getMessage());
>>>>>>> 776108d593455101c84009fc3a497908dab48d66
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
            catch (IOException e) {
            e.printStackTrace();
        }

    }
    
<<<<<<< HEAD
    
    public static LinkedList<LogObject> getFilteredLogs( ArrayList<Integer> category, int minSeverity){
        LinkedList<LogObject> filteredList = new LinkedList<LogObject>();
        LogObject lo;
        for(int i = 0; i<logList.size(); i++){
            lo = logList.get(i);
            if(category.contains(lo.getCategory()) &&lo.getSeverity() <= minSeverity){
=======
    /**
     * Returns the list of logs filtered on category and severity.
     * @param category
     * @param minSeverity
     */
    public static LinkedList<LogObject> getFilteredLogs(ArrayList<Integer> category, int minSeverity) {
        LinkedList<LogObject> filteredList = new LinkedList<LogObject>();    
        LogObject lo;
        for (int i = 0; i < logList.size(); i++) {
            lo = logList.get(i);
            if (category.contains(lo.getCategory()) && lo.getSeverity() <= minSeverity) {
>>>>>>> 776108d593455101c84009fc3a497908dab48d66
                filteredList.add(lo);
            }
        }
        return filteredList;
    }
}
