package Controller;


import Model.Game1;
import View.ViewGame1;
import View.ViewPrize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyCode;

public class ControllerGame1 {
	/*
	 * ViewGame1 that represents the view of the game
	 */
	public ViewGame1 view;
	/*
	 * Game1 that represents the model of the game
	 */
	public Game1 game;
	/*
	 * Integer that represents the answer number
	 */
	private int answerGame;
	/*
	 * Constructor of the class ControllerGame1
	 */
	public ControllerGame1(){
		view = new ViewGame1();
		game = new Game1();
		answerGame = -1;
	}
	/*
	 * Getter function that returns the Tab of the view 
	 * @return A Tab that represents the Tab of the view
	 */
	public Tab getTab(){
		return view.getTabGame();
	}
	/*
	 * Function that initializes the game
	 */
	public void initGame(){
		//Buttons events
        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	quitGame();
            }
        });
        view.getBtnReset().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	game.reset();
            	view.reset();
            }
        });
        view.getBtnGuess().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	checkGame();
            }
        });
        view.getTxtNumber().setOnKeyReleased(event -> {
        	  if (event.getCode() == KeyCode.ENTER){
              	checkGame();
			  }
			});
        
	}
	/*
	 * Function that quits the game
	 */
	public void quitGame(){
        System.exit(0);//quit the application
	}
	/*
	 * Function that checks the answer of the game
	 */
	public void checkGame(){
		if(view.getTxtNumber().getText() != null && !view.getTxtNumber().getText().trim().isEmpty()){
			answerGame = Integer.parseInt(view.getTxtNumber().getText());
        	if(answerGame < 0){
        		view.getLblHint().setText("A number bigger than -1!");
        		view.getTxtNumber().setText("");    	
        	}
        	else if(answerGame > 50){
        		view.getLblHint().setText("A number lower than 51!");
        		view.getTxtNumber().setText("");    	
        	}
        	else if(answerGame == game.getRandomNumber()){
        		//you won
        		view.getLblHint().setText("You won 2★ !");
    			view.getLblHint().setId("labelGreen");
        		view.getTxtNumber().setDisable(true);
        		view.getTxtNumber().setText(game.getRandomNumber()+"");    	

        		game.setTries(game.getTries()+1);
        		view.getLblTriesLeft().setText("Tries : " + (4-game.getTries())+"");
        		view.getBtnGuess().setVisible(false);
        		
        		//Add 2 points for winning the game
        		GlobalController.gamePoints+= 2;
        		ViewPrize.lbl_gamePoints.setText("Game Points : " + GlobalController.gamePoints +"★");
        		GlobalController.tab5.setDisable(false);
        	}
        	else if(answerGame < game.getRandomNumber()){
        		view.getLblHint().setText("The number is higher than "+ answerGame +" !");
        		game.setTries(game.getTries()+1);
        		view.getLblTriesLeft().setText("Tries : " + (4-game.getTries())+"");
        		view.getTxtNumber().setText("");    	

        		if(game.noTriesLeft()){
        			view.getLblHint().setText("You lost !");
        			view.getLblHint().setId("labelRed");
        			view.getBtnGuess().setVisible(false);
        			view.getTxtNumber().setDisable(true);
        			view.getTxtNumber().setText(game.getRandomNumber()+"");    	
        		}
        	}
        	else{
        		view.getLblHint().setText("The number is lower than "+ answerGame +" !");
        		game.setTries(game.getTries()+1);
        		view.getLblTriesLeft().setText("Tries : " + (4-game.getTries())+"");
        		view.getTxtNumber().setText("");    	

        		if(game.noTriesLeft()){
        			view.getLblHint().setText("You lost !");
        			view.getLblHint().setId("labelRed");
        			view.getBtnGuess().setVisible(false);
        			view.getTxtNumber().setDisable(true);
        			view.getTxtNumber().setText(game.getRandomNumber()+"");    	
        		}
        	}
    	}
	}
}
