package by.ryazantseva.kickstart.entity;

public class Point {
    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;

    public Point(double coordinateX, double coordinateY, double coordinateZ) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setCoordinateZ(double coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public double getCoordinateZ() {
        return coordinateZ;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Point another = (Point) obj;
        return ((coordinateX == another.getCoordinateX()) && (coordinateY == another.getCoordinateY()) && (coordinateZ == another.getCoordinateZ()));
    }

    @Override
    public int hashCode() {
        final double prime = 31;
        double result = 1;
        result = prime * result + coordinateX;
        result = prime * result + coordinateY;
        result = prime * result + coordinateZ;
        return (int) result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", coordinateZ=" + coordinateZ +
                '}';
    }
}
