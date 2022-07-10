/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.Step;

import hedspi.oop.group6.model.graph.Edge;

/**
 *
 * @author Trung
 */
public class EdgeStep extends DetailStep {

    private Edge edge;

    public EdgeStep() {

    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public Edge getEdge() {
        return edge;
    }
}
