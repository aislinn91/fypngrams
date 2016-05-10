/** Program to calculate Levenshtein distance between word taken from input and expected word 
	**Lev Dist = Amount of work needed to change one string to another**
	Operations that determine this value are 1)inserting 2)deleting 3)replacing 4)transposition(swapping)
	Parts to be improved commented below as such in blue
	
	boolean occursin1/2 doesnt seem to be working fully fix this
	Aislinn Moorhouse CASE4 **/

import java.io.*;
import java.util.*;

	
public class generateWords{
	
	//function will take in two strings and return integer i.e. the number of edit operations required to convert string 1 into string 2
	public static int editDist(String wordinput, String lmostfreq){
		
		//creating two variables that will be the length of each of the strings 
		int inputlen = wordinput.length();
		int freqlen = lmostfreq.length();
		
		//creating variable to store result to be returned
		int totaledist = 0;

		//if the length of the first string is zero editDist will be length of second string
		//as all letters would need to be inserted to turn s1 inputlen into s2 freqlen
		if(inputlen == 0){
			return freqlen;
		}
		//conversely if length of second string is zero editDist will be length of first string
		else if (freqlen == 0){
			return inputlen;
		}
		
		//else{
			
			/**    complete     **/
		//}
		
		
		//return int variable with resulting edit distance value for string pair
		return totaledist;	
	}

	//may be required
	//public boolean knownDist(String wordinput, String lmostfreq){
		
	//	if word pair is recognised in either hashmap editdist1 or hashmap editdist2
		
		
	//	return true;
	//}
	
	//function used to check if word pair contained in hashmap(dist1//dist2) 
	public static boolean checkMap (HashMap<String,String> eDist, String wordinput, String lmostfreq){
		
		//assigning parameters to variables
		String str1 = wordinput;
		String str2 = lmostfreq;
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap = eDist;
		//Creating string variable to store hmap value for comparison with lmostfreq
		String val;
		
		//if word input is a key in map
			if(hmap.containsKey(str1)){
				//for all entries in the hashmap   
				for (Map.Entry <String, String> entry : hmap.entrySet()) {
					//if the entries key is word input
					
					if (entry.getKey().equals(str1)) {
						//check the keys value and store in variable 	
						val = entry.getValue();
						System.out.println(val);
						//if values are the same
						if(val == str2){
							return true;
						}
						else{
							return false;
						}
					}
					else{
					return false;
					}
				}
			}
			else{
				return false;
			}
		
		return false;
	}
	
	
	
	
	
	public static void main(String [] args){
		
		//creating hashmap used to store all word pairs one edit away from word input- more likely for autocorrect 
		HashMap <String, String> editDist1 = new HashMap <String, String>();
		//creating hashmap to store all words two edits away from inputted word- less likely
		HashMap <String, String> editDist2 = new HashMap <String, String>();
		
		//creating int variable used to store result 
		int levenCount;
		//creating boolean variables to store results initialized to false 
		boolean occursin1 = false;
		boolean occursin2 = false;
		
		//test
		editDist1.put("dog","dot");
		editDist2.put(" ","it");
		
		
		//test print statement
		System.out.println("Please enter strings");
		
		//taking in word from console 
		String wordinput = Console.readString();
		/**taking most freq word from texts ***** need to work out how to take in file with freqs use most freq with same first letter?**/
		String lmostfreq = Console.readString();
		
		/** check if word is in the Irish dictionary ***********************************************/
		
		//running method and storing integer returned in levenCount variable
		levenCount = editDist(wordinput, lmostfreq);
		
		//checks to see if word already contained in editDist1/editDist2
		occursin1 = checkMap(editDist1, wordinput, lmostfreq);
		System.out.println("occurs in 1 (t/f)?" + occursin1);
		occursin2 = checkMap(editDist2, wordinput, lmostfreq);
		System.out.println("occurs in 2 (t/f)?" + occursin2);
			if(occursin1 == true){
				System.out.println("Edit distance of 1.. occurring in hashmap editDist1 already");
				levenCount = 1;
			}
			else if(occursin2 == true){
				System.out.println("Edit distance of 2.. occurring in hashmap editDist2 already");
				levenCount = 2;
		}
		
		else{		
			//if int comes back as 1 add to editDist1 array else add to editDist2 array 
			if(levenCount=='1'){
				editDist1.put(wordinput, lmostfreq);
				System.out.println("lev count was 1 on running editDist method");
			}
			else if(levenCount=='2'){
				editDist2.put(wordinput, lmostfreq);
				System.out.println("lev count was 2 on running editDist method");
			}
		}
		
		System.out.println("dis 1  " + editDist1);
		System.out.println("dis 2 " + editDist2);
		System.out.println("levenCount " + levenCount);
		
	}
	
}
