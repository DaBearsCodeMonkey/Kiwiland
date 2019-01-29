package serviceimpl;

import service.DistanceService;
import service.pojos.Edge;
import utility.Utility;

import java.util.List;

public class DistanceServiceImpl implements DistanceService {
    private final List<Edge>[] graph;
    private final Utility utility;

    public DistanceServiceImpl(List<Edge>[] graph) {
        this.graph = graph;
        utility = new Utility();
    }

    /*Iterates through the trainStation to get the total distance of any given String*/
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

            for(Edge edge : graph[station1]){
                if(station2 == edge.getRoute()){
                    totalDistance += edge.getDistance();
                    destinationWasFound = true;
                    break;
                }
            }

            if(!destinationWasFound){
                return "NO SUCH ROUTE";
            }
        }

        return String.valueOf(totalDistance);
    }
}
