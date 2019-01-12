package service.pojos;

public class Edge {
    private Integer route;
    private Integer distance;

    public Edge(Integer route, Integer distance) {
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
