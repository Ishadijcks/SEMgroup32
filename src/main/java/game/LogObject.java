package game;

public class LogObject {
    private String message;
    private int category;
    public static String[] categoryString = {"Player Input","Player","Bubble Movement","Bubble","Collisions","Rope","Powerup","Game","Level"};
    public static String[] severityString = {"","ERROR","EXCEPTION","WARNING","INFO","DETAIL"};
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
    
    public String toString(){
        if (category < 0 || category >= categoryString.length){
            category = 8;
            severity = 1;
        }
        return "["+severityString[severity]+"] ["+categoryString[category]+"] "+ message;
    }

    
}
