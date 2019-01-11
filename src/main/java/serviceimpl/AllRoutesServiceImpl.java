package serviceimpl;

import service.AllRoutesService;
import service.pojos.RouteAndDistance;
import utility.Utility;

import java.util.ArrayList;
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
        List<Integer> localRouteList = new ArrayList<>();
        Integer source = utility.getIntValueOfChar(startingStation);
        Integer destination = utility.getIntValueOfChar(endingStation);
        Integer currentStop = 0;
        totalNumberOfRoutes = 0;
        localRouteList.add(source);

        if(chooseYourPath.toLowerCase().matches("max")){
            findAllPathsMaximum(source, destination, currentStop, maxStops, localRouteList);
        }

        else if(chooseYourPath.toLowerCase().matches("exact")){
            findAllPathsExact(source, destination, currentStop, maxStops, localRouteList);
        }

        else{
            return "Please choose max or exact.";
        }

        return String.valueOf(totalNumberOfRoutes);
    }


    private void findAllPathsExact(Integer index,
                                   Integer destination,
                                   Integer currentStop,
                                   Integer maxStops,
                                   List<Integer> localRouteList){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && currentStop.equals(maxStops) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(RouteAndDistance temp : adjListArr[index]){
            localRouteList.add(temp.getRoute());
            findAllPathsExact(temp.getRoute(), destination, currentStop + 1, maxStops, localRouteList);
            localRouteList.remove(temp.getRoute());
        }
    }

    private void findAllPathsMaximum(Integer index,
                                     Integer destination,
                                     Integer currentStop,
                                     Integer maxStops,
                                     List<Integer> localRouteList){

        if(currentStop > maxStops){
            return;
        }

        if(index.equals(destination) && !currentStop.equals(0)){
            totalNumberOfRoutes++;
            return;
        }

        for(RouteAndDistance temp : adjListArr[index]){
            localRouteList.add(temp.getRoute());
            findAllPathsMaximum(temp.getRoute(), destination, currentStop + 1, maxStops, localRouteList);
            localRouteList.remove(temp.getRoute());
        }
    }
}
