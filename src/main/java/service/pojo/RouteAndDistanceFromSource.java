package service.pojo;

public class RouteAndDistanceFromSource {
    private final Character route;
    private final Integer distanceFromSource;

    public RouteAndDistanceFromSource(Character route, Integer distanceFromSource) {
        this.route = route;
        this.distanceFromSource = distanceFromSource;
    }

    public Character getRoute() {
        return route;
    }

    public Integer getDistanceFromSource() {
        return distanceFromSource;
    }
}
