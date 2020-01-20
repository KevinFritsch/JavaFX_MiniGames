package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class ViewGame3 {
	/*
	 * FlowPane that contains word to find
	 */
	private FlowPane flowpaneTitle;
	/*
	 * Label that represents the number of tries left
	 */
    private Label lbl_triesLeft;
    /*
     * FlowPane that contains the alphabet letters for the game
     */
    private FlowPane flowpaneCenter;
    /*
     * BorderPane that contains all the panes of this view
     */
    private BorderPane borderpane;
    /*
     * Button that exits the view game
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
     * Constructor of the class ViewGame3
     */
    public ViewGame3(){
    	flowpaneTitle = new FlowPane();
    	flowpaneCenter = new FlowPane();
    	lbl_triesLeft = new Label("Tries left : 6");
    	tabGame = new Tab("Game 3");
    	btn_exit = new Button("Exit");
    	btn_reset = new Button("Reset");
		btn_reset.setId("buttonUtility");
		btn_exit.setId("buttonUtility");
    	borderpane = new BorderPane();

    	//HBox
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().add(btn_reset);
        hbox.getChildren().add(btn_exit);
        hbox.setAlignment(Pos.CENTER);
        
        //FlowPane
        flowpaneTitle.setAlignment(Pos.CENTER);
        flowpaneCenter.setId("flowpane");
        
        //Paddings and Margins
        BorderPane.setMargin(flowpaneCenter, new Insets(50,20,50,20));
    	borderpane.setPadding(new Insets(50,50,50,50));
        hbox.setPadding(new Insets(0,10, 10,0));
    	borderpane.setPadding(new Insets(50,50,50,50));

    	//BorderPane add
        borderpane.setTop(flowpaneTitle);
        borderpane.setBottom(hbox);
        borderpane.setCenter(flowpaneCenter);
        tabGame.setContent(borderpane);
    }
    /*
     * Getter function that returns the title FlowPane
     * @return A FlowPane that contains the word to find
     */
    public FlowPane getFlowPaneTitle(){
    	return this.flowpaneTitle;
    }
    /*
     * Getter function that returns the number of tries left Label
     * @return A Label that represents the number of tries left
     */
    public Label getLblTriesLeft(){
    	return this.lbl_triesLeft;
    }
    /*
     * Getter function that returns the center FlowPane
     * @return A FlowPane that contains the alphabet letters as Buttons for the game
     */
    public FlowPane getFlowPaneCenter(){
    	return this.flowpaneCenter;
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
	 * Getter function that returns the Tab of the game
	 * @return A Tab that represents the main view of the game
	 */
    public Tab getTab(){
    	return this.tabGame;
    }
    /*
	 * Function that resets the view of the game
	 */
    public void reset(){
    	flowpaneCenter.getChildren().clear();
    	flowpaneTitle.getChildren().clear();
    	lbl_triesLeft.setText("Tries left : 6");
        borderpane.setTop(flowpaneTitle);
        borderpane.setCenter(flowpaneCenter);
    }
}
