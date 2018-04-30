import java.awt.Insets;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    Game rootGame;
    
    Main() {}
    
    public static void main(String[] args) {
        Main main = new Main();
        //launch(args);
        Team[] teams = new Team[8];
        teams[0] = new Team("team1", 1);
        teams[0].setTeamScore(1);
        teams[1] = new Team("team2", 2);
        teams[1].setTeamScore(2);
        teams[2] = new Team("team3", 3);
        teams[2].setTeamScore(3);
        teams[3] = new Team("team4", 4);
        teams[3].setTeamScore(4);
        teams[4] = new Team("team5", 5);
        teams[4].setTeamScore(5);
        teams[5] = new Team("team6", 6);
        teams[5].setTeamScore(6);
        teams[6] = new Team("team7", 7);
        teams[6].setTeamScore(7);
        teams[7] = new Team("team8", 8);
        teams[7].setTeamScore(8);
        main.fillTournament(teams);
        //main.fillTournament(parseTeams(args[0]));
    }
    
    public void fillTournament(Team[] teams) {
        rootGame = new Game();
        rootGame = fillPrevGames(0, 0, teams);
        rootGame = updateTree(rootGame);
        rootGame.getPrevGame1().getTeam1().setTeamScore(9);
        rootGame.getPrevGame1().getTeam2().setTeamScore(10);
        rootGame = updateTree(rootGame);
        rootGame.getTeam1().setTeamScore(11);
        System.out.println(rootGame.getTeam1().getTeamName());
    }
    
    private Game fillPrevGames(int height, int width, Team[]teams) {
        int totalRounds = (int) (Math.log(teams.length) / Math.log(2)); // Log(x) / Log(2) = Log2(x)
        
        if (height >= totalRounds-1) {
            Team team1 = teams[(width*2)];
            Team team2 = teams[(width*2)+1];
            Game returnGame = new Game(team1, team2);
            System.out.println(team1.getTeamName());
            System.out.println(team2.getTeamName());
            return returnGame;
        }
        
        Game returnGame = new Game();
        returnGame.setPrevGame1(fillPrevGames(height + 1, width * 2, teams));
        returnGame.setPrevGame2(fillPrevGames(height + 1, (width * 2) + 1, teams));
        return returnGame;

    }
    
    public void start(Stage primaryStage) {
        
    }
    
    public Game updateTree(Game curr) {
        if (rootGame == null) { return null; }
        if (curr.getPrevGame1() == null || curr.getPrevGame2() == null) { // curr is a leaf node and must already have two teams set
            return curr; 
        }
        if (curr.getWinner() == null) {
            Team team1 = updateTree(curr.getPrevGame1()).getWinner();
            Team team2 = updateTree(curr.getPrevGame2()).getWinner();
            if (team1 != null) {
                curr.setTeam1(new Team(team1.getTeamName(), team1.getTeamRank()));
            }
            if (team2 != null) { 
                curr.setTeam2(new Team(team2.getTeamName(), team2.getTeamRank()));
            }
        }
        return curr;
    }
    
    private static Team[] parseTeams(String arg) {
        Team[] teams = new Team[4];
        teams[0] = new Team("team1", 1);
        teams[0].setTeamScore(1);
        teams[1] = new Team("team2", 2);
        teams[1].setTeamScore(2);
        teams[2] = new Team("team3", 3);
        teams[2].setTeamScore(3);
        teams[3] = new Team("team4", 4);
        teams[3].setTeamScore(4);
        teams[0] = new Team("team5", 5);
        teams[0].setTeamScore(5);
        teams[1] = new Team("team6", 6);
        teams[1].setTeamScore(6);
        teams[2] = new Team("team7", 7);
        teams[2].setTeamScore(7);
        teams[3] = new Team("team8", 8);
        teams[3].setTeamScore(8);
        return teams;
    }

}
