package service;

import service.pojos.Edge;

import java.util.List;

public interface DirectedGraphService {
    void addRoute(int sourceStation, int destinationStation, int distance);
    List<Edge>[] getGraph();
}
