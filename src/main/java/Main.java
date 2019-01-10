import graph.DirectedGraphForTrainRoutes;
import utility.BuildTrainStationHelper;

public class Main {
    public static void main(String[] args) {
        BuildTrainStationHelper utilObj = new BuildTrainStationHelper();
        DirectedGraphForTrainRoutes kiwilandTrainStations = new DirectedGraphForTrainRoutes(utilObj.getNumberOfUniqueTrainStations(args));
        utilObj.buildGraphFromCommandLineArguments(kiwilandTrainStations, args);
    }
}
