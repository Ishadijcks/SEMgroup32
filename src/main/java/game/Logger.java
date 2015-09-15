package game;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

public class Logger {

    private LinkedList<LogObject> logList = new LinkedList<LogObject>();
    
    public void log(String message, short category, short severity){
        
        LogObject tempLog = new LogObject(message,category,severity);
        logList.add(tempLog);
        appendToFile(tempLog);
    }

    public void appendToFile(LogObject log){
        PrintWriter writer;
        try {
            writer = new PrintWriter("the-file-name.txt", "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
