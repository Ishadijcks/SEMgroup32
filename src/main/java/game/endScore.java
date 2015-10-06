package game;

/** 
 * Class the will keep the score at the end of a game session.
 * @author Boning
 *
 */
public class endScore {
    
    private String name;
    private int score;
    
    /** 
     * Constructor of the endScore.
     * @param name Name of the player
     * @param score Score that the player got
     */
    public endScore(String name, int score) {
	    this.name = name;
	    this.score = score;
    }

    /** 
     * Getter for the name of the player.
     * @return Name of the player
     */
    public String getName() {
        return name;
    }

    /** 
     * Setter for the name of the player.
     * @param name Name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the score of the player.
     * @return Score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the score of the player.
     * @param score Score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /** 
     * Gives a string representation of this class.
     * @return String of the name + the score of the player
     */
    public String toString() {
        String res = name;
        res = res + ":" + score;
        return res;
    }
}
