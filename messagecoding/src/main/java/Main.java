import com.codes.BergerCode;
import com.codes.ParityChecking;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1.- Проверка четности\n2.- Код Бергера \n3.- Код Хемминга \n Введите номер операции:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.print("Введите двоичное 4-битовое сообщение:");
        Scanner scanner1 = new Scanner(System.in);
        int[] massive = new int[10];
        String buffer = scanner1.nextLine();
        for (int i = 0; i < 4; i++) {
            switch (buffer.charAt(i)) {
                case '0':
                    massive[i] = 0;
                    break;
                case '1':
                    massive[i] = 1;
                    break;
                default:
                    System.out.println("Введено неккоректное число!");
                    System.exit(0);
            }
        }

        switch (choice) {
            case 1:
                ParityChecking parityChecking = new ParityChecking();
                parityChecking.execute(massive);
                break;
            case 2:
                break;
            case 3:
                BergerCode bergerCode = new BergerCode();

                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

}

