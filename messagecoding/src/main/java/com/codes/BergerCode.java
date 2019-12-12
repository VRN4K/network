package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.utils.*;

public class BergerCode {
    private Logger logger = LoggerFactory.getLogger(BergerCode.class);
    private int[] massiveCheck = new int[3];
    private int[] massiveInversion = new int[3];


    public void execute(List<Integer> message, int errorCount) {
        massiveCheck = binary(oneCount(message));

        System.out.print("Двоичное представление количества единиц в сообщении:");
        for (int i : massiveCheck) {
            System.out.print(i);
        }
        System.out.println();

        //Склеиваем полученное сообщение и массив с количеством единиц
        for (int value : massiveCheck) {
            message.add(inversion(value));
        }
        System.out.println("Полученное после склейки и инвертации 3 последних бит сообщение:" + message.toString() );

        //Генирируем ошибки
        if (errorCount != 0) {
            while (errorCount != 0) {
                int errorPlace = rand(0, 4);
                message.set(errorPlace, inversion(message.get(errorPlace)));
                logger.info(String.format("Ошибка сгенерирована на позиции %1$s", errorPlace + 1));
                errorCount--;
            }
        } else {
            logger.info("Ошибка не сгенерирована!");
        }

        System.out.println("Сообщение:" + message.toString());

        massiveInversion = binary(oneCount(message));

        if (isSame(massiveInversion, massiveCheck)) {
            logger.info("Передача сообщения успешно завершена");
        } else {
            logger.error("Сообщение искажено!");
        }

    }

}
