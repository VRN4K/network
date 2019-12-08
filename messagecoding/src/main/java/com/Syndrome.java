package com;

import java.util.List;

public class Syndrome {
    private int syndrome1;
    private int syndrome2;
    private int syndrome3;

    public void createSyndrome(List<Integer> message) {
        int bit1 = message.get(0);
        int bit2 = message.get(1);
        int bit3 = message.get(2);
        int bit4 = message.get(3);
        int hammingBit1 = message.get(4);
        int hammingBit2 = message.get(5);
        int hammingBit3 = message.get(6);
        syndrome1 = hammingBit1 ^ bit1 ^ bit2 ^ bit3;
        syndrome2 = hammingBit2 ^ bit2 ^ bit3 ^ bit4;
        syndrome3 = hammingBit3 ^ bit1 ^ bit2 ^ bit4;
    }

    public boolean analyzeSyndrome() {
        return syndrome1 == 0 && syndrome2 == 0 && syndrome3 == 0;
    }

    public int getCorruptedBit() {
        if (syndrome1 == 0) {
            if (syndrome2 == 0) {
                if (syndrome3 == 1) {
                    return 6;
                }
            } else {
                if (syndrome3 == 0) {
                    return 5;
                } else {
                    return 3;
                }
            }
        } else {
            if (syndrome2 == 0) {
                if (syndrome3 == 0) {
                    return 4;
                } else {
                    return 0;
                }
            } else {
                if (syndrome3 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 7;
    }
}



