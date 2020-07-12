package de.uni_hannover.hci.turing_machine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// VM options: --module-path %PATH_TO_FX%  --add-modules=javafx.controls,javafx.fxml

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));
        primaryStage.setTitle("Turing Machine");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*
     * public static void (old)main(String[] args) {
     * 
     * // TuringMachine TM1 = ProgramsList.EqualWordSize(); // boolean done =
     * TM1.Run("aaa#bbb");
     * 
     * TuringMachine TM2 = ProgramsList.Anagram(); boolean done =
     * TM2.Run("aab#aba");
     * 
     * String As&Bs = "As&Bs.txt"; //Programm As&Bs wird eingelesen
     * ladeDatei(As&Bs);
     * 
     * String Annagramm = "Annagramm.txt"; //Programm Annagramm wird eingelesen
     * ladeDatei(Annagramm);
     * 
     * if (done == true) { System.out.println("The input was accepted."); } else {
     * System.out.println("The input was rejected."); } }
     */

}
