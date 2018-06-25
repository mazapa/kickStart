package by.ryazantseva.kickstart.entity;
import by.ryazantseva.kickstart.validation.PointValidator;
import by.ryazantseva.kickstart.observer.realization.PlaneObserver;

public class Plane {
    private long id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private PlaneObserver observer = new PlaneObserver();

    public Plane(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    private boolean isPlane()  {
       return new PointValidator().isPlane(pointA, pointB, pointC);
    }

    public void setPointA(Point pointA) {
        if(isPlane()){
            this.pointA = pointA;
            observer.update(this);
        }
    }

    public void setPointB(Point pointB){
        if(isPlane()){
            this.pointB = pointB;
            observer.update(this);
        }
    }

    public void setPointC(Point pointC) {
        if(isPlane()){
            this.pointC = pointC;
            observer.update(this);
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Plane another = (Plane) obj;
        return ((pointA != null && pointA.equals(another.getPointA()))
                && (pointB != null && pointB.equals(another.getPointB())) && (pointC != null && pointC.equals(another.getPointC())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pointA.hashCode();
        result = prime * result + pointB.hashCode();
        result = prime * result + pointC.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", id=" + id +
                '}';
    }
}
