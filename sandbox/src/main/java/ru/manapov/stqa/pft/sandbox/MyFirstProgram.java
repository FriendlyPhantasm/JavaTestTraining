package ru.manapov.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {

        Point p1 = new Point(2,4);
        Point p2 = new Point(3,2);

        System.out.println("Coordinates of the first point:");
        System.out.println("x = " + p1.x);
        System.out.println("y = " + p1.y);
        System.out.println("Coordinates of the second point:");
        System.out.println("x = " + p2.x);
        System.out.println("y = " + p2.y);

        System.out.println("Distance between points:" + p2.distance(p1,p2));
    }
}