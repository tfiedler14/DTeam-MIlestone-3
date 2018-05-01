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
        
    public static void main(String[] args) {
        launch(args);
        
    }
    
    public void fillTournament(Team[] teams) {
        rootGame = new Game();
        rootGame = fillPrevGames(0, 0, teams);
        rootGame = updateTree(rootGame);
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
        Team[] teams = new Team[8]; //for testing
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
        fillTournament(teams);
        
        int initialTeams = teams.length;
        primaryStage.setTitle("DTeam");
        Label title = new Label();
        title.setText("Tournament");
        title.setFont(new Font(20.0));
        GridPane grid = new GridPane();
        grid.setVgap(0);
        grid.setHgap(15);
        int rounds = (int) (Math.log(initialTeams) / Math.log(2));
        
        for (int round = 0; round < rounds; round++) {
            
            int numberOfGames = (int) (initialTeams/(Math.pow(2, round+1)));
            int spaces = ((initialTeams/2)-numberOfGames)/2;
            
            for (int i = 0; i < numberOfGames; i++) {
                //Game i
                VBox game1 = new VBox();
                game1.setSpacing(2);
                //Team 1
                HBox team1 = new HBox();
                team1.setAlignment(Pos.CENTER_LEFT);
                team1.setSpacing(5);
                //Game Label
                Label gameLabel = new Label();
                gameLabel.setText("Game " + (round+1) + "-" + (i+1));
                gameLabel.setMinWidth(75);
                gameLabel.setFont(new Font(18));
                //Team 1 Label
                Label team1Label = new Label();
                team1Label.setText(teams[2*i].getTeamName()); //remove once we are able to fill it with actual data
                team1Label.setMinWidth(75.0);
                //Team 1 Field
                TextField team1Field = new TextField();
                team1Field.setPromptText("Score");
                
                //Team 2
                HBox team2 = new HBox();
                team2.setAlignment(Pos.CENTER_LEFT);
                team2.setSpacing(5);
                //Team 2 Label
                Label team2Label = new Label();
                team2Label.setText(teams[2*i + 1].getTeamName()); //remove once we are able to fill it with actual data
                team2Label.setMinWidth(75.0);
                //Team 2 Field
                TextField team2Field = new TextField();
                team2Field.setPromptText("Score");
                //Buttons HBox
                HBox buttons = new HBox();
                buttons.setAlignment(Pos.CENTER_LEFT);
                buttons.setSpacing(5);
                //Reset Button
                Button reset = new Button();
                reset.setText("Reset Game");
               reset.setOnAction(new EventHandler<ActionEvent>(){
                    @Override public void handle(ActionEvent e){
                        team1Field.setText("");
                        team2Field.setText("");
                    }
                });
             
                //Submit Button
                Button submit = new Button();
                submit.setText("Submit");
                
                buttons.getChildren().addAll(reset, submit);
                
                team1.getChildren().addAll(team1Label, team1Field);
                
                team2.getChildren().addAll(team2Label, team2Field);
                
                game1.getChildren().addAll(gameLabel, team1, team2, buttons);
                
                grid.add(game1, round, i+spaces);
            }
        }
        
        ScrollPane sp = new ScrollPane();      
        sp.setContent(grid);
        sp.setPrefWidth(1370);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
     
        BorderPane root = new BorderPane();
        root.setTop(title);
        root.setCenter(grid);
        root.setRight(sp);
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
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
        return null; // TODO
    }

}
