package serviceimpl;

import service.DifferentRoutesService;
import service.pojos.Edge;
import service.pojos.RouteAndDistanceFromSource;
import utility.Utility;

import java.util.LinkedList;
import java.util.List;

public class DifferentRoutesServiceImpl implements DifferentRoutesService {
    private final List<Edge> graph[];
    private final Utility utility;

    public DifferentRoutesServiceImpl(List<Edge>[] graph) {
        this.graph = graph;
        utility = new Utility();
    }

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
