package service.pojo;

public class ShortestDistance {
    private int distance;
    private boolean shortestDistanceFound;

    public ShortestDistance() {
        distance = Integer.MAX_VALUE;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isShortestDistanceFound() {
        return shortestDistanceFound;
    }

    public void shortestDistanceFound() {
        shortestDistanceFound = true;
    }
}
