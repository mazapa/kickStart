package test.by.ryazantseva.kickstart.action;

import by.ryazantseva.kickstart.action.ActionPlane;
import org.testng.annotations.Test;
import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import org.testng.Assert;
import by.ryazantseva.kickstart.create.PlaneCreator;
import java.util.ArrayList;
import java.util.List;

public class ActionPlaneTest {

    private List<Double> createListWithPoints(){
        List<Double> pointsForPlane = new ArrayList<>();
        pointsForPlane.add(1.0);
        pointsForPlane.add(3.3);
        pointsForPlane.add(4.4);
        pointsForPlane.add(2.0);
        pointsForPlane.add(1.3);
        pointsForPlane.add(9.4);
        pointsForPlane.add(6.0);
        pointsForPlane.add(3.1);
        pointsForPlane.add(4.0);
        return pointsForPlane;
    }

    @Test
    public void getAngleOXNegativeTest() throws InvalidInputDataException {

        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 1;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertNotEquals(expectedAngle,actionPlane.calcAngleOX(creator.buildPlane(pointsForPlane)));
    }

    @Test
    public void getAngleOXPositiveTest() throws InvalidInputDataException {
        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 3.7826470367806673;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertEquals(expectedAngle,actionPlane.calcAngleOX(creator.buildPlane(pointsForPlane)));
    }

    @Test
    public void getAngleOYNegativeTest() throws InvalidInputDataException {
        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 1;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertNotEquals(expectedAngle,actionPlane.calcAngleOY(creator.buildPlane(pointsForPlane)));
    }

    @Test
    public void getAngleOYPositiveTest() throws InvalidInputDataException {
        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 68.5808710261203;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertEquals(expectedAngle,actionPlane.calcAngleOY(creator.buildPlane(pointsForPlane)));
    }

    @Test
    public void getAngleOZNegativeTest() throws InvalidInputDataException {
        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 1;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertNotEquals(expectedAngle,actionPlane.calcAngleOZ(creator.buildPlane(pointsForPlane)));
    }

    @Test
    public void getAngleOZPositiveTest() throws InvalidInputDataException {
        List<Double> pointsForPlane = createListWithPoints();
        double expectedAngle = 21.04979881552135;
        PlaneCreator creator = new PlaneCreator();
        ActionPlane actionPlane = new ActionPlane();
        Assert.assertEquals(expectedAngle,actionPlane.calcAngleOZ(creator.buildPlane(pointsForPlane)));
    }

}

