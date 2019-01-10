package graph;

public class RouteAndDistance {
    private int route;
    private int distance;

    public RouteAndDistance(int route, int distance) {
        this.route = route;
        this.distance = distance;
    }

    int getRoute() {
        return route;
    }

    int getDistance() {
        return distance;
    }
}
