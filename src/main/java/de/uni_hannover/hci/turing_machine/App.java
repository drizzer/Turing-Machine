package de.uni_hannover.hci.turing_machine;

import de.uni_hannover.hci.turing_machine.components.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.BufferedReader; //Scanner
import java.io.FileReader;

// VM options: --module-path %PATH_TO_FX%  --add-modules=javafx.controls,javafx.fxml

public class App extends Application {
    Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
            Parent root = (Parent) loader.load();
            Controller controller = (Controller) loader.getController(); // getting instance of the controller
            controller.setPrimaryStage(primaryStage); // set stage
            primaryStage.setTitle("Turing Machine");
            primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/icon.png"))); //Bild GUI
            Scene scene = new Scene(root, 1280, 800);
            scene.getStylesheets().addAll(this.getClass().getResource("/style.css").toExternalForm()); //Style Bild
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
