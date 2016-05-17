import java.io.*;
import java.util.*;

/* Takes in text file tst2.txt of 3 columns col.1 = non fada words col.2 = fada words col.3= int counts */
/* returns back three arrays one for each col */
/* assumes alphabetical order */
/*assumes length of 7 here*/
/*working for an equal match but modification still needed*/


public class fadassearch{

	public static void main(String [] args){
	//creating array of int counts	
	int [] counts = new int[7];
	//creating array of fada words
	String [] fadas = new String[7];
	//creating array of non-fada words
	String [] nonfadas = new String[7];
	//creating array to store array of results
	String [] result = new String [7];
	
	//int position 
	int pos = 0;
	//storing user input
	String input = Console.readString();
	//int storing pointer value in results array to keep track of where next value will go
	int respoint = 0;
	
	
	
		
	
	Scanner myFile = null;
	//read in text file
	try {myFile = new Scanner(new File("tst2.txt"));} 
			catch(FileNotFoundException e){};
		while (myFile.hasNextLine()) {
		//take in strings
		String str = myFile.next();
		String str2 = myFile.next();
		int count = myFile.nextInt();
			
			//next int found stored at array in current position
			counts[pos] = count;
			fadas[pos] = str;
			nonfadas[pos] = str2;
			pos++;	
			
			//arrays populated now loop through nonfada array to find matching substring to input
			//int storing the length of the string + 1 needed for substring 
			int endpoint = nonfadas.length+1;
			
			
			for(int i=0;i<nonfadas.length;i++){
				//creating boolean/ resetting after loop
				boolean findingmatch = false;
				//if the input of a few letters e.g. 'cui' equals array entry.substring of amount of letters entered in 
				String nonfadaval = nonfadas[i];
				System.out.println(nonfadaval);
				//substring of current array word
				String subs = nonfadaval.substring(0,3);
				System.out.println(subs);
				
				if(input.equals(subs)){
					//match of input and words first few letters
					//input equivalent in fada array to result array at next pos
					result[respoint] = fadas[pos];
					//increase respoint counter
					respoint++;
					//set boolean to true
					findingmatch = true;
					System.out.println("equals");
				}
				else{
					//was finding matches but have gone past match range (alphabetical)
					if(findingmatch == true){
						break;
					}
				}
				
			}
			
		}
		System.out.println(Arrays.toString(nonfadas));
		System.out.println(Arrays.toString(fadas));
		System.out.println(Arrays.toString(counts));
		System.out.println(Arrays.toString(result));
	}
}
