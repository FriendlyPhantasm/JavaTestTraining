package ru.manapov.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
        Point p1 = new Point(2,4);
        Point p2 = new Point(3,2);
        Point p3 = new Point(3,2);

        Assert.assertEquals(Math.ceil(p1.distance(p1,p2)), 3.0);
    }
    @Test
    public void testZeroDistance() {
        Point p1 = new Point(3,2);
        Point p2 = new Point(3,2);

        Assert.assertEquals(Math.ceil(p1.distance(p1,p2)), 0.0);
    }

    @Test
    public void testAccuracyDistance() {
        Point p1 = new Point(3,2);
        Point p2 = new Point(3,2);

        Assert.assertNotSame(p1.distance(p1,p2), 3.0);
    }

}
