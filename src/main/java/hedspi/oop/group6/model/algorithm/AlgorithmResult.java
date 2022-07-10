package hedspi.oop.group6.model.algorithm;

import hedspi.oop.group6.Step.DetailStep;
import hedspi.oop.group6.Step.PseudoStep;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmResult {

    private final List<PseudoStep> pseudoSteps = new ArrayList<>();

    private final List<DetailStep> detailSteps = new ArrayList<>();

    private DetailStep finalResult;

    public List<DetailStep> getDetailSteps() {
        return detailSteps;
    }

    public void setFinalResult(DetailStep finalResult) {
        this.finalResult = finalResult;
    }



    public List<PseudoStep> getPseudoSteps() {
        return pseudoSteps;
    }

    public void addPseudoStep(PseudoStep pseudoStep){
        pseudoSteps.add(pseudoStep);
    }

    public void addDetailStep(DetailStep detailStep){
        detailSteps.add(detailStep);
    }

}
