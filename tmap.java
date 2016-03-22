
/* File used to take in no of ngrams required and sentence returning treemap of ngram keys and occurring values*/
/* FYP-NGRAMS  */
/* Aislinn Moorhouse 10316229 */

import java.io.*;
import java.util.*;


public class tmap {
		
	//function takes in int n and string and returns treemap of (n) ngrams with linking occurrence amount
    public static TreeMap<String, Integer> ngrams(int n, String sen) {
		
		//Creating array list named ngrams to store words from sen
    ArrayList<String> ngrams = new ArrayList<String>();
		//TreeMap used to store string and no of occurrences
		TreeMap <String, Integer> map = new TreeMap <String, Integer>();
		
		//Creating string array of sentence split up into words using split function 
    String[] words = sen.split(" ");
		
		//int variable to store total number of ngrams that will occur
		int totaln = (words.length - n);
		
		
		
		//keep looping up to totaln to create all possible combinations for value given
        for (int i = 0; i <= totaln; i++){
			//each time run join function below on current values for i,i+n and add resulting string to arraylist  
            ngrams.add(join(words, i, i+n));
			//get ngram just entered into arraylist and store in variable
			String thisn = ngrams.get(i);
			
			//print statement checks value is correct
			//System.out.println(thisn);
			//boolean checks if string in arraylist
			boolean exists = map.containsKey(thisn);
			
			//int variable to keep track of ngram
			int num = (i + 1);
			
			//if value true i.e.  
			if(exists==true){
				//key already inserted increase the count 
				map.put(thisn, map.get(thisn) +1);
				//print statement to check boolean working correctly 
				System.out.println(" Ngram no. " + num  + " = " + thisn + " : is an existing key");
			}
			else{//boolean will be false -no such key as of yet
				//add to treemap with a count of one as it is the first occurring string
				map.put(thisn, 1);
				//check
				System.out.println(" Ngram no. " + num  + " = " + thisn + " : new key");
			}
		}
			System.out.println();
		    //for loop to print out ngram strings and final arraylist as stored in result arraylist variable 
            for (String key : map.keySet())
				System.out.println(key + " "+map.get(key));
			System.out.println();
		////return treelist
        return map;                          
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
		
		//create treemap to store existing ngrams and responding amount of occurrences
		TreeMap <String, Integer> freq = new TreeMap<String, Integer>(); 
		
		
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
			System.out.println("sentence inputted to be split into ngrams = " + sen);
			
			//Carry out "ngrams" function passing number and sentence entered as params to function
			//store the resulting treemap in freq variable
			freq = ngrams(n, sen);  
				
			System.out.println("RESULTING TREEMAP AND VALS "+ freq);
       
		}
    }
}
