package functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* The author of this code is Makar Stetsenko */

class ConvertToCorrectForm {
		private boolean isLetter(char c) {
			Pattern p = Pattern.compile("[a-z]");
			Matcher m = p.matcher(Character.toString(c));
			return m.matches();
		}
		private boolean isNumber(char c) {
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(Character.toString(c));
			return m.matches();
		}
    	public String convert (String a)
    	{
            char prev = ']'; // ini
            for (int i=0; i < a.length(); i++)
            {
                char cChar = a.charAt(i);
                if ((isLetter(cChar) && (isNumber(prev) || isLetter(prev))) || (isNumber(cChar) && isLetter(prev))) {
                    //insert
                	String beforePointer = a.substring(0, i);
                	String afterPointer = a.substring(i, a.length());
                	a = beforePointer + "*" + afterPointer;
                	i++;
                } 
            	prev = cChar;
                
            }
            return(a);
    	}
}
