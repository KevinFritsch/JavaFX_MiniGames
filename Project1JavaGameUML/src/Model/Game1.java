package Model;

import java.util.Random;

public class Game1 {
	/*
	 * Integer that represents a random number to find
	 */
	private int randomNumber;
	/*
	 * Integer that represents the number of tries
	 */
	private int tries;
	/*
	 * Constructor of the class Game1
	 */
	public Game1(){
		randomNumber = randNum(0, 50);
		tries = 0;
	}
	/*
	 * Getter function that returns the variable randomNumber
	 */
	public int getRandomNumber(){
		return this.randomNumber;
	}
	/*
	 * Getter function that returns the variable tries 
	 */
	public int getTries(){
		return this.tries;
	}
	/*
	 * Setter function that sets the variable tries
	 * @param a An integer which represents the number of tries	
	 * 
	 */
	public void setTries(int a){
		this.tries = a;
	}
	/*
	 * Boolean function that returns true if the variable tries is equal to 4
	 * @return A boolean if tries is equal to 4
	 */
	public boolean noTriesLeft(){
		return tries == 4;
	}
	/*
	 * Function that calculates a random number between two integers
	 * @param min The minimum value of the generated number
	 * @param max The maximum value of the generated number
	 * @return An integer which represents the random number between min and max
	 */
	private int randNum(int min, int max){
		Random rand = new Random();
		int res = rand.nextInt(max - min + 1) + min;
		System.out.println("\n*********Game1**********\nNumber to find : " + res);
		return res;
	}
	/*
	 * Function that resets the game by changing the random number and setting tries to 0
	 */
	public void reset(){
		this.randomNumber = randNum(0, 50);
		this.tries = 0;
	}
}
