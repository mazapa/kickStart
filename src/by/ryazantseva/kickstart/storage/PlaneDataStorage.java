package by.ryazantseva.kickstart.storage;

import by.ryazantseva.kickstart.action.ActionPlane;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.repository.realization.PlaneRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class PlaneDataStorage {
    private static Logger logger = LogManager.getLogger();
    private static PlaneDataStorage planeDataStorage;
    public Map<Long,Map<String,Double>> planeAngles = new HashMap<>();

    private PlaneDataStorage(){
    }

    public static PlaneDataStorage getInstance() {
        if (planeDataStorage == null) {
            planeDataStorage = new PlaneDataStorage();
        }
        return planeDataStorage;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException("Clone is not supported!");
    }

    public void putPlane(Plane plane) {
        ActionPlane action = new ActionPlane();
        Map<String,Double> angles = new HashMap<>();
        angles.put("angleOX", action.calcAngleOX(plane));
        angles.put("angleOY", action.calcAngleOY(plane));
        angles.put("angleOZ", action.calcAngleOZ(plane));
        planeAngles.put(plane.getId(), angles);
        logger.log(Level.INFO, "Plane: " + plane.toString());
    }


}
