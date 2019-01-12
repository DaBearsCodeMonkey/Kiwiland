package serviceimpl;

import service.ShortestPathService;
import service.pojos.Edge;
import utility.Utility;

import java.util.List;

public class ShortestPathServiceImpl implements ShortestPathService {
    private final List<Edge> graph[];
    private final Utility utility;
    private final int SIZE;

    public ShortestPathServiceImpl(List<Edge>[] graph) {
        this.graph = graph;
        utility = new Utility();
        SIZE = graph.length;
    }

    @Override
    public String getShortestRoute(char startingStation, char endingStation) {
        int source = utility.getIntValueOfChar(startingStation);
        int destination = utility.getIntValueOfChar(endingStation);
        int[] distance = new int[SIZE];
        boolean spt[] = new boolean[SIZE];

        for(int counter = 0; counter < SIZE; counter++){
            distance[counter] = Integer.MAX_VALUE;
            spt[counter] = false;
        }

        distance[source] = 0;

        for(int count = 0; count < SIZE - 1; count++){
            int u = getMinDistance(distance, spt);
            spt[u] = true;

            for(Edge e : graph[u]){
                if(!spt[e.getRoute()] &&
                   distance[u] != Integer.MAX_VALUE &&
                   distance[u] + e.getDistance() < distance[e.getRoute()]){

                    distance[e.getRoute()] = distance[u] + e.getDistance();
                }
            }
        }

        return String.valueOf(distance[destination]);
    }

    private int getMinDistance(int distance[], boolean spt[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int counter = 0; counter < SIZE; counter++){
            if(!spt[counter] && distance[counter] <= min){
                min = distance[counter];
                min_index = counter;
            }
        }

        return min_index;
    }
}
