//This is the solution to the original questions we were given where we had to
//give the top 10 suggestions of words from the given letters
import java.util.*;
import java.io.*;
public class Lab4_Scrabble{
	public static void main(String args[]) throws FileNotFoundException{
		//Reads in the dictionary
		Scanner file = new Scanner(new FileReader("C:/Users/Rian/Desktop/Lab4/dictionary.txt"));
		ArrayList<String> words = new ArrayList<String>();

		//Fills an array list with all the words in the dictionary
		while(file.hasNext())
			words.add(file.nextLine());

		//Reads in the letters and stores them in a char array
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your letters");
		String temp = sc.nextLine().replaceAll(" ", "");
		System.out.println();
		char letters[] = temp.toCharArray();

		//Will store in an array list all the words that match the letters
		ArrayList<String> result = checkWords(words, letters);

		//Sorts those words in desending order of length and prints the top ten
		Collections.sort(result, new comp());
		int size = Math.min(10, result.size());

		System.out.printf("Here are the top %d suggestions:\n\n", size);

		for(int i = 0; i < size; i++){
			System.out.println(result.get(i));
		}
	}

	//Checks all the words in the dictionary againt the letters given
	public static ArrayList<String> checkWords(ArrayList<String> words, char[] letters) {
		ArrayList<String> result = new ArrayList<String>();

		//Calls checkString method on every word and adds word to list if it returns true
		for(int i = 0; i < words.size(); i++){
			boolean check = checkString(words.get(i), letters) ;
			if(check){
				result.add(words.get(i));
			}
		}
		return result;
	}

	//Checks a string against the letters given
	public static boolean checkString(String word, char[] letters){
		//Create a hashtable that will store each letter and it's frequency
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

		for(int i = 0; i < letters.length; i++){
			char temp = letters[i];

			//Increment the frequency of a leter you've seen before by one
			if(table.get(temp) != null)
				table.put(temp, table.get(temp)+1);

			//If you've never seen the letter before insert 1 in to that slot in the hashtable
			else
				table.put(temp, 1);
		}

		//Loop through all the letters in the word you're checking to see if they're in the table
		for(int i = 0; i < word.length(); i++){
			char temp = word.charAt(i);

			//Decrement a letter's frequency if you find it in the table
			if(table.get(temp) != null && table.get(temp) > 0)
				table.put(temp, table.get(temp)-1);
			else
				return false;
		}
		return true;
	}
}

//This comparator sorts by string length and if they're the same length, alphabetically
class comp implements Comparator<String> {
	  public int compare(String one, String two) {
		    //By length
		    if (one.length() > two.length())
		    	return -1;
		    else if (one.length() < two.length())
		    	return 1;

		    //Alphabetically
		    else{
		    	if(one.compareTo(two) > 0)
		    		return 1;
		    	else if(one.compareTo(two) < 0)
		    		return -1;
		    	else
		    		return 0;
		    }
	  }
}