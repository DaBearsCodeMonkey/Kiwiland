package serviceimpl;

import service.BreadthFirstSearchService;
import service.pojo.Edge;
import service.pojo.RouteAndDistanceFromSource;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchServiceImpl implements BreadthFirstSearchService {
    private final HashMap<Character, List<Edge>> GRAPH;

    public BreadthFirstSearchServiceImpl(HashMap<Character, List<Edge>> GRAPH) {
        this.GRAPH = GRAPH;
    }

    /*Does a modified Breadth First Search to find all the different routes when given a maximum distance.
    * Requirements stated it was not inclusive so I made it so it is not inclusive of the maxDistance*/
    @Override
    public String getDifferentRoutes(char startingStation, char endingStation, int maxDistance) {
        LinkedList<RouteAndDistanceFromSource> queue = new LinkedList<>();
        int currentNumberOfRoutes = 0;
        queue.add(new RouteAndDistanceFromSource(startingStation, 0));

        while(!queue.isEmpty()){
            RouteAndDistanceFromSource tempObj = queue.poll();
            char currentStop = tempObj.getRoute();
            int currentDistance = tempObj.getDistanceFromSource();

            if(currentStop == endingStation && currentDistance < maxDistance && currentDistance!= 0){
                currentNumberOfRoutes++;
            }

            if(currentDistance < maxDistance) {
                for (Edge temp : GRAPH.get(currentStop)) {
                    queue.add(new RouteAndDistanceFromSource(temp.getRoute(), currentDistance + temp.getDistance()));
                }
            }
        }

        return String.valueOf(currentNumberOfRoutes);
    }
}
