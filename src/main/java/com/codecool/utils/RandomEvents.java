package com.codecool.utils;

import java.util.Random;

public class RandomEvents {
    private static final Random RANDOM = new Random();

    public static int nextNumber(int end) {
        return RANDOM.nextInt(end);
    }

    public static boolean shouldEventHappen(int chance) {
        // 0 - 99
        // chance = 5
        // 0,1,2,3,4 - event occurred
        // 5-99 (95 numbers) -> event not occurred

        return nextNumber(100) < chance;
    }

    public static int nextNumber(int start, int end) {
        // 0 - 5
        // (0, 5) -> 0,1,2,3,4
        // (0, 6) -> 0,1,2,3,4,5
        return RANDOM.nextInt(start, end + 1);
    }

    public static String pickOne(String[] options) {
        // names -> Name1, Name2, Name3
        //          0        1      2
        // 0 - 3 (names.length) 0,1,2
        // names[1]

        return options[nextNumber(options.length)];
    }
}
