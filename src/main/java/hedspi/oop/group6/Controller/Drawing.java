package hedspi.oop.group6.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXToggleButton;
import hedspi.oop.group6.Model.Edge;
import hedspi.oop.group6.Model.Vertex;
import hedspi.oop.group6.ModelFX.Arrow;
import hedspi.oop.group6.ModelFX.NodeFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import org.controlsfx.control.HiddenSidesPane;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXSlider;


import javafx.scene.text.Font;
import java.net.URL;
import java.security.Timestamp;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.StrokeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class Drawing implements Initializable {
    private String dir = System.getProperty("user.dir") + "/target/classes/images/";

    @FXML
    private JFXToggleButton addEdgeButton;

    @FXML
    private JFXToggleButton addVertexButton;

    @FXML
    private ToggleGroup algoToggleGroup;

    @FXML
    private AnchorPane anchorRoot;

    @FXML
    private JFXToggleButton bfsButton;

    @FXML
    private JFXToggleButton bitButton;

    @FXML
    private Pane border;

    @FXML
    private ImageView canvasBack;

    @FXML
    private JFXButton canvasBackButton;

    @FXML
    private Group canvasGroup;

    @FXML
    private ChoiceBox<String> choiceExGraph;
    private String[] ExGraph = {"Drawing","CP3 4.9 DG", "Graph 8-24 Bit", "Graph 8-14 SCC" };
    @FXML
    private JFXButton clearButton;

    @FXML
    private JFXButton gear;

    @FXML
    private HiddenSidesPane hiddenPane;

    public AnchorPane hiddenRoot = new AnchorPane();

    public static TextArea textFlow = new TextArea();
    public ScrollPane textContainer = new ScrollPane();

    private int selectedVertex = -1;



    @FXML
    private ImageView openHidden;


    @FXML
    private JFXButton playPauseButton;

    @FXML
    private ImageView playPauseImage;

    @FXML
    private ImageView FastForwardImage;
    @FXML
    private JFXButton resetButton;

    @FXML
    private JFXToggleButton sccButton;

    @FXML
    private StackPane stackRoot;

    @FXML
    private JFXNodesList vertexList;

    @FXML
    private Pane viewer;

    int nNode = 0;
    NodeFX selectedNode = null;
    List<NodeFX> vertexes = new ArrayList<>();
    List<Edge> mstEdges = new ArrayList<>();
    List<Edge> realEdges = new ArrayList<>();
//    List<Shape> edges = new ArrayList<>();

    boolean addNode = true, addEdge = false, calculate = false,
            calculated = false, playing = false, paused = false, pinned = false;


    @FXML
    void AddHandle(ActionEvent event){
        if(addVertexButton.isSelected() == true) {
            addEdgeButton.setSelected(false);
            selectedNode = null;
        }
        if(addEdgeButton.isSelected() == true) {
            addVertexButton.setSelected(false);
        }
    }

    @FXML
    void BfsHandle(ActionEvent event) {

    }

    @FXML
    void BitHandle(ActionEvent event) {

    }

    @FXML
    void ClearHandle(ActionEvent event) {

    }

    @FXML
    void PlayPauseHandle(ActionEvent event) {

    }

    @FXML
    void ResetHandle(ActionEvent event) {
        canvasGroup.getChildren().clear();
        canvasGroup.getChildren().addAll(viewer);
        selectedNode = null;
        vertexes = new ArrayList<NodeFX>();
        addVertexButton.setSelected(false);
        addEdgeButton.setSelected(false);
//        addEdgeButton.setDisable(true);
//        addVertexButton.setDisable(false);
        nNode = 0;
    }

    @FXML
    void SccHandle(ActionEvent event) {

    }

//    @FXML
//    void nothing(MouseEvent event){
//
//    }

    long start = System.currentTimeMillis();
    @FXML
    void handle(MouseEvent event) {
        long time = System.currentTimeMillis() - start;
        if (addVertexButton.isSelected() == false ||  event.getEventType() != MouseEvent.MOUSE_CLICKED || time < 100) return;

        double x = event.getX();
        double y = event.getY();
        double rad = 12;
        NodeFX nodeFX = new NodeFX(x, y, rad, new Vertex(nNode), String.valueOf(nNode));

        nodeFX.setOnMouseClicked((mouseEvent -> {
            if(selectedVertex != -1){
                NodeFX vertexFrom = vertexes.get(selectedVertex);
                NodeFX vertexTo = nodeFX;
                Arrow arrow = new Arrow(vertexFrom, vertexTo);
                canvasGroup.getChildren().add(arrow);
                selectedVertex = -1;
            } else {
                this.selectedVertex = Integer.parseInt(nodeFX.getLabel().getText());
                System.out.println(selectedVertex);
            }
        }));

        nodeFX.getLabel().setOnMouseClicked((mouseEvent -> {
            this.selectedVertex = Integer.parseInt(nodeFX.getLabel().getText());
            System.out.println(selectedVertex);
        }));



        nodeFX.setFill(Color.GRAY);
        canvasGroup.getChildren().add(nodeFX);
        canvasGroup.getChildren().add(nodeFX.getLabel());
        vertexes.add(nodeFX);
        System.out.println(event.getEventType() + String.valueOf(nNode) + String.valueOf(event.getClickCount()));
        nNode += 1;


//        FillTransition ft = new FillTransition(Duration.millis(300), circle, Color.BLACK, Color.RED);
//        ft.play();
//        NodeFX circle = (NodeFX) mouseEvent.
//        circle.isSelected = true;
//        selectedNode = circle;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            openHidden.setImage(getImage("openHidden.png"));
            canvasBack.setImage(getImage("arrow_back_black_96x96.png"));
            playPauseImage.setImage(getImage("pause_black_48x48.png"));
            FastForwardImage.setImage(getImage("fast_forward_black_48x48.png"));
            choiceExGraph.getItems().addAll(ExGraph);
    }

    private JFXSlider slider = new JFXSlider();

    private Image getImage(String name) {
        try {
            File file = new File(dir + name);
            return new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

