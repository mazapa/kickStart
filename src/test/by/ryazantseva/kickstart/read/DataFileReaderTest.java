package test.by.ryazantseva.kickstart.read;

import by.ryazantseva.kickstart.exception.DataFileReaderException;
import org.testng.annotations.Test;
import org.testng.Assert;
import by.ryazantseva.kickstart.read.DataFileReader;

import java.util.ArrayList;
import java.util.List;

public class DataFileReaderTest {
    private final String FIRST_STRING = "3.0 4.0 6.0 7.0 8.0 9.0 4.0 7.0 8.0";
    private final String SECOND_STRING = "1.0 1.1 0.0 5.0 2.1 2.5 3.7 2.9 3.0";
    private final String THIRD_STRING = "10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0 18.0";
    private final String FOURTH_STRING = "-1.4 3.5 5.5 1.2 5.7 -2.4 -8.8 9.9 3.5";

    @Test
    public void readDataPositiveTest() throws DataFileReaderException {

        List<String> expectedStrings = new ArrayList<>();
        expectedStrings.add(FIRST_STRING);
        expectedStrings.add(SECOND_STRING);
        expectedStrings.add(THIRD_STRING);
        expectedStrings.add(FOURTH_STRING);
        Assert.assertEquals(expectedStrings, new DataFileReader().readFromFile("files/in.txt"));

    }

    @Test
    public void readEmptyFileTest() throws DataFileReaderException {
        try {
            new DataFileReader().readFromFile("files/empty.txt");
            Assert.fail("File is empty");
        } catch (RuntimeException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void readNonexistentFileTest() throws DataFileReaderException {
        try {
            new DataFileReader().readFromFile("nonexistent.txt");
            Assert.fail("File is nonexistent");
        } catch (RuntimeException e) {
            Assert.assertTrue(true);

        }
    }


}

