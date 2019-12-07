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

    public static int rand(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min ;
    }

    public static int XOR(int[] massive, int n){
        int fifthBit = massive[0];
        for (int i = 1; i < n; i++) {
            fifthBit = fifthBit ^ massive[i];
        }
        return fifthBit;
    }
}
