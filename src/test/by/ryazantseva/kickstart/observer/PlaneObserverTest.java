package test.by.ryazantseva.kickstart.observer;

import by.ryazantseva.kickstart.create.PlaneCreator;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.entity.Point;
import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import by.ryazantseva.kickstart.storage.PlaneDataStorage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;


public class PlaneObserverTest {

    @Test
    public void PlaneObserverPositiveTest() throws InvalidInputDataException {
        PlaneCreator creator = new PlaneCreator();
        List<Double> numbersForPlane = Arrays.asList(1.0,1.4,1.2,2.4,1.3,5.7,7.6,7.0,9.0);
        Plane plane = creator.buildPlane(numbersForPlane);
        Double startAngle = PlaneDataStorage.getInstance().planeAngles.get(plane.getId()).get("angleOX");
        plane.setPointA(new Point(3, 5, 1));
        Double changedAngle = PlaneDataStorage.getInstance().planeAngles.get(plane.getId()).get("angleOX");
        Assert.assertNotEquals(startAngle, changedAngle);
    }
}
