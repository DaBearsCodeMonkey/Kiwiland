package serviceimpl;

import service.BreadthFirstSearchService;
import service.pojos.Edge;
import service.pojos.RouteAndDistanceFromSource;
import utility.Utility;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchServiceImpl implements BreadthFirstSearchService {
    private final List<Edge> graph[];
    private final Utility utility;

    public BreadthFirstSearchServiceImpl(List<Edge>[] graph) {
        this.graph = graph;
        utility = new Utility();
    }

    /*Does a modified Breadth First Search to find all the different routes when given a maximum distance.
    * Requirements stated it was not inclusive so I made it so it is not inclusive of the maxDistance*/
    @Override
    public String getDifferentRoutes(char startingStation, char endingStation, int maxDistance) {
        LinkedList<RouteAndDistanceFromSource> queue = new LinkedList<>();
        Integer source = utility.getIntValueOfChar(startingStation);
        int destination = utility.getIntValueOfChar(endingStation);
        int currentNumberOfRoutes = 0;
        queue.add(new RouteAndDistanceFromSource(source, 0));

        while(!queue.isEmpty()){
            RouteAndDistanceFromSource tempObj = queue.poll();
            int index = tempObj.getRoute();
            int currentDistance = tempObj.getDistanceFromSource();

            if(index == destination && currentDistance < maxDistance && currentDistance!= 0){
                currentNumberOfRoutes++;
            }

            if(currentDistance < maxDistance) {
                for (Edge temp : graph[index]) {
                    queue.add(new RouteAndDistanceFromSource(temp.getRoute(), currentDistance + temp.getDistance()));
                }
            }
        }

        return String.valueOf(currentNumberOfRoutes);
    }
}
