package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.utils.*;

public class ParityChecking {
    private Logger logger = LoggerFactory.getLogger(ParityChecking.class);
    private int errorMissing = rand(0, 1);

    public void execute(int[] message) {
        message[4] = XOR(message, 4);
        System.out.println("Пятый бит: " + message[4]);

        if (errorMissing == 0) {
            int errorPlace = rand(0, 4);
            message[errorPlace] = inversion(message[errorPlace]);
            logger.info("Ошибка сгенерирована!");
        } else {
            logger.info("Ошибка не сгенерирована!");
        }

        message[5] = XOR(message, 5);
        if (message[5] == 1) {
            System.out.println("Сообщение было искажено!");
            logger.error(String.format("%1$s", message[5]));

        } else {
            System.out.println("Передача файла успешно завершена");
            logger.info(String.format("%1$s", message[5]));
        }
        System.out.print("Полученное сообщение:");
        for (int i : message) {
            System.out.print(String.format("%1$s", i));
        }
    }
}
