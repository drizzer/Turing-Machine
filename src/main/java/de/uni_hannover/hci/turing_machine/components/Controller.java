package de.uni_hannover.hci.turing_machine.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Tooltip;
import de.uni_hannover.hci.turing_machine.components.model.TuringMachine;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.event.ActionListener;

//import components.*;


public class Controller extends TuringMachine implements ActionListener {
    // JavaFx components for the User Interface

    /**
     * Constructor vom Typ Controller
     */
    public Controller()
    {
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Object Typ TuringMachine
     */
    TuringMachine TM = new TuringMachine();


    
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

    @FXML
    private TableView<?> transitionTable_txt;

    @FXML
    private TextField input_txt;

    @FXML
    private Button stop_btn;

    @FXML
    private Button start_btn;

    @FXML
    private Button pause_btn;

    @FXML
    private TableView<?> outputTape_txt;

    @FXML
    private Button stepBack_btn;

    @FXML
    private Button stepForward_btn;

    @FXML
    private TableView<?> actionsList_txt;

    @FXML
    private TableView<?> stepsStateChanges_txt;

    @FXML
    private TableView<?> CellidVisits_txt;

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
/**
 * Methods for input and buttons of GUI
 */
    @FXML
    void acceptState(ActionEvent event) {
        setAcceptState(acceptState_txt.getText());

    }

    @FXML
    void editTransiton(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {

    }

    @FXML
    void new_CellidVisits_txt(ActionEvent event) {

    }

    @FXML
    void new_outputTape_txt(ActionEvent event) {

    }

    @FXML
    void pause(ActionEvent event) {
      
    }

    @FXML
    void save(ActionEvent event) {
        try { 

            File f = new File("test.txt"); //New file is created
            boolean bool = false;
            bool = f.createNewFile(); //checks if file is already there
           

        }
        catch (Exception e) { //If file already exists

            Tooltip tt = new Tooltip();
            tt.setText("TM already exists.");
            tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");
            save_btn.setTooltip(tt);

            save_btn.setText("Error");
            
        }

    }

    @FXML
    void setAlphabet(ActionEvent event) {
        TM.setAlphabet(setAlphabet_txt.getText());
    }

    @FXML
    void setName(ActionEvent event) {
        TM.setNameTM(setName_txt.getText());
    }

    @FXML
    void setState(ActionEvent event) {
        TM.addState(setState_txt.getText());
    }

    @FXML
    void setTransiton(ActionEvent event) {

        String[] transition = setTransition_txt.getText().split(";");

        String rState = transition[0];
        char rSymbol = setTransition_txt.getText().charAt(4);
        String wState = transition[2];
        char wSymbol = setTransition_txt.getText().charAt(12);
         boolean mDirection;

        if(transition[5] == "R"){
            mDirection = true;
        } else {
            mDirection = false;
        }

        TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);
    }

    @FXML
    void setstartState(ActionEvent event) {
        TM.setStartState(setstartState_txt.getText());
    }

    @FXML
    void start(ActionEvent event) {

        start_btn.setText("Running..");
        start_btn.setStyle("-fx-font-size : 12");

        Tooltip tt = new Tooltip();

        tt.setText("Work is being done");
        tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");

        start_btn.setTooltip(tt);

    }

    @FXML
    void stepBack(ActionEvent event) {

    }

    @FXML
    void stepForward(ActionEvent event) {

    }

    /**
     * this method stops the programm completely
     * @param event
     * @return void
     */
    @FXML
    void stop(ActionEvent event) {
        System.exit(0);
    }

}

