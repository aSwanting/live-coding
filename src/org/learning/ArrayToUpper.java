package org.learning;

import java.util.Arrays;

//Transform array strings to upper case
public class ArrayToUpper {
    static String[] guestList = {
            "Dua Lipa",
            "Paris Hilton",
            "Manuel Agnelli",
            "J-Ax",
            "Francesco Totti",
            "Ilary Blasi",
            "Bebe Vio",
            "Luis",
            "Pardis Zarei",
            "Martina Maccherone",
            "Rachel Zeilic"
    };

    public static void arrayToUpperCase(String[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toUpperCase();
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(guestList));
        arrayToUpperCase(guestList);
        System.out.println(Arrays.toString(guestList));
    }
}
