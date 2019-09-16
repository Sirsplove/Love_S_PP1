/**
 * This class initializes the two hashmaps for the application to search the IP addresses and unique
 * usernames to match with the regex.
 * @author Stephen Love
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */

import java.util.regex.*;
import java.util.HashMap;

public class PatternMatching {

	private HashMap<String, Integer> IPAddressesMap = new HashMap<>();
	private HashMap<String, Integer> UsernamesMap = new HashMap<>();

	
	public PatternMatching() {
		IPAddressesMap = new HashMap<>();
		UsernamesMap = new HashMap<>();
		
	}
	
	public HashMap<String, Integer> getIPAddressesMap() {
		
		return IPAddressesMap;
		
	}

	public HashMap<String, Integer> getUsernamesMap() {
		
		return UsernamesMap;
	}

	public int getIPAddressesMapSize() {
		
		return IPAddressesMap.size();
	}

	public int getUsernamesMapSize() {
		
		return UsernamesMap.size();
	}

	public void PatternMatch(String input) {
		
	    
	    Matcher ipPattern = Pattern.compile(\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\b).matcher(input); //ipaddress pattern in regex
	    
	    Matcher usernamePattern = Pattern.compile("user\\s\\w+").matcher(input); //usernames pattern in regex

	    
	    while(ipPattern.find()) {
	    	
	    		String match = ipPattern.group();
	    		if(IPAddressesMap.containsKey(match)){
	    		
	    		IPAddressesMap.put(match, IPAddressesMap.get(match) + 1);
	    		} 
	    	
	    		else	 {
	    		
	    		IPAddressesMap.put(match, 1);
	    		
	    		}// end if/else
	    }// end while

	   
	    while(usernamePattern.find()) {
	    	
	    	String match = usernamePattern.group();
		String username = match.substring(5);
	    	if(UsernamesMap.containsKey(username)) {
	    		
	    		UsernamesMap.put(username, UsernamesMap.get(username) + 1);
	    	} 
	    	
	    	else 	{
	    		
	    		UsernamesMap.put(username, 1);
	    		
	    	}// end if/else
	    }// end while

	}//end PatternMatch

}// end PatternMatching
