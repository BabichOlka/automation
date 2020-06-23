package com.solvd.automation.lab.model;

public class Wheels extends AbstractEntity{
    private double cof;

    public Wheels(double cof) {
        this.cof = cof;
    }

    public Wheels() {
    }

    public double getCof() {
        return cof;
    }

    public void setCof(double cof) {
        this.cof = cof;
    }
}
