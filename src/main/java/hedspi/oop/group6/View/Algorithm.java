package hedspi.oop.group6.View;

import hedspi.oop.group6.Model.Graph;
import hedspi.oop.group6.Model.Vertex;
import hedspi.oop.group6.Step.Step;
import java.util.ArrayList;
import java.util.List;

public abstract class Algorithm {
    private Graph graph;
    
    private Vertex sourceVertex;
    protected List<Step> listOfSteps = new ArrayList<>();
    
    public abstract void createSteps();

    public Algorithm() {
    }

    public Algorithm(Graph data) {
        this.graph = data;
        createSteps();
    }

    public Graph getData() {
        return graph;
    }

    public void setData(Graph data) {
        this.graph = data;
    }
    
    public void setSourceVertex(Vertex v){
        this.sourceVertex = v;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public List<Step> getListOfSteps() {
        return listOfSteps;
    }

    public void setListOfSteps(List<Step> listOfSteps) {
        this.listOfSteps = listOfSteps;
    }

    public Graph getGraph() {
        return graph;
    }
    
    
    
    public abstract void traversal();
}