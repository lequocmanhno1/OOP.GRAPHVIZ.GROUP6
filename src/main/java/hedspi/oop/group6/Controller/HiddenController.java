package hedspi.oop.group6.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class HiddenController {

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

    public int writeTextDetail(String content){
        Label label = new Label(content);
//        label.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");
//        label.setFont(new Font("Roboto",15));
        label.setMinWidth(300);
        detailLabels.add(label);
        detailFlow.getChildren().add(label);
        return detailLabels.size() - 1;
    }

}
