package Controller;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class GlobalController {
	/*
	 * Static Integer that represents the game points
	 */
	public static int gamePoints;
	/*
	 * Static Tab that represents the Tab for the prizes
	 */
	public static Tab tab5; 
	/*
	 * ControllerGame1 that represents the Controller of the Game1
	 */
	public ControllerGame1 game1;
	/*
	 * ControllerGame2 that represents the Controller of the Game2
	 */
	public ControllerGame2 game2;
	/*
	 * ControllerGame3 that represents the Controller of the Game3
	 */
	public ControllerGame3 game3;
	/*
	 * ControllerPrizes that represents the Controller of the prizes shop
	 */
	private ControllerPrizes prize;
	/*
	 * TabPane that contains the tabs of all the games
	 */
	private TabPane tabPane;
	/*
	 * Constructor of the class GlobalController
	 */
	public GlobalController(){
		//gamePoints
		gamePoints = 0;
		
		//TabPane
		tabPane = new TabPane();

		//Game1
		game1 = new ControllerGame1();
		game1.initGame();
		Tab tab1 = game1.getTab();
		tabPane.getTabs().add(tab1);
		
		//Game2
		game2 = new ControllerGame2();
		game2.initGame();
		Tab tab2 = game2.getTab();
		tabPane.getTabs().add(tab2);
		
		//Game3
		game3 = new ControllerGame3("/word_hangman.txt");
		game3.initGame();
		Tab tab3 = game3.getTab();
		tabPane.getTabs().add(tab3);
		
		
		
		//Prizes
		prize = new ControllerPrizes("/prizes.txt");
		prize.initPrizes();
		tab5 = prize.getTab();

		//TabPane add
		tabPane.getTabs().add(tab5);	
	}
	/*
	 * Getter function that returns the TabPane of this class
	 * @return TabPane that contains the tabs of all the games
	 */
	public TabPane getTabPane(){
		return this.tabPane;
	}
	public int getGamePoints(){
		return gamePoints;
	}
	public void setGamePoints(int a){
		gamePoints = a;
	}
}
