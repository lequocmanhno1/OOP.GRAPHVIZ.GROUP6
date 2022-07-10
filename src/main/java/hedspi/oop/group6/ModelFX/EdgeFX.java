package hedspi.oop.group6.ModelFX;

import hedspi.oop.group6.model.graph.Edge;
import javafx.scene.shape.Path;

public abstract class EdgeFX extends Path {
    protected Edge edge;
    protected NodeFX vertexFrom;
    protected NodeFX vertexTo;


    public EdgeFX(NodeFX vertexFrom, NodeFX vertexTo) {
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
    }

    public Edge getEdge() {
        return edge;
    }
}
