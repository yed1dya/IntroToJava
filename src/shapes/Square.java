package shapes;

import java.awt.*;

public class Square extends Rectangle{

    private double width;

    public Square(Point point, double width) {
        super(point, null);
        this.width = width;
    }

    @Override
    public double area() {
        return width * width;
    }

}
