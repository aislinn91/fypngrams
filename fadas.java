import java.io.*;
import java.util.*;

/* Takes in text file tst2.txt of 3 columns col.1 = non fada words col.2 = fada words col.3= int counts */
/* returns back three arrays one for each col */


public class fadas{

	public static void main(String [] args){
	//creating array of int counts	
	int [] counts = new int[7];
	//creating array of fada words
	String [] fadas = new String[7];
	//creating array of non-fada words
	String [] nonfadas = new String[7];
	
	//int position 
	int pos = 0;
		
	
	Scanner myFile = null;
	//read in text file
	try {myFile = new Scanner(new File("tst2.txt"));} 
			catch(FileNotFoundException e){};
		while (myFile.hasNextLine()) {
		//take in strings
		String str = myFile.next();
		String str2 = myFile.next();
		int count = myFile.nextInt();
			
			counts[pos] = count;
			fadas[pos] = str;
			nonfadas[pos] = str2;
			pos++;	
			
		}
		System.out.println(Arrays.toString(fadas));
		System.out.println(Arrays.toString(nonfadas));
		System.out.println(Arrays.toString(counts));
	}
}
