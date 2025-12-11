package thursday;

import java.awt.*;

public abstract class Polygon implements shape {

    public void rotate(double degrees, Point axis) {
        System.out.println("rotated " + degrees + " degrees around " + axis);
    }
}
