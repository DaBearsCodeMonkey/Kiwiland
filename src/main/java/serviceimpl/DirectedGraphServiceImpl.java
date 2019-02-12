package serviceimpl;

import service.DirectedGraphService;
import service.pojos.Edge;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;

/*This class builds the graph needed for the whole assignment*/
public class DirectedGraphServiceImpl implements DirectedGraphService {
    private final List<Edge>[] graph;
    private final Utility utility = new Utility();

    @SuppressWarnings("unchecked")
    public DirectedGraphServiceImpl(int numberOfTrainStations, String[] trainStations) {
        graph = new ArrayList[numberOfTrainStations];

        for(int counter = 0; counter < numberOfTrainStations; counter++){
            graph[counter] = new ArrayList<>();
        }

        buildGraph(trainStations);
    }

    private void buildGraph(String[] trainStations){
        int source;
        int destination;
        int distance;

        for(String trainStation : trainStations){
            source = utility.getIntValueOfChar(trainStation.charAt(0));
            destination = utility.getIntValueOfChar(trainStation.charAt(1));
            distance = Character.getNumericValue(trainStation.charAt(2));

            addRoute(source, destination, distance);
        }
    }

    private void addRoute(int sourceStation, int destinationStation, int distance){
        graph[sourceStation].add(new Edge(destinationStation, distance));
    }

    @Override
    public List<Edge>[] getGraph() {
        return graph;
    }
}