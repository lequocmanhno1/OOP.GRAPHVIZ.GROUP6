package hedspi.oop.group6.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;

public class HiddenController {

    @FXML
    private ScrollPane DetailCont;

    @FXML
    private TextArea detailTextArea;

    @FXML
    private AnchorPane hiddenRoot;

    @FXML
    private TextArea pseudoTextArea;

    @FXML
    private ScrollPane psudoCont;

    @FXML
    private TextFlow psudoFlow;

    @FXML
    private TextFlow textDetail;

    public void writeTextDetail(String content){
//        detailTextArea.
        detailTextArea.appendText(content + "\n");
    }


}

