package com.codecool;

import com.codecool.race.Race;
import com.codecool.vehicles.Car;
import com.codecool.vehicles.Motorcycle;
import com.codecool.vehicles.Truck;

public class Main {
    private static final int NUMBER_OF_EACH_RACER_TYPE = 10;

    public static void main(String[] args) {
        Race race = new Race();

        for (int i = 0; i < NUMBER_OF_EACH_RACER_TYPE; i++) {
            race.registerRacer(new Car());
            race.registerRacer(new Truck());
            race.registerRacer(new Motorcycle());
        }

        race.simulateRace();
        // todo sort results with traveled distance
        race.printRaceResults();
    }
}