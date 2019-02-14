package service.pojo;

public class BreadthFirstSearch {
    private final Character currentRoute;
    private final Integer distanceFromSource;

    public BreadthFirstSearch(Character currentRoute, Integer distanceFromSource) {
        this.currentRoute = currentRoute;
        this.distanceFromSource = distanceFromSource;
    }

    public Character getCurrentRoute() {
        return currentRoute;
    }

    public Integer getDistanceFromSource() {
        return distanceFromSource;
    }
}
