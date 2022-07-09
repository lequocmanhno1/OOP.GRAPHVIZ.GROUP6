package hedspi.oop.group6.Controller;

import hedspi.oop.group6.View.Algorithm;

public class Context {
    private Algorithm algorithm;

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public void run(){
        algorithm.traversal();
    }
    
}