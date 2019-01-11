package serviceimpl;

import service.DistanceService;
import service.pojos.RouteAndDistance;
import utility.Utility;

import java.util.List;

public class DistanceServiceImpl implements DistanceService {

    private final List<RouteAndDistance> adjListArray[];
    private Utility utility = new Utility();

    public DistanceServiceImpl(List<RouteAndDistance>[] adjListArray) {
        this.adjListArray = adjListArray;
    }

    @Override
    public String getTotalDistance(String trainStations){
        trainStations = utility.removeDashesFromString(trainStations);
        int station1;
        int station2;
        int totalDistance = 0;
        boolean destinationWasFound;

        //iterates through all the trains
        for(int counter = 0; counter < trainStations.length() - 1; counter++){
            station1 = utility.getIntValueOfChar(trainStations.charAt(counter));
            station2 = utility.getIntValueOfChar(trainStations.charAt(counter + 1));
            destinationWasFound = false;

            for(RouteAndDistance routeAndDistance: adjListArray[station1]){
                if(station2 == routeAndDistance.getRoute()){
                    totalDistance += routeAndDistance.getDistance();
                    destinationWasFound = true;
                }
            }

            if(!destinationWasFound){
                return "NO SUCH ROUTE";
            }
        }

        return String.format("%d", totalDistance);
    }
}
