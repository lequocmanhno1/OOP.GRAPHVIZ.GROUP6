package hedspi.oop.group6.Controller.context;

import hedspi.oop.group6.Controller.Drawing;
import hedspi.oop.group6.Controller.HiddenController;
import hedspi.oop.group6.ModelFX.DirectedEdgeFX;
import hedspi.oop.group6.ModelFX.EdgeFX;
import hedspi.oop.group6.ModelFX.NodeFX;
import hedspi.oop.group6.ModelFX.UndiredtedEdgeFX;
import hedspi.oop.group6.model.algorithm.Algorithm;
import hedspi.oop.group6.model.algorithm.AlgorithmResult;

import java.util.List;

public abstract class Context implements Runnable{
    private Algorithm algorithm;

    protected List<NodeFX> vertexes;

    protected List<DirectedEdgeFX> edges;

    protected AlgorithmResult result = null;


    public void setHiddenController(HiddenController hiddenController) {
        this.hiddenController = hiddenController;
    }

    protected HiddenController hiddenController;

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public void execute(){
        result = algorithm.traversal();
    }

    public abstract void visualize();

    public void setVertexes(List<NodeFX> vertexes) {
        this.vertexes = vertexes;
    }

    public void setEdges(List<DirectedEdgeFX> edges) {
        this.edges = edges;
    }

//    public void setEdges(List<UndiredtedEdgeFX> edges) {
//        this.edges = edges;
//    }

    @Override
    public void run() {
        this.visualize();
    }
}