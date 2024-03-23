package com.codecool.race;

import com.codecool.conditions.Weather;
import com.codecool.vehicles.Truck;
import com.codecool.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int NUMBER_OF_LAPS = 50;

    private static final Weather WEATHER = new Weather();

    private final List<Vehicle> racers = new ArrayList<>();

    public void registerRacer(Vehicle vehicle) {
        racers.add(vehicle);
    }

    public boolean isRainingDuringRace() {
        return WEATHER.isRaining();
    }

    public void simulateRace() {
        for (int i = 0; i < NUMBER_OF_LAPS; i++) {
            for (Vehicle racer : racers) {
                racer.prepareForLap(this);
                racer.moveForAnHour();
            }

            WEATHER.advance();
        }
    }

    public void printRaceResults() {
        System.out.println("Race results: ");

        for (Vehicle racer : racers) {
            System.out.println(racer);
        }
    }

    public boolean isYellowFlagActive() {
        for (Vehicle racer : racers) {
            if (racer instanceof Truck truck && truck.isTruckBroken()) {
                return true;
            }
        }

        return false;
    }
}
