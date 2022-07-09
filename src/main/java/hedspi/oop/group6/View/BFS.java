package hedspi.oop.group6.View;

import hedspi.oop.group6.Model.Graph;
import hedspi.oop.group6.Model.Vertex;
import hedspi.oop.group6.Step.DetailStep;
import hedspi.oop.group6.Step.PseudoStep;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends Algorithm {
    
    public BFS(Graph data){
        super(data);
    }
    
    @Override
    public void createSteps(){
        listOfSteps.add(new PseudoStep("BFS(u), Q = {u}"));
        listOfSteps.add(new PseudoStep("while !Q.empty // Q is a normal queue"));
        listOfSteps.add(new PseudoStep("  for each neighbor v of u = Q.front, Q.pop"));
        listOfSteps.add(new PseudoStep("    if v is unvisited, tree edge, Q.push(v)"));
        listOfSteps.add(new PseudoStep("    else if v is visited, we ignore this edge"));
        
        listOfSteps.add(new DetailStep("Set Q = {"));                           //5
        listOfSteps.add(new DetailStep("}."));
        listOfSteps.add(new DetailStep("The queue is now {"));
        listOfSteps.add(new DetailStep("Exploring neighbors of vertex u = "));
        listOfSteps.add(new DetailStep("Try edge "));
        listOfSteps.add(new DetailStep("Vertex "));
        listOfSteps.add(new DetailStep(" is unvisited, we have a tree edge."));
        listOfSteps.add(new DetailStep(" is explored, we ignore this non-tree edge."));
        listOfSteps.add(new DetailStep("BFS("));
        listOfSteps.add(new DetailStep(") is completed. Red/grey edge is tree/non-tree edge of the BFS & SSSP spanning tree (for unweighted graph)."));
    }
    
    private boolean checkVisit(List<Vertex> Visit ,Vertex v){
        for(int i=0 ; i < Visit.size() ; i ++){
            if(Visit.get(i).getVertexId() == v.getVertexId()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void traversal() {
        List<Vertex> Visit = new ArrayList<>();
        Queue<Vertex> Queue = new LinkedList<>();
        System.out.println(((DetailStep)super.getListOfSteps().get(5)).toStringV(super.getSourceVertex()) 
                + super.getListOfSteps().get(6).toString());
        System.out.println(super.getListOfSteps().get(0).toString());
        Queue.add(super.getSourceVertex());
        while (!Queue.isEmpty()) {
            System.out.println(((DetailStep)super.getListOfSteps().get(7)).toStringQ(Queue) + super.getListOfSteps().get(6));
            System.out.println(super.getListOfSteps().get(1).toString());
            Vertex s = Queue.peek();
            if(checkVisit(Visit,s) == false){
                Visit.add(s);
            }
            System.out.println(((DetailStep)super.getListOfSteps().get(8)).toStringV(s));
            System.out.println(super.getListOfSteps().get(2).toString());
            for (int i = 0; i < super.getGraph().getListOfEdges().size(); i++) {
                if (s.getVertexId() == super.getGraph().getListOfEdges().get(i).getFrom().getVertexId()) {
                    System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringE(super.getGraph().getListOfEdges().get(i)));
                    System.out.println(super.getListOfSteps().get(2).toString());
                    if(checkVisit(Visit,super.getGraph().getListOfEdges().get(i).getTo()) == false){
                        if(Queue.contains(super.getGraph().getListOfEdges().get(i).getTo())== false){
                            System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringE(super.getGraph().getListOfEdges().get(i)));
                            System.out.println(((DetailStep)super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                                    + super.getListOfSteps().get(11));
                            System.out.println(super.getListOfSteps().get(3).toString());
                            Queue.add(super.getGraph().getListOfEdges().get(i).getTo());
                        }else{
                            System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringE(super.getGraph().getListOfEdges().get(i)));
                            System.out.println(((DetailStep)super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                                    + super.getListOfSteps().get(12));
                            System.out.println(super.getListOfSteps().get(4).toString());
                        }
                    }
                    else{
                        System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringE(super.getGraph().getListOfEdges().get(i)));
                        System.out.println(((DetailStep)super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo()) 
                            + super.getListOfSteps().get(12));
                        System.out.println(super.getListOfSteps().get(4).toString());
                    }
                }
            }
            Queue.poll();
        }
        System.out.println(((DetailStep)super.getListOfSteps().get(13)).toStringV(super.getSourceVertex()) + super.getListOfSteps().get(14));
        System.out.print(" Ket qua duyet BFS ");
        for (int i = 0; i < Visit.size(); i++) {
            System.out.print(Visit.get(i).getVertexId());
            if(i != (Visit.size()-1)){
            System.out.print("->");
            }
        }
        System.out.println("");
    }
}