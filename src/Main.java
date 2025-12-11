import thursday.*;
import thursday.Polygon;
import thursday.Rectangle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2), p2 = new Point(3, 4);
        Square s1 = new Square(p1, 5), s2 = new Square(p2, 2);
        System.out.println(s1.area());
        Square[] squares = {s1, s2};
        Rectangle r1 = new Rectangle(p1, p2);

        Rectangle[] rectangles = {s1, s2, r1};

        Triangle t1 = new Triangle();

        Polygon[] polygons = {t1, r1, s1, s2};

        Circle c1 = new Circle(p1, 4.5);

        shape[] shapes = {s1, s2, r1, c1};

        for (shape shape : shapes) {
            System.out.println(shape.area());
        }

        for (Polygon polygon : polygons) {
            polygon.rotate(34, new Point());
        }

    }
}
