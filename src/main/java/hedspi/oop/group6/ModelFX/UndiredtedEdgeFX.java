package hedspi.oop.group6.ModelFX;

import hedspi.oop.group6.model.graph.Edge;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

public class UndiredtedEdgeFX extends EdgeFX{
    private Edge reEdge;

    public Edge getReEdge() {
        return reEdge;
    }

    public UndiredtedEdgeFX(NodeFX vertexFrom, NodeFX vertexTo) {
        super(vertexFrom, vertexTo);
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.edge = new Edge(vertexFrom.getVertex(), vertexTo.getVertex());
        this.reEdge = new Edge(vertexTo.getVertex(), vertexFrom.getVertex());
        double startX = vertexFrom.getCenterX();
        double startY = vertexFrom.getCenterY();
        double endX = vertexTo.getCenterX();
        double endY = vertexTo.getCenterY();


        double sqrtPow = Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
        double cosAlpha = Math.abs(startY - endY) / sqrtPow;
        double sinAlpha = Math.abs(startX - endX) / sqrtPow;

        if (startX > endX) {
            startX -= 12 * sinAlpha;
            endX += 12 * sinAlpha;
        } else {
            startX += 12 * sinAlpha;
            endX -= 12 * sinAlpha;
        }

        if (startY > endY) {
            startY -= 12 * cosAlpha;
            endY += 12 * cosAlpha;
        } else {
            startY += 12 * cosAlpha;
            endY -= 12 * cosAlpha;
        }


        strokeProperty().bind(fillProperty());
        setFill(Color.BLACK);

        //Line
        getElements().add(new MoveTo(startX, startY));
        getElements().add(new LineTo(endX, endY));
    }
}
