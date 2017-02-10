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