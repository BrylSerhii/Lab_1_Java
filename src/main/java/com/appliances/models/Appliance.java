package com.appliances.models;

public abstract class Appliance {
    private String name;
    private int power;
    private boolean isPluggedIn;

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isPluggedIn = false;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public boolean isPluggedIn() {
        return isPluggedIn;
    }

    public void plugIn() {
        this.isPluggedIn = true;
    }

    public void unplug() {
        this.isPluggedIn = false;
    }

    // Метод для отримання інформації про прилад
    public abstract String getDescription();
}
