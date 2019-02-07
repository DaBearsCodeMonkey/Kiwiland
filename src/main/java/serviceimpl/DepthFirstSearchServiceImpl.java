package serviceimpl;

import service.DepthFirstSearchService;
import service.pojos.Edge;
import utility.Utility;

import java.util.List;

/*Modified depth first search algorithm without a visited variable because cycles are allowed*/
public class DepthFirstSearchServiceImpl implements DepthFirstSearchService {
    private final List<Edge>[] graph;
    private final Utility utility;
    private int totalNumberOfRoutes;

    public DepthFirstSearchServiceImpl(List<Edge>[] graph){
        this.graph = graph;
        utility = new Utility();
    }

    /*Needs a starting point, ending point, number of stops, and a string 'max' or 'exact' to choose whether or not
    * you want to do <= or == */
    @Override
    public String getNumberOfStops(char startingStation, char endingStation, Integer maxStops, String chooseYourPath) {
        Integer source = utility.getIntValueOfChar(startingStation);
        Integer destination = utility.getIntValueOfChar(endingStation);
        Integer currentStop = 0;
        totalNumberOfRoutes = 0;

        if(chooseYourPath.toLowerCase().matches("max")){
            findAllPathsMaximum(source, destination, currentStop, maxStops);
        }

        else if(chooseYourPath.toLowerCase().matches("exact")){
            findAllPathsExact(source, destination, currentStop, maxStops);
        }

        else{
            return "Please choose max or exact.";
        }

        return String.valueOf(totalNumberOfRoutes);
    }


    private void findAllPathsExact(Integer currentStop, Integer destination, Integer currentStopNumber, Integer maxStops){

        if(currentStopNumber > maxStops){
            return;
        }

        if(currentStop.equals(destination) && currentStopNumber.equals(maxStops) && !currentStopNumber.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(Edge temp : graph[currentStop]){
            findAllPathsExact(temp.getRoute(), destination, currentStopNumber + 1, maxStops);
        }
    }

    private void findAllPathsMaximum(Integer currentStop, Integer destination, Integer currentStopNumber, Integer maxStops){

        if(currentStopNumber > maxStops){
            return;
        }

        if(currentStop.equals(destination) && !currentStopNumber.equals(0)){
            totalNumberOfRoutes++;
        }

        for(Edge temp : graph[currentStop]){
            findAllPathsMaximum(temp.getRoute(), destination, currentStopNumber + 1, maxStops);
        }
    }
}
