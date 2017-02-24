package allAround.tools;

import java.util.ArrayList;
import java.util.List;

public class ToolBox {
	
	public static String toTitleCase(String input) {
		String[] splitStr = input.split("\\s");
		List<String> outputStrs = new ArrayList<String>();
		for(String word:splitStr){
			outputStrs.add(toCamelCase(word));
		}
		return String.join(" ", outputStrs);
			
	}
	
	public static String toCamelCase(String input) {
		if (input.toLowerCase().equals("of") || input.toLowerCase().equals("at") || 
			input.toLowerCase().equals("in")	|| input.toLowerCase().equals("and") ){
			return input.toLowerCase();
		}
		else {
			if (input.indexOf("-") == -1){
				return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
			}
			else {
				return input.substring(0,1).toUpperCase() + 
					   input.substring(1, input.indexOf("-")).toLowerCase() +
					   "-" +
			           input.substring(input.indexOf("-")+1, input.indexOf("-")+2).toUpperCase() +
			           input.substring(input.indexOf("-")+2).toLowerCase();
			}
		}
			
	}
	
	public static void main(String[] args) {
		System.out.println("OF".toLowerCase());
		System.out.println(toTitleCase("UNIVERSITY OF CALIFORNIA-BERKELEY"));
	}


}
