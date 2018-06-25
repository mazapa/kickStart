package by.ryazantseva.kickstart.repository;

import by.ryazantseva.kickstart.entity.Plane;

public interface PlaneSpecification {
    boolean specified(Plane plane);
}
