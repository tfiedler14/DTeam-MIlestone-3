/////////////////////////////////////////////////////////////////////////////
// Semester:         CS400 Spring 2018
// PROJECT:          Tournament Bracket (CS400 Final)
// FILES:            Main.java
//                   Game.java
//                   Team.java
//
// AUTHORS:          Steven Berry
//                   Tom Fiedler
//                   Mike Espe
//                   Collin Dedrick
//
// Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
// Bugs:             no known bugs
//
// May 3, 2018 Team.java 
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Team Class - an Abstract Data Type
 * Stores the name, rank, and score of a team.
 * Specific to its game, instances of the Team class are created
 * for each game a team participates in, not once for each team.
 * 
 * @author Steven Berry, Tom Fiedler, Mike Espe, Collin Dedrick
 *
 */
public class Team {
    //Instance data fields
    private String name;
    private int rank;
    private int score; // 0 <= score. If score = -1, game hasn't been completed. 
    
    /**
     * Constructor used by Main to create a new team.
     * Initializes score to -1.
     * @param name is the name of the team.
     * @param rank is the rank of the team.
     *             assumed to be 1 <= rank <= number of teams
     */
    Team(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.score = -1;
    }
    
    /**
     * Getter method for the name of the team.
     * @return the name of the team.
     */
    public String getTeamName() {
        return this.name;
    }
    /**
     * Getter method for the rank of the team.
     * @return the rank of the team.
     */
    public int getTeamRank() {
        return this.rank;
    }
    
    /**
     * Getter method for the score of the team.
     * @return the score of the team.
     *         -1 if the game has not been played.
     */
    public int getTeamScore() {
        return this.score;
    }
    
    /**
     * Setter method for the score of the team.
     * @param score is the score to be set.
     *              assumed to be a valid score (0 <= score)
     */
    public void setTeamScore(int score) {
        this.score = score;
    }
}
