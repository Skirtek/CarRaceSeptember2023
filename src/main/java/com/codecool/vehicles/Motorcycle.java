package com.codecool.vehicles;

import com.codecool.race.Race;
import com.codecool.utils.RandomEvents;

public class Motorcycle extends Vehicle {
    private static int CURRENT_NUMBER = 1;

    private static final int MIN_SLOW_DOWN_VALUE = 5;

    private static final int MAX_SLOW_DOWN_VALUE = 50;

    private static final int NORMAL_SPEED = 100;

    public Motorcycle() {
        super(NORMAL_SPEED);
    }

    @Override
    public String generateName() {
        return "Motorcycle " + CURRENT_NUMBER++;
    }

    @Override
    public void prepareForLap(Race race) {
        if (race.isRainingDuringRace()) {
            int slowDownAmount = RandomEvents.nextNumber(MIN_SLOW_DOWN_VALUE, MAX_SLOW_DOWN_VALUE);
            actualSpeed = normalSpeed - slowDownAmount;
        } else {
            actualSpeed = normalSpeed;
        }
    }
}
