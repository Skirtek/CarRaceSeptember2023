package com.codecool.conditions;

import com.codecool.utils.RandomEvents;

public class Weather {
    private static final int CHANCE_OF_RAIN_PERCENT = 30;

    private boolean isRaining;

    public Weather() {
        advance();
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void advance() {
        isRaining = RandomEvents.shouldEventHappen(CHANCE_OF_RAIN_PERCENT);
    }
}
