package serviceimpl;

import service.DistanceService;
import service.pojo.Edge;
import utility.Utility;

import java.util.HashMap;
import java.util.List;

public class DistanceServiceImpl implements DistanceService {
    private final HashMap<Character, List<Edge>> GRAPH;
    private final Utility UTILITY;

    public DistanceServiceImpl(HashMap<Character, List<Edge>> GRAPH) {
        this.GRAPH = GRAPH;
        UTILITY = new Utility();
    }

    /*Iterates through the trainStation to get the total distance of any given String*/
    @Override
    public String getTotalDistance(String trainStations){
        trainStations = UTILITY.removeDashesFromString(trainStations);
        char station1;
        char station2;
        int totalDistance = 0;
        boolean destinationWasFound;

        //iterates through all the trains
        for(int counter = 0; counter < trainStations.length() - 1; counter++){
            station1 = trainStations.charAt(counter);
            station2 = trainStations.charAt(counter + 1);
            destinationWasFound = false;

            for(Edge edge : GRAPH.get(station1)){
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
