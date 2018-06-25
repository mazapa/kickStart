package by.ryazantseva.kickstart.repository.realization;
import by.ryazantseva.kickstart.action.ActionPlane;
import by.ryazantseva.kickstart.entity.Plane;
import by.ryazantseva.kickstart.repository.PlaneSpecification;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlaneRepository implements by.ryazantseva.kickstart.repository.PlaneRepository {
    private static PlaneRepository planeRepository;
    private List<Plane> planes = new ArrayList<>();

    private PlaneRepository() {
    }

    public static PlaneRepository getInstance() {
        if (planeRepository == null) {
            planeRepository = new PlaneRepository();
        }
        return planeRepository;
    }

    public List<Plane> sortPlanes(){
        List<Plane> result= new ArrayList<>(planes);
        ActionPlane actionPlane = new ActionPlane();
        result.sort(Comparator.comparingDouble(plane->actionPlane.calcAngleOX(plane)));
        return result;
    }

    @Override
    public List<Plane> query(PlaneSpecification specification) {
        List<Plane> result = new ArrayList<>();
        for(Plane plane: planes) {
            if(specification.specified(plane)){
                result.add(plane);
            }
        }
        return result;
    }

    public void addPlane(Plane plane){
        planes.add(plane);
    }

    public List<Plane> getPlanes(){
        return planes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }


}
