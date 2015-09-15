package game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Logger {
    public static String[] categoryString = {"Player Input","Player","Bubble Movement","Bubble","Collisions","Rope","Powerup","Game","Level"};
    private static LinkedList<LogObject> logList = new LinkedList<LogObject>();
    
    private static java.util.Date date= new java.util.Date();
    private static SimpleDateFormat d = new SimpleDateFormat("dd-M-yyyy hh-mm-ss"); 
    
    public static void log(String message, int category, int severity){
        
        LogObject tempLog = new LogObject(message,category,severity);
        logList.add(tempLog);
        appendToFile(tempLog);
    }

    public static void appendToFile(LogObject log){
        PrintWriter writer;
        try {
            
           
            System.out.println(d.format(date));
            writer = new PrintWriter(new FileWriter("Logs/log "+d.format(date)+".txt",true));
            writer.println("["+categoryString[log.getCategory()]+"] "+log.getMessage());
            writer.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

    }
}
