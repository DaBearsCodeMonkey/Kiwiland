package serviceimpl;

import service.DijkstraService;
import service.pojos.Edge;
import utility.Utility;

import java.util.List;

public class DijkstraServiceImpl implements DijkstraService {
    private final List<Edge>[] graph;
    private final Utility utility;
    private final int SIZE;

    public DijkstraServiceImpl(List<Edge>[] graph) {
        this.graph = graph;
        utility = new Utility();
        SIZE = graph.length;
    }

    /*Does a check to see if the source is the same as the destination. If true, then it looks for the shortest path
    * from itself to it's neighbor + it's neighbor + itself. If false, it just does the normal Dijkstra shortest path
    * algorithm.*/
    @Override
    public String getShortestRoute(char startingStation, char endingStation) {
        int source = utility.getIntValueOfChar(startingStation);
        int destination = utility.getIntValueOfChar(endingStation);
        int shortestDistance = 0;

        if(source == destination){
            for(Edge e : graph[source]){
                int currentDistance = dijkstraShortestPath(source, e.getRoute()) + dijkstraShortestPath(e.getRoute(), source);

                if(shortestDistance == 0 || shortestDistance > currentDistance){
                    shortestDistance = currentDistance;
                }
            }
        }

        else{
            shortestDistance = dijkstraShortestPath(source, destination);
        }


        return String.valueOf(shortestDistance);
    }

    /*Dijkstra algorithm to find the shortest path*/
    private int dijkstraShortestPath(int source, int destination){
        int[] distance = new int[SIZE];
        boolean[] stationVisited = new boolean[SIZE];

        for(int counter = 0; counter < SIZE; counter++){
            distance[counter] = Integer.MAX_VALUE;
            stationVisited[counter] = false;
        }

        distance[source] = 0;

        for(int count = 0; count < SIZE - 1; count++){
            int index = getIndexOfMinDistance(distance, stationVisited);
            stationVisited[index] = true;

            if (stationVisited[destination]){
                return distance[destination];
            }

            for(Edge e : graph[index]){
                if(!stationVisited[e.getRoute()] &&
                        distance[index] != Integer.MAX_VALUE &&
                        distance[index] + e.getDistance() < distance[e.getRoute()]){

                    distance[e.getRoute()] = distance[index] + e.getDistance();
                }
            }
        }

        return distance[destination];
    }

    /*Helper fucntion to find the minimum distance*/
    private int getIndexOfMinDistance(int[] distance, boolean[] spt){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int counter = 0; counter < SIZE; counter++){
            if(!spt[counter] && distance[counter] <= min){
                min = distance[counter];
                minIndex = counter;
            }
        }

        return minIndex;
    }
}
