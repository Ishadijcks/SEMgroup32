package game;

import java.util.ArrayList;

public class LogFilters {
    /*
     * categoryString = { "Player Input", "Player","Bubble Movement", "Bubble",
     * "Collisions", "Rope", "Powerup", "Game", "Level", "UI" }; severityString
     * = { "", "ERROR", "EXCEPTION", "WARNING", "INFO", "DETAIL" };
     */
    private ArrayList<Integer> category;
    private int severity;

    public LogFilters(){
        category = new ArrayList<Integer>();
        category.add(1);
        category.add(2);
        category.add(3);
        category.add(4);
        severity = 5;
    }
    /**
     * @return the category
     */
    public ArrayList<Integer> getCategory() {
        return category;
    }

    /**
     * @param category
     *            add a category
     */
    public void addCategory(Integer category) {
        if (!this.category.contains(category)) {
            this.category.add(category);
        }
    }

    /**
     * @param category
     *       Remove a category 
     */
    public void removeCategory(Integer category) {
        for (int i = 0; i < this.category.size(); i++) {
            if (this.category.get(i) == category) {
                this.category.remove(i);
            }
        }
    }

    /**
     * @return the severity
     */
    public int getSeverity() {
        return severity;
    }

    /**
     * @param severity
     *            the severity to set
     */
    public void setSeverity(int severity) {
            this.severity = severity;
    }
}
