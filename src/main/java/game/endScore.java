package game;

public class endScore {
    
    private String name;
    private int score;
    
    public endScore(String name, int score) {
    
    this.name = name;
    this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public String toString()
    {
        String res = name;
        res = res + ":" + score;
        return res;
    }
}