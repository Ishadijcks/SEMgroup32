package game.log;

/**
 * A simple log object.
 * 
 * @author Tim, Isha
 *
 */
public class LogObject {
    private String message;
    private int category;
    public static String[] categoryString = { "Player Input", "Player",
            "Bubble Movement", "Bubble", "Collisions", "Rope", "Powerup",
            "Game", "Level", "UI" };
    public static String[] severityString = { "", "ERROR", "EXCEPTION",
            "WARNING", "INFO", "DETAIL" };
    private int severity;

    /**
     * The constructor for the log object.
     * 
     * @param message of the logger
     * @param categoryInput of the message
     * @param severityInput of the logger
     */
    public LogObject(String message, int categoryInput, int severityInput) {
        this.message = message;
        this.category = categoryInput;
        this.severity = severityInput;
    }

    /**
     * get Message.
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * get Category.
     * 
     * @return category
     */
    public int getCategory() {
        return category;
    }

    /**
     * get severity.
     * 
     * @return severity
     */
    public int getSeverity() {
        return severity;
    }

    /**
     * method that converts the integer to a string.
     * @return string
     */
    public String toString() {
        if (category < 0 || category >= categoryString.length) {
            category = 8;
            severity = 1;
        }
        return "[" + severityString[severity] + "] ["
                + categoryString[category] + "] " + message;
    }

    /**
     * method that converts the integer to a string.
     * @return string
     */
    public String toStringShort() {
        if (category < 0 || category >= categoryString.length) {
            category = 8;
            severity = 1;
        }
        return "[" + categoryString[category] + "] " + message;
    }

    
    /**
     * get Category names.
     * 
     * @return string
     */
    public static String[] getCategoryNames() {
        return categoryString;
    }

    /**
     * get severity names..
     * 
     * @return string
     */
    public static String[] getSeverityNames() {
        return severityString;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LogObject other = (LogObject) obj;
		if (category != other.category) {
			return false;
		}
		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		if (severity != other.severity) {
			return false;
		}
		return true;
	}

}
