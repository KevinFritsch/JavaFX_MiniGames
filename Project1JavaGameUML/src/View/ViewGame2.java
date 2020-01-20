package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ViewGame2 {
	/*
	 * Label that represents the number of good answers
	 */
	private Label lbl_goodAnswers;
	/*
	 * Button thats checks the answers
	 */
    private Button btn_check;
    /*
     * Button that resets the view game
     */
    private Button btn_reset;
    /*
     * Button that exits the view game
     */
    private Button btn_exit;
    /*
     * Integer that represents the number of values that are selected
     */
	private int numberOfValuesSelected;
	/*
	 * Tab that represents the main view of the game
	 */
	private Tab tabGame;
	/*
	 * Grid that represents the view of the lottery buttons
	 */
	private GridPane grid;
	/*
	 * Integer that represents the lottery grid size
	 */
    private int lotteryGridSize= 10;
    /*
     * Constructor of the class ViewGame2
     */
    public ViewGame2(){
    	numberOfValuesSelected = 0;
    	lbl_goodAnswers = new Label("Good answers : ");
    	btn_check = new Button("Check");
    	btn_reset = new Button("Reset");
    	btn_exit = new Button("Exit");
    	btn_check.setId("buttonUtility");
		btn_reset.setId("buttonUtility");
		btn_exit.setId("buttonUtility");
    	
        tabGame = new Tab("Game 2");
        
        //Grid
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setId("grid");
        
        //Title
        Label lbl_titleGame2 = new Label("Lottery : choose 5 numbers!");
        lbl_titleGame2.setId("titleLabel");
        
        //BorderPane
    	BorderPane borderpaneGame = new BorderPane();
        borderpaneGame.setTop(lbl_titleGame2);
        BorderPane.setAlignment(lbl_titleGame2, Pos.CENTER);
        
        //HBox
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(btn_reset);
        hbox.getChildren().add(btn_check);

        //Labels
        lbl_goodAnswers.setVisible(false);
        lbl_goodAnswers.setId("label");
        hbox.getChildren().add(lbl_goodAnswers);
        hbox.getChildren().add(btn_exit);

        int lineNumber = 1;
        int columnNumber = 1;
        for (int i = 1; i <= lotteryGridSize; i++){
        	Button btn_lottery = new Button(i+"");
            btn_lottery.setMinSize(65,60);
            btn_lottery.setId("buttonGame");
    		grid.add(btn_lottery, columnNumber -1, lineNumber);
    		columnNumber++;
    		if(columnNumber == 11){
    			columnNumber = 1;
    			lineNumber++;
    		}
    		btn_lottery.setOnAction(e -> {
    			eventButtonLottery(btn_lottery);
        });
        }
        //Paddings and Margins
        BorderPane.setMargin(grid, new Insets(80,50,80,50));
        borderpaneGame.setPadding(new Insets(50,50,50,50));
        hbox.setPadding(new Insets(15,20, 10,10));

        borderpaneGame.setBottom(hbox);
        borderpaneGame.setCenter(grid);
        tabGame.setContent(borderpaneGame);	
    }
    /*
     * Getter function that returns the lottery grid size
     * @return An Integer that represents the size of the lottery grid
     */
    public int getLotteryGridSize(){
    	return this.lotteryGridSize;
    }
    /*
     * Getter function that returns the number of good answers Label 
     * @return A Label that represents the number of good answers
     */
    public Label getGoodAnswers(){
    	return this.lbl_goodAnswers;
    }
    /*
     * Getter function that returns the check Button
     * @return A check Button 
     */
    public Button getBtnCheck(){
    	return this.btn_check;
    }
    /*
     * Getter function that returns the exit Button
     * @return An exit Button
     */
    public Button getBtnExit(){
    	return this.btn_exit;
    }
    /*
     * Getter function that returns the reset Button
     * @return A reset Button
     */
    public Button getBtnReset(){
    	return this.btn_reset;
    }
    /*
     * Getter function that returns the Tab of the game
     * @return A Tab that represent the main view of the game
     */
    public Tab getTab(){
    	return this.tabGame;
    }
    /*
     * Getter function that returns the number of values that are selected
     * @return An Integer that represents the number of values that are selected
     */
    public int getNumberOfValuesSelected(){
    	return this.numberOfValuesSelected;
    }
    /*
     * Getter function that returns the number of good answers Label
     * @return A Label that represents the number of good answers
     */
    public Label getLblGoodAnswers(){
    	return this.lbl_goodAnswers;
    }
    /*
     * Getter function that return the lottery grid
     * @return A GridPane that represents the lottery grid
     */
    public GridPane getGrid(){
    	return this.grid;
    }
    /*
     * Setter function that set the size of the lottery grid
     * @param An Integer that represents the size of the lottery grid
     */
    public void setLotteryGridSize(int a){
    	lotteryGridSize = a;
    }
    /*
     * Setter function that set the number of values that are selected
     * @param An Integer that represents the number of values that are selected
     */
    public void setNumberOfValuesSelected(int a){
    	this.numberOfValuesSelected = a;
    }
    
    /*
     * Function that create an event for a Button
     * @param A Button
     */
    public void eventButtonLottery(Button btn){
		if(btn.getStyle() == "-fx-background-color: #ff9966" ){
			btn.setStyle("");
			setNumberOfValuesSelected(getNumberOfValuesSelected() - 1);
		}
		else{
			if(getNumberOfValuesSelected() < 5){
			btn.setStyle("-fx-background-color: #ff9966");
			setNumberOfValuesSelected(getNumberOfValuesSelected() + 1);	
			}
		}
	}
    /*
	 * Function that resets the view of the game
	 */
    public void reset(){
    	for(Node node : grid.getChildren()){
			if(node instanceof Button ){
        		node.setDisable(false);
				node.setStyle("");
				node.setId("buttonGame");
			}
		}
    	numberOfValuesSelected = 0;
    	lbl_goodAnswers.setText("Good answers : ");
    	lbl_goodAnswers.setVisible(false);
    	lbl_goodAnswers.setId("label");
    	btn_check.setText("Check");
    	btn_check.setVisible(true);	
    } 
}
