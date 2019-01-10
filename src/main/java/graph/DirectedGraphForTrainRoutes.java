package graph;

import utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphForTrainRoutes {
    private static int outputNumber = 0;
    private List<RouteAndDistance> adjListArray[];
    private Utility utility = new Utility();

    @SuppressWarnings("unchecked")
    public DirectedGraphForTrainRoutes(int numberOfTrainStations) {
        adjListArray = new ArrayList[numberOfTrainStations];

        for(int counter = 0; counter < numberOfTrainStations; counter++){
            adjListArray[counter] = new ArrayList<>();
        }
    }

    public void addRoute(int sourceStation, int destinationStation, int distance){
        RouteAndDistance tempObj = new RouteAndDistance(destinationStation, distance);
        adjListArray[sourceStation].add(tempObj);
    }

    public String getTotalDistance(String trainStations){
        outputNumber++;
        trainStations = utility.removeDashesFromString(trainStations).toLowerCase();
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

        return String.format("Output #%d: %d",outputNumber, totalDistance);
    }

    public String maximumNumberOfStops(int startingStation, int endingStation, int numberOfStops){
        return "";
    }

    public String exactlyNumberOfStops(int startingStation, int endingStation, int numberOfStops){
        return "";
    }

    private String shortestRoute(){
        return "";
    }

    private String shortestRouteHelper(){
        return "";
    }

    private String numberOfDifferentRoutes(int startingStation, int endingStation, int maxDistance){
        return "";
    }
}
