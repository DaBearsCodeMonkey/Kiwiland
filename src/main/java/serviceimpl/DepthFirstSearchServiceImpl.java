package serviceimpl;

import service.DepthFirstSearchService;
import service.pojo.Edge;
import utility.Utility;

import java.util.HashMap;
import java.util.List;

/*Modified depth first search algorithm without a visited variable because cycles are allowed*/
public class DepthFirstSearchServiceImpl implements DepthFirstSearchService {
    private final HashMap<Character, List<Edge>> GRAPH;
    private int totalNumberOfRoutes;

    public DepthFirstSearchServiceImpl(final HashMap<Character, List<Edge>> GRAPH){
        this.GRAPH = GRAPH;
    }

    /*Needs a starting point, ending point, number of stops, and a string 'max' or 'exact' to choose whether or not
    * you want to do <= or == */
    @Override
    public String getNumberOfStops(char startingStation, char endingStation, Integer maxStops, String chooseYourPath) {
        Integer currentStop = 0;
        totalNumberOfRoutes = 0;

        if(chooseYourPath.toLowerCase().matches("max")){
            findAllPathsMaximum(startingStation, endingStation, currentStop, maxStops);
        }

        else if(chooseYourPath.toLowerCase().matches("exact")){
            findAllPathsExact(startingStation, endingStation, currentStop, maxStops);
        }

        else{
            return "Please choose max or exact.";
        }

        return String.valueOf(totalNumberOfRoutes);
    }


    private void findAllPathsExact(Character currentStop, Character destination, Integer currentStopNumber, Integer maxStops){

        if(currentStopNumber > maxStops){
            return;
        }

        if(currentStop.equals(destination) && currentStopNumber.equals(maxStops) && !currentStopNumber.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(Edge temp : GRAPH.get(currentStop)){
            findAllPathsExact(temp.getRoute(), destination, currentStopNumber + 1, maxStops);
        }
    }

    private void findAllPathsMaximum(Character currentStop, Character destination, Integer currentStopNumber, Integer maxStops){

        if(currentStopNumber > maxStops){
            return;
        }

        if(currentStop.equals(destination) && !currentStopNumber.equals(0)){
            totalNumberOfRoutes++;
        }

        for(Edge temp : GRAPH.get(currentStop)){
            findAllPathsMaximum(temp.getRoute(), destination, currentStopNumber + 1, maxStops);
        }
    }
}
