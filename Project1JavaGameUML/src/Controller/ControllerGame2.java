package Controller;

import java.util.Arrays;
import java.util.Random;

import Model.Game2;
import View.ViewGame2;
import View.ViewPrize;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class ControllerGame2 {

	/*
	 * Game2 that represents the model of the game
	 */
	public Game2 game;
	/*
	 * ViewGame2 that represents the view of the game
	 */
	public ViewGame2 view;
	
	/*
	 * Constructor of the class ControllerGame2
	 */
	public ControllerGame2(){
		game = new Game2();
		view = new ViewGame2();
	}
	/*
	 * Function that initializes the game
	 */
	public void initGame(){
		generateRandomNumbers();
		
		view.getBtnCheck().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	checkAnswersGame2(view.getGrid());
            }
        });

        
        view.getBtnReset().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	view.reset();
            	game.reset();
        		generateRandomNumbers();
            }
        });
        view.getBtnExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	quitGame();
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
	 * Function that generates random numbers for the lottery
	 */
	public void generateRandomNumbers(){
		for(int i = 0; i < 5; i++){
			int newNumber = randomNumber(1, view.getLotteryGridSize());
			while(contains(game.getRandomNumbers(), newNumber)){
				newNumber = randomNumber(1, view.getLotteryGridSize());
			}
	
			game.getRandomNumbers()[i] = newNumber;
			}
		System.out.println("\n**********Game2********\nNumbers to find : \n"+ Arrays.toString(game.getRandomNumbers()));

	}
	/*
	 * Function that calculates a random number between two integers
	 * @param min The minimum value of the generated number
	 * @param max The maximum value of the generated number
	 * @return An integer which represents the random number between min and max
	 */
	public int randomNumber(int min, int max){
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	/*
	 * Function that returns true if an Array contains an Integer
	 * @param array An Array of Integers
	 * @param v An Integer
	 * @return True if the Integer is in the Array
	 */
	public boolean contains(int[] array, int v) {
        boolean result = false;
        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }
        return result;
    }
	/*
	 * Function that check the answers of the game
	 * @param grid A GridPane that contains the lottery values
	 */
	public void checkAnswersGame2(GridPane grid){
		if (view.getNumberOfValuesSelected()== 5){
			int count = 0;
			for(Node node : grid.getChildren()){
	        	if(node instanceof Button){
	        		Button btn = (Button) node;
	        		btn.setDisable(true);
	        		if(btn.getStyle() == "-fx-background-color: #ff9966"){
		        		game.getNumbers()[count] = Integer.parseInt(btn.getText());
		        		count++;
	        		}
	        	}
	        		
			}
			int[] correctValues = rightAnswersGame2(game.getRandomNumbers(),game.getNumbers());
			Arrays.sort(game.getRandomNumbers());
			
			int valuesNumber = 1;
			count =0;
			int count2 = 0;
			for(Node node : grid.getChildren()){
	        	if(node instanceof Button){
	        		Button btn = (Button) node;
	        		if(count2 < game.getRandomNumbers().length){
	        			if(valuesNumber == game.getRandomNumbers()[count2]){
	        				count2++;
	        				btn.setStyle("-fx-background-color: #ff0000");
	        			}
	        		}
	        		if(count < correctValues.length){
		        		if(valuesNumber == correctValues[count]){
	        				count++;
	        				btn.setStyle("-fx-background-color: #00ff1e");
		        		}

	        		}
	        		
	        		valuesNumber++;
	        	}
			}
			view.getLblGoodAnswers().setId("labelRed");

			int numberOfGamepoints = 0;
			if(count == 4){
				GlobalController.gamePoints+= 4;
        		ViewPrize.lbl_gamePoints.setText("Game Points : " + GlobalController.gamePoints+"★");
        		GlobalController.tab5.setDisable(false);
        		numberOfGamepoints+= 4;
    			view.getLblGoodAnswers().setId("labelGreen");
			}
			else if(count == 5){
				GlobalController.gamePoints+= 5;
        		ViewPrize.lbl_gamePoints.setText("Game Points : " + GlobalController.gamePoints+"★");
        		GlobalController.tab5.setDisable(false);
        		numberOfGamepoints+= 5;
    			view.getLblGoodAnswers().setId("labelGreen");
			}
			
			view.getBtnCheck().setVisible(false);
			view.getLblGoodAnswers().setVisible(true);
			view.getLblGoodAnswers().setText("You won " + numberOfGamepoints +"★ !");
		}
        		
	}
	
	/*
	 * Function that returns the right answers
	 * @param firstArray An Array of Integers that contains the correct values
	 * @param secondArray An Array of Integers that contains the chosen values
	 * @return An Array of Integer that contains all the right answers
	 */
	public int[] rightAnswersGame2(int[] firstArray, int[] secondArray){
		int[] res = new int[5];
		int numberElementsRes = 0;
		for(int i = 0; i < 5; i++){
			int firstValue = game.getRandomNumbers()[i];
			for(int y = 0; y < 5; y++){
				int secondValue = game.getNumbers()[y];
				if(firstValue == secondValue){
					res[numberElementsRes] = firstValue;
					numberElementsRes++;
					break;
				}
			}
		}
		res = cleanArray(res);
		return res;
	}
	/*
	 * Function that cleans an Array of Integer, by sorting the values and remove all the zeros
	 * @param array An Array of Integer that has to be cleaned
	 * @return An Array of Integers
	 */
	public int[] cleanArray(int[] array){
		Arrays.sort(array);
		int targetIndex = 0;
		for( int sourceIndex = 0;  sourceIndex < array.length;  sourceIndex++ )
		{
		    if( array[sourceIndex] != 0 )
		        array[targetIndex++] = array[sourceIndex];
		}
		int[] newArray = new int[targetIndex];
		System.arraycopy( array, 0, newArray, 0, targetIndex );
		return newArray;
	}
	/*
	 * Getter function that returns the Tab of the view 
	 * @return A Tab that represents the Tab of the view
	 */
	public Tab getTab(){
		return view.getTab();
	}
}
