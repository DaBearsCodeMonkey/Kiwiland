package service;

import service.pojos.Edge;

import java.util.List;

public interface DirectedGraphService {
    List<Edge>[] getGraph();
}
