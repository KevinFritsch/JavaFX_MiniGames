package Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Controller.GlobalController;
import Model.Prize;
import View.ViewPrize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;

public class ControllerPrizes {
	/*
	 * ViewPrize that represents the view
	 */
	private ViewPrize view;
	/*
	 * Prize that represents the model
	 */
	private Prize prize;
	/*
	 * String that represents the path of the text file where there are all the possible prizes
	 */
	private String pathPrizes;
	/*
	 * Constructor of the class ControllerPrizes
	 */
	public ControllerPrizes(String pathPrizes){
		this.pathPrizes = pathPrizes;
		view = new ViewPrize();
		prize = new Prize(this.pathPrizes);
	}
	/*
	 * Getter function that returns the Tab of the view 
	 * @return A Tab that represents the Tab of the view
	 */
	public Tab getTab(){
		return view.getTab();
	}
	/*
	 * Function that initialize the Prizes shop
	 */
	public void initPrizes(){
		view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	quitGame();
            }
        });
        view.getBtnChoose().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	choosePrize(view.getListView());
            }
        });
        
        HashMap<String, List<String>> hashmap = prize.getHashMapPrizes();
        
        for(Entry<String, List<String>> entry : hashmap.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();

            view.setStringToList(key, values.get(0));
        }  
	}
	/*
	 * Function that chooses a prize
	 * @param ListView of Strings that represents the List of all possible prizes
	 */
	public void choosePrize(ListView<String> prizesList ){
		if(prizesList.getSelectionModel().getSelectedItem() != null){
			String selectionList[] = prizesList.getSelectionModel().getSelectedItem().split(" ");
	
			int pointsNeeded = Integer.parseInt(prize.getHashMapPrizes().get(selectionList[0]).get(0));
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Prize");
			alert.setHeaderText(null);
			alert.setContentText("Congratulation, you won :\n "+
					
			prize.getHashMapPrizes().get(selectionList[0]).get(1));
			if(pointsNeeded <= GlobalController.gamePoints){
				GlobalController.gamePoints -= pointsNeeded;
				ViewPrize.getLblGamePoints().setText("Game Points : " + GlobalController.gamePoints);
				
				alert.setContentText("Congratulation, you won :\n "+
				prize.getHashMapPrizes().get(selectionList[0]).get(1));	
			}
			else{
				alert.setContentText("You don't have enough game points ! ("
						+ pointsNeeded +" points are needed)");
			}
			alert.showAndWait();
		} 
	}
	/*
	 * Function that quits the game
	 */
	public void quitGame(){
        System.exit(0);//quit the application
	}	
}
