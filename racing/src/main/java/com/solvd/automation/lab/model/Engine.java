package com.solvd.automation.lab.model;

public class Engine extends AbstractEntity{
    private int maxSpeed;

    public Engine(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Engine() {
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}