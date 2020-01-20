package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class ViewGame1 {
	/*
	 * TextField that represents the number input
	 */
	private TextField txt_number;
	/*
	 * Label that represents the hint information
	 */
	private Label lbl_hint;
	/*
	 * Label that represents the number of tries left
	 */
	private Label lbl_triesLeft;
	/*
	 * Button that checks/guess the chosen number
	 */
	private Button btn_guess;
	/*
	 * Button that exit the view game
	 */
	private Button btn_exit;
	/*
	 * Button that resets the view game
	 */
	private Button btn_reset;
	/*
	 * Tab that represents the main view of the game
	 */
	private Tab tabGame;
	/*
	 * Constructor of the class ViewGame1
	 */
	public ViewGame1(){
		txt_number = new TextField();
		lbl_hint = new Label("Enter a number : ");
        lbl_hint.setId("label");
        lbl_triesLeft = new Label("Tries left : 4");
        lbl_triesLeft.setId("label");
		tabGame = new Tab("Game 1");

		//BorderPane
        BorderPane borderpaneGame = new BorderPane();
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        //FlowPane for the center of the TabPane
        FlowPane flowpane = new FlowPane();
        flowpane.setAlignment(Pos.CENTER);
        flowpane.setId("flowpane");
        
        //Title
        Label lbl_titleGame1 = new Label("Find a number between 0 and 50 !");
        lbl_titleGame1.setId("titleLabel");
        BorderPane.setAlignment(lbl_titleGame1, Pos.CENTER);	
        
        //Buttons declaration
        btn_exit = new Button("Exit");
        btn_guess = new Button("Guess");
        btn_reset = new Button("Reset");
		btn_guess.setId("buttonUtility");
		btn_reset.setId("buttonUtility");
		btn_exit.setId("buttonUtility");
		
        //Buttons add
        hbox.getChildren().add(btn_guess);
        hbox.getChildren().add(btn_reset);
        hbox.getChildren().add(btn_exit);

        //TextField for the answer
        txt_number.setPrefWidth(60);
        txt_number.setFont(new Font(20));
	        
        //FlowPane adds
        flowpane.getChildren().add(lbl_hint);
        flowpane.getChildren().add(txt_number);
        flowpane.getChildren().add(lbl_triesLeft);
        
        //BorderPane configuration
        borderpaneGame.setTop(lbl_titleGame1);
        borderpaneGame.setBottom(hbox);
        borderpaneGame.setCenter(flowpane);
        BorderPane.setAlignment(hbox, Pos.CENTER);
        BorderPane.setAlignment(flowpane, Pos.CENTER);
        BorderPane.setMargin(flowpane, new Insets(80,50,80,50));
        
        //paddings
        lbl_triesLeft.setPadding(new Insets(0,20,0,20));
        lbl_hint.setPadding(new Insets(0,20,0,0));
        hbox.setPadding(new Insets(15,20, 10,10));
        borderpaneGame.setPadding(new Insets(60,60,60,60));

        //tabGame add
        tabGame.setContent(borderpaneGame);
        
        
        
	}
	/*
	 * Getter function that returns the number TextField
	 * @return A TextField that represents the chosen number
	 */
	public TextField getTxtNumber(){
		return this.txt_number;
	}
	/*
	 * Getter function that returns the hint Label
	 * @return Label that represents the hint
	 */
	public Label getLblHint(){
		return this.lbl_hint;
	}
	/*
	 * Getter function that returns the number of tries left Label
	 * @return A Label that represents the number of tries left
	 */
	public Label getLblTriesLeft(){
		return this.lbl_triesLeft;
	}
	/*
	 * Getter function that returns the guess Button
	 * @return A Button that checks the chosen number
	 */
	public Button getBtnGuess(){
		return this.btn_guess;
	}
	/*
	 * Getter function that returns the Tab of the game
	 * @return A Tab that represents the main view of the game
	 */
	public Tab getTabGame(){
		return this.tabGame;
	}
	/*
	 * Getter function that returns the exit Button
	 * @return A Button that exits the view
	 */
	public Button getBtnExit(){
		return this.btn_exit;
	}
	/*
	 * Getter function that returns the reset Button
	 * @return A Button that resets the view
	 */
	public Button getBtnReset(){
		return this.btn_reset;
	}
	/*
	 * Function that resets the view of the game
	 */
	public void reset(){
		txt_number.setDisable(false);

		txt_number.setText("");
		lbl_hint.setText("Enter a number :");
		lbl_hint.setId("label");
    	lbl_triesLeft.setText("Tries : 4");
    	btn_guess.setVisible(true);
	}
}
