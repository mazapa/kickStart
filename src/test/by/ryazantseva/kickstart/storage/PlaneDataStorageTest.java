package test.by.ryazantseva.kickstart.storage;

import by.ryazantseva.kickstart.storage.PlaneDataStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaneDataStorageTest
{
    @Test
    public void getInstanceTest(){
        PlaneDataStorage firstStorage = PlaneDataStorage.getInstance();
        PlaneDataStorage secondStorage = PlaneDataStorage.getInstance();
        Assert.assertEquals(firstStorage,secondStorage);
    }

}
