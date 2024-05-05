package com.codecool.vehicles;

import com.codecool.race.Race;
import com.codecool.utils.RandomEvents;

public class Truck extends Vehicle {
    private static final int NORMAL_SPEED = 100;

    private static final int BROKEN_TRUCK_SPEED = 0;

    private static final int MIN_TRUCK_NUMBER = 0;

    private static final int MAX_TRUCK_NUMBER = 1000;

    private static final int BREAKDOWN_CHANCE_PERCENT = 5;

    private static final int LAPS_TO_FIX = 2;

    private int breakdownLapsLeft = 0;

    private TruckState state = TruckState.RUNNING;

    public boolean isTruckBroken() {
        return state != TruckState.RUNNING;
    }

    public Truck() {
        super(NORMAL_SPEED);
    }

    @Override
    public String generateName() {
        int truckNumber = RandomEvents.nextNumber(MIN_TRUCK_NUMBER, MAX_TRUCK_NUMBER);
        return Integer.toString(truckNumber);
    }

    /***/
    @Override
    public void prepareForLap() {
        state = getNextState();
        actualSpeed = isTruckBroken() ? BROKEN_TRUCK_SPEED : NORMAL_SPEED;
    }

    private TruckState getNextState() {
        switch (state) {
            case RUNNING -> {
                boolean willTruckBeBroke = RandomEvents.shouldEventHappen(BREAKDOWN_CHANCE_PERCENT);

                if (willTruckBeBroke) {
                    breakdownLapsLeft = LAPS_TO_FIX;
                    return TruckState.BROKEN;
                }
            }
            case BROKEN -> {
                breakdownLapsLeft--;

                if (breakdownLapsLeft > 0) {
                    return TruckState.BROKEN;
                }
            }
        }

        return TruckState.RUNNING;
    }
}
