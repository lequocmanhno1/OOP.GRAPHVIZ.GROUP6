/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.View;

import hedspi.oop.group6.Model.Graph;
import hedspi.oop.group6.Model.Vertex;
import hedspi.oop.group6.Step.DetailStep;
import hedspi.oop.group6.Step.PseudoStep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class BipartiteGraph extends Algorithm {
    
    public BipartiteGraph(Graph data){
        super(data);
    }
    
    @Override
    public void createSteps(){
        listOfSteps.add(new PseudoStep("for each unvisited vertex u"));
        listOfSteps.add(new PseudoStep("  push u to the queue"));
        listOfSteps.add(new PseudoStep("  while !Q.empty // Q is a normal queue"));
        listOfSteps.add(new PseudoStep("    for each neighbor v of u = Q.front, Q.pop"));
        listOfSteps.add(new PseudoStep("      if u and v have the same color → exit"));
        listOfSteps.add(new PseudoStep("      assign another color to v, push v to queue"));
        //6
        listOfSteps.add(new DetailStep("Vertex "));
        listOfSteps.add(new DetailStep(" is unvisited."));
        listOfSteps.add(new DetailStep("Q = ["));
        listOfSteps.add(new DetailStep("]."));
        listOfSteps.add(new DetailStep("Extract "));
        listOfSteps.add(new DetailStep(" from queue."));
        listOfSteps.add(new DetailStep("Try edge "));
        listOfSteps.add(new DetailStep(" is free, assign another color and push it to queue."));
        listOfSteps.add(new DetailStep(" and vertex "));
        listOfSteps.add(new DetailStep(" (already visited) have different color, continue."));
        listOfSteps.add(new DetailStep("This is a bipartite graph!"));
        listOfSteps.add(new DetailStep(" have the same color."));
        listOfSteps.add(new DetailStep("This is NOT a bipartite graph!"));
    }

    private boolean checkVisit(List<Vertex> Visit, Vertex v) {
        for (int i = 0; i < Visit.size(); i++) {
            if (Visit.get(i).getVertexId() == v.getVertexId()) {
                return true;
            }
        }
        return false;
    }

    private int reverseColor(Vertex v) {
        if (v.getColor() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void traversal() {
        List<Vertex> Visit = new ArrayList<>();
        Queue<Vertex> Queue = new LinkedList<>();
        System.out.println(((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getSourceVertex()) 
                + ((DetailStep)super.getListOfSteps().get(7)).toString());
        System.out.println(super.getListOfSteps().get(0).toString());
        super.getSourceVertex().setColor(0);
        Queue.add(super.getSourceVertex());
        System.out.println(((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue) + ((DetailStep)super.getListOfSteps().get(9)).toString());
        System.out.println(super.getListOfSteps().get(1).toString());
        while (!Queue.isEmpty()) {
            Vertex s = Queue.poll();
            System.out.println(((DetailStep)super.getListOfSteps().get(10)).toStringV(s) + ((DetailStep)super.getListOfSteps().get(11)).toString());
            System.out.println(super.getListOfSteps().get(2).toString());
            if (checkVisit(Visit, s) == false) {
                Visit.add(s);
            }
            for (int i = 0; i < super.getGraph().getListOfEdges().size(); i++) {
                if (s.getVertexId() == super.getGraph().getListOfEdges().get(i).getFrom().getVertexId()) {
                    if (checkVisit(Visit, super.getGraph().getListOfEdges().get(i).getTo()) == false){
                        System.out.println(((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue) 
                                + ((DetailStep)super.getListOfSteps().get(9)).toString());
                        System.out.println(((DetailStep)super.getListOfSteps().get(12)).toStringE(super.getGraph().getListOfEdges().get(i)));
                        System.out.println(super.getListOfSteps().get(3).toString());
                        if( super.getGraph().getListOfEdges().get(i).getTo().getColor() == s.getColor()){
                            System.out.println(((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getFrom()) 
                                + ((DetailStep)super.getListOfSteps().get(14)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                                + ((DetailStep)super.getListOfSteps().get(17)).toString());
                            System.out.println(((DetailStep)super.getListOfSteps().get(18)).toString());
                            System.out.println(super.getListOfSteps().get(4).toString());
                            return;
                        }
                        if(Queue.contains(super.getGraph().getListOfEdges().get(i).getTo()) == false) {
                            super.getGraph().getListOfEdges().get(i).getTo().setColor(this.reverseColor(s));
                            Queue.add(super.getGraph().getListOfEdges().get(i).getTo());
                            System.out.println(((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue) 
                                    + ((DetailStep)super.getListOfSteps().get(9)).toString());
                            System.out.println(((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                                    + ((DetailStep)super.getListOfSteps().get(13)).toString());
                            System.out.println(super.getListOfSteps().get(5).toString());
                            
                        }
                    }else{
                        System.out.println(((DetailStep)super.getListOfSteps().get(12)).toStringE(super.getGraph().getListOfEdges().get(i)));
                        System.out.println(((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getFrom()) 
                                + ((DetailStep)super.getListOfSteps().get(14)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                                + ((DetailStep)super.getListOfSteps().get(15)).toString());
                        System.out.println(super.getListOfSteps().get(4).toString());
                    }
                }
            }
        }
        System.out.println(((DetailStep)super.getListOfSteps().get(16)).toString());
    }

}
