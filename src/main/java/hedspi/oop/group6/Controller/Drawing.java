package hedspi.oop.group6.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXToggleButton;
import hedspi.oop.group6.Controller.context.BFSContext;
import hedspi.oop.group6.Controller.context.Context;
import hedspi.oop.group6.model.graph.Graph;
import hedspi.oop.group6.model.graph.Vertex;
import hedspi.oop.group6.ModelFX.DirectedEdgeFX;
import hedspi.oop.group6.ModelFX.NodeFX;
import hedspi.oop.group6.model.algorithm.Algorithm;
import hedspi.oop.group6.model.algorithm.BFS;
import hedspi.oop.group6.model.algorithm.BipartiteGraph;
import hedspi.oop.group6.model.algorithm.SCC;
import hedspi.oop.group6.graphproject.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
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


import java.io.IOException;
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
    private Button showHidden;

    @FXML
    private Group canvasGroup;

    @FXML
    private ChoiceBox<String> choiceExGraph;
    private final String[] ExGraph = {"Drawing", "CP3 4.9 DG", "Graph 8-24 Bit", "Graph 8-14 SCC"};
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

    @FXML
    private Button runBtn;

    @FXML
    private HiddenController hiddenController;


    @FXML
    void runAlgo(ActionEvent event) {
        if (sourceAlgo == -1) {
            algorithm.setSourceVertex(g.findVertex(0));
        } else {
            algorithm.setSourceVertex(g.findVertex(sourceAlgo));
        }
        Collections.sort(algorithm.getGraph().getListOfEdges());
        context.setAlgorithm(algorithm);
        context.execute();

        context.setEdges(mstEdges);
        context.setVertexes(vertexes);
        context.setHiddenController(hiddenController);

        Thread t1 = new Thread(context);
        t1.start();
    }

    int nNode = 0;
    NodeFX selectedNode = null;
    List<NodeFX> vertexes = new ArrayList<>();
    List<DirectedEdgeFX> mstEdges = new ArrayList<>();

    boolean addNode = true, addEdge = false, calculate = false,
            calculated = false, playing = false, paused = false, pinned = false;

    private Algorithm algorithm;

    @FXML
    void AddHandle(ActionEvent event) {
        if (addVertexButton.isSelected()) {
            addEdgeButton.setSelected(false);
            selectedNode = null;
        }
        if (addEdgeButton.isSelected()) {
            addVertexButton.setSelected(false);
        }
    }

    private Context context;

    private Graph g = new Graph();

    @FXML
    void BfsHandle(ActionEvent event) {
        algorithm = new BFS(g);
        context = new BFSContext();
    }

    @FXML
    void BitHandle(ActionEvent event) {
        algorithm = new BipartiteGraph(g);
    }

    @FXML
    void SccHandle(ActionEvent event) {
        algorithm = new SCC(g);
    }

    @FXML
    void ClearHandle(ActionEvent event) {
        canvasGroup.getChildren().clear();
        canvasGroup.getChildren().addAll(viewer);
        selectedNode = null;
        vertexes = new ArrayList<NodeFX>();
        addVertexButton.setSelected(false);
        addEdgeButton.setSelected(false);
        nNode = 0;
    }

    @FXML
    void PlayPauseHandle(ActionEvent event) {

    }

    @FXML
    void ResetHandle(ActionEvent event) {
        for (NodeFX nodeFX: vertexes){
            nodeFX.setFill(Color.GRAY);
        }
        for (DirectedEdgeFX directedEdgeFX: mstEdges){
            directedEdgeFX.setFill(Color.BLACK);
        }
    }


    private int sourceAlgo = -1;

    long start = System.currentTimeMillis();

    @FXML
    void handle(MouseEvent event) {
        long time = System.currentTimeMillis() - start;
        if (!addVertexButton.isSelected() || event.getEventType() != MouseEvent.MOUSE_CLICKED || time < 100) return;

        double x = event.getX();
        double y = event.getY();
        double rad = 12;
        NodeFX nodeFX = new NodeFX(x, y, rad, new Vertex(nNode), String.valueOf(nNode));
        g.addVertex(nodeFX.getVertex());

        nodeFX.setOnMouseClicked((mouseEvent -> {
            // add Edge
            if (selectedVertex != -1 && addEdgeButton.isSelected()) {
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
            if (addEdgeButton.isSelected() == false && addVertexButton.isSelected() == false) {
                if (nodeFX.getVertex().getColor() == -1) {
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
        playPauseImage.setImage(getImage("pause_black_48x48.png"));
        FastForwardImage.setImage(getImage("fast_forward_black_48x48.png"));
        choiceExGraph.getItems().addAll(ExGraph);
        URL url1 = App.class.getResource("HidenPanel.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url1);
        try {
            hiddenRoot = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        hiddenController = fxmlLoader.getController();

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

    private boolean isHiddenPaneVisible = false;
    @FXML
    void showHiddenPane(ActionEvent event) {
        if(!isHiddenPaneVisible){
            hiddenPane.setContent(hiddenRoot);
            hiddenPane.show(Side.RIGHT);
            isHiddenPaneVisible = true;
        } else {
            hiddenPane.setContent(null);
            hiddenPane.hide();
            isHiddenPaneVisible = false;
        }

    }

}

