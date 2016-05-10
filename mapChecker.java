import java.io.*;
import java.util.*;

public class mapChecker{
	
	public static void main(String [] args) {
		
			System.out.println("Please enter strings");
			
			String wordinput = Console.readString();
			String lmostfreq = Console.readString();
		
			HashMap <String, String> editDist1 = new HashMap<String, String>();
			editDist1.put(wordinput, lmostfreq);
	   
			boolean occursin1 = false;
			boolean occursin2;
	   
			String val;
	   
			//if word input is a key in map
			if(editDist1.containsKey(wordinput)){
				//for all entries in the hashmap   
				for (Map.Entry <String, String> entry : editDist1.entrySet()) {
					//if the entries key is word input
					System.out.println(entry.getKey());
					if (entry.getKey().equals(wordinput)) {
						//check the keys value and store in variable 	
						val = entry.getValue();
						System.out.println(val);
						//if values are the same
						if(val == lmostfreq){
							occursin1 = true;
						}
						else{
							occursin1 = false;
						}
					}
					else{
					occursin1 = false;
					}
				}
			}
			else{
				occursin1 = false;
			}
			
			System.out.println(occursin1);
			System.out.println(editDist1);
		
	}
}
