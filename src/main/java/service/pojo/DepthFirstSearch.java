package service.pojo;

public class DepthFirstSearch {
    private Character currentStation;
    private Character destination;
    private Integer currentDepth;
    private Integer maxDepth;

    public DepthFirstSearch(Character currentStation, Character destination, Integer currentDepth, Integer maxDepth) {
        this.currentStation = currentStation;
        this.destination = destination;
        this.currentDepth = currentDepth;
        this.maxDepth = maxDepth;
    }

    public Character getCurrentStation() {
        return currentStation;
    }

    public Character getDestination() {
        return destination;
    }

    public Integer getCurrentDepth() {
        return currentDepth;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }
}
