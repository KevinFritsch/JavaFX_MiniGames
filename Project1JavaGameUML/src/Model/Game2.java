package Model;

public class Game2 {
	/*
	 * An array of integers that represents the random numbers to find
	 */
	private int randomNumbers[];
	/*
	 * An array of integers that represents the number chosen by an user
	 */
	private int numbers[];
    /*
     * Constructor of the class Game2
     */
    public Game2(){
    	randomNumbers = new int[5];
    	numbers = new int[5];
    }
    /*
     * Getter function that returns all the generated random numbers
     * @return An array of integers representing all the generated random number
     */
    public int[] getRandomNumbers(){
    	return this.randomNumbers;
    }
    /*
     * Getter function that returns all the numbers chosen by an user
     * @return An array of integers representing all the numbers chosen by an user
     */
    public int[] getNumbers(){
    	return this.numbers;
    }
    /*
     * Setter function that sets the array "randomNumbers"
     * @param An array of integers representing generated numbers
     */
    public void setRandomNumbers(int[] a){
    	this.randomNumbers = a;
    }
    /*
     * Setter function that set the array "numbers"
     * @param An array of integers representing the numbers chosen by an user
     */
    public void setNumbers(int[] a){
    	this.numbers = a;
    }
    /*
     * Function that resets the game by replacing the random numbers and the chosen numbers
     */
    public void reset(){
    	this.randomNumbers = new int[5];
    	this.numbers = new int[5];
    }   
}
