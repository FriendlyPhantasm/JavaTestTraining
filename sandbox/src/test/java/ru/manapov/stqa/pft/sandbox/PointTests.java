package ru.manapov.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testDistance() {
        Point p = new Point(2,4);
        Assert.assertEquals(Math.ceil(p.distance(3,2)), 3.0);
    }
    @Test
    public void testZeroDistance() {
        Point p = new Point(3,2);
        Assert.assertEquals(Math.ceil(p.distance(3,2)), 0.0);
    }

    @Test
    public void testAccuracyDistance() {
        Point p = new Point(3,2);
        Assert.assertEquals(Math.ceil(p.distance(300,200)), 357.0);
    }

}
