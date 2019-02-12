package service;

import service.pojos.Edge;

import java.util.List;
import java.util.TreeMap;

public interface DirectedGraphService {
    TreeMap<Character, List<Edge>> getGraph();
}
