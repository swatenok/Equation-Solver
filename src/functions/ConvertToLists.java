package functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertToLists {

	private boolean isElse(char c) {
		Pattern p = Pattern.compile("-,+");
		Matcher m = p.matcher(Character.toString(c));
		return m.matches();}
	
	
	private int howMuch(String a){
		int n=0;
		for (int i=0; i<a.length();i++){
            char cChar = a.charAt(i);
            if(isElse(cChar)){
            	n++;
            }
		}
		return(n);
	}
		
	private int howMuchChars(String a, int n){
        char cChar = a.charAt(n);
        int ans=0;
		while(isElse(cChar)==false){
            cChar = a.charAt(n);
		    n=n+1;
		    ans++;
		}
		return(ans);
	}
	public String[] convertToAList (String a){
		
		boolean everstarted = true;
		
		String[] answ = new String [howMuch(a)];
		
		int answi = 0;
		 
		for (int i=0; i<a.length();i++){
            char cChar = a.charAt(i);
			if ((isElse(cChar)) || (everstarted)){
				i++;
				if(everstarted==true) everstarted=false;
				cChar = a.charAt(i);
				char[] tmp = new char[howMuchChars(a,i)];
                int n=0;
                char nextChar=a.charAt(i+1);
				while(isElse(nextChar)==false){
				     nextChar = a.charAt(i+1);
			         cChar = a.charAt(i);
                     tmp[n] = cChar;
                     n++;
                     i++;
				     }
				answ[answi]= tmp.toString();
				answi++;
				}
			
		
		
		
		
		}
		return answ;
		
		
		
		
		
		
	} 
}
