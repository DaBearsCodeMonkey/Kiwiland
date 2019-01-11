package controllers;

import serviceimpl.DirectedGraphServiceImpl;
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
    }
}
