
public class Game {
    private Team team1;
    private Team team2;
    private Game prevGame1;
    private Game prevGame2;
    
    Game(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    
    Game() {}
    
 public Team getWinner() {
		if (Main.totalRounds == Main.round)
		{
			return getChampion();
		}
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

	public Team getChampion(){
		Team champion;
			if (team1 == null || team2 == null) { return null; }
			if (team1.getTeamScore() >= 0 && team2.getTeamScore() >= 0) {
				if (team1.getTeamScore() == team2.getTeamScore()) {
					//tie
					return null;
				}
				if (team1.getTeamScore() > team2.getTeamScore())
					{
						getSecondPlace(team2);
						champion = team1;
					}
				else {
					getSecondPlace(team1);
					champion = team2;
				}
			} else {
				//throw exception
				return null;
			}
		return champion;
	}
	
	public Team getSecondPlace(Team team){
		Team secondPlace = team;
		return secondPlace;
	}
    
    public Game getPrevGame1() {
        return prevGame1;
    }
    
    public void setPrevGame1(Game game1) {
        this.prevGame1 = game1;
    }
    
    public Game getPrevGame2() {
        return prevGame2;
    }
    
    public void setPrevGame2(Game game2) {
        this.prevGame2 = game2;
    }
    
    public Team getTeam1() {
        return team1;
    }
    
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }
    
    public Team getTeam2() {
        return team2;
    }
    
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }
    
}
