package by.ryazantseva.kickstart.create;

import by.ryazantseva.kickstart.util.IdGenerator;
import by.ryazantseva.kickstart.observer.realization.PlaneObserver;
import by.ryazantseva.kickstart.repository.realization.PlaneRepository;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.entity.Point;
import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import by.ryazantseva.kickstart.validation.PointValidator;
import java.util.List;

public class PlaneCreator {
    private static final int NUMBER_OF_POINTS = 9;

    public Plane buildPlane(List<Double> points) throws InvalidInputDataException {
        PlaneObserver observer = new PlaneObserver();
        Plane plane;
        if (points.size() != NUMBER_OF_POINTS) {
            throw new InvalidInputDataException("Incorrect number of points");
        }
        Point A = new Point(points.get(PointType.FIRST_POINT_X.ordinal()), points.get(PointType.FIRST_POINT_Y.ordinal()), points.get(PointType.FIRST_POINT_Z.ordinal()));
        Point B = new Point(points.get(PointType.SECOND_POINT_X.ordinal()), points.get(PointType.SECOND_POINT_Y.ordinal()), points.get(PointType.SECOND_POINT_Z.ordinal()));
        Point C = new Point(points.get(PointType.THIRD_POINT_X.ordinal()), points.get(PointType.THIRD_POINT_Y.ordinal()), points.get(PointType.THIRD_POINT_Z.ordinal()));

        if (new PointValidator().isPlane(A, B, C)) {
            plane = new Plane(A, B, C);
        } else {
            throw new InvalidInputDataException("Incorrect input points! It is not a plane!");
        }
        plane.setId(IdGenerator.generateId());
        observer.update(plane);
        PlaneRepository.getInstance().addPlane(plane);
        return plane;
    }
}

