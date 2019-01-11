package service.pojos;

public class RouteAndDistance {
    private Integer route;
    private Integer distance;

    public RouteAndDistance(Integer route, Integer distance) {
        this.route = route;
        this.distance = distance;
    }

    public Integer getRoute() {
        return route;
    }

    public Integer getDistance() {
        return distance;
    }
}
