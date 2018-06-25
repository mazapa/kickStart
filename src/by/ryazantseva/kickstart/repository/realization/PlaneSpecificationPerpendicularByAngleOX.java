package by.ryazantseva.kickstart.repository.realization;

import by.ryazantseva.kickstart.action.ActionPlane;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.repository.PlaneSpecification;

public class PlaneSpecificationPerpendicularByAngleOX implements PlaneSpecification {
    @Override
    public boolean specified(Plane plane) {
        return new ActionPlane().isPerpendicularlyOX(plane);
    }

}
