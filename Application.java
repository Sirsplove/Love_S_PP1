/**
 * This class reads the auth.log file and uses the PatternMatching
 * class to track IP addresses and usernames from the log file into hashmaps.
 * @author Stephen Love
 * @version 1.0
 * Programming Project One
 * CS322
 * Spring 2019
 */

import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class Application {
	
	public static void main(String[] args) {
		
		int lines = 0;

		PatternMatching patternMatch = new PatternMatching();

		try {
			
			Scanner scanner = new Scanner(new File(args[0]));
			while(scanner.hasNextLine()) {
				patternMatch.PatternMatch(scanner.nextLine());
				lines++;
				
			}// end whiile
			
			scanner.close();
			
		}// end try
		catch(IOException e) {
			
			e.printStackTrace();
			
		}// end catch

		if(args[1].equals("1")) {
			
			patternMatch.getIPAddressesMap().forEach((k,v)->System.out.println("IP Address: " + k + "; Frequency: " + v));
			System.out.println();
			
		}// end if
		
		if(args[1].equals("2")) {
			
			patternMatch.getUsernamesMap().forEach((k,v)->System.out.println("Username: " + k + "; Frequency:  " + v));
			System.out.println();
			
		}// end if

		System.out.println("The file " + args[0] + " contains " + lines + " lines.");
		System.out.println("There are " + patternMatch.getIPAddressesMap().size() + " IP addresses.");
		System.out.println("There are " + patternMatch.getUsernamesMap().size() + " usernames.");

	}// end main

}// end Application

