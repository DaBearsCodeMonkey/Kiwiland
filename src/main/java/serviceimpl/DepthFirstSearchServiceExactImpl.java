package serviceimpl;

import service.DepthFirstSearchService;
import service.pojo.DepthFirstSearch;
import service.pojo.Edge;

import java.util.HashMap;
import java.util.List;

/*Modified depth first search algorithm without a visited variable because cycles are allowed*/
public class DepthFirstSearchServiceExactImpl implements DepthFirstSearchService {
    private final HashMap<Character, List<Edge>> GRAPH;
    private int totalNumberOfRoutes;

    public DepthFirstSearchServiceExactImpl(final HashMap<Character, List<Edge>> GRAPH){
        this.GRAPH = GRAPH;
    }

    /*Needs a starting point, ending point, number of stops, and a string 'max' or 'exact' to choose whether or not
    * you want to do <= or == */
    @Override
    public String getNumberOfStops(char startingStation, char endingStation, Integer maxStops) {
        Integer currentStop = 0;
        totalNumberOfRoutes = 0;

        findAllPaths(new DepthFirstSearch(startingStation, endingStation, currentStop, maxStops));

        return String.valueOf(totalNumberOfRoutes);
    }

    private void findAllPaths(DepthFirstSearch depthFirstSearch){

        if(depthFirstSearch.getCurrentDepth() > depthFirstSearch.getMaxDepth()){
            return;
        }

        if(depthFirstSearch.getCurrentStation().equals(depthFirstSearch.getDestination()) &&
           depthFirstSearch.getCurrentDepth().equals(depthFirstSearch.getMaxDepth()) &&
           !depthFirstSearch.getCurrentDepth().equals(0)){

            totalNumberOfRoutes++;
            return;
        }

        for(Edge temp : GRAPH.get(depthFirstSearch.getCurrentStation())){
            findAllPaths(new DepthFirstSearch(temp.getRoute(),
                                              depthFirstSearch.getDestination(),
                                              depthFirstSearch.getCurrentDepth() + 1,
                                              depthFirstSearch.getMaxDepth()));
        }
    }
}
