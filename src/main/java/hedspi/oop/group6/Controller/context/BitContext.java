package hedspi.oop.group6.Controller.context;

import hedspi.oop.group6.ModelFX.EdgeFX;
import hedspi.oop.group6.ModelFX.NodeFX;
import hedspi.oop.group6.Step.DetailStep;
import hedspi.oop.group6.Step.EdgeStep;
import hedspi.oop.group6.Step.VertexStep;
import hedspi.oop.group6.model.graph.Edge;
import hedspi.oop.group6.model.graph.Vertex;
import javafx.scene.paint.Color;

import java.util.concurrent.TimeUnit;

public class BitContext extends Context {
    @Override
    public void visualize() {
        for (DetailStep detailStep : result.getDetailSteps()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            hiddenController.writeTextDetail(detailStep.getDetail());
            if (detailStep instanceof VertexStep) {
                VertexStep vertexStep = (VertexStep) detailStep;
                Vertex vertex = vertexStep.getVertex();
                NodeFX nodeFX = vertexes.get(vertex.getVertexId());
                nodeFX.setFill(Color.RED);
            }
            if (detailStep instanceof EdgeStep) {
                EdgeStep edgeStep = (EdgeStep) detailStep;
                Edge edge = edgeStep.getEdge();
                EdgeFX myEdge = null;
                for (EdgeFX edgeFX : edges) {
                    if (edgeFX.getEdge().equals(edge)) {
                        myEdge = edgeFX;
                        break;
                    }
                }
                myEdge.setFill(Color.ORANGE);

            }
            hiddenController.writeTextDetail(result.getFinalResult().getDetail());
        }
    }
}
