/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.Step;

import hedspi.oop.group6.model.graph.Vertex;

/**
 *
 * @author Trung
 */
public class VertexStep extends DetailStep{

    private Vertex vertex;

    public VertexStep(){

    }


    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public Vertex getVertex() {
        return vertex;
    }
}
