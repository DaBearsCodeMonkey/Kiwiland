package service.pojos;

public class Edge {
    private final Character route;
    private final Integer distance;

    public Edge(Character route, Integer distance) {
        this.route = route;
        this.distance = distance;
    }

    public Character getRoute() {
        return route;
    }

    public Integer getDistance() {
        return distance;
    }
}
