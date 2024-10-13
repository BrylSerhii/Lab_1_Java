package com.appliances;

public class TV extends Appliance {

    public TV(String name, int power) {
        super(name, power);
    }

    @Override
    public String getDescription() {
        return "TV: " + getName() + ", Power: " + getPower() + "W";
    }
}
