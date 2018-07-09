package com.learning;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mgr {

	public static void main(String[] args) {
		checker(".*s$|.*t$|.*r$|.*k$|.*fe$", "camera");

	}
	
	public static void checker(String Regex_Pattern, String Test_String) {
        //Scanner Input = new Scanner(System.in);
        int T = 1;//Integer.parseInt(Input.nextLine());

        while(T-- > 0) {
           // String Test_String = Input.nextLine();
            Pattern p = Pattern.compile(Regex_Pattern);
            Matcher m = p.matcher(Test_String);
            System.out.println(m.find());

            if(Regex_Pattern.length() == 0) {
                System.out.println("Warning : Empty regular expression.");
            }

            if(Regex_Pattern.length() > 25) {
                System.out.println("Warning : Length of regular expression greater than 25 characters.");
            }
        }
    }


}
