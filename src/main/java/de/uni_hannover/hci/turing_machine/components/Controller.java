package de.uni_hannover.hci.turing_machine.components;

import de.uni_hannover.hci.turing_machine.components.model.ProgramsList;
import de.uni_hannover.hci.turing_machine.components.model.Program;
import de.uni_hannover.hci.turing_machine.components.model.TuringMachine;

import java.io.*;
import java.lang.*;
import java.util.*;

import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.event.ActionListener;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
// import javafx.scene.control.cell.PropertyValueFactory;

//import components.*;

public class Controller extends TuringMachine implements ActionListener {
    // JavaFx components for the User Interface

    private Stage primaryStage;
    public static Program TM = new Program(); // Object Typ Program

    Date date = new Date();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public Controller() {
    }

    // setter method for stage variable
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @FXML
    private HBox mainBox;

    @FXML
    private AnchorPane config_pane;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Button load_btn;

    @FXML
    private Button save_btn;

    @FXML
    private TextField setName_txt;

    @FXML
    private Button setName_btn;

    @FXML
    private TextField setAlphabet_txt;

    @FXML
    private Button setAlphabet_btn;

    @FXML
    private TextField setState_txt;

    @FXML
    private Button setState_btn;

    @FXML
    private TextField setTransition_txt;

    @FXML
    private Button setTransition_btn;

    @FXML
    private Button editTransition_btn;

    // Variable Output State Transitions

    @FXML
    private TextField input_txt;

    @FXML
    private Button stop_btn;

    @FXML
    private Button start_btn;

    @FXML
    private Button pause_btn;

    @FXML
    private Button stepBack_btn;

    @FXML
    private Button stepForward_btn;

    @FXML
    private Button setstartState_btn;

    @FXML
    private Button acceptState_btn;

    @FXML
    private TextField acceptState_txt;

    @FXML
    private TextField setstartState_txt;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private TableView<?> transitionTable_txt;

    @FXML
    private TextArea actionsList_txt;

    @FXML
    private TextArea outputTape_txt;

    @FXML
    private TextArea StateChanges_txt;

    @FXML
    private TextArea steps_txt;

    @FXML
    private TextArea CellidVisits_txt;

    // Methods for input and buttons of GUI
    @FXML
    void acceptState(ActionEvent event) {
        setAcceptState(acceptState_txt.getText());
        acceptState_txt.setText(""); // emptys textfield
    }

    @FXML
    void editTransiton(ActionEvent event) {

    }

    @FXML
    void setAlphabet(ActionEvent event) {
        String temp = setAlphabet_txt.getText();
        setAlphabet_txt.setText(""); // emptys textfield
        TM.setnewAlphabet(setAlphabet_txt.getText());
        setTransition_txt.setText(temp); // empty text field
    }

    @FXML
    void setName(ActionEvent event) {
        TM.setNameTM(setName_txt.getText());
        setName_txt.setText(""); // emptys textfield
        actionsList_txt.setText(TM.getNameTM());

    }

    @FXML
    void setState(ActionEvent event) {
        TM.addState(setState_txt.getText());
        setState_txt.setText(""); // emptys the Textfield
    }

    /**
     * This method sets the transitions in a transitionSet and prints the
     * transitions in a textfield below
     * 
     * @author Lisanne Haase
     * @version v0.4
     * @param event
     * @return transitionset
     */
    @FXML
    void setTransiton(ActionEvent event) {
        // saves the input of transitions in Object TM
        String temp2 = setTransition_txt.getText();

        // transitionTable_txt.setText(temp2);

        setTransition_txt.setText("");

        String[] transition = temp2.split("; ");

        String rState = transition[0];
        char rSymbol = temp2.charAt(4);
        String wState = transition[2];
        char wSymbol = temp2.charAt(12);
        boolean mDirection;

        if (transition[5] == "R") {
            mDirection = true;
        } else {
            mDirection = false;
        }

        TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);
        // Transitoins auflisten
        // transitionTable_txt.setText(temp2);
    }

    @FXML
    void setstartState(ActionEvent event) {
        TM.setStartState(setstartState_txt.getText());
        setstartState_txt.setText(""); // emptys textfield
    }

    @FXML
    void start(ActionEvent event) throws IOException, FileNotFoundException {
        start_btn.setText("Running..");
        start_btn.setStyle("-fx-font-size : 12");

        Tooltip tt = new Tooltip();
        tt.setText("Work is being done");
        tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");
        start_btn.setTooltip(tt);

        Program TM1 = ProgramsList.EqualWordSize();
        boolean done = TM1.launch("aaa#bbb");

        // TM.launch(input_txt.getText());

        // Output state changes & steps statistics
        steps_txt.setText(Integer.toString(TM.statSteps));
        StateChanges_txt.setText(Integer.toString(TM.statChangeofstates));
        // Output Cell ID & Visits statistics ????
    }

    @FXML
    void pause(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Load program");
        file_chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Turing Machine Files", "*.turm"));
        EventHandler<ActionEvent> openEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                // get the file selected
                File file = file_chooser.showOpenDialog(primaryStage);

                if (file != null) {
                    actionsList_txt.setText(file.getAbsolutePath() + "  loaded");
                }

            }
        };
        load_btn.setOnAction(openEvent);
    }

    @FXML
    void save(ActionEvent event) {

        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Save program");
        file_chooser.setInitialFileName("Program " + dateFormatter.format(date));
        file_chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Turing Machine Files", "*.turm"));

            EventHandler<ActionEvent> openEvent = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    // get the file selected
                // file_chooser.setSelectedExtensionFilter();
                File file = file_chooser.showSaveDialog(primaryStage);

                if (file != null) {
                    actionsList_txt.setText(file.getAbsolutePath() + "  saved");
                }

            }
        };
        save_btn.setOnAction(openEvent);
/*
        try {
            File f = new File("./src/main/java/de/uni_hannover/hci/turing_machine/components/model/lib/saves/test.txt");
            boolean bool = false;
            bool = f.createNewFile(); // checks if file is already there
        } catch (Exception e) { // If file already exists
            Tooltip tt = new Tooltip();
            tt.setText("TM already exists.");
            tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");
            save_btn.setTooltip(tt);
            save_btn.setText("Error");
        }
        */
    }

    @FXML
    void stepBack(ActionEvent event) {

    }

    @FXML
    void stepForward(ActionEvent event) {

    }

    /**
     * this method stops the programm completely
     * 
     * @param event
     * @return void
     */
    @FXML
    void stop(ActionEvent event) {
        System.exit(0);
    }

}
