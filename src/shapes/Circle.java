package shapes;

import java.awt.*;

public class Circle implements shape{

    private Point center;
    private double radius;

    public Circle(Point c, double r) {
        center = c;
        radius = r;
    }

    public double area() {
        return radius * radius * Math.PI;
    }
}
