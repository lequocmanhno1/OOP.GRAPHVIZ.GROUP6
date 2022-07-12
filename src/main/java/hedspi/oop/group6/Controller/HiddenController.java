package hedspi.oop.group6.Controller;

import hedspi.oop.group6.Step.DetailStep;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

import java.io.Console;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HiddenController implements Initializable {

    @FXML
    private ScrollPane DetailCont;

    @FXML
    private TextFlow detailFlow;

    @FXML
    private AnchorPane hiddenRoot;

    @FXML
    private ScrollPane psudoCont;

    @FXML
    private TextFlow psudoFlow;

    private final List<Label> detailLabels = new ArrayList<>();

    private final List<Label> pseudoLabels = new ArrayList<>();

    public int writeTextDetail(String content) {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

//        label.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
//        label.setFont(new Font("Roboto",15));
                Label label = new Label(content);
                System.out.println(content);
                label.setMinWidth(300);
                detailLabels.add(label);
                if(detailFlow.getChildren().size() > 8){
                    detailFlow.getChildren().remove(0);
                }
                detailFlow.getChildren().add(label);

            }

        });
        return detailLabels.size() - 1;

    }

    public void clear(){
        detailLabels.clear();
        detailFlow.getChildren().clear();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DetailCont.needsLayoutProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                DetailCont.setVvalue(1.00);
            }
        });
    }
}
