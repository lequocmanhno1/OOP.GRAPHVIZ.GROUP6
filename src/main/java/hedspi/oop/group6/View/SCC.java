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
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class SCC extends Algorithm{

    
    public SCC(Graph data){
        super(data);
    }
    
    private void DFS(Graph g , Vertex v ,List<Vertex> Visit, Stack<Vertex> s){
        Visit.add(v);
        System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s) 
                + ((DetailStep)super.getListOfSteps().get(10)).toString());
        System.out.println(((DetailStep)super.getListOfSteps().get(11)).toStringV(v) 
                + ((DetailStep)super.getListOfSteps().get(12)).toString());
        System.out.println(super.getListOfSteps().get(0).toString());
        for(int i =0 ;i < g.getListOfEdges().size(); i++){
            if(v.getVertexId() == g.getListOfEdges().get(i).getFrom().getVertexId()){
                System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s) 
                    + ((DetailStep)super.getListOfSteps().get(10)).toString());
                System.out.println(((DetailStep)super.getListOfSteps().get(13)).toStringE(g.getListOfEdges().get(i)));
                System.out.println(super.getListOfSteps().get(1).toString());
                if((Visit.contains(g.getListOfEdges().get(i).getTo())) == false){
                    System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s) 
                        + ((DetailStep)super.getListOfSteps().get(10)).toString());
                    System.out.println(((DetailStep)super.getListOfSteps().get(7)).toStringV(g.getListOfEdges().get(i).getTo()) 
                            + ((DetailStep)super.getListOfSteps().get(8)).toString());
                    System.out.println(super.getListOfSteps().get(1).toString());
                    this.DFS(g, g.getListOfEdges().get(i).getTo(), Visit, s); 
                }
            }
        }
        s.push(v);
        System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s) 
            + ((DetailStep)super.getListOfSteps().get(10)).toString());
        System.out.println(((DetailStep)super.getListOfSteps().get(11)).toStringV(v) 
            + ((DetailStep)super.getListOfSteps().get(14)).toStringV(v) 
            + ((DetailStep)super.getListOfSteps().get(15)).toString());
        System.out.println(super.getListOfSteps().get(2).toString());  
    }
    
    private void DFSDao(Graph g , Vertex v ,List<Vertex> Visit, Stack<Vertex> s2, Stack<Vertex> s1){
        Visit.add(v);
        System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                + ((DetailStep)super.getListOfSteps().get(10)).toString());
        System.out.println(((DetailStep)super.getListOfSteps().get(11)).toStringV(v) 
                + ((DetailStep)super.getListOfSteps().get(12)).toString());
        System.out.println(super.getListOfSteps().get(4).toString());
        for(int i =0 ;i < g.getListOfEdges().size(); i++){
            if(v.getVertexId() == g.getListOfEdges().get(i).getFrom().getVertexId()){
                System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                    + ((DetailStep)super.getListOfSteps().get(10)).toString());
                System.out.println(((DetailStep)super.getListOfSteps().get(13)).toStringE(g.getListOfEdges().get(i)));
                System.out.println(super.getListOfSteps().get(5).toString());
                if((Visit.contains(g.getListOfEdges().get(i).getTo())) == false){
                    System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                        + ((DetailStep)super.getListOfSteps().get(10)).toString());
                    System.out.println(((DetailStep)super.getListOfSteps().get(7)).toStringV(g.getListOfEdges().get(i).getTo()) 
                            + ((DetailStep)super.getListOfSteps().get(8)).toString());
                    System.out.println(super.getListOfSteps().get(5).toString());
                    this.DFSDao(g, g.getListOfEdges().get(i).getTo(), Visit, s2, s1); 
                }else{
                    System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                        + ((DetailStep)super.getListOfSteps().get(10)).toString());
                    System.out.println(((DetailStep)super.getListOfSteps().get(21)).toStringV(g.getListOfEdges().get(i).getTo()) 
                            + ((DetailStep)super.getListOfSteps().get(22)).toString());
                    System.out.println(super.getListOfSteps().get(5).toString());
                }
            }
        }
        s2.push(v);
        System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
            + ((DetailStep)super.getListOfSteps().get(10)).toString());
        System.out.println(((DetailStep)super.getListOfSteps().get(17)).toStringV(v) 
            + ((DetailStep)super.getListOfSteps().get(18)).toString());
        System.out.println(super.getListOfSteps().get(4).toString());  
    }
    
    private Graph reverseGraph(Graph g){
        Graph graph = new Graph();
        for(int i =0 ; i < g.getListOfVertexs().size() ; i++){
            graph.addVertex(g.getListOfVertexs().get(i));
        }
        for(int i = 0 ; i < g.getListOfEdges().size() ; i++){
            graph.addEdge(g.getListOfEdges().get(i).getTo().getVertexId(), g.getListOfEdges().get(i).getFrom().getVertexId());
        }
        return graph;
    }
    
    private void printSCC(List<Vertex> listofVertex){
       System.out.println(listofVertex.toString());
    }
    
    @Override
    public void createSteps() {
        listOfSteps.add(new PseudoStep("for each unvisited vertex u, DFS(u)"));
        listOfSteps.add(new PseudoStep("  try all free neighbor v of u, DFS(v)"));
        listOfSteps.add(new PseudoStep("  finish DFS(u), add u to the front of list"));
        listOfSteps.add(new PseudoStep("transpose the graph"));
        listOfSteps.add(new PseudoStep("DFS in order of the list, DFS(u)"));
        listOfSteps.add(new PseudoStep("  try all free neighbor v of u, DFS(v)"));
        listOfSteps.add(new PseudoStep("each time we complete a DFS, we get an SCC"));
        //7
        listOfSteps.add(new DetailStep("Vertex "));
        listOfSteps.add(new DetailStep(" has not been visited."));
        listOfSteps.add(new DetailStep("List = ["));                           //5
        listOfSteps.add(new DetailStep("]."));
        listOfSteps.add(new DetailStep("DFS("));
        listOfSteps.add(new DetailStep(")."));
        listOfSteps.add(new DetailStep("Try edge "));
        listOfSteps.add(new DetailStep(") is completed, add "));
        listOfSteps.add(new DetailStep(" to the front of the list."));
        //16
        listOfSteps.add(new DetailStep("Then, we transpose the directed graph."));
        listOfSteps.add(new DetailStep("DFS from "));
        listOfSteps.add(new DetailStep(" is completed, back to the parent"));
        listOfSteps.add(new DetailStep("Finish DFS("));
        listOfSteps.add(new DetailStep(") and we get 1 Strongly Connected Component."));
        listOfSteps.add(new DetailStep(""));
        listOfSteps.add(new DetailStep(" is visited"));
        listOfSteps.add(new DetailStep(" is visited, ignore."));
        listOfSteps.add(new DetailStep("We transpose the directed graph again."));
        listOfSteps.add(new DetailStep("In total, we have "));
        listOfSteps.add(new DetailStep(" Strongly Connected Component(s) as seen above."));
    }

    @Override
    public void traversal() {
        int scc = 0;
        Stack<Vertex> s1 = new Stack<Vertex>();
        List<Vertex> Visit = new ArrayList<>();
        System.out.println(((DetailStep)super.getListOfSteps().get(7)).toStringV(super.getSourceVertex()) + ((DetailStep)super.getListOfSteps().get(8)).toString());
        System.out.println(super.getListOfSteps().get(0).toString()); 
        this.DFS(super.getGraph(), super.getSourceVertex(), Visit, s1);
        for(int i=0 ; i < super.getGraph().getListOfVertexs().size() ; i++){
            if(Visit.contains(super.getGraph().getListOfVertexs().get(i)) ==false){
                this.DFS(super.getGraph(), super.getGraph().getListOfVertexs().get(i), Visit, s1);
            }
        }
        List<Vertex> Visit2 = new ArrayList<>();
        List<Vertex> list = new ArrayList<>();
        Vertex v = new Vertex();
        Stack<Vertex> s2 = new Stack<Vertex>();
        Graph g = reverseGraph(super.getGraph()); // transpose the graph
        System.out.println(((DetailStep)super.getListOfSteps().get(16)).toString());
        System.out.println(super.getListOfSteps().get(3).toString()); 
        while(!s1.empty()){
            v = s1.peek();
            list.removeAll(list);
            if(!Visit2.contains(v)){
                this.DFSDao(g, v, Visit2, s2, s1);
            }else{
                System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                    + ((DetailStep)super.getListOfSteps().get(10)).toString());
                System.out.println(((DetailStep)super.getListOfSteps().get(21)).toStringV(v) 
                    + ((DetailStep)super.getListOfSteps().get(23)).toString());
                System.out.println(super.getListOfSteps().get(4).toString());
            }
            list.addAll(s2);
            while(!s2.empty()){
                g.removeNB(s2.pop(),list);
            }
            if(!list.isEmpty()){
                System.out.println(((DetailStep)super.getListOfSteps().get(9)).toStringS(s1) 
                    + ((DetailStep)super.getListOfSteps().get(10)).toString());
                System.out.println(((DetailStep)super.getListOfSteps().get(19)).toStringV(v) 
                    + ((DetailStep)super.getListOfSteps().get(20)).toString());
                System.out.println(super.getListOfSteps().get(6).toString());
                this.printSCC(list);
                scc++;
            }
            s1.pop();
        }
        System.out.println(((DetailStep)super.getListOfSteps().get(24)).toString());
        System.out.println(((DetailStep)super.getListOfSteps().get(25)).toString() + scc 
            + ((DetailStep)super.getListOfSteps().get(26)).toString());
    }
    
}
