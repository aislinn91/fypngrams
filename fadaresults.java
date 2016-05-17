//importing java classes needed for Scanner
import java.io.*;
import java.util.*;

/** Takes in text file tst2.txt of 3 columns col.1 = non fada words col.2 = fada words col.3= int counts **/
/** returns back three arrays one for each col **/
/** assumes alphabetical order **/
/** assumes length of 7 here **/
/** all nonfada array entries with substring matches to input string are identified and corresponding fada values added to a results array **/
/** next step will be to compare corresponding counts of results the highest will be identified as most used string **/


public class fadaresults{

	public static void main(String [] args){
	
	//storing user input in string
	String input = Console.readString();
	//used to store length of string input as needed to determine substrings
	int inputlen = input.length();
	
	/** All arrays the size of no. of unique words this no. will vary for different programs **/
	//creating array of int counts to store the number of times each unique word occurs
	int [] counts = new int[7];
	//creating array of non-fada words
	String [] nonfadas = new String[7];
	//creating array of corresponding fada words
	String [] fadas = new String[7];
	//creating array to store array of results that are fada equivalents of the matching nonfada words
	String [] result = new String [7];
	//creates a string of current string in nonfada array 
	String nonfadaval;
	
	
	//int position used to keep track of indexes 
	int pos = 0;
	//int storing pointer value in results array to keep track of where next value will go
	int respoint = 0;
	
	
	
		
	
	Scanner myFile = null;
	//read in text file
	try {myFile = new Scanner(new File("tst2.txt"));} 
			catch(FileNotFoundException e){};
		//while the text file has another line
		while (myFile.hasNextLine()) {
		//take in next available strings and store in string variables str (nonfadas) and str2 (fadas) respectively
		String str = myFile.next();
		String str2 = myFile.next();
		//int count variable to read in the next available int
		int count = myFile.nextInt();
			
		//next int found as above stored at counts array of index current position
		counts[pos] = count;
		//first string in each line will be stored in nonfadas array of index current position 	
		nonfadas[pos] = str;
		//second string in each line will be stored in fadas array of index current position
		fadas[pos] = str2;
		//increment position counter
		pos++;
		}

					
		//arrays populated above 
		//now must loop through nonfada array to find matching substring for results array
		//for loop loops until end of array
		for(int i=0;i<nonfadas.length;i++){
				//creating boolean set to false will be true if matches found/ resetting after loop
				boolean findingmatch = false;
				//if the input of a few letters e.g. 'cui' equals array entry.substring of amount of letters entered in string
				//nonfada arrays value at current position will be stored in string variable as declared above
				nonfadaval = nonfadas[i];
				//test statement output to check array value being stored is correct
				System.out.println("Non fada array value for i = " + i + " is " + nonfadaval);
				//substring of current array word from index 0 of word to length(of string taken in) stored in subs string variable
				String subs = (nonfadaval.substring(0,inputlen));
				//test statement output of substring value checking end point 
				System.out.println("Array substring is "+ subs);
				
				//if string input is equal to substring
				if(input.equals(subs)){
					//match of input and first few letters of nonfada array words
					//input fada array at equivalent index to result array at next available position
					result[respoint] = fadas[i];
					//increase respoint counter
					respoint++;
					//set boolean to true as a match has been found
					findingmatch = true;
					//test statement
					System.out.println("Substring and input string are equal");	
				}
				else{
					//was finding matches but have gone past match range (alphabetical)
					if(findingmatch){
						//in this case break out of loop
						break;
					}
				}
				
		}
		//printing arrays 
		System.out.println(Arrays.toString(nonfadas));
		System.out.println(Arrays.toString(fadas));
		System.out.println(Arrays.toString(counts));
		System.out.println(Arrays.toString(result));
	}
}
