package serviceimpl;

import service.DirectedGraphService;
import service.pojo.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*This class builds the graph needed for the whole assignment*/
public class DirectedGraphServiceImpl implements DirectedGraphService {
    private final HashMap<Character, List<Edge>> GRAPH;

    public DirectedGraphServiceImpl(String[] trainStations) {
        GRAPH = new HashMap<>();
        buildGraph(trainStations);
    }

    private void buildGraph(String[] trainStations){
        final byte SOURCE = 0;
        final byte DESTINATION = 1;
        final byte DISTANCE = 2;

        for(String trainStation : trainStations){

            if(!GRAPH.containsKey(trainStation.charAt(SOURCE))){
                GRAPH.put(trainStation.charAt(SOURCE), new ArrayList<>());
            }

            GRAPH.get(trainStation.charAt(SOURCE)).add(new Edge(trainStation.charAt(DESTINATION),
                                                                Character.getNumericValue(trainStation.charAt(DISTANCE))));
        }
    }

    @Override
    public HashMap<Character, List<Edge>> getGraph() {
        return GRAPH;
    }
}