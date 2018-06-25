package test.by.ryazantseva.kickstart.create;

import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.entity.Point;
import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import org.testng.annotations.Test;
import org.testng.Assert;
import by.ryazantseva.kickstart.create.PlaneCreator;
import java.util.ArrayList;
import java.util.List;

public class PlaneCreatorTest {

    @Test
    public void buildPlanePositiveTest() throws InvalidInputDataException {
        Point A = new Point(1.0,3.3,4.4);
        Point B = new Point(2.0,1.3,9.4);
        Point C = new Point(6.0,3.1,4.0);
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
        PlaneCreator planeCreator = new PlaneCreator();
        Assert.assertEquals( planeCreator.buildPlane(pointsForPlane),new Plane(A,B,C));
    }

    @Test
    public void buildPlaneEmptyListTest(){
        try{
           List<Double> emptyList = new ArrayList<>();
            PlaneCreator creator = new PlaneCreator();
            creator.buildPlane(emptyList);
            Assert.fail("Input list is empty");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void buildPlaneIncorrectNumberOfPointsTest(){
        try{
           List<Double> emptyList = new ArrayList<>();
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
           emptyList.add(1.6);
            PlaneCreator creator = new PlaneCreator();
            creator.buildPlane(emptyList);
            Assert.fail("Input list has incorrect numbers of points");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }
    @Test
    public void buildPlaneInvalidPlaneTest(){
        try{
           List<Double> emptyList = new ArrayList<>();
           emptyList.add(1.0);
           emptyList.add(2.0);
           emptyList.add(3.0);
           emptyList.add(4.0);
           emptyList.add(5.0);
           emptyList.add(6.0);
           emptyList.add(7.0);
           emptyList.add(8.0);
           emptyList.add(9.0);
            PlaneCreator creator = new PlaneCreator();
            creator.buildPlane(emptyList);
            Assert.fail("Input list has invalid points");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);

        }
    }

}
