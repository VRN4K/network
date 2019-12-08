package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.utils.*;

public class BergerCode {
    private Logger logger = LoggerFactory.getLogger(BergerCode.class);
    private int[] massiveCheck = new int[3];
    private int[] massiveInversion = new int[3];


    public void execute(int[] message, int errorCount) {
        massiveCheck = binary(oneCount(message));

        System.out.println("Двоичное представление количества единиц в сообщении:");
        for (int i : massiveCheck) {
            System.out.print(i);
        }
        System.out.println();

        //Склеиваем полученное сообщение и массив с количеством единиц
        for (int i = 4, j = 0; i < 7; i++, j++) {
            message[i] = inversion(massiveCheck[j]);
        }
        System.out.print("Полученное после склейки сообщение:");
        for (int i : message) {
            System.out.print(i);
        }
        System.out.println();

        //Генирируем ошибки
        if (errorCount != 0) {
            while (errorCount != 0) {
                int errorPlace = rand(0, 6);
                message[errorPlace] = inversion(message[errorPlace]);
                logger.info(String.format("Ошибка сгенерирована на позиции %1$s", errorPlace + 1));
                errorCount--;
            }
        } else {
            logger.info("Ошибка не сгенерирована!");
        }

        System.out.print("Сообщение:");
        for (int i : message) {
            System.out.print(i);
        }
        massiveInversion = binary(oneCount(message));

        if (isSame(massiveInversion, massiveCheck)) {
            logger.info("Передача сообщения успешно завершена");
        } else {
            logger.error("Сообщение искажено!");
        }

    }

}
