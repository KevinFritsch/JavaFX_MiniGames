package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prize {

	/*
	 * An HashMap that contains a String that represents the title of the prize and a List of Strings that contains the number of game points needed and the final prize
	 */
	private HashMap<String, List<String>> hashmapPrizes; 
	/*
	 * A String that represents the path of the text file where there are all the possible prizes
	 */
	private String listPath;
	
	/*
	 * Constructor of the class Prize
	 * @param A String that represents the path of the text file where there are all the possible prizes
	 */
	public Prize(String pathPrizes){
		listPath = pathPrizes;
		hashmapPrizes = addElementsToHashMap();
	}
	/*
	 * Getter function that returns the HashMap that contains all the informations for a prize
	 * @return HashMap of a String (Title of the prize) and a List of Strings (Game points needed and final prize)
	 */
	public HashMap<String, List<String>> getHashMapPrizes(){
		return this.hashmapPrizes;
	}
	/*
	 * Getter function that returns the number of points as a String needed from the HashMap	
	 * @param A String that represents the title of the prize (the key of the HashMap)
	 * @return A String that represents the number of game points needed for a prize
	 */
	public String getPointsNeeded(String stringTitle){
		return getHashMapPrizes().get(stringTitle).get(1);
	}
	/*
	 * Getter function that returns the final prize from the HashMap
	 * @param A String that represents the title of the prize (the key of the HashMap)
	 * @return A String that represents the final prize
	 */
	public String getPrize(String stringTitle){
		return getHashMapPrizes().get(stringTitle).get(1);
	}
	/*
	 * Function that adds all the elements from the text file to the HashMap
	 * @return An HashMap that contains a String (the title of the prize) and a List of Strings (points needed and final prize)
	 */
	private HashMap<String, List<String>> addElementsToHashMap(){
		HashMap<String, List<String>> res = new HashMap<>();
		String[] parts;
        
        for(int i = 0; i < 19; i++){
        	parts = splitTxtFilePrizes(listPath,i);
        	List<String> listPrize = new ArrayList<String>();
        	listPrize.add(parts[1]);
        	listPrize.add(parts[2]);
        	res.put(parts[0], listPrize);
        }
        return res;
	}
	/*
	 * Function that split a sentence at each "," from a text file and put it into a String Array
	 * @param path A String that represents the path of the text file that contains all the prizes information
	 * @param line An Integer that represents the line of the text file that has to be split
	 * @return An Array of String that represents each word from a sentence separated by a ","
	 */
	private String[] splitTxtFilePrizes(String path, int line){
		String[] parts = null;
		String word="";
		BufferedReader br;
		int count = 0;
		InputStream in = getClass().getResourceAsStream(path); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		br = new BufferedReader(reader);
		while (word != null ) {
		    try{
		    	word = br.readLine();
		    	if(word !=null && count == line){
		    		parts = word.split(",");
		    		break;
		    	}
		    	count++;
		    }
		    catch(IOException e){
				e.printStackTrace();
		    }
		}
		return parts;
	}
}
