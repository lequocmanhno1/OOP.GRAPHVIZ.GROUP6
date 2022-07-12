package hedspi.oop.group6.model.graph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph extends Graph{
    @Override
    public List<Edge> getNeighborsVertex(Vertex vertex) {
        List<Edge> neighbors = new ArrayList<>();
        for(Edge edge: listOfEdges){
            if(edge.getFrom().equals(vertex)){
                neighbors.add(edge);
            }
        }
        return neighbors;
    }
}
