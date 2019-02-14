package controllers;

import javafx.fxml.FXML;
import service.*;
import serviceimpl.*;

public class MainController {

    @SuppressWarnings("unused")
    @FXML private ImportButtonController importButtonController;

    @FXML
    public void initialize(){
        importButtonController.initialize(this);
    }

    void startUpKiwiland(String[] trainStations){
        DirectedGraphService kiwilandTrainStations = new DirectedGraphServiceImpl(trainStations);
        final DepthFirstSearchService depthFirstSearchServiceExact = new DepthFirstSearchServiceExactImpl(kiwilandTrainStations.getGraph());
        final DepthFirstSearchService depthFirstSearchServiceMax = new DepthFirstSearchMaxImpl(kiwilandTrainStations.getGraph());
        final BreadthFirstSearchService breadthFirstSearchService = new BreadthFirstSearchServiceImpl(kiwilandTrainStations.getGraph());
        final DistanceService distanceService = new DistanceServiceImpl(kiwilandTrainStations.getGraph());
        final DijkstraService dijkstraService = new DijkstraServiceImpl(kiwilandTrainStations.getGraph());
        doTheFunAssignment(depthFirstSearchServiceExact, depthFirstSearchServiceMax, breadthFirstSearchService, distanceService, dijkstraService);
    }

    private void doTheFunAssignment(DepthFirstSearchService depthFirstSearchServiceExact,
                                    DepthFirstSearchService depthFirstSearchServiceMax,
                                    BreadthFirstSearchService breadthFirstSearchService,
                                    DistanceService distanceService,
                                    DijkstraService dijkstraService){

        System.out.println(String.format("Output #1: %s", distanceService.getTotalDistance("A-B-C")));
        System.out.println(String.format("Output #2: %s", distanceService.getTotalDistance("A-D")));
        System.out.println(String.format("Output #3: %s", distanceService.getTotalDistance("A-D-C")));
        System.out.println(String.format("Output #4: %s", distanceService.getTotalDistance("A-E-B-C-D")));
        System.out.println(String.format("Output #5: %s", distanceService.getTotalDistance("A-E-D")));
        System.out.println(String.format("Output #6: %s", depthFirstSearchServiceMax.getNumberOfStops('C', 'C', 3)));
        System.out.println(String.format("Output #7: %s", depthFirstSearchServiceExact.getNumberOfStops('A', 'C', 4)));
        System.out.println(String.format("Output #8: %s", dijkstraService.getShortestRoute('A', 'C')));
        System.out.println(String.format("Output #9: %s", dijkstraService.getShortestRoute('C', 'C')));
        System.out.println(String.format("Output #10: %s", breadthFirstSearchService.getDifferentRoutes('C', 'C', 30)));
    }
}
