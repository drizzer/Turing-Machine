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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.beans.property.SimpleStringProperty;


import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.awt.event.ActionListener;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

//Kopie 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.scene.control.cell.PropertyValueFactory;

//import components.*;

public class Controller extends TuringMachine implements ActionListener, Initializable {

    
    // JavaFx components for the User Interface

    private Stage primaryStage;
    public static Program TM = new Program(); // Object Typ Program

    Transit TS; //Für Tableview

    public static Scanner x; //for start Method

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
    private TableView<Transit> transitionTable_txt;

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
    void setName(ActionEvent event) { // ! GUT
        TM.setNameTM(setName_txt.getText());
        setName_txt.setText(""); // emptys textfield
        actionsList_txt.setText(TM.getNameTM() + "\n");

    }

    @FXML
    void setAlphabet(ActionEvent event) { // TODO check übernahme
        String temp = setAlphabet_txt.getText();
        setAlphabet_txt.setText(""); // emptys textfield
        TM.setnewAlphabet(setAlphabet_txt.getText());
        setTransition_txt.setText(temp); // empty text field
        actionsList_txt.appendText(TM.getAlphabetSet());
    }

    @FXML
    void setState(ActionEvent event) { // ! GUT
        String state = setState_txt.getText();
        TM.addState(state);
        setState_txt.setText(""); // emptys the Textfield
        actionsList_txt.appendText("\n" + state);
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
    void setTransiton(ActionEvent event) { // TODO check übernahme
        // saves the input of transitions in Object TM
        String temp2 = setTransition_txt.getText();
        // transitionTable_txt.setText(temp2);
        setTransition_txt.setText("");

        String[] transition = temp2.split(", ");

        String rState = transition[0];
        char rSymbol = transition[1].toCharArray()[0];
        String wState = transition[2];
        char wSymbol = transition[3].toCharArray()[0];
        boolean mDirection;

            if (transition[4] == "R") {
            mDirection = true;
        } else {
            mDirection = false;
        }
       TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);

        actionsList_txt.appendText("\n" + temp2);

        // Transitoins auflisten
        TS = new Transit(transition[0], transition[1], transition[2], transition[3], transition[4]);

        transitionTable_txt.getItems().addAll(TS); //Fehler

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TableColumn<Transit, String> RSt = new TableColumn<>("RSt");
        RSt.setMinWidth(50);
        TableColumn<Transit, String> RSy = new TableColumn<>("RSy");
        RSy.setMinWidth(50);
        TableColumn<Transit, String> ST = new TableColumn<>("ST");
        ST.setMinWidth(50);
        TableColumn<Transit, String> WSy = new TableColumn<>("WSy");
        WSy.setMinWidth(50);
        TableColumn<Transit, String> D = new TableColumn<>("D");
        D.setMinWidth(50);

        transitionTable_txt.getColumns().addAll(RSt, RSy, ST, WSy, D);

        ObservableList<Transit> info = FXCollections.observableArrayList(); //Fehler

        info.add(new Transit("0", "1", "1", "0", "R"));

//        info.add(new Transit(TS.getone(), TS.gettwo(), TS.getthree(), TS.getfour(), TS.getfive())); //Fehler

        RSt.setCellValueFactory(new PropertyValueFactory<>("RSt"));
        RSy.setCellValueFactory(new PropertyValueFactory<>("RSy"));
        ST.setCellValueFactory(new PropertyValueFactory<>("ST"));
        WSy.setCellValueFactory(new PropertyValueFactory<>("WSy"));
        D.setCellValueFactory(new PropertyValueFactory<>("D"));

        transitionTable_txt.getItems().addAll(info); //Fehler
        
    }






    @FXML
    void editTransiton(ActionEvent event) {




        ObservableList<Transit> info = FXCollections.observableArrayList();

        info.add(new Transit(TS.getone(), TS.gettwo(), TS.getthree(), TS.getfour(), TS.getfive()));

        transitionTable_txt.setItems(info);
        

    }






    @FXML
    void setstartState(ActionEvent event) { // ! GUT
        String startState = setstartState_txt.getText();
        TM.setStartState(startState);
        setstartState_txt.setText(""); // emptys textfield
        actionsList_txt.appendText("\n" + startState );
    }

    @FXML
    void acceptState(ActionEvent event) {
        String acceptState = acceptState_txt.getText();
        setAcceptState(acceptState);
        acceptState_txt.setText(""); // emptys textfield
        actionsList_txt.appendText("\n" + acceptState );
    }

    @FXML
    void start(ActionEvent event) throws IOException, FileNotFoundException {
        start_btn.setText("Running..");
        start_btn.setStyle("-fx-font-size : 12");

        Tooltip tt = new Tooltip();
        tt.setText("Work is being done");
        tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " + "-fx-text-fill: orange;");
        start_btn.setTooltip(tt);


        TM = ProgramsList.EqualWordSize();
        String input = input_txt.getText();
        boolean done = TM.launch(input);

        // TM.launch(input_txt.getText());

        // Output state changes & steps statistics
        //steps_txt.setText(Integer.toString(TM.statSteps));
        //StateChanges_txt.setText(Integer.toString(TM.statChangeofstates));
        // Output Cell ID & Visits statistics ????

        

        try {
            x = new Scanner(new File("./src/main/java/de/uni_hannover/hci/turing_machine/components/io/output.txt"));

        } catch (Exception e) {
            outputTape_txt.setText("Fehler: Datei nicht auslesbar.");
        }

        while(x.hasNextLine()) {
            String s = x.nextLine();
            outputTape_txt.setText(s);
        }

        x.close(); 
    }

    @FXML
    void pause(ActionEvent event) {

    }

    @FXML
    void load(ActionEvent event) {
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Load program");
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
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
        file_chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
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
         * try { File f = new File(
         * "./src/main/java/de/uni_hannover/hci/turing_machine/components/model/lib/saves/test.txt"
         * ); boolean bool = false; bool = f.createNewFile(); // checks if file is
         * already there } catch (Exception e) { // If file already exists Tooltip tt =
         * new Tooltip(); tt.setText("TM already exists.");
         * tt.setStyle("-fx-font: normal bold 12 Langdon; " + "-fx-base: #AE3522; " +
         * "-fx-text-fill: orange;"); save_btn.setTooltip(tt);
         * save_btn.setText("Error"); }
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
