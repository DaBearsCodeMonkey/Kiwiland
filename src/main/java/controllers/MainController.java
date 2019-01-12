package controllers;

import service.AllRoutesService;
import service.DifferentRoutesService;
import service.DistanceService;
import service.ShortestPathService;
import serviceimpl.*;
import javafx.fxml.FXML;
import utility.BuildTrainStationHelper;

public class MainController {

    @FXML private ImportButtonController importButtonController;

    @FXML
    public void initialize(){
        importButtonController.initialize(this);
    }

    void startUpKiwiland(String[] trainStations){
        BuildTrainStationHelper buildTrainStationHelper = new BuildTrainStationHelper();
        DirectedGraphServiceImpl kiwilandTrainStations = new DirectedGraphServiceImpl(buildTrainStationHelper.getNumberOfUniqueTrainStations(trainStations));
        buildTrainStationHelper.buildGraph(kiwilandTrainStations, trainStations);
        final AllRoutesService allRoutesService = new AllRoutesServiceImpl(kiwilandTrainStations.getGraph());
        final DifferentRoutesService differentRoutesService = new DifferentRoutesServiceImpl(kiwilandTrainStations.getGraph());
        final DistanceService distanceService = new DistanceServiceImpl(kiwilandTrainStations.getGraph());
        final ShortestPathService shortestPathService = new ShortestPathServiceImpl(kiwilandTrainStations.getGraph());
        doTheFunAssignment(allRoutesService, differentRoutesService, distanceService, shortestPathService);
    }

    private void doTheFunAssignment(AllRoutesService allRoutesService,
                                    DifferentRoutesService differentRoutesService,
                                    DistanceService distanceService,
                                    ShortestPathService shortestPathService){

        System.out.println(String.format("Output #1: %s", distanceService.getTotalDistance("A-B-C")));
        System.out.println(String.format("Output #2: %s", distanceService.getTotalDistance("A-D")));
        System.out.println(String.format("Output #3: %s", distanceService.getTotalDistance("A-D-C")));
        System.out.println(String.format("Output #4: %s", distanceService.getTotalDistance("A-E-B-C-D")));
        System.out.println(String.format("Output #5: %s", distanceService.getTotalDistance("A-E-D")));
        System.out.println(String.format("Output #6: %s", allRoutesService.getNumberOfStops('C', 'C', 3, "max")));
        System.out.println(String.format("Output #7: %s", allRoutesService.getNumberOfStops('A', 'C', 4, "exact")));
        System.out.println(String.format("Output #8: %s", shortestPathService.getShortestRoute('A', 'C')));
        System.out.println(String.format("Output #9: %s", shortestPathService.getShortestRoute('C', 'C')));
        System.out.println(String.format("Output #10: %s", differentRoutesService.getDifferentRoutes('C', 'C', 30)));
    }
}
