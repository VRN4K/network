import com.codes.BergerCode;
import com.codes.ParityChecking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[] massive = new int[10];
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
        for (int i = 0; i < 4; i++){
            massive[i] = buffer.charAt(i) - '0';
        }
        System.out.print("Введите количество ошибок:");
        Scanner scanner2 = new Scanner(System.in);
        int errorCount = scanner2.nextInt();

        switch (choice) {
            case 1:
                ParityChecking parityChecking = new ParityChecking();
                parityChecking.execute(massive,errorCount);
                break;
            case 2:
                BergerCode bergerCode = new BergerCode();
                bergerCode.execute(massive, errorCount);
                break;
            case 3:


                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

}

