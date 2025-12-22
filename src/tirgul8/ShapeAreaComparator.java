package tirgul8;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<GeoShape> {
    @Override
    public int compare(GeoShape s1, GeoShape s2) {
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return -1; // null is "smaller"
        if (s2 == null) return 1;

        double area1 = s1.area();
        double area2 = s2.area();

        return Double.compare(area1, area2);
    }
}
