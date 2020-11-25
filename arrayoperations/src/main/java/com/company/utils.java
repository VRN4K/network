package com.company;

import java.util.*;

public class utils {
    private static Set toArray(String str){
        String letter = "";

        Set hashSet = new HashSet();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ',' && str.charAt(i) != '.'){
                letter += str.charAt(i);
            }else{
                hashSet.add(letter);
                letter = "";
            }
        }
        return hashSet;
    }

    public static Set read(Scanner scanner){
        StringBuilder input = new StringBuilder(scanner.nextLine());

        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ' || input.charAt(i) == '.'){
                input.deleteCharAt(i);
                i--;
            }
        }
        input.append(".");

        return toArray(input.toString());
    }

    public static boolean emptyArrayCheck(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if(stringBuilder.charAt(i) == '{' || stringBuilder.charAt(i) == ' '
                     || stringBuilder.charAt(i) == ','){
                stringBuilder.deleteCharAt(i);
                i--;
            }
        }
        return stringBuilder.length() <= 0;
    }

}
