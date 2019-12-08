package com.codes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.utils.*;

public class ParityChecking {
    private static Logger logger = LoggerFactory.getLogger(ParityChecking.class);

    public boolean execute(List<Integer> message, int errorCount) {
        boolean result = false;
        message.add(XOR(message, message.size()));
        System.out.println("Пятый бит: " + message.get(message.size() - 1));

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

        int val = XOR(message, message.size() - 1);
        if (message.get(message.size() - 1) != val) {
            System.out.println("Сообщение было искажено!");
            result = false;
            logger.error("1");

        } else {
            System.out.println("Передача файла успешно завершена");
            result = true;
            logger.info("0");
        }
        System.out.print("Полученное сообщение:");
        for (int i : message) {
            System.out.print(String.format("%1$s", i));
        }
        return result;
    }
}
