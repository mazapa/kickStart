package test.by.ryazantseva.kickstart.repository;

import by.ryazantseva.kickstart.create.PlaneCreator;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import by.ryazantseva.kickstart.repository.realization.PlaneRepository;
import by.ryazantseva.kickstart.repository.realization.PlaneSpecificationFindByAngleOx;
import by.ryazantseva.kickstart.repository.realization.PlaneSpecificationPerpendicularByAngleOX;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneRepositoryTest {
    private Plane firstPlane;
    private Plane secondPlane;
    private Plane thirdPlane;
    private PlaneRepository repository = PlaneRepository.getInstance();


    private void createPlanes() throws InvalidInputDataException {
        PlaneCreator creator = new PlaneCreator();

        List<Double> pointsForFirstPlane = Arrays.asList(1.0, 2.0, 1.1, 5.5, 6.7, 7.8, 4.7, 2.4, 5.7);
        List<Double> pointsForSecPlane = Arrays.asList(1.0, 2.7, 6.7, 5.5, 3.5, 7.8, 4.7, 2.8, 5.7);
        List<Double> pointsForThirdPlane = Arrays.asList(1.1, 2.9, 1.1, 5.1, 5.7, 7.8, 4.2, 9.4, 6.7);

        firstPlane = creator.buildPlane(pointsForFirstPlane);
        secondPlane = creator.buildPlane(pointsForSecPlane);
        thirdPlane = creator.buildPlane(pointsForThirdPlane);
    }

    @Test
    public void getInstanceTest() {
        PlaneRepository firstRepository = PlaneRepository.getInstance();
        PlaneRepository secondRepository = PlaneRepository.getInstance();
        Assert.assertEquals(firstRepository, secondRepository);
    }

    @Test
    public void sortPlanesPositiveTest() throws InvalidInputDataException {

        createPlanes();
        List<Plane> expected = Arrays.asList(secondPlane, firstPlane, thirdPlane);
        List<Plane> actual = repository.sortPlanes();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortPlanesNegativeTest() throws InvalidInputDataException {

        createPlanes();
        List<Plane> expected = Arrays.asList(firstPlane, secondPlane, thirdPlane);
        List<Plane> actual = repository.sortPlanes();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void planeSpecificationFindByAngleOxPositiveTest() throws InvalidInputDataException {
        createPlanes();
        PlaneSpecificationFindByAngleOx findByAngleOx = new PlaneSpecificationFindByAngleOx(0, 50);
        List<Plane> expected = Arrays.asList(firstPlane, secondPlane);
        List<Plane> actual = repository.query(findByAngleOx);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void planeSpecificationFindByAngleOxNegativeTest() throws InvalidInputDataException {

        PlaneSpecificationFindByAngleOx findByAngleOx = new PlaneSpecificationFindByAngleOx(0, 50);
        createPlanes();
        List<Plane> expected = Arrays.asList(firstPlane);
        List<Plane> actual = repository.query(findByAngleOx);

        Assert.assertNotEquals(expected, actual);

    }
    @Test
    public void planeSpecificationPerpendicularByAngleOXNegativeTest() throws InvalidInputDataException {

        PlaneSpecificationPerpendicularByAngleOX specification = new PlaneSpecificationPerpendicularByAngleOX();
        createPlanes();
        List<Plane> expected = Arrays.asList(firstPlane);
        List<Plane> actual = repository.query(specification);

        Assert.assertNotEquals(expected, actual);

    }
    @Test
    public void planeSpecificationPerpendicularByAngleOXPositiveTest() throws InvalidInputDataException {

        PlaneSpecificationPerpendicularByAngleOX specification = new PlaneSpecificationPerpendicularByAngleOX();
        createPlanes();
        List<Plane> expected = new ArrayList<>();
        List<Plane> actual = repository.query(specification);

        Assert.assertEquals(expected, actual);

    }


}
