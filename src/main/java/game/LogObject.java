package game;

public class LogObject {
    private String message;
    private short category;

    private short severity;
    
    public LogObject(String message, short category, short severity){
        this.message = message;
        this.category = category;
        this.severity = severity;
    }
    
    
    
    public String getMessage() {
        return message;
    }

    public short getCategory() {
        return category;
    }

    public short getSeverity() {
        return severity;
    }

    
}
