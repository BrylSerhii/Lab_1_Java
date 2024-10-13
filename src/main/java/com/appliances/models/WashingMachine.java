package com.appliances.models;

public class WashingMachine extends Appliance {

    public WashingMachine(String name, int power) {
        super(name, power);
    }

    @Override
    public String getDescription() {
        return "Washing Machine: " + getName() + ", Power: " + getPower() + "W";
    }
}

