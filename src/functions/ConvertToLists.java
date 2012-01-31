package functions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertToLists {

	private boolean isElse(char c) {                   // метод для проверки
		Pattern p = Pattern.compile("-,+");
		Matcher m = p.matcher(Character.toString(c));
		return m.matches();}
	
	 
	private int howMuch(String a){                      // метод используется для того, чтобы узнать, сколько слагаемых в 
		int n=0;                                        // уравнении (считает по кол-ву плюсов и минусов)
		for (int i=0; i<a.length();i++){                
            char cChar = a.charAt(i);                   
            if(isElse(cChar)){
            	n++;
            } 
		}
		n++;                                            // прибавляет плюс единицу, т.к. если первый эл-т = плюс, то 
		if(a.charAt(0)=='-') n--;                       // выдаваемое знач. будет равно n-1, где n = истинное кол-во.
		return(n);                                      
	}
		
	private int howMuchChars(String a, int n){          // Метод считает кол-во символов в слагаемом.
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
