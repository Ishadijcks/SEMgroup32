package game;

/**
 * A simple log object.
 * @author Tim
 *
 */
public class LogObject {
    private String message;
    private int category;

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

    
}
