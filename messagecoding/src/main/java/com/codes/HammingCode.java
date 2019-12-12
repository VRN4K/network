package com.codes;

import com.Syndrome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.utils.inversion;

public class HammingCode {
    private static Logger logger = LoggerFactory.getLogger(HammingCode.class);
    private ParityChecking parityChecking = new ParityChecking();
    private Syndrome syndrome = new Syndrome();

    public void execute(List<Integer> message, int errorCount) {
        int bit1 = message.get(0);
        int bit2 = message.get(1);
        int bit3 = message.get(2);
        int bit4 = message.get(3);
        //Проверочные биты Хемминга
        message.add(bit1 ^ bit2 ^ bit3);
        message.add(bit2 ^ bit3 ^ bit4);
        message.add(bit1 ^ bit2 ^ bit4);

        boolean parityResult = parityChecking.execute(message, errorCount);
        syndrome.createSyndrome(message);

        boolean state = syndrome.analyzeSyndrome();
        if (!state) {
            int index = syndrome.getCorruptedBit();
            message.set(index, inversion(message.get(index)));
        }
        if (parityResult && state) {
            logger.info("Сообщение не было искажено!");
        } else if (!parityResult && !state) {
            logger.info("Сообщение было искажено, но исправлено!");
        } else {
            logger.error("Сообщение было искажено");
        }
        System.out.println("Конечное сообщение:" + message.toString());

    }
}
