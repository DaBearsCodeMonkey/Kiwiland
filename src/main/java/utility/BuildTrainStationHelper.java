package utility;

import graph.DirectedGraphForTrainRoutes;

import java.util.HashSet;
import java.util.Set;

public class BuildTrainStationHelper {
    private Utility utility = new Utility();

    public int getNumberOfUniqueTrainStations(String[] trainStations){
        Set<Character> uniqueCharacters = new HashSet<>();

        for(String trainStation : trainStations){
            uniqueCharacters.add(trainStation.charAt(0));
            uniqueCharacters.add(trainStation.charAt(1));
        }

        return uniqueCharacters.size();
    }

    public void buildGraph(DirectedGraphForTrainRoutes myGraph, String[] trainStations){
        int source;
        int destination;
        int distance;

        for(String trainStation : trainStations){
            source = utility.getIntValueOfChar(trainStation.toLowerCase().charAt(0));
            destination = utility.getIntValueOfChar(trainStation.toLowerCase().charAt(1));
            distance = Character.getNumericValue(trainStation.charAt(2));

            myGraph.addRoute(source, destination, distance);
        }
    }
}
