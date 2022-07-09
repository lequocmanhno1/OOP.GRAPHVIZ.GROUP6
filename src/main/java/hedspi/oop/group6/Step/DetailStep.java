/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.Step;

import hedspi.oop.group6.Model.Edge;
import hedspi.oop.group6.Model.Vertex;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Trung
 */
public class DetailStep extends Step{
    private String detail;

    public DetailStep() {
    }

    public DetailStep(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return detail;
    }
    
    public String toStringV(Vertex vertex) {
        String v = String.valueOf(vertex.getVertexId());
        return detail + v;
    }
    
    public String toStringQ(Queue<Vertex> Queue) {
        String s = Queue.toString();
        String s1 = s.substring(1, s.length()-1);
        return detail + s1;
    }
    
    public String toStringS(Stack<Vertex> Stack) {
        String s = Stack.toString();
        String s1 = s.substring(1, s.length()-1);
        return detail + s1;
    }
    
    public String toStringE(Edge edge) {
        return detail + edge.getFrom().getVertexId() + "->" + edge.getTo().getVertexId() + ".";
    }
}
