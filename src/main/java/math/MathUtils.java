package math;

import docgen.Doc;

import java.awt.geom.Point2D;

@Doc(
        desc = "Utility class for commonly used math functions"
)
public class MathUtils {
    private static final Double epsilon = 0.0001;

    @Doc(
            desc = "Calculates the area of a triangle",
            params  = {"Coordinates of the first vertex", "Coords of second vertex", "Coords of third vertex"},
            returnValue = "Calculated area of the triangle"
    )
    public static Double triangleArea(Point2D.Double a, Point2D.Double b, Point2D.Double c){
        return 0.0;
    }

    @Doc(desc = "The distance between two points", params = {"Coords of one point", "Coords of second point"}, returnValue = "Double - the distance")
    public static Double distance(Point2D.Double a, Point2D.Double b){
        return 0.0;
    }

    @Doc(desc = "quadratic roots of a line with two points", params = {"Coords of point one", "Coords of point two"}, returnValue = "Double - calculated quadratic roots")
    public static Double[] quadraticRoots(int a, int b){
        return new Double[]{};
    }

    @Doc(
            desc = "Displays the value of epsilon"
    )
    public static void epsilon(){

    }

    private static boolean arePointsClose(Point2D.Double a, Point2D.Double b){
        return false;
    }
}
