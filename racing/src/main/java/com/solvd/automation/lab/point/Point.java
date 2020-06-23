package com.solvd.automation.lab.point;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.solvd.lab.v2.automation.c9.exception.UnableToReadException;



public class Point extends java.awt.Point {
    private double x;
    private double y;
    private double cof;
    private List<Point> pointList;

    public Point(double x, double y, double cof) {
        this.x = x;
        this.y = y;
        this.cof = cof;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {

        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getCof() {
        return cof;
    }

    public void setCof(double cof) throws CofExeption {
        if ( cof < 0) {
                throw new CofExeption("Cof is incorrect!");
        }
        this.cof = cof;
    }

//    public static void main(String[] args) throws IOException {
//
//      //  StreamTextFileReader streamTextFileReader = new StreamTextFileReader("src/point/point.properties");
//        List<Point> points = new ArrayList<>();
//        for (int i = 0 ; i < 200; i++){
//            points.add(new Point(Math.random()*10,Math.random()*10,Math.random()));
//        String[] pointsList = new String[]{};
//        try {
//           //pointsList = streamTextFileReader.read().split("\n");
//            System.out.println(pointsList);
//        } catch (UnableToReadException e) {
//            e.printStackTrace();
//        }
//        for (Point point : points){
//            String[] xy = point.split(",");
//            System.out.println(xy);
//            points.add(new Point(Double.parseDouble(xy[0]), Double.parseDouble(xy[1]),Math.random()));
//
//        }




        }





