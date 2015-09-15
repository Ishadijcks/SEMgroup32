package game;

public class LogObject {
    private String message;
    private int category;

    private int severity;
    
    public LogObject(String message, int category2, int severity2){
        this.message = message;
        this.category = category2;
        this.severity = severity2;
    }
    
    
    
    public String getMessage() {
        return message;
    }

    public int getCategory() {
        return category;
    }

    public int getSeverity() {
        return severity;
    }

    
}
