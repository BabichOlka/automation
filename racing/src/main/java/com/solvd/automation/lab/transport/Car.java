package com.solvd.automation.lab.transport;

import java.awt.*;

public class Car extends Transport {

    public Car(String name, Engine engine, Wheels wheels, Point currentPosition){
        super(name,engine,wheels,currentPosition);
    }
}