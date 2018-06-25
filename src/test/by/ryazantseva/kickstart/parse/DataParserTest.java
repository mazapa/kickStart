package test.by.ryazantseva.kickstart.parse;

import by.ryazantseva.kickstart.exception.InvalidInputDataException;
import org.testng.annotations.Test;
import org.testng.Assert;
import by.ryazantseva.kickstart.parse.DataParser;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {

    @Test
    public void parsePositiveTest() throws  InvalidInputDataException {
        List<Double> expected = new ArrayList<>();
        expected.add(3.0);
        expected.add(5.0);
        expected.add(6.0);
        DataParser parser = new DataParser();
        List<Double> actual = parser.parseString("3.0 5.0 6.0");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseEmptyStringTest() {
        try {
            DataParser parser = new DataParser();
            parser.parseString("");
            Assert.fail("String is empty");
        } catch (InvalidInputDataException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void parseIncorrectStringTest() throws  InvalidInputDataException {
        List<Double> expected = new ArrayList<>();
        expected.add(3.0);
        expected.add(6.0);
        DataParser parser = new DataParser();
        List<Double> actual = parser.parseString("3.0 4a.0 fd 6.0");
        Assert.assertEquals(actual, expected);
    }

}
