package hedspi.oop.group6.ModelFX;

import hedspi.oop.group6.model.graph.Edge;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;

public class DirectedEdgeFX extends EdgeFX {
    private static final double defaultArrowHeadSize = 7;

    public DirectedEdgeFX(NodeFX vertexFrom, NodeFX vertexTo){
        super(vertexFrom, vertexTo);
        this.vertexFrom = vertexFrom;
        this.vertexTo = vertexTo;
        this.edge = new Edge(vertexFrom.getVertex(), vertexTo.getVertex());
        double startX  = vertexFrom.getCenterX();
        double startY = vertexFrom.getCenterY();
        double endX = vertexTo.getCenterX();
        double endY = vertexTo.getCenterY();


        double sqrtPow = Math.sqrt(Math.pow((startX - endX), 2) + Math.pow((startY - endY), 2));
        double cosAlpha = Math.abs(startY - endY) / sqrtPow;
        double sinAlpha = Math.abs(startX - endX) / sqrtPow;

        if(startX > endX){
            startX -= 12 * sinAlpha;
            endX += 12 * sinAlpha;
        } else {
            startX += 12 * sinAlpha;
            endX -= 12 * sinAlpha;
        }

        if(startY > endY){
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

        //ArrowHead
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + endX;
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * defaultArrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * defaultArrowHeadSize + endY;

        getElements().add(new LineTo(x1, y1));
        getElements().add(new LineTo(x2, y2));
        getElements().add(new LineTo(endX, endY));
    }

}
