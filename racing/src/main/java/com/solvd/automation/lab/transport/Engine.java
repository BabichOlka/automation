package com.solvd.automation.lab.transport;

public class Engine  {


    private int maxSpeed;

    public Engine(String name, int maxSpeed) {

        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) throws SpeedExeption {
        if (maxSpeed < 0){
            throw new SpeedExeption("Speed is incorrect!");
        }
        this.maxSpeed = maxSpeed;
    }
}
