package game;

/**
 * A simple log object.
 * @author Tim, Isha
 *
 */
public class LogObject {
    private String message;
    private int category;
    public static String[] categoryString = {"Player Input","Player","Bubble Movement","Bubble","Collisions","Rope","Powerup","Game","Level"};
    public static String[] severityString = {"","ERROR","EXCEPTION","WARNING","INFO","DETAIL"};
    private int severity;
    
    /**
     * The constructor for the log object.
     * @param message
     * @param categoryInput
     * @param severityInput
     */
    public LogObject(String message, int categoryInput, int severityInput){
        this.message = message;
        this.category = categoryInput;
        this.severity = severityInput;
    }
    
    
    /**
     * get Message.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * get Category.
     * @return category
     */
    public int getCategory() {
        return category;
    }

    /**
     * get severity.
     * @return severity
     */
    public int getSeverity() {
        return severity;
    }
    
    public String toString(){
        if (category < 0 || category >= categoryString.length){
            category = 8;
            severity = 1;
        }
        return "["+severityString[severity]+"] ["+categoryString[category]+"] "+ message;
    }

    
}
