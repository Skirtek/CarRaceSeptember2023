package com.codecool.vehicles;

import com.codecool.race.Race;
import com.codecool.utils.RandomEvents;

public class Car extends Vehicle {
    private static final int MIN_SPEED = 80;

    private static final int MAX_SPEED = 110;

    private static final int YELLOW_FLAG_SPEED = 75;

    private static final String[] POSSIBLE_NAMES = {
            "Vertu",
            "Envie",
            "Aeon",
            "Cosmos",
            "Lune",
            "Quête",
            "Obsidienne",
            "Pionnier",
            "Résolution",
            "Prestige"
    };

    public Car() {
        super(RandomEvents.nextNumber(MIN_SPEED, MAX_SPEED));
    }

    @Override
    public String generateName() {
        // TODO Try to do it in one method
        // TODO Do not duplicate elements
        String firstPart = RandomEvents.pickOne(POSSIBLE_NAMES);
        String secondPart = RandomEvents.pickOne(POSSIBLE_NAMES);

        return firstPart + " " + secondPart;
    }

    /** If yellow flag is up, car should go with YELLOW_FLAG_SPEED, otherwise with normal speed */
    @Override
    public void prepareForLap(Race race) {
        actualSpeed = race.isYellowFlagActive() ? YELLOW_FLAG_SPEED : normalSpeed;
    }
}
