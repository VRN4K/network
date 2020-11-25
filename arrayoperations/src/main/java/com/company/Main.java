package com.company;

import com.company.Operations;
import com.company.utils;

import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите множество A:");
            Scanner scannerA = new Scanner(System.in);

            Set arrayA = utils.read(scannerA);

            System.out.println("Введите множество B:");
            Scanner scannerB = new Scanner(System.in);

            Set arrayB = utils.read(scannerB);

            System.out.println(" 1. - Объединение \n 2. - Пересечение \n 3. - Разность А\\B \n 4. - Разность B\\A \nВведите номер операции:");
            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Operations.combination(arrayA,arrayB);
                    break;
                case 2:
                    Operations.intersection(arrayA,arrayB);
                    break;
                case 3:
                    Operations.residualAB(arrayA,arrayB);
                    break;
                case 4:
                    Operations.residualBA(arrayA,arrayB);
                    break;
                default:
                    System.out.println("Введена неверная команда!");
            }

            System.out.println("\n1.- Выход из программы \n2.- Повторить выполнение операций");
            Scanner scanner1 = new Scanner(System.in);
            if(scanner1.nextInt() == 1){
                exit(0);
            }

        }
    }
}
