package serviceimpl;

import service.DijkstraService;
import service.pojo.Edge;
import service.pojo.ShortestDistanceDAO;

import java.util.HashMap;
import java.util.List;


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
        HashMap<Character, ShortestDistanceDAO> shortestDistance = createDistanceAndVisitedMap();
        shortestDistance.get(source).setDistance(0);

        for(int count = 0; count < SIZE - 1; count++){
            char key = getKeyOfMinDistance(shortestDistance);
            shortestDistance.get(key).shortestDistanceFound();

            if (shortestDistance.get(destination).isShortestDistanceFound()){
                return shortestDistance.get(destination).getDistance();
            }

            for(Edge e : GRAPH.get(key)){
                if(!shortestDistance.get(e.getRoute()).isShortestDistanceFound() &&
                   shortestDistance.get(key).getDistance() + e.getDistance() < shortestDistance.get(e.getRoute()).getDistance()){

                    shortestDistance.get(e.getRoute()).setDistance(shortestDistance.get(key).getDistance() + e.getDistance());
                }
            }
        }

        return shortestDistance.get(destination).getDistance();
    }

    private HashMap<Character, ShortestDistanceDAO> createDistanceAndVisitedMap(){
        HashMap<Character, ShortestDistanceDAO> distanceAndVisited = new HashMap<>();

        for(char key: GRAPH.keySet()){
            distanceAndVisited.put(key, new ShortestDistanceDAO());
        }

        return distanceAndVisited;
    }

    /*Helper function to find the minimum distance*/
    private char getKeyOfMinDistance(HashMap<Character, ShortestDistanceDAO> distance){
        int min = Integer.MAX_VALUE;
        char trainStationKey = '\0';

        for(char key: distance.keySet()){
            if(!distance.get(key).isShortestDistanceFound() && distance.get(key).getDistance() < min){
                min = distance.get(key).getDistance();
                trainStationKey = key;
            }
        }

        return trainStationKey;
    }
}
