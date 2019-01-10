package utility;

import graph.DirectedGraphForTrainRoutes;

import java.util.HashSet;
import java.util.Set;

public class BuildTrainStationHelper {
    private Utility utility = new Utility();

    public int getNumberOfUniqueTrainStations(String[] args){
        Set<Character> uniqueCharacters = new HashSet<>();

        for(int counter = 0; counter < args.length; counter++){
            uniqueCharacters.add(args[counter].toLowerCase().charAt(0));
            uniqueCharacters.add(args[counter].toLowerCase().charAt(1));
        }

        return uniqueCharacters.size();
    }

    public void buildGraphFromCommandLineArguments(DirectedGraphForTrainRoutes myGraph, String[] args){
        int source;
        int destination;
        int distance;

        for(int counter = 0; counter < args.length; counter++){
            source = utility.getIntValueOfChar(args[counter].toLowerCase().charAt(0));
            destination = utility.getIntValueOfChar(args[counter].toLowerCase().charAt(1));
            distance = Character.getNumericValue(args[counter].charAt(2));

            myGraph.addRoute(source,destination,distance);
        }
    }
}
