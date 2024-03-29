package org.learning;

import java.util.Scanner;

public class CharCounter {
    static String userString;
    static char userChar;

    public static String charCounter(String userString, char userChar) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a string");
        userString = scan.nextLine();

        System.out.println("Enter a character to count");
        userChar = scan.nextLine().charAt(0);

        scan.close();

        int charCount = 0;
        String lowercaseString = userString.toLowerCase();
        char lowercaseChar = Character.toLowerCase(userChar);

        for (int i = 0; i < lowercaseString.length(); i++) {
            char currentChar = lowercaseString.charAt(i);
            if (currentChar == lowercaseChar) charCount++;
        }

        return "Your input (" + userString + ") contains '" + lowercaseChar + "' " + charCount + " time(s)";
    }

    public static void main(String[] args) {

        System.out.println(charCounter(userString, userChar));

    }

}
