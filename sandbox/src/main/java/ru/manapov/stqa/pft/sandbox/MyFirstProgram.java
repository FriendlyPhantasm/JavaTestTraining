package ru.manapov.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {

        double x = 300;
        double y = 200;

        Point p = new Point(2,4);

        System.out.println("Distance calculation between default point with coordinates:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("and received point with coordinates:");
        System.out.println("x = " + p.x);
        System.out.println("y = " + p.y);

        System.out.println("Distance between points:" + p.distance(x,y));

    }
}