package hedspi.oop.group6.ModelFX;


import hedspi.oop.group6.Model.Vertex;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


public class NodeFX extends Circle{

    Vertex vertex;
    Label label;

    public Vertex getVertex() {
        return vertex;
    }

    public NodeFX(double x, double y, double rad, Vertex vertex, String name){
        super(x, y, rad);
        this.vertex = vertex;
        this.label = new Label(name);
        this.label.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
        this.label.setFont(new Font("Roboto",15));
        label.setLayoutX(x-8);
        label.setLayoutY(y-8);
    }



    public Label getLabel() {
        return label;
    }
}
