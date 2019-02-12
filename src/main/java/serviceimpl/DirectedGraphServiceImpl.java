package serviceimpl;

import service.DirectedGraphService;
import service.pojos.Edge;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*This class builds the graph needed for the whole assignment*/
public class DirectedGraphServiceImpl implements DirectedGraphService {
    private final TreeMap<Character, List<Edge>> GRAPH = new TreeMap<>();

    @SuppressWarnings("unchecked")
    public DirectedGraphServiceImpl(String[] trainStations) {
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

            else{
                GRAPH.get(trainStation.charAt(SOURCE)).add(new Edge(trainStation.charAt(DESTINATION),
                                                               Character.getNumericValue(trainStation.charAt(DISTANCE))));
            }
        }
    }

    @Override
    public TreeMap<Character, List<Edge>> getGraph() {
        return GRAPH;
    }
}