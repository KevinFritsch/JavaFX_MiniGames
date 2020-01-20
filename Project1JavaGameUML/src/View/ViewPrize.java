package View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ViewPrize {
	/*
     * Tab that represents the main view of the game
     */
    private Tab tabGame;
    /*
     * Static Label that represents the number of game points for an user
     */
	public static Label lbl_gamePoints;
	/*
	 * Button that exit the view game
	 */
	private Button btn_exit;
	/*
	 * Button that choose a prize
	 */
	private Button btn_choosePrize;
	/*
     * BorderPane that contains all the panes of this view
     */
	private BorderPane borderpane;
	/*
	 * ObservableList of Strings that represents the prizes
	 */
	private ObservableList<String> prizesList;
	/*
	 * ListView of String that represents the prizes
	 */
    private ListView<String> listView;
	/*
	 * Constructor of the class ViewPrize
	 */
	public ViewPrize(){
		//Tab
		tabGame = new Tab();
		tabGame.setText("Prizes");	
        tabGame.setDisable(true);
        
        //GamePoints
		ViewPrize.lbl_gamePoints = new Label("Game points : 0");
		ViewPrize.lbl_gamePoints.setId("titleLabel");
		
		//Button Exit
		btn_exit = new Button("Exit");
		btn_exit.setId("buttonUtility");
		
		//Button Choose
        btn_choosePrize = new Button("Choose");
		btn_choosePrize.setId("buttonUtility");
		
		//ObservableList
        prizesList = FXCollections.observableArrayList();
        
        //HBox
        HBox hbox4 = new HBox();
        hbox4.setSpacing(10);
        hbox4.setAlignment(Pos.CENTER);
        hbox4.getChildren().add(btn_choosePrize);
        hbox4.getChildren().add(btn_exit);
        
        //ListView
        listView = new ListView<>();
        listView.setItems(prizesList);
        
        listView.setOrientation(Orientation.VERTICAL);
        listView.setMaxHeight(300);
        listView.setMaxWidth(850);
        
        //BorderPane
        borderpane = new BorderPane();
        borderpane.setTop(lbl_gamePoints);
        BorderPane.setAlignment(lbl_gamePoints, Pos.CENTER);
        borderpane.setBottom(hbox4);
        borderpane.setCenter(listView);
        
        //Paddings and Margins
        borderpane.setPadding(new Insets(30,30,60,30));
        BorderPane.setMargin(lbl_gamePoints, new Insets(15,0,0,0));
        hbox4.setPadding(new Insets(0,10, 10,0)); 
        
        tabGame.setContent(borderpane);
	}
	/*
	 * Getter function that returns the ListView that contains the prizes
	 * @return A ListView of Strings that contains all the prizes
	 */
	public ListView<String> getListView(){
		return this.listView;
	}
	/*
	 * Getter function that returns the ObservableList that contains the prizes
	 * @return An ObservableList of Strings that contains all the prizes
	 */
	public ObservableList<String> getObservableList(){
		return this.prizesList;
	}
	/*
	 * Getter function that returns the Tab of the game
	 * @return A Tab that represents the main view of the game
	 */
	public Tab getTab(){
		return this.tabGame;
	}
	/*
	 * Getter function that return the number of game points Label
	 * @return A Label that represents the number of game points
	 */
	public static Label getLblGamePoints(){
		return ViewPrize.lbl_gamePoints;
	}
	
	
	/*
	 * Getter function that returns the Exit Button
	 * @return Button that exits the view
	 */
	public Button getBtnExit(){
		return this.btn_exit;
	}
	/*
	 * Getter function that returns the choose Button
	 * @return Button that choose a prize
	 */
	public Button getBtnChoose(){
		return this.btn_choosePrize;
	}
	/*
	 * Setter function that add a prize to the ObservableList
	 * @param stringTitle A String that represents the title of the prize
	 * @param pointsNeeded A String that represents the number of game points needed for this prize
	 */
	public void setStringToList(String stringTitle, String pointsNeeded){
		prizesList.add(stringTitle + " ★" + pointsNeeded);
	}
	
}
