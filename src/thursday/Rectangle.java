package thursday;

import java.awt.*;

public class Rectangle extends Polygon{

    protected Point min, max;

    public Rectangle(Point min, Point max) {
        this.max = max;
        this.min = min;
    }

    public double area() {
        double minX = min.x, minY = min.y, maxX = max.x, maxY = max.y;
        double width = maxX - minX, height = maxY - minY;
        return width * height;
    }

}
