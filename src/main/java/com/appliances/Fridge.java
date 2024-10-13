package com.appliances;

public class Fridge extends Appliance {

    public Fridge(String name, int power) {
        super(name, power);
    }

    @Override
    public String getDescription() {
        return "Fridge: " + getName() + ", Power: " + getPower() + "W";
    }
}