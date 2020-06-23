package com.solvd.automation.lab.transport;

import java.awt.*;

import com.solvd.automation.lab.point.CofExeption;



public class Transport {
    private  int id;
    private int currentSpeed;
    private Point currentPosition;
    private String name;
    private Engine engine;
    private Wheels wheels;

    public Transport(String name, Engine engine, Wheels wheels, Point currentPosition){
    this.name = name;
    this.engine = engine;
    this.wheels = wheels;
    this.currentPosition = currentPosition;

}

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public Transport(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public Transport() {
    }
}
