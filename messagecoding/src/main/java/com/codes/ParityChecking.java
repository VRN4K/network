package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.utils.*;

public class ParityChecking {
    private static Logger logger = LoggerFactory.getLogger(ParityChecking.class);

    public void execute(int[] message, int errorCount) {
        message[4] = XOR(message, 4);
        System.out.println("Пятый бит: " + message[4]);

        if (errorCount != 0) {
            while (errorCount != 0) {
                int errorPlace = rand(0, 4);
                message[errorPlace] = inversion(message[errorPlace]);
                logger.info(String.format("Ошибка сгенерирована на позиции %1$s", errorPlace+1));
                errorCount--;
            }
        } else {
            logger.info("Ошибка не сгенерирована!");
        }

        message[5] = XOR(message, 4);
        if (message[5] != message[4]) {
            System.out.println("Сообщение было искажено!");
            logger.error("1");

        } else {
            System.out.println("Передача файла успешно завершена");
            logger.info("0");
        }
        System.out.print("Полученное сообщение:");
        for (int i : message) {
            System.out.print(String.format("%1$s", i));
        }
    }
}
