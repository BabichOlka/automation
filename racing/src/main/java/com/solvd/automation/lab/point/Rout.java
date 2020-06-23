package com.solvd.automation.lab.point;

import java.util.List;

public class Rout {

    private List<Point> pointList;

    public Rout(List<Point> pointList) {
        this.pointList = pointList;


    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

}

