package serviceimpl;

import service.DirectedGraphService;
import service.pojos.RouteAndDistance;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphServiceImpl implements DirectedGraphService {
    private List<RouteAndDistance> adjListArray[];

    @SuppressWarnings("unchecked")
    public DirectedGraphServiceImpl(int numberOfTrainStations) {
        adjListArray = new ArrayList[numberOfTrainStations];

        for(int counter = 0; counter < numberOfTrainStations; counter++){
            adjListArray[counter] = new ArrayList<>();
        }
    }


    public void addRoute(int sourceStation, int destinationStation, int distance){
        RouteAndDistance tempObj = new RouteAndDistance(destinationStation, distance);
        adjListArray[sourceStation].add(tempObj);
    }


    public List<RouteAndDistance>[] getAdjListArray() {
        return adjListArray;
    }
}