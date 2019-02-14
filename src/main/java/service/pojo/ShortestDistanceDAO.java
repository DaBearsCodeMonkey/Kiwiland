package service.pojo;

public class ShortestDistanceDAO {
    private int distance;
    private boolean shortestDistanceFound;

    public ShortestDistanceDAO() {
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
