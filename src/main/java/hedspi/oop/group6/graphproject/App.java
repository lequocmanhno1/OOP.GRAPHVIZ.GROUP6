package hedspi.oop.group6.graphproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Draw.fxml"));
            window = primaryStage;
            Parent root = fxmlLoader.load();
            Scene menu = new Scene(root, 1400, 600);



//            primaryStage.setTitle("Graph Visualizer");
//            primaryStage.setScene(menu);
//            primaryStage.show();
            window.setTitle("Graph Visualizer");
            window.setScene(menu);
            window.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static void main(String[] args) {
        launch(args);
    }
}
