package com;

import java.util.Random;

public class utils {
    private Random random = new Random();

    public static int inversion(int bit) {
        if (bit == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int rand(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static int XOR(int[] massive, int n) {
        int fifthBit = massive[0];
        for (int i = 1; i < n; i++) {
            fifthBit = fifthBit ^ massive[i];
        }
        return fifthBit;
    }

    public static int charToBin(char binChar) {
        if (binChar == '0') {
            return 0;
        }
        if (binChar == '1') {
            return 1;
        }
        return 2;
    }

    public static int[] binary(int n) {
        int[] massive = new int[3];
        int b;
        for (int i = 2; n != 0; i--) {
            b = n % 2;
            massive[i] = b;
            n = n / 2;
        }
        return massive;
    }

    public static int oneCount(int[] massive) {
        int count = 0;
        for (int i : massive) {
            if (i == 1) {
                count++;
            }

        }

        return count;
    }

    public static boolean isSame(int[] message, int[] check) {
        int countSame = 0;
        for (int i = 4, j = 0; i < 6; i++, j++) {
            if (message[i] == check[j]) {
                countSame++;
            }
        }
        return countSame == 3;
    }
}

