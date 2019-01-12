package serviceimpl;

import service.DifferentRoutesService;
import service.pojos.RouteAndDistance;
import service.pojos.RouteAndDistanceFromSource;
import utility.Utility;

import java.util.LinkedList;
import java.util.List;

public class DifferentRoutesServiceImpl implements DifferentRoutesService {

    private final List<RouteAndDistance> adjListArr[];
    private final Utility utility = new Utility();

    public DifferentRoutesServiceImpl(List<RouteAndDistance>[] adjListArr) {
        this.adjListArr = adjListArr;
    }

    @Override
    public String getDifferentRoutes(char startingStation, char endingStation, int maxDistance) {
        LinkedList<RouteAndDistanceFromSource> queue = new LinkedList<>();
        Integer source = utility.getIntValueOfChar(startingStation);
        int destination = utility.getIntValueOfChar(endingStation);
        int currentNumberOfRoutes = 0;
        queue.add(new RouteAndDistanceFromSource(source, 0));

        while(!queue.isEmpty()){
            RouteAndDistanceFromSource tempObj = queue.poll();
            int index = tempObj.getRoute();
            int currentDistance = tempObj.getDistanceFromSource();

            if(index == destination && currentDistance < maxDistance && currentDistance!= 0){
                currentNumberOfRoutes++;
            }

            if(currentDistance < maxDistance) {
                for (RouteAndDistance temp : adjListArr[index]) {
                    queue.add(new RouteAndDistanceFromSource(temp.getRoute(), currentDistance + temp.getDistance()));
                }
            }
        }

        return String.valueOf(currentNumberOfRoutes);
    }
}
