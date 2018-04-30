
public class Team {
    private String name;
    private int rank;
    private int score;
    
    Team(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.score = -1;
    }
    
    public String getTeamName() {
        return this.name;
    }
    
    public int getTeamRank() {
        return this.rank;
    }
    
    public int getTeamScore() {
        return this.score;
    }
    
    public void setTeamScore(int score) {
        this.score = score;
    }
}
