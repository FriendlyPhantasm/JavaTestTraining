package ru.manapov.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
        Point p = new Point(2,4);
        Point p2 = new Point(3,2);
        Assert.assertEquals(Math.ceil(p.distance(p2)), 3.0);
    }
    @Test
    public void testZeroDistance() {
        Point p = new Point(3,2);
        Point p2 = new Point(3,2);
        Assert.assertEquals(Math.ceil(p.distance(p2)), 0.0);
    }

    @Test
    public void testAccuracyDistance() {
        Point p = new Point(3,2);
        Point p2 = new Point(300,200);
        Assert.assertEquals(Math.ceil(p.distance(p2)), 357.0);
    }

}
