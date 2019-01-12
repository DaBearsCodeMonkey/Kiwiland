package serviceimpl;

import service.AllRoutesService;
import service.pojos.RouteAndDistance;
import utility.Utility;

import java.util.List;

/*Modified depth first search algorithm without a visited variable because cycles are allowed*/
public class AllRoutesServiceImpl implements AllRoutesService {

    private final List<RouteAndDistance> adjListArr[];
    private final Utility utility = new Utility();
    private static int totalNumberOfRoutes;

    public AllRoutesServiceImpl(List<RouteAndDistance> adjListArr[]){
        this.adjListArr = adjListArr;
    }

    @Override
    public String getNumberOfStops(char startingStation, char endingStation, Integer maxStops, String chooseYourPath) {
        Integer source = utility.getIntValueOfChar(startingStation);
        Integer destination = utility.getIntValueOfChar(endingStation);
        Integer currentStop = 0;
        totalNumberOfRoutes = 0;

        if(chooseYourPath.toLowerCase().matches("max")){
            findAllPathsMaximum(source, destination, currentStop, maxStops);
        }

        else if(chooseYourPath.toLowerCase().matches("exact")){
            findAllPathsExact(source, destination, currentStop, maxStops);
        }

        else{
            return "Please choose max or exact.";
        }

        return String.valueOf(totalNumberOfRoutes);
    }


    private void findAllPathsExact(Integer index, Integer destination, Integer currentStop, Integer maxStops){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && currentStop.equals(maxStops) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(RouteAndDistance temp : adjListArr[index]){
            findAllPathsExact(temp.getRoute(), destination, currentStop + 1, maxStops);
        }
    }

    private void findAllPathsMaximum(Integer index, Integer destination, Integer currentStop, Integer maxStops){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(RouteAndDistance temp : adjListArr[index]){
            findAllPathsMaximum(temp.getRoute(), destination, currentStop + 1, maxStops);
        }
    }
}
