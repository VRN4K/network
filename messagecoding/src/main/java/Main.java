import com.codes.BergerCode;
import com.codes.HammingCode;
import com.codes.ParityChecking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> message = new ArrayList<Integer>();
        System.out.println("1.- Проверка четности\n2.- Код Бергера \n3.- Код Хемминга \n Введите номер операции:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("Введите двоичное 4-битовое сообщение:");
        Scanner scanner1 = new Scanner(System.in);
        String buffer;
        while (true){
            try{
                buffer = scanner1.next("[0-1]{4}");
            } catch(InputMismatchException e){
                System.out.println("Введено неверное число! Попробуйте снова.");
                scanner1.nextLine();
                continue;
            }
            break;
        }
        for (char i: buffer.toCharArray()){
            message.add(i - '0');
        }
        System.out.print("Введите количество ошибок:");
        Scanner scanner2 = new Scanner(System.in);
        int errorCount = scanner2.nextInt();

        switch (choice) {
            case 1:
                ParityChecking parityChecking = new ParityChecking();
                parityChecking.execute(message,errorCount);
                break;
            case 2:
                BergerCode bergerCode = new BergerCode();
                bergerCode.execute(message, errorCount);
                break;
            case 3:
                HammingCode hammingCode = new HammingCode();
                hammingCode.execute(message,errorCount);
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

}

