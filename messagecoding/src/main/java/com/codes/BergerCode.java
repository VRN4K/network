package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.utils.*;

public class BergerCode {
    private Logger logger = LoggerFactory.getLogger(BergerCode.class);
    private int[] massiveCheck = new int[3];
    private int firstError = rand(0, 6);
    private int secondError = rand(0, 6);

    public void execute(int[] message) {
        massiveCheck = binary(oneCount(message));

        System.out.println("Двоичное представление количества единиц в сообщении:");
        for (int i : massiveCheck) {
            System.out.print(i);
        }
        System.out.println();

        //Склеиваем полученное сообщение и массив с количеством единиц
        for (int i = 4, j = 0; i < 7; i++, j++) {
            message[i] = massiveCheck[j];
        }
        System.out.print("Полученное после склейки сообщение:");
        for (int i : message) {
            System.out.print(i);
        }
        System.out.println();

        //Генирируем ошибки
        message[firstError] = inversion(message[firstError]);
        logger.info(String.format("Ошибка сгенерированна на позиции %1$s", firstError));
        message[secondError] = inversion(message[secondError]);
        logger.info(String.format("Ошибка сгенерированна на позиции %1$s", secondError));

        System.out.print("Сообщение после искажения:");
        for (int i : message) {
            System.out.print(i);
        }

        massiveCheck = binary(oneCount(message));
       if(isSame(message,massiveCheck)){
           logger.info("Передача сообщения успешно завершена");
       }else {
           logger.error("Сообщение искажено!");
       }

    }

}
