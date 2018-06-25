package by.ryazantseva.kickstart.validation;
import by.ryazantseva.kickstart.entity.Point;

public class PointValidator {

    private boolean pointsIsDifferent(Point pointA, Point pointB, Point pointC) {
        return (!pointA.equals(pointB) & !pointA.equals(pointC) & !pointB.equals(pointC));
    }

    private double equationOfTheLine(double point3, double point2, double point1) {
        return (point3 - point1) / (point2 - point1);
    }

    private boolean isPointsOnLine(Point pointA, Point pointB, Point pointC) {
       return  (equationOfTheLine(pointC.getCoordinateX(), pointB.getCoordinateX(), pointA.getCoordinateX()) == equationOfTheLine(pointC.getCoordinateY(), pointB.getCoordinateY(), pointA.getCoordinateY())
                && equationOfTheLine(pointC.getCoordinateY(), pointB.getCoordinateY(), pointA.getCoordinateY()) == equationOfTheLine(pointC.getCoordinateZ(), pointB.getCoordinateZ(), pointA.getCoordinateZ()));
    }

    public boolean isPlane(Point pointA, Point pointB, Point pointC) {
        return  (!isPointsOnLine(pointA, pointB, pointC) && pointsIsDifferent(pointA, pointB, pointC));
    }
}
