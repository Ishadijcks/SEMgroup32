package game;

import game.log.LogObject;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Leaderboard {
    
    private static ArrayList<endScore> scoreList = new ArrayList<endScore>();
    
    public void addScore(endScore newScore) {
        if(scoreList.size() != 0)
        {
            for(int i = 0; i < scoreList.size(); i++) {
                if(scoreList.get(i).getScore() < newScore.getScore())
                {
                    scoreList.add(i, newScore);
                    return;
                }
            }
            scoreList.add(newScore);
            return;
        }
        else
        {
            scoreList.add(newScore);
        }
    }

    public ArrayList<endScore> getScoreList() {
        return scoreList;
    }

    public void setScoreList(ArrayList<endScore> scoreList) {
        this.scoreList = scoreList;
    }
    
    /**
     * write the Leaderboard to a text file.
     * 
     * @param log
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
    
    public static String fullLeaderBoard()
    {
        String empty = "";
        if(scoreList.size() != 0)
        {
            String res = "";
            for(int i = 0; i < scoreList.size(); i++)
            {
                res = res + scoreList.get(i).toString() + "\n";
            }
            return res;
        }
        
        return empty;
    }

}
