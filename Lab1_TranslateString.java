//Take in a string and print each character as a 7 bit binary ASCII number
//Print each character and it's frequency
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Enumeration;

public class Lab1_TranslateString{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		//Create a hash table that's going to store each char that occurs and it's frequency
		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>(input.length() * 2);

		for(int i = 0; i < input.length(); i++){
			char current = input.charAt(i);
			String num = Integer.toBinaryString((int)current); //Convert char to ASCII binary string

			//This just formats the output so that there's four binary strings per line
			if(i % 4 == 0)
				System.out.println();

			//Pad the string
			if(num.length() < 7)
				for(int j = 0; j < 7 - num.length(); j++)
					num = "0" + num;

			System.out.print(num + " ");

			//Count how many times you see a character
			if(table.get(current) == null)
				table.put(current, 1);
			else
				table.put(current, table.get(current)+1);
		}
		System.out.println();

		//Prints out the frequency of each character that occured
		Enumeration<Character> n = table.keys();
		while(n.hasMoreElements()){
			char temp = n.nextElement();
			System.out.println("'"+temp+"'" + " appeared " + table.get(temp) + " times");
		}
	}
}
/*
Example input: "the cat in the hat"
Output: 1110100 1101000 1100101 0100000 
	1100011 1100001 1110100 0100000 
	1101001 1101110 0100000 1110100 
	1101000 1100101 0100000 1101000 
	1100001 1110100 
	'i' appeared 1 times
	' ' appeared 4 times
	'h' appeared 3 times
	'e' appeared 2 times
	'c' appeared 1 times
	'a' appeared 2 times
	't' appeared 4 times
	'n' appeared 1 times
*/	
