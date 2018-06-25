package by.ryazantseva.kickstart.observer.realization;

import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.repository.realization.PlaneRepository;
import by.ryazantseva.kickstart.storage.PlaneDataStorage;

public class PlaneObserver implements by.ryazantseva.kickstart.observer.PlaneObserver {
    @Override
    public void update(Plane plane) {
        PlaneDataStorage.getInstance().putPlane(plane);
    }
}
