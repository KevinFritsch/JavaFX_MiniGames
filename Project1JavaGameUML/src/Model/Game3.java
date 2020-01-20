package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;


public class Game3 {
	/*
	 * An integer that represents the number of tries left
	 */
    private int triesLeft;
    /*
     * A String that represents the word to find
     */
	private String word;
	/*
	 * An integer that represents the number of letters found
	 */
	private int numberLetterFound;
	/*
	 * A String that represents the path of the text file where there are all the possible words
	 */
	private String path;
	/*
	 * Constructor of the class Game3
	 * @param A String that represents the path of the text file with all the possible words
	 */
	public Game3(String path){
		triesLeft = 6;
		this.path = path;
		word = randomWord();
		numberLetterFound = 0;		
	}
	/*
	 * Getter function that returns the number of letters found by an user
	 * @return An integer that represents the number of letters found by an user
	 */
	public int getNumberLetterFound(){
		return this.numberLetterFound;
	}
	/*
	 * Getter function that returns the number of tries left
	 * @return An integer that represents the number of tries left
	 */
	public int getTriesLeft(){
		return this.triesLeft;
	}
	/*
	 * Getter function that returns the word to found
	 * @return A String that represents the word to found
	 */
	public String getWord(){
		return this.word;
	}
	/*
	 * Setter function that sets the integer "numberLetterFound"
	 * @param An integer that represents the number of letters found by an user
	 */
	public void setNumberLetterFound(int a){
		this.numberLetterFound = a;
	}
	/*
	 * Setter function that sets the integer "triesLeft"
	 * @param An integer that represents the number of tries left
	 */
	public void setTriesLeft(int a){
		this.triesLeft = a;
	}
	/*
	 * Function that calculates a random number between two integers
	 * @param min The minimum value of the generated number
	 * @param max The maximum value of the generated number
	 * @return An integer which represents the random number between min and max
	 */
	private int randNum(int min, int max){
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
	/*
	 * Function that return a random word from a text file
	 * @return A String that represents a random word
	 */
	private String randomWord(){
		int randomNumber = randNum(0, 122);
		int count = 0;
	    String word="";
		BufferedReader br;
		InputStream in = getClass().getResourceAsStream(path); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		br = new BufferedReader(reader);
		try{
			word = br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();

		}
		while (word != null && count != randomNumber) {
		    try{
		    	word = br.readLine();
		    }
		    catch(IOException e){
				e.printStackTrace();
		    }
		    count++;   
		}
		System.out.println("\n**********Game3**********\nWord to find : '" + word +"'");
		return word;
	}
	/*
	 * Function that resets the game by setting the number of tries left to 6, the number of letters found to 0 and choosing a new word
	 */
	public void reset(){
		this.triesLeft = 6;
		this.word = randomWord();
		this.numberLetterFound = 0;
	}
}
