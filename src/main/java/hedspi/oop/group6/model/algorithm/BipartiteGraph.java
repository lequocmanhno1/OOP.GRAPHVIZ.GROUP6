/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.model.algorithm;

import hedspi.oop.group6.model.graph.Graph;
import hedspi.oop.group6.model.graph.Vertex;
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
        listOfSteps.add(new PseudoStep("for each unvisited vertex u")); //1
        listOfSteps.add(new PseudoStep("  push u to the queue"));       //2
        listOfSteps.add(new PseudoStep("  while !Q.empty // Q is a normal queue")); //3
        listOfSteps.add(new PseudoStep("    for each neighbor v of u = Q.front, Q.pop")); //4
        listOfSteps.add(new PseudoStep("      if u and v have the same color → exit"));
        listOfSteps.add(new PseudoStep("      assign another color to v, push v to queue"));
        //6
        listOfSteps.add(new DetailStep("Vertex "));                 //1
        listOfSteps.add(new DetailStep(" is unvisited."));          //1
        listOfSteps.add(new DetailStep("Q = ["));                   //2
        listOfSteps.add(new DetailStep("]."));                      //2
        listOfSteps.add(new DetailStep("Extract "));                //3
        listOfSteps.add(new DetailStep(" from queue."));            //3
        listOfSteps.add(new DetailStep("Try edge "));               //4
        listOfSteps.add(new DetailStep(" is free, assign another color and push it to queue.")); //4
        listOfSteps.add(new DetailStep(" and vertex "));                                            //4
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
    public AlgorithmResult traversal() {
        AlgorithmResult algorithmResult = new AlgorithmResult();
        List<Vertex> Visit = new ArrayList<>();
        Queue<Vertex> Queue = new LinkedList<>();

        DetailStep detailStep1 = new DetailStep(((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getSourceVertex())
                + ((DetailStep)super.getListOfSteps().get(7)).toString());
        System.out.println(detailStep1.getDetail());
        algorithmResult.addDetailStep(detailStep1);

        PseudoStep pseudoStep1 = new PseudoStep(super.getListOfSteps().get(0).toString());
        System.out.println(pseudoStep1.getComporseStep());
        algorithmResult.addPseudoStep(pseudoStep1);

        super.getSourceVertex().setColor(0);
        Queue.add(super.getSourceVertex());

        DetailStep detailStep2 = new DetailStep(((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue) + ((DetailStep)super.getListOfSteps().get(9)).toString());
        System.out.println(detailStep2.getDetail());
        algorithmResult.addDetailStep(detailStep2);
        PseudoStep pseudoStep2 = new PseudoStep(super.getListOfSteps().get(1).toString());
        System.out.println(pseudoStep2.getComporseStep());
        algorithmResult.addPseudoStep(pseudoStep2);


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

                        String s1 = ((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue)
                                + ((DetailStep)super.getListOfSteps().get(9)).toString();
                        String s2 = ((DetailStep)super.getListOfSteps().get(12)).toStringE(super.getGraph().getListOfEdges().get(i));
                        s1= s1.concat(s2);

                        DetailStep detailStep3 = new DetailStep(s1);
                        System.out.println(detailStep3.getDetail());
                        algorithmResult.addDetailStep(detailStep3);

                        PseudoStep pseudoStep3 = new PseudoStep(super.getListOfSteps().get(3).toString());
                        System.out.println(pseudoStep3.getComporseStep());
                        algorithmResult.addPseudoStep(pseudoStep3);

                        if( super.getGraph().getListOfEdges().get(i).getTo().getColor() == s.getColor()){

                            s1 = ((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getFrom())
                                    + ((DetailStep)super.getListOfSteps().get(14)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                    + ((DetailStep)super.getListOfSteps().get(17)).toString();
                            s2 = ((DetailStep)super.getListOfSteps().get(18)).toString();

                            s1 = s1.concat(s2);
//                            System.out.println();
                            DetailStep detailStep4 = new DetailStep(s1);
                            System.out.println(detailStep4.getDetail());
                            algorithmResult.addDetailStep(detailStep4);

                            PseudoStep pseudoStep4 = new PseudoStep(super.getListOfSteps().get(4).toString());
                            System.out.println(pseudoStep4);
                            algorithmResult.addPseudoStep(pseudoStep4);
                            return null;
                        }
                        if(Queue.contains(super.getGraph().getListOfEdges().get(i).getTo()) == false) {
                            super.getGraph().getListOfEdges().get(i).getTo().setColor(this.reverseColor(s));
                            Queue.add(super.getGraph().getListOfEdges().get(i).getTo());

                            s1 = ((DetailStep)super.getListOfSteps().get(8)).toStringQ(Queue)
                                    + ((DetailStep)super.getListOfSteps().get(9)).toString();
                            s2 = ((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                    + ((DetailStep)super.getListOfSteps().get(13)).toString();

                            s1 = s1.concat(s2);
                            DetailStep detailStep5 = new DetailStep(s1);
                            System.out.println(detailStep5.getDetail());
                            algorithmResult.addDetailStep(detailStep5);

                            PseudoStep pseudoStep5 = new PseudoStep(super.getListOfSteps().get(5).toString());
                            System.out.println(pseudoStep5.getComporseStep());
                            algorithmResult.addPseudoStep(pseudoStep5);
                        }
                    }else{
                        String s1 = ((DetailStep)super.getListOfSteps().get(12)).toStringE(super.getGraph().getListOfEdges().get(i));
                        String s2 = ((DetailStep)super.getListOfSteps().get(6)).toStringV(super.getGraph().getListOfEdges().get(i).getFrom())
                                + ((DetailStep)super.getListOfSteps().get(14)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                + ((DetailStep)super.getListOfSteps().get(15)).toString();
                        s1 = s1.concat(s2);
                        DetailStep detailStep6 = new DetailStep(s1);
                        System.out.println(detailStep6.getDetail());
                        algorithmResult.addDetailStep(detailStep6);

                        PseudoStep pseudoStep6 = new PseudoStep(super.getListOfSteps().get(4).toString());
                        System.out.println(pseudoStep6.getComporseStep());
                        algorithmResult.addPseudoStep(pseudoStep6);
                    }
                }
            }
        }

        DetailStep detailStep7 = new DetailStep(((DetailStep)super.getListOfSteps().get(16)).toString());
        System.out.println(detailStep7.getDetail());
        algorithmResult.addDetailStep(detailStep7);
        return algorithmResult;
    }

}
