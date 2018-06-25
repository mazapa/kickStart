package by.ryazantseva.kickstart.action;

import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.entity.Point;
import java.util.ArrayList;
import java.util.List;

public class ActionPlane {
    private static final int COEFFICIENT_A = 0;
    private static final int COEFFICIENT_B = 1;
    private static final int COEFFICIENT_C = 2;
    private static final int PERPENDICULAR = 90;

    private final Point pointO = new Point(0, 0, 0);
    private final Point pointOnX = new Point(1, 0, 0);
    private final Point pointOnY = new Point(0, 1, 0);
    private final Point pointOnZ = new Point(0, 0, 1);

    private List<Double> calcPlaneEquation(Plane plane) {

        List<Double> valuesEquation = new ArrayList<>();
        Double valueAx = plane.getPointA().getCoordinateX();
        Double valueAy = plane.getPointA().getCoordinateY();
        Double valueAz = plane.getPointA().getCoordinateZ();

        Double valueBx = plane.getPointB().getCoordinateX();
        Double valueBy = plane.getPointB().getCoordinateY();
        Double valueBz = plane.getPointB().getCoordinateZ();

        Double valueCx = plane.getPointC().getCoordinateX();
        Double valueCy = plane.getPointC().getCoordinateY();
        Double valueCz = plane.getPointC().getCoordinateZ();

        Double coefficientA, coefficientB, coefficientC;

        coefficientA = (valueBy - valueAy) * (valueCz - valueAz) - (valueCy - valueAy) * (valueBz - valueAz);
        coefficientB = (valueBz - valueAz) * (valueCx - valueAx) - (valueCz - valueAz) * (valueBx - valueAx);
        coefficientC = (valueBx - valueAx) * (valueCy - valueAy) - (valueCx - valueAx) * (valueBy - valueAy);

        valuesEquation.add(coefficientA);
        valuesEquation.add(coefficientB);
        valuesEquation.add(coefficientC);
        return valuesEquation;
    }

    public double calcAngleOX(Plane plane) {
        return anglePlaneLine(pointOnX,plane);
    }

    public double calcAngleOY(Plane plane) {
        return anglePlaneLine(pointOnY,plane);
    }

    public double calcAngleOZ(Plane plane) {
        return anglePlaneLine(pointOnZ,plane);
    }

    public boolean isPerpendicularlyOX(Plane plane) {
        return anglePlaneLine(pointOnX,plane) == PERPENDICULAR;
    }

    public boolean isPerpendicularlyOY(Plane plane) {
        return anglePlaneLine(pointOnY,plane) == PERPENDICULAR;
    }

    public boolean isPerpendicularlyOZ(Plane plane) {
        return anglePlaneLine(pointOnZ,plane) == PERPENDICULAR;
    }


    private double anglePlaneLine(Point coordinateAxis, Plane plane) {
        List<Double> valuesEquation = calcPlaneEquation(plane);
        double sin;
        double numerator = (valuesEquation.get(COEFFICIENT_A) * (coordinateAxis.getCoordinateX() - pointO.getCoordinateX()) +
                valuesEquation.get(COEFFICIENT_B) * (coordinateAxis.getCoordinateY() - pointO.getCoordinateY()) +
                valuesEquation.get(COEFFICIENT_C) * (coordinateAxis.getCoordinateZ() - pointO.getCoordinateZ()));
        double denominatorPart1 = Math.sqrt(Math.pow(valuesEquation.get(COEFFICIENT_A), 2) + Math.pow(valuesEquation.get(COEFFICIENT_B), 2) + Math.pow(valuesEquation.get(COEFFICIENT_C), 2));
        double denominatorPart2 = Math.sqrt(Math.pow(coordinateAxis.getCoordinateX() - pointO.getCoordinateX(), 2) + Math.pow(coordinateAxis.getCoordinateY() - pointO.getCoordinateY(), 2) + Math.pow(coordinateAxis.getCoordinateZ() - pointO.getCoordinateZ(), 2));

        if (denominatorPart1 == 0 || denominatorPart2 == 0) {
            throw new ArithmeticException();
        }
        sin = Math.abs(numerator / denominatorPart1 * denominatorPart2);
        return Math.toDegrees(Math.asin(sin));
    }


}
