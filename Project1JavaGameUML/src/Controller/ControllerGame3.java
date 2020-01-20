package Controller;



import Model.Game3;
import View.ViewGame3;
import View.ViewPrize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;

public class ControllerGame3 {
	/*
	 * Game3 that represents the model of the game
	 */
	public Game3 game;
	/*
	 * ViewGame3 that represents the view of the game
	 */
	public ViewGame3 view;	
	/*
	 * Constructor of the class ControllerGame3
	 */
	public ControllerGame3(String path){
		game = new Game3(path);
		view = new ViewGame3();
	}
	/*
	 * Function that initializes the game
	 */
	public void initGame(){
		for(int i= 0; i < game.getWord().length(); i++){
				Label lbl = new Label("_");
				lbl.setId("titleLabel");
				view.getFlowPaneTitle().getChildren().add(lbl);
				FlowPane.setMargin(lbl, new Insets(30,30,0,0));
		}
		view.getLblTriesLeft().setText("Tries left : " + game.getTriesLeft());
		view.getLblTriesLeft().setId("titleLabel");
		view.getFlowPaneTitle().getChildren().add(view.getLblTriesLeft());
        FlowPane.setMargin(view.getLblTriesLeft(), new Insets(30,30,0,0));
	        
        view.getBtnReset().setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	resetGame();
	            }
	        });
        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	quitGame();
            }
        });	        
        for(char i = 'A'; i <= 'Z'; i++){
			Button btn = new Button(i+"");
            FlowPane.setMargin(btn,new Insets(2,2,2,2));
			btn.setMinSize(80, 50);
			btn.setVisible(true);
			btn.setId("buttonGame");
			view.getFlowPaneCenter().getChildren().add(btn);
			final char letter = i;
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	    			boolean goodAnswer = false;

	            	for(int y =0; y < game.getWord().length(); y ++){
	            		if(game.getWord().charAt(y) == Character.toLowerCase(letter) || game.getWord().charAt(y) == letter){
	            			setLetterGame3(letter, y);
	            			game.setNumberLetterFound(game.getNumberLetterFound()+1);
	            			btn.setVisible(false);
	            			goodAnswer = true;
	            			if(game.getNumberLetterFound() == game.getWord().length()){
	            				view.getLblTriesLeft().setText("You won 3★ !");
	            				endGame3(true);

	            				//game points
	            				GlobalController.gamePoints+= 3;
	                    		ViewPrize.lbl_gamePoints.setText("Game Points : " + GlobalController.gamePoints+"★");
	                    		GlobalController.tab5.setDisable(false);
	            			}
	            		}
	            		else{
	            			btn.setVisible(false);
	            		}
	            	}
	            	if(!goodAnswer){
	            		game.setTriesLeft(game.getTriesLeft()-1);
            			if(game.getTriesLeft() == 0){
            				view.getLblTriesLeft().setText("You lost !");
            				endGame3(false);
            			}
            			else{
            				view.getLblTriesLeft().setText("Tries left : " + game.getTriesLeft());
            			}
	            	}
	            }
	        });
			}
	        view.getFlowPaneCenter().setAlignment(Pos.CENTER);  
	}
	/*
	 * Setter function that set a letter at a position in the title FlowPane
	 * @param letter A Char that represents the letter to put
	 * @param pos An Integer that represents the position where the letter has to be put
	 */
	private void setLetterGame3(char letter, int pos){
		int count = 0;
		for(Node node : view.getFlowPaneTitle().getChildren()){
			if(node instanceof Label){
				if(count == pos){
					((Label) node).setText(letter+"");
				}
				count++;
			}

		}
	}
	/*
	 * Function that end the game depending on whether the user successes or not
	 */
	private void endGame3(boolean success){
		for(Node node : view.getFlowPaneCenter().getChildren()){
			if(node instanceof Button){
				((Button) node).setDisable(true);
			}
		}
		int count = 0;
		for(Node node : view.getFlowPaneTitle().getChildren()){
			if(node instanceof Label){
				((Label) node).setText(Character.toUpperCase(game.getWord().charAt(count))+"");
				count++;
				node.setId("wrongAnswer");
				if(success){
					node.setId("goodAnswer");
				}
				if(count == game.getWord().length()){
					count = 0;
					break;
				}
			}
		}
	}
	/*
	 * Function that resets the game
	 */
	public void resetGame(){
		view.reset();
    	game.reset();
    	initGame();
	}
	/*
	 * Function that quits the game
	 */
	public void quitGame(){
        System.exit(0);//quit the application
	}
	/*
	 * Getter function that returns the Tab of the view 
	 * @return A Tab that represents the Tab of the view
	 */
	public Tab getTab(){
		return view.getTab();
	}
	
}
