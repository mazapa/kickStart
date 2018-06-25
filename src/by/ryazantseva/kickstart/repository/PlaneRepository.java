package by.ryazantseva.kickstart.repository;

import by.ryazantseva.kickstart.entity.Plane;
import java.util.List;

public interface PlaneRepository {
    List<Plane> query(PlaneSpecification specification);
}
