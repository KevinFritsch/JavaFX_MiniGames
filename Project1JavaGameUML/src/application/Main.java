package application;
	

import Controller.GlobalController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Game Kevin Fritsch");
			primaryStage.getIcons().add(new Image("application/gamepad.png"));
	        Group root = new Group();
	        Scene scene = new Scene(root, Color.WHITE);
			primaryStage.sizeToScene();

	        primaryStage.setResizable(false);
	        scene.getStylesheets().add("application/application.css");
	        BorderPane borderPane = new BorderPane();

	        GlobalController game = new GlobalController();
	        TabPane tabPane = game.getTabPane();

	        borderPane.setCenter(tabPane);

	        root.getChildren().add(borderPane);
	        
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
