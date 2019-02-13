package service;

import service.pojo.Edge;

import java.util.HashMap;
import java.util.List;


public interface DirectedGraphService {
    HashMap<Character, List<Edge>> getGraph();
}
