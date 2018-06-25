package by.ryazantseva.kickstart.repository.realization;

import by.ryazantseva.kickstart.action.ActionPlane;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.repository.PlaneSpecification;

public class PlaneSpecificationFindByAngleOx implements PlaneSpecification {
    private double minAngle;
    private double maxAngle;

    public PlaneSpecificationFindByAngleOx(double minAngle, double maxAngle) {
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
    }

    @Override
    public boolean specified(Plane plane) {
        ActionPlane actionPlane = new ActionPlane();
        double planeAngle = actionPlane.calcAngleOX(plane);
        return planeAngle>minAngle && planeAngle < maxAngle;
    }
}
