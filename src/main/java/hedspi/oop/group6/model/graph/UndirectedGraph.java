package hedspi.oop.group6.model.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph extends Graph{
    @Override
    public List<Edge> getNeighborsVertex(Vertex vertex) {
        List<Edge> neighbors = new ArrayList<>();
        for(Edge edge: listOfEdges){
            if(edge.getFrom().equals(vertex) || edge.getTo().equals(vertex)){
                if(edge.getFrom().equals(vertex)){
                    neighbors.add(edge);
                } else {
                    Vertex from = edge.getFrom();
                    Vertex to =  edge.getTo();
                    edge.setFrom(to);
                    edge.setTo(from);
                    neighbors.add(edge);
                }
            }

        }
        return neighbors;
    }
}
