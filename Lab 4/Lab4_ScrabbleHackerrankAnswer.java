//This is the answer to the actual Hackerrank question
//where we had to find the length of the longest word we can form from the given letters
//I adapted my solution from the original question he gave us, to answer this
import java.util.*;

public class Lab4_ScrabbleHackerrankAnswer{
    public static void main(String args[] ) throws Exception {
    	//Reads in the dictionary and stores it in an array
        Scanner myscanner = new Scanner(System.in);
        String letters = myscanner.nextLine();
        String array[] = new String[216555];
        for(int i=0;i<216555;i++)
            array[i]=myscanner.nextLine();

        //findLength is the method we had to write
        System.out.println(findLength(letters,array));
    }

    public static int findLength(String letters, String[] array){
    	//Create a char array of the letters
        char letter[] = letters.toCharArray();
        ArrayList<String> result = checkWords(array, letter);

		//This will sort the matching words by length
		Collections.sort(result, new comp());
		//Print the first entry in the list
		return result.get(0).length();
    }

	//Checks all the words in the dictionary againt the letters given
	public static ArrayList<String> checkWords(String words[], char[] letters) {
		ArrayList<String> result = new ArrayList<String>();

		//Calls checkString method on every word and adds word to list if it returns true
		for(int i = 0; i < words.length; i++){
			boolean check = checkString(words[i], letters) ;
			if(check){
				result.add(words[i]);
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
