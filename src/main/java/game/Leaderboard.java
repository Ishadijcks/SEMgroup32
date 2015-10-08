package game;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Class that will make a leaderboard.
 * @author Boning
 *
 */
public class Leaderboard {
    
    private static ArrayList<EndScore> scoreList = new ArrayList<EndScore>();
    
    /**
     * Add a new score to the leaderboard.
     * @param newScore New score that will be added
     */
    public void addScore(EndScore newScore) {
        if (scoreList.size() != 0) {
            for (int i = 0; i < scoreList.size(); i++) {
                if (scoreList.get(i).getScore() < newScore.getScore()) {
                    scoreList.add(i, newScore);
                    return;
                }
            }
            scoreList.add(newScore);
            return;
        }
        else {
            scoreList.add(newScore);
        }
    }

    /**
     * Getter for the score list.
     * @return List of the scores
     */
    public ArrayList<EndScore> getScoreList() {
        return scoreList;
    }

    /**
     * Setter for the score list.
     * @param scoreList A new score list that will be used
     */
    public void setScoreList(ArrayList<EndScore> scoreList) {
        this.scoreList = scoreList;
    }
    
    /**
     * Reset the score list.
     */
    public void resetScoreList() {
    	this.scoreList = new ArrayList<EndScore>();
    }
    
    /**
     * write the leaderboard to a text file.
     * 
     */
    public static void appendToFile() {
        PrintWriter writer;
        try {

            writer = new PrintWriter(new FileWriter("leaderboard.txt", false));
            writer.println(fullLeaderBoard());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Gives a string representation of the leaderboard.
     * @return String of all scores
     */
    public static String fullLeaderBoard() {
        String empty = "";
        if (scoreList.size() != 0) {
            String res = "";
            for (int i = 0; i < scoreList.size(); i++) {
                res = res + scoreList.get(i).toString() + "\n";
            }
            return res;
        }
        
        return empty;
    }

}
