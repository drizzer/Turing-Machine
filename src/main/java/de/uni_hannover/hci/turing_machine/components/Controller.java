package de.uni_hannover.hci.turing_machine.components;

import de.uni_hannover.hci.turing_machine.components.io.Module;

import de.uni_hannover.hci.turing_machine.components.model.Program;
import de.uni_hannover.hci.turing_machine.components.model.ProgramsList;
import de.uni_hannover.hci.turing_machine.components.model.Transit;
import de.uni_hannover.hci.turing_machine.components.model.TuringMachine;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.net.URL;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.BufferedReader; //Scanner
import java.io.FileReader;

import java.awt.event.ActionListener;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

import javafx.css.PseudoClass;


public class Controller extends TuringMachine implements ActionListener, Initializable {
  // JavaFx components for the User Interface

  private Stage primaryStage;
  public static Program TM = new Program(); // Object Typ Program

  //    Transit TS; //Für Tableview

  public static Scanner x; //for start Method

  PseudoClass centered = PseudoClass.getPseudoClass("centered"); // custom CSS pseudoclass for the text area

  Date date = new Date();
  SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

  public Controller() {}

  // setter method for stage variable
  public void setPrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
  }

  @Override
  public void actionPerformed(java.awt.event.ActionEvent e)  {
    /*try {
      Thread.sleep(30);
    } catch(InterruptedException ex) {
      ex.printStackTrace();
    };*/
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
  private TableView<Transit> transitionTable_txt;

  @FXML
  private Button editTransition_btn;

  @FXML
  private TextField startState_txt;

  @FXML
  private Button setStartState_btn;

  @FXML
  private TextField acceptState_txt;

  @FXML
  private Button setAcceptState_btn;

  @FXML
  private TextField operations_txt;

  @FXML
  private Button operations_btn;

  @FXML
  private TextArea statesList_txt;

  @FXML
  private Button stepBack_btn;

  @FXML
  private Button stepForward_btn;

  @FXML
  private TextArea actionsList_txt;

  @FXML
  private TextArea outputTape_txt;

  @FXML
  private TextField input_txt;

  @FXML
  private Button start_btn;

  @FXML
  private Button stop_btn;

  @FXML
  private TextArea StateChanges_txt;

  @FXML
  private TextArea steps_txt;

  @FXML
  private Font x3;

  @FXML
  private Color x4;

  @FXML
  private TableView<Program> statChangeOfState_txt;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //        transitionTable_txt.getItems().addAll(TS); //Fügt Linien hinzu
    transitionTable_txt.setEditable(true);

    //Überschriften hinzufügen
    TableColumn<Transit, String> RSt = new TableColumn<>("RSt");
    RSt.setMinWidth(50);
    TableColumn<Transit, String> RSy = new TableColumn<>("RSy");
    RSy.setMinWidth(50);
    TableColumn<Transit, String> WSt = new TableColumn<>("WSt");
    WSt.setMinWidth(50);
    TableColumn<Transit, String> WSy = new TableColumn<>("WSy");
    WSy.setMinWidth(50);
    TableColumn<Transit, String> D = new TableColumn<>("D");
    D.setMinWidth(35);

    transitionTable_txt.getColumns().addAll(RSt, RSy, WSt, WSy, D);

    // ObservableList<Transit> info = FXCollections.observableArrayList(new Transit("0", "1", "1", "0", "R")); //Fehler

    //  info.add(new Transit("0", "1", "1", "0", "R"));

    //  info.add(new Transit(TS.getone(), TS.gettwo(), TS.getthree(), TS.getfour(), TS.getfive())); //Fehler

    RSt.setCellValueFactory(new PropertyValueFactory<Transit, String>("one"));
    RSy.setCellValueFactory(new PropertyValueFactory<Transit, String>("two"));
    WSt.setCellValueFactory(new PropertyValueFactory<Transit, String>("three"));
    WSy.setCellValueFactory(new PropertyValueFactory<Transit, String>("four"));
    D.setCellValueFactory(new PropertyValueFactory<Transit, String>("five"));

    transitionTable_txt.setEditable(true); //Tableview kann verändert werden
    //  transitionTable_txt.getItems().addAll(TS);
    // transitionTable_txt.getItems(info); //Fehler

  }

  // Event Handling for load and save
  @FXML
  void load(ActionEvent event) {
    FileChooser file_chooser = new FileChooser();
    file_chooser.setTitle("Load program");
    file_chooser
      .getExtensionFilters()
      .addAll(
        new FileChooser.ExtensionFilter("Turing Machine Files", "*.turm"),
        new FileChooser.ExtensionFilter("Text Files", "*.txt")
      );
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
    file_chooser
      .getExtensionFilters()
      .addAll(
        new FileChooser.ExtensionFilter("Turing Machine Files", "*.turm"),
        new FileChooser.ExtensionFilter("Text Files", "*.txt")
      );

    EventHandler<ActionEvent> openEvent = new EventHandler<ActionEvent>() {

      public void handle(ActionEvent event) {
        // get the file selected
        // file_chooser.setSelectedExtensionFilter();
        File file = file_chooser.showSaveDialog(primaryStage);

        if (file != null) {
          Module.createFile(TM.getNameTM());
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

  // Event Handling for buttons
  @FXML
  void setName(ActionEvent event) { // TODO check übernahme
    String name = setName_txt.getText();
    TM.setNameTM(name);
    setName_txt.setText(name);
  }

  @FXML
  void setAlphabet(ActionEvent event) { // TODO check übernahme
    String temp = setAlphabet_txt.getText();
    setAlphabet_txt.setText(temp);

    String[] alphabetArray = temp.split(", ");

 /*   ArrayList<String> alphabetArrayList = new ArrayList<String>(Arrays.asList(alphabetArray));
    boolean isAdded = alphabetArrayList.addAll(Arrays.asList(alphabetArray));

    if (isAdded) {
      for (String alpha : alphabetArrayList ) {
      TM.setAlphabetSet(alpha); }
    } else {
        setAlphabet_txt.setText("Error");
      }*/

  }

  @FXML
  void setState(ActionEvent event) { // TODO check übernahme
    String state = setState_txt.getText();
    TM.addState(state);
    setState_txt.setText(""); // emptys the Textfield
    statesList_txt.appendText(state + " - ");
  }

  /**
   * This method sets the transitions in a transitionSet and prints the
   * transitions in a textfield below
   *
   * @author Lisanne Haase
   * @version v0.6
   * @param event
   * @return transitionset
   */
  @FXML
  void setTransiton(ActionEvent event) { // TODO check übernahme
    String temp = setTransition_txt.getText();
    setTransition_txt.setText("");
    
    String[] transition = temp.split(", ");
    
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

    // saves the input of transitions in Object TM
    boolean isAdded = TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);

    // if(isAdded) {}

    // Transitoins auflisten
    Transit ts = new Transit(
      transition[0],
      transition[1],
      transition[2],
      transition[3],
      transition[4]
      );
      
    actionsList_txt.setText(
      ts.getOne() + ts.getTwo() + ts.getThree() + ts.getFour() + ts.getFive()
      );

    final ObservableList<Transit> info = FXCollections.observableArrayList(ts);
    transitionTable_txt.getItems().addAll(info);

    actionsList_txt.appendText("\n" + temp);
  }

  @FXML
  void editTransition(ActionEvent event) { // ? to edit table, implement editTransitin in TuringMachine.java
    String temp = setTransition_txt.getText();
    setTransition_txt.setText("");
    
    String[] transition = temp.split(", ");
    
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
    
    /*
    // saves the input of transitions in Object TM
    TM.addTransition(rState, rSymbol, wState, wSymbol, mDirection);
    // Transitoins auflisten
    Transit ts = new Transit(
      transition[0],
      transition[1],
      transition[2],
      transition[3],
      transition[4]
      );
      
    actionsList_txt.setText(
      ts.getOne() + ts.getTwo() + ts.getThree() + ts.getFour() + ts.getFive()
      );

    ObservableList<Transit> info = FXCollections.observableArrayList(ts);
    info.add(new Transit(ts.getOne(), ts.getTwo(), ts.getThree(), ts.getFour(), ts.getFive()));
    transitionTable_txt.setItems(info);
    */
  }

  @FXML
  void setStartState(ActionEvent event) { // TODO check übernahme
    String startState = startState_txt.getText();
    startState_txt.setText(startState);
    TM.setStartState(startState);

    actionsList_txt.appendText("\n" + startState);
  }

  @FXML
  void setAcceptState(ActionEvent event) { // TODO check übernahme
    String acceptState = acceptState_txt.getText();
    acceptState_txt.setText(acceptState);
    TM.setAcceptState(acceptState);


    actionsList_txt.appendText("\n" + acceptState);
  }
  
  @FXML
  void setOperations(ActionEvent event) {

  }

  @FXML
  void start(ActionEvent event) throws IOException, FileNotFoundException {
    outputTape_txt.pseudoClassStateChanged(centered, true);
    start_btn.setText("Pause");
    start_btn.setStyle("-fx-font-size : 12");

    Tooltip tt = new Tooltip();
    tt.setText("Turing Machine is running");
    tt.setStyle(
      "-fx-font: normal bold 12 Langdon; " +
      "-fx-base: #AE3522; " +
      "-fx-text-fill: orange;"
    );

    start_btn.setTooltip(tt);

    TM = ProgramsList.EqualWordSize();
    String input = input_txt.getText();
    boolean done = TM.launch(input);

    // TM.launch(input_txt.getText());

    // Output state changes & steps statistics
    //steps_txt.setText(Integer.toString(TM.statSteps));
    //StateChanges_txt.setText(Integer.toString(TM.statChangeofstates));
    // Output Cell ID & Visits statistics ????

    String details = Module.buffReader("./src/main/java/de/uni_hannover/hci/turing_machine/components/io/output.turm");

    actionsList_txt.setText(details);


   /*

    try {
      x =
        new Scanner(
          new File(
            "./src/main/java/de/uni_hannover/hci/turing_machine/components/io/output.turm"
          )
        );
    } catch (Exception e) {
      outputTape_txt.setText("Fehler: Datei nicht auslesbar.");
    }

    while (x.hasNextLine()) {
      String s = x.nextLine();
      outputTape_txt.setText(s);
    }

    x.close(); */
  }

  @FXML
  void stepBack(ActionEvent event) {}

  @FXML
  void stepForward(ActionEvent event) {}

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
