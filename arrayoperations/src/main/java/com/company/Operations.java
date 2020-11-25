package com.company;

import java.util.HashSet;
import java.util.Set;

public class Operations {
    public static void combination(Set arrayA, Set arrayB){
        HashSet resultSet = new HashSet(arrayA);
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Object item: arrayB) {
            resultSet.add(item);
        }
        for (Object item: resultSet) {
            stringBuilder.append(item + ", ");
        }

        stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()," }");
        System.out.println("Результат операции \"объединение\":\n" + stringBuilder.toString());
    }

    public static void intersection(Set arrayA, Set arrayB){

        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Object item: arrayB) {
            if(arrayA.contains(item)){
                stringBuilder.append(item + ", ");
            }
        }

        if(utils.emptyArrayCheck(stringBuilder.toString())){
            System.out.println("Результат операции - пустое множество.");
        }else{
            stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length()," }");
            System.out.println("Результат операции \"пересечение\":\n" + stringBuilder.toString());
        }
    }

    public static void residualAB(Set arrayA, Set arrayB){
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Object item: arrayA) {
            if(!arrayB.contains(item)){
                stringBuilder.append(item + ", ");
            }
        }
        if(utils.emptyArrayCheck(stringBuilder.toString())){
            System.out.println("Результат операции - пустое множество.");
        }else {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }");
            System.out.println("Результат операции \"разность A\\B\":\n" + stringBuilder.toString());
        }
    }

    public static void residualBA(Set arrayA, Set arrayB){
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (Object item: arrayB) {
            if(!arrayA.contains(item)){
                stringBuilder.append(item + ", ");
            }
        }
        if(utils.emptyArrayCheck(stringBuilder.toString())){
            System.out.println("Результат операции - пустое множество.");
        }else {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), " }");
            System.out.println("Результат операции \"разность B\\A\":\n" + stringBuilder.toString());
        }
    }
}
