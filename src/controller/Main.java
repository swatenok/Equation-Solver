package controller;

import java.util.Arrays;

import functions.*;

public class Main {

	public static void main (String [] args)
	{
	    String a = "4xy+y=0";
        ConvertToCorrectForm form = new ConvertToCorrectForm();
        String formed = form.convert(a);
        System.out.println(a);
        System.out.println(formed);
        ConvertToLists list = new ConvertToLists();
        String[] listed = list.convertToAList(formed);
        String answer= Arrays.toString(listed);
        System.out.println(answer);

	}
}
