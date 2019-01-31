package serviceimpl;

import service.DepthFirstSearchService;
import service.pojos.Edge;
import utility.Utility;

import java.util.List;

/*Modified depth first search algorithm without a visited variable because cycles are allowed*/
public class DepthFirstSearchServiceImpl implements DepthFirstSearchService {
    private final List<Edge>[] graph;
    private final Utility utility;
    private static int totalNumberOfRoutes;

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


    private void findAllPathsExact(Integer index, Integer destination, Integer currentStop, Integer maxStops){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && currentStop.equals(maxStops) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(Edge temp : graph[index]){
            findAllPathsExact(temp.getRoute(), destination, currentStop + 1, maxStops);
        }
    }

    private void findAllPathsMaximum(Integer index, Integer destination, Integer currentStop, Integer maxStops){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(Edge temp : graph[index]){
            findAllPathsMaximum(temp.getRoute(), destination, currentStop + 1, maxStops);
        }
    }
}
