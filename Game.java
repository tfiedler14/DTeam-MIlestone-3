///////////////////////////////////////////////////////////////////////////////
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
// May 3, 2018 Game.java 
///////////////////////////////////////////////////////////////////////////////


/**
 * Team Game - an Abstract Data Type
 * Stores references to the teams playing in the game.
 * Stores references to the two games previous to this game (unless this is a round one game). 
 * After the game is played and scores are input, can return the winner.
 * 
 * @author Steven Berry, Tom Fiedler, Mike Espe, Collin Dedrick
 *
 */
public class Game {
    //Instance data fields
    private Team team1;
    private Team team2;
    private Game prevGame1; 
    private Game prevGame2;
    
    /**
     * Constructor used by Main to create a new game.
     * Initializes previous games to null.
     * 
     * @param team1 is the first team playing in the game.
     * @param team2 is the second team playing in the game.
     */
    public Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    
    /**
     * Constructor used by Main to create a new game.
     * Initializes previous games to null. 
     * 
     * This constructor initializes team1 and team2 as null.
     */
    public Game() {
        this(null, null);
    }
    
    /**
     * Computes the winner of the game, if one exists.
     * 
     * @return null if teams aren't defined.
     *         null if scores aren't correctly defined.
     *         null if the game is a tie.
     *         The winning team, assuming none of the above errors.
     */
    public Team getWinner() {
        if (team1 == null || team2 == null) { return null; }
        if (team1.getTeamScore() >= 0 && team2.getTeamScore() >= 0) {
            if (team1.getTeamScore() == team2.getTeamScore()) {
                //tie
                return null;
            }
            return (team1.getTeamScore() > team2.getTeamScore()) ? team1 : team2;
        } else {
            //throw exception
            return null;
        }
    }
    
    /**
     * Getter method for prevGame1
     * @return the value in prevGame1
     */
    public Game getPrevGame1() {
        return prevGame1;
    }
    
    /**
     * Setter method for prevGame1
     * @param game1 is the first game previous to this game.
     */
    public void setPrevGame1(Game game1) {
        this.prevGame1 = game1;
    }
    
    /**
     * Getter method for prevGame2
     * @return the value in prevGame2
     */
    public Game getPrevGame2() {
        return prevGame2;
    }
    
    /**
     * Setter method for prevGame2
     * @param game1 is the second game previous to this game.
     */  
    public void setPrevGame2(Game game2) {
        this.prevGame2 = game2;
    }
    
    /**
     * Getter method for the first team in the game.
     * @return the value of team1
     */
    public Team getTeam1() {
        return team1;
    }
    
    /**
     * Setter method for the first team in the game.
     * @param team1 is the first team to play in the game.
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
  
    /**
     * Getter method for the second team in the game.
     * @return the value of team2
     */    
    public Team getTeam2() {
        return team2;
    }
    
    /**
     * Setter method for the second team in the game.
     * @param team1 is the second team to play in the game.
     */   
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
    
}
