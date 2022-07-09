/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hedspi.oop.group6.Step;

/**
 *
 * @author Trung
 */
public class PseudoStep extends Step{
    private String comporseStep;

    public PseudoStep() {
    }

    public PseudoStep(String comporseStep) {
        this.comporseStep = comporseStep;
    }

    public String getComporseStep() {
        return comporseStep;
    }

    public void setComporseStep(String comporseStep) {
        this.comporseStep = comporseStep;
    }

    @Override
    public String toString() {
        return comporseStep;
    }
}
