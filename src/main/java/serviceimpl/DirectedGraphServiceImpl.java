package serviceimpl;

import service.DirectedGraphService;
import service.pojos.Edge;

import java.util.ArrayList;
import java.util.List;

/*This class builds the graph needed for the whole assignment*/
public class DirectedGraphServiceImpl implements DirectedGraphService {
    private final List<Edge>[] graph;

    @SuppressWarnings("unchecked")
    public DirectedGraphServiceImpl(int numberOfTrainStations) {
        graph = new ArrayList[numberOfTrainStations];

        for(int counter = 0; counter < numberOfTrainStations; counter++){
            graph[counter] = new ArrayList<>();
        }
    }


    public void addRoute(int sourceStation, int destinationStation, int distance){
        Edge tempObj = new Edge(destinationStation, distance);
        graph[sourceStation].add(tempObj);
    }


    public List<Edge>[] getGraph() {
        return graph;
    }
}