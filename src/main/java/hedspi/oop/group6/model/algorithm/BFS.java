package hedspi.oop.group6.model.algorithm;

import hedspi.oop.group6.Step.EdgeStep;
import hedspi.oop.group6.Step.VertexStep;
import hedspi.oop.group6.model.graph.Graph;
import hedspi.oop.group6.model.graph.Vertex;
import hedspi.oop.group6.Step.DetailStep;
import hedspi.oop.group6.Step.PseudoStep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends Algorithm {

    public BFS(Graph data) {
        super(data);
    }

    @Override
    public void createSteps() {
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
        listOfSteps.add(new DetailStep(") is completed. "));
    }

    private boolean checkVisit(List<Vertex> Visit, Vertex v) {
        for (int i = 0; i < Visit.size(); i++) {
            if (Visit.get(i).getVertexId() == v.getVertexId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public AlgorithmResult traversal() {
        AlgorithmResult algorithmResult = new AlgorithmResult();
        List<Vertex> Visit = new ArrayList<>();
        Queue<Vertex> Queue = new LinkedList<>();
        VertexStep detailStep1 = new VertexStep();
        detailStep1.setVertex(super.getSourceVertex());
        String startDetail = ((DetailStep) super.getListOfSteps().get(5)).toStringV(super.getSourceVertex())
                + super.getListOfSteps().get(6).toString();
        System.out.println(startDetail);
        detailStep1.setDetail(startDetail);
        algorithmResult.addDetailStep(detailStep1);

        PseudoStep pseudoStep1 = new PseudoStep();
        pseudoStep1.setComporseStep(super.getListOfSteps().get(0).toString());
        System.out.println(pseudoStep1.getComporseStep());
        algorithmResult.addPseudoStep(pseudoStep1);

        Queue.add(super.getSourceVertex());
        while (!Queue.isEmpty()) {

            String s15 = ((DetailStep) super.getListOfSteps().get(7)).toStringQ(Queue) + super.getListOfSteps().get(6);
            String a15 = super.getListOfSteps().get(1).toString();

            Vertex s = Queue.peek();
            if (!checkVisit(Visit, s)) {
                Visit.add(s);
            }
            String s16 = ((DetailStep) super.getListOfSteps().get(8)).toStringV(s);
            s15 = s15.concat("\n" + s16);

            DetailStep detailStep2 = new DetailStep();
            detailStep2.setDetail(s15);
            System.out.println(s15);
            algorithmResult.addDetailStep(detailStep2);

            PseudoStep pseudoStep2 = new PseudoStep();
            pseudoStep2.setComporseStep(a15);
            System.out.println(a15);
            algorithmResult.addPseudoStep(pseudoStep2);

            for (int i = 0; i < super.getGraph().getListOfEdges().size(); i++) {
                if (s.getVertexId() == super.getGraph().getListOfEdges().get(i).getFrom().getVertexId()) {
                    EdgeStep detailStep4 = new EdgeStep();
                    detailStep4.setDetail(((DetailStep) super.getListOfSteps().get(9)).toStringE(super.getGraph().getListOfEdges().get(i)));
                    System.out.println(detailStep4.getDetail());
                    detailStep4.setEdge(super.getGraph().getListOfEdges().get(i));
                    algorithmResult.addDetailStep(detailStep4);

                    PseudoStep pseudoStep4 = new PseudoStep();
                    pseudoStep4.setComporseStep(super.getListOfSteps().get(2).toString());
                    System.out.println(pseudoStep4.getComporseStep());
                    algorithmResult.addPseudoStep(pseudoStep4);

                    if (!checkVisit(Visit, super.getGraph().getListOfEdges().get(i).getTo())) {
                        if (!Queue.contains(super.getGraph().getListOfEdges().get(i).getTo())) {

                            String s10 = ((DetailStep) super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                    + super.getListOfSteps().get(11);
                            System.out.println(s10);


                            VertexStep detailStep5 = new VertexStep();
                            detailStep5.setDetail(s10);
                            detailStep5.setVertex(super.getGraph().getListOfEdges().get(i).getTo());
                            algorithmResult.addDetailStep(detailStep5);

                            PseudoStep pseudoStep5 = new PseudoStep();
                            pseudoStep5.setComporseStep(super.getListOfSteps().get(3).toString());
                            System.out.println(pseudoStep5.getComporseStep());
                            algorithmResult.addPseudoStep(pseudoStep5);
                            Queue.add(super.getGraph().getListOfEdges().get(i).getTo());

                        } else {
                            String s10 = ((DetailStep) super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                    + super.getListOfSteps().get(12);
                            System.out.println(s10);

                            DetailStep detailStep6 = new DetailStep();
                            detailStep6.setDetail(s10);
                            algorithmResult.addDetailStep(detailStep6);

                            PseudoStep pseudoStep6 = new PseudoStep();
                            pseudoStep6.setComporseStep(super.getListOfSteps().get(4).toString());
                            System.out.println(pseudoStep6.getComporseStep());
                            algorithmResult.addPseudoStep(pseudoStep6);
                        }
                    } else {
                        String s10 = ((DetailStep) super.getListOfSteps().get(10)).toStringV(super.getGraph().getListOfEdges().get(i).getTo())
                                + super.getListOfSteps().get(12);
                        System.out.println(s10);

                        DetailStep detailStep6 = new DetailStep();
                        detailStep6.setDetail(s10);
                        algorithmResult.addDetailStep(detailStep6);

                        PseudoStep pseudoStep6 = new PseudoStep();
                        pseudoStep6.setComporseStep(super.getListOfSteps().get(4).toString());
                        System.out.println(pseudoStep6.getComporseStep());
                        algorithmResult.addPseudoStep(pseudoStep6);
                    }
                }
            }
            Queue.poll();
        }
        String finalResult = ((DetailStep) super.getListOfSteps().get(13)).toStringV(super.getSourceVertex()) + super.getListOfSteps().get(14);
        DetailStep detailStep7 = new DetailStep();
        System.out.println(finalResult);
        System.out.print("\nKet qua duyet BFS ");
        finalResult = finalResult.concat("\nKet qua duyet BFS ");
        for (int i = 0; i < Visit.size(); i++) {
            System.out.print(Visit.get(i).getVertexId());
            finalResult = finalResult.concat(String.valueOf(Visit.get(i).getVertexId()));
            if (i != (Visit.size() - 1)) {
                System.out.print("->");
                finalResult = finalResult.concat("->");
            }
        }
        finalResult = finalResult.concat("\n");
        System.out.println("");
        detailStep7.setDetail(finalResult);
        algorithmResult.setFinalResult(detailStep7);
        return algorithmResult;
    }
}