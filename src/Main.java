import thursday.*;
import thursday.Polygon;
import thursday.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2), p2 = new Point(3, 4);
        Square s1 = new Square(p1, 5), s2 = new Square(p2, 2);
        Circle c1 = new Circle(p1, 4);

        Square[] squares = {s1, s2};

        Rectangle r1 = new Rectangle(p1, p2);

        Rectangle[] rectangles = {s1, s2, r1};

        ArrayList<shape> shapes = new ArrayList<>();

        Triangle t1 = new Triangle();

        shapes.add(s1);
        shapes.add(s2);
        shapes.add(r1);
        shapes.add(c1);

        for (Square s : squares) {
            System.out.println(s.area());
        }

        System.out.println();

        for (Rectangle r : rectangles) {
            System.out.println(r.area());
        }

        System.out.println();

        for (shape s : shapes) {
            System.out.println(s.area());
        }

    }
}
