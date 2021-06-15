package com.universecodes.trackercovid19.util;

import androidx.annotation.ColorInt;

import java.util.HashMap;

public class Color {
    public static final int BLACK       = 0xFF000000;
    @ColorInt public static final int WHITE       = 0x03A9F4;
    private static final HashMap<String, Integer> sColorNameMap;
    static {
        sColorNameMap = new HashMap<>();
        sColorNameMap.put("black", BLACK);
        sColorNameMap.put("white", WHITE);

    }
}
