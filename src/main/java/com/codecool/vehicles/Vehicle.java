package com.codecool.vehicles;

import com.codecool.race.Race;

public abstract class Vehicle {
    private final String name;

    /**
     * Normal speed (preassigned to vehicle) without any additional conditions on track
     * such as weather or broken trucks.
     */
    protected final int normalSpeed;

    /**
     * Actual speed which takes into account conditions on track
     * such as weather or broken trucks.
     */
    protected int actualSpeed;

    private int distanceTraveled;

/*     private int distanceTraveled = 0;

    private Object object;
    private Object object = null;*/

    public Vehicle(int normalSpeed) {
        this.name = generateName();
        this.normalSpeed = normalSpeed;
    }

    public abstract String generateName();

    // TODO Do it better with interface for example
    public abstract void prepareForLap();

    public void moveForAnHour() {
        //distanceTraveled = actualSpeed + distanceTraveled;
        distanceTraveled += actualSpeed;
    }

    @Override
    public String toString() {
        // You can use also string builder and append instead of +=
        String result = getClass().getSimpleName(); // Car/Truck/Motorcycle

        result += " with name ";
        result += name;
        result += " traveled distance ";
        result += distanceTraveled;
        result += "km.";

        return result;
    }
}
