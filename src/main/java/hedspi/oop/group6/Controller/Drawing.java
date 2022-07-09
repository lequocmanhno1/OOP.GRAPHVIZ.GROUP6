package hedspi.oop.group6.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXToggleButton;
import hedspi.oop.group6.Model.Graph;
import hedspi.oop.group6.Model.Vertex;
import hedspi.oop.group6.ModelFX.DirectedEdgeFX;
import hedspi.oop.group6.ModelFX.NodeFX;
import hedspi.oop.group6.View.Algorithm;
import hedspi.oop.group6.View.BFS;
import hedspi.oop.group6.View.BipartiteGraph;
import hedspi.oop.group6.View.SCC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.HiddenSidesPane;

import com.jfoenix.controls.JFXSlider;


import java.net.URL;
import java.util.*;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.paint.Color;

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
    private final String[] ExGraph = {"Drawing","CP3 4.9 DG", "Graph 8-24 Bit", "Graph 8-14 SCC" };
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
    List<DirectedEdgeFX> mstEdges = new ArrayList<>();

    boolean addNode = true, addEdge = false, calculate = false,
            calculated = false, playing = false, paused = false, pinned = false;


    @FXML
    void AddHandle(ActionEvent event){
        if(addVertexButton.isSelected()) {
            addEdgeButton.setSelected(false);
            selectedNode = null;
        }
        if(addEdgeButton.isSelected()) {
            addVertexButton.setSelected(false);
        }
    }

    private Context context = new Context();

    private Graph g = new Graph();
    @FXML
    void BfsHandle(ActionEvent event) {
        Algorithm algorithm = new BFS(g);



        algorithm.setSourceVertex(g.findVertex(sourceAlgo));
        context.setAlgorithm(algorithm);
        context.run();
    }

    @FXML
    void BitHandle(ActionEvent event) {
        Algorithm test = new BipartiteGraph(g);
        test.setSourceVertex(g.findVertex(sourceAlgo));
        context.setAlgorithm(test);
        context.run();
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
        Algorithm test2 = new SCC(g);
        test2.setSourceVertex(g.findVertex(sourceAlgo));
        context.setAlgorithm(test2);
        context.run();
    }

    private int sourceAlgo=-1;

    long start = System.currentTimeMillis();
    @FXML
    void handle(MouseEvent event) {
        long time = System.currentTimeMillis() - start;
        if (!addVertexButton.isSelected() ||  event.getEventType() != MouseEvent.MOUSE_CLICKED || time < 100) return;

        double x = event.getX();
        double y = event.getY();
        double rad = 12;
        NodeFX nodeFX = new NodeFX(x, y, rad, new Vertex(nNode), String.valueOf(nNode));
        g.addVertex(nodeFX.getVertex());

        nodeFX.setOnMouseClicked((mouseEvent -> {
            // add Edge
            if(selectedVertex != -1 && addEdgeButton.isSelected()){
                NodeFX vertexFrom = vertexes.get(selectedVertex);
                NodeFX vertexTo = nodeFX;
                DirectedEdgeFX directedArrow = new DirectedEdgeFX(vertexFrom, vertexTo);
                g.addEdge(directedArrow.getEdge());
                mstEdges.add(directedArrow);
                canvasGroup.getChildren().add(directedArrow);
                selectedVertex = -1;
            } else {
                this.selectedVertex = Integer.parseInt(nodeFX.getLabel().getText());
                System.out.println(selectedVertex);
            }


            // Choose source vertex
            if(addEdgeButton.isSelected() == false && addVertexButton.isSelected() == false){
                if(nodeFX.getVertex().getColor() == -1) {
                    if (sourceAlgo != -1) {
                        vertexes.get(sourceAlgo).getVertex().setColor(-1);
                        vertexes.get(sourceAlgo).setFill(Color.GRAY);
                    }

                    nodeFX.setFill(Color.RED);
                    nodeFX.getVertex().setColor(0);
                    sourceAlgo = nodeFX.getVertex().getVertexId();

                } else {
                    nodeFX.setFill(Color.GRAY);
                    nodeFX.getVertex().setColor(-1);
                    sourceAlgo = -1;
                }
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

