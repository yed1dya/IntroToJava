package practice_exams.exam2024AB;

import java.awt.*;
import java.awt.geom.Point2D;

public class LinearFunction {

    private static double EPS = 0.001;
    private double a, b;

    public LinearFunction(Point2D p1, Point2D p2) {
        if (p1 == null || p2 == null) throw new RuntimeException("points cannot be null");
        double x1 = p1.getX(), x2 = p2.getX();
        if (x1 == x2) throw new RuntimeException("points cannot have the same x value");
        double y1 = p1.getY(), y2 = p2.getY();
        a = (y2 - y1) / (x2 - x1);
        // f(x) = a * x + b -> b = f(x) - a * x = y1 - a * x1
        b = y1 - a * x1;
    }

    public double f(double x) {
        return a * x + b;
    }

    public boolean equal(Object t) {
        if (!(t instanceof LinearFunction)) return false;
        LinearFunction other = (LinearFunction) t;
        double x1 = 0, x2 = 2;
        double d1 = Math.abs(this.f(x1) - other.f(x1)), d2 = Math.abs(this.f(x2) - other.f(x2));
        return (d1 < EPS && d2 < EPS);
    }
}
