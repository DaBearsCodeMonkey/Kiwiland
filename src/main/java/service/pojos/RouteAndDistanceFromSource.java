package service.pojos;

public class RouteAndDistanceFromSource {
    private final Integer route;
    private final Integer distanceFromSource;

    public RouteAndDistanceFromSource(Integer route, Integer distanceFromSource) {
        this.route = route;
        this.distanceFromSource = distanceFromSource;
    }

    public Integer getRoute() {
        return route;
    }

    public Integer getDistanceFromSource() {
        return distanceFromSource;
    }
}
