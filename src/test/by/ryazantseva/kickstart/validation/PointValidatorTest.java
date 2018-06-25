package test.by.ryazantseva.kickstart.validation;

import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.entity.Point;
import by.ryazantseva.kickstart.validation.PointValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PointValidatorTest {

    @Test
    public void isPlanePositiveTest(){
        PointValidator validator = new PointValidator();
        Assert.assertTrue(validator.isPlane(new Point(1,6,7),new Point(1,1,6), new Point(9,3,5)));
    }

    @Test
    public void isPlaneNegativeTest(){
        PointValidator validator = new PointValidator();
        Assert.assertFalse(validator.isPlane(new Point(1,1,1),new Point(1,1,1), new Point(1,1,1)));
    }



}
