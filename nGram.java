/* File used to output (2, 3, 4)n-grams using console input */
/* FYP-NGRAMS  */
/* Aislinn Moorhouse 10316229 */

import java.io.*;
import java.util.*;


public class nGram {

	//function takes in int n and string entered in to console and returns arraylist of (n) ngrams
    public static ArrayList<String> ngrams(int n, String sen) {
		
		//Creating array list named ngrams to store words from sen
        ArrayList<String> ngrams = new ArrayList<String>();
		//Creating string array of sentence split up into words using split function 
        String[] words = sen.split(" ");
		
		//int variable to store total number of ngrams that will occur
		int totaln = (words.length - n);
		
		
		//keep looping up to totaln to create all possible combinations for value given
        for (int i = 0; i <= totaln; i++)
			//each time run join function below on current values for i,i+n and add resulting string to arraylist  
            ngrams.add(join(words, i, i+n));
	    
		//return arraylist
        return ngrams;                          
    }
    
	//function used to concatenate contents of array  
    public static String join(String[] str, int start, int end) {
		//creating a stringbuilder object for concatenation of multiple strings
        StringBuilder sb = new StringBuilder();
		
		//loop from start value to end value(start+n)
        for (int i = start; i < end; i++){
			//append current word at i position in string array to stringbuilder 
            sb.append((i > start ? " " : "") + str[i]);
		}
		//return stringbuilder object in the form of a string
        return sb.toString();
    }

    public static void main(String[] args) {
		
		//Arraylist used to store resulting ngrams
		ArrayList <String> result = new ArrayList<String>(); 
		
		//Print statement requesting user to enter number of ngrams required
		System.out.println("Please enter number of required n grams:");
		//Reading in number of ngrams required from console- storing as integer variable n
		int n = Console.readInt();
		
		//Print statement requesting user to enter sentence to be split
		System.out.println("Please enter sentence required to compute ngrams:");
		
		while(!Console.endOfFile()){
			
			//Reading in sentence from console to be split into ngrams- storing as string sen  
			String sen = Console.readString(); 

			//Print statements verifying data was taken in (optional)
			System.out.println("no. of ngrams required = "+n);
			System.out.println("sentence inputted to be split into ngrams");
			
			//Carry out "ngrams" function passing number and sentence entered as params to function
			//store the resulting ngrams in the arraylist named ngram
			result = ngrams(n, sen);  
								
       
			//for loop to print out ngram strings and final arraylist as stored in result arraylist variable 
            for (String ngram : ngrams(n, sen))
				System.out.println(ngram);
				System.out.println("result:" + result);
			System.out.println();
		}
    }
}
