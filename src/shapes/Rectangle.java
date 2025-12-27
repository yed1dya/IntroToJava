package shapes;

import java.awt.*;

public class Rectangle extends Polygon {

    private Point min, max;
    private int ID;

    private static int counter = 0;

    public Rectangle(Point min, Point max) {
        this.max = max;
        this.min = min;
        ID = counter++;
    }

    public double area() {
        double minX = this.min.x, minY = this.min.y, maxX = max.x, maxY = max.y;
        double width = maxX - minX, height = maxY - minY;
        return width * height;
    }

    public static int getCounter() {
        return counter;
    }

}
