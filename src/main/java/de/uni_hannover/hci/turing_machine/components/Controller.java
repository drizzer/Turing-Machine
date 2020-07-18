package de.uni_hannover.hci.turing_machine.components;

import de.uni_hannover.hci.turing_machine.components.model.Program;
import de.uni_hannover.hci.turing_machine.components.model.TuringMachine;

import java.io.*;
import java.lang.*;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextArea;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.awt.event.ActionListener;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
// import javafx.scene.control.cell.PropertyValueFactory;

//import components.*;

public class Controller extends TuringMachine implements ActionListener {
    // JavaFx components for the User Interface

    // Constructor vom Typ Controller

    Program TM = new Program();

    // Objekt

    public Controller() {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub

    }

    // Object Typ TuringMachine

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
    private TextArea transitionTable_txt;

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
    void load(ActionEvent event) {

    }

    @FXML
    void pause(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        try {
            File f = new File("./src/main/java/de/uni_hannover/hci/turing_machine/components/model/lib/saves/test.txt"); // New
                                                                                                                         // file
                                                                                                                         // is
                                                                                                                         // created
            boolean bool = false;
            bool = f.createNewFile(); // checks if file is already there
        } catch (Exception e) { // If file already exists
            Tooltip tt = new Tooltip();
            tt.setText("TM already exists.");
            tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");
            save_btn.setTooltip(tt);
            save_btn.setText("Error");
        }
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

        String[] transition = setTransition_txt.getText().split("; ");

        String rState = transition[0];
        char rSymbol = setTransition_txt.getText().charAt(4);
        String wState = transition[2];
        char wSymbol = setTransition_txt.getText().charAt(12);
        boolean mDirection;

        if (transition[5] == "R") {
            mDirection = true;
        } else {
            mDirection = false;
        }

        TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);
        setTransition_txt.setText(""); // empty text field
        // adds Transitions in transitionTable_txt
        transitionTable_txt.setText(TM.toString());
    }

    @FXML
    void setstartState(ActionEvent event) {
        TM.setStartState(setstartState_txt.getText());
        setstartState_txt.setText(""); // emptys textfield
    }

    @FXML
    void start(ActionEvent event) throws FileNotFoundException {

        start_btn.setText("Running..");
        start_btn.setStyle("-fx-font-size : 12");

        Tooltip tt = new Tooltip();

        tt.setText("Work is being done");
        tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");

        start_btn.setTooltip(tt);

        TM.launch(input_txt.getText());

        // Output state changes & steps statistics

        steps_txt.setText(Integer.toString(TM.statSteps));

        StateChanges_txt.setText(Integer.toString(TM.statChangeofstates));

        // Output Cell ID & Visits statistics ????
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
