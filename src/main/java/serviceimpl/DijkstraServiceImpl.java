package serviceimpl;

import service.DijkstraService;
import service.pojo.Edge;

import java.util.HashMap;
import java.util.List;


//TODO: change algorithm for hash-map

public class DijkstraServiceImpl implements DijkstraService {
    private final HashMap<Character, List<Edge>> GRAPH;
    private final int SIZE;

    public DijkstraServiceImpl(HashMap<Character, List<Edge>> GRAPH) {
        this.GRAPH = GRAPH;
        SIZE = GRAPH.size();
    }

    /*Does a check to see if the source is the same as the destination. If true, then it looks for the shortest path
    * from itself to it's neighbor + it's neighbor + itself. If false, it just does the normal Dijkstra shortest path
    * algorithm.*/
    @Override
    public String getShortestRoute(char startingStation, char endingStation) {
        int shortestDistance = 0;

        if(startingStation == endingStation){
            for(Edge e : GRAPH.get(startingStation)){
                int currentDistance = dijkstraShortestPath(startingStation, e.getRoute()) + dijkstraShortestPath(e.getRoute(), startingStation);

                if(shortestDistance == 0 || shortestDistance > currentDistance){
                    shortestDistance = currentDistance;
                }
            }
        }

        else{
            shortestDistance = dijkstraShortestPath(startingStation, endingStation);
        }

        if(shortestDistance == Integer.MAX_VALUE){
            return "NO SUCH ROUTE";
        }

        return String.valueOf(shortestDistance);
    }

    /*Dijkstra algorithm to find the shortest path*/
    private int dijkstraShortestPath(char source, char destination){
        int[] distance = new int[SIZE];
        boolean[] shortestPathFound = new boolean[SIZE];

        for(int counter = 0; counter < SIZE; counter++){
            distance[counter] = Integer.MAX_VALUE;
            shortestPathFound[counter] = false;
        }

        distance[source] = 0;

        for(int count = 0; count < SIZE - 1; count++){
            int index = getIndexOfMinDistance(distance, shortestPathFound);
            shortestPathFound[index] = true;

            if (shortestPathFound[destination]){
                return distance[destination];
            }

            for(Edge e : GRAPH.get(index)){
                if(!shortestPathFound[e.getRoute()] &&
                        distance[index] != Integer.MAX_VALUE &&
                        distance[index] + e.getDistance() < distance[e.getRoute()]){

                    distance[e.getRoute()] = distance[index] + e.getDistance();
                }
            }
        }

        return distance[destination];
    }

    /*Helper fucntion to find the minimum distance*/
    private int getIndexOfMinDistance(int[] distance, boolean[] shortestPathFound){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int counter = 0; counter < SIZE; counter++){
            if(!shortestPathFound[counter] && distance[counter] < min){
                min = distance[counter];
                minIndex = counter;
            }
        }

        return minIndex;
    }
}
