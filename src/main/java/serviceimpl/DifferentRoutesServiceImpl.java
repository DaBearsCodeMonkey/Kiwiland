package serviceimpl;

import service.DifferentRoutesService;
import service.DistanceService;
import service.pojos.RouteAndDistance;

import java.util.List;

public class DifferentRoutesServiceImpl implements DifferentRoutesService {

    private final List<RouteAndDistance> adjListArr[];

    public DifferentRoutesServiceImpl(List<RouteAndDistance>[] adjListArr) {
        this.adjListArr = adjListArr;
    }

    @Override
    public String differentRoutes(char startingStation, char endingStation) {
        final DistanceService distanceService = new DistanceServiceImpl(adjListArr);
        int numberOfRoutes = 0;
        int totalDistance = 0;



        return "";
    }
}
