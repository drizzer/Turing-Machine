package de.uni_hannover.hci.turing_machine.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Tooltip;
import de.uni_hannover.hci.turing_machine.TuringMachine;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Controller extends TuringMachine {
    // JavaFx components for the User Interface

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

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


    // Event Handling

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
    void new_setAlphabet_txt(ActionEvent event) {

    }

    @FXML
    void new_setName_txt(ActionEvent event) {

    }

    @FXML
    void new_setState_txt(ActionEvent event) {

    }

    @FXML
    void new_setTransition_txt(ActionEvent event) {

    }

        /**
         * This method takes the execution of the TM on hold until the start button is pressed.
         * @param event
         * @return void
         */
    @FXML
    void pause(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void setAlphabet(ActionEvent event) {

    }

    @FXML
    void setInput_txt(ActionEvent event) {

    }

    @FXML
    void setName(ActionEvent event) {


    }

    @FXML
    void setState(ActionEvent event) { 
        addState(getSetState_txt().getText());
    }

    @FXML
    void setTransiton(ActionEvent event) {
        String str = getSetTransition_txt().getText().split(", ");
        String part1 = str[0];
        String part2 = str[1];
        String part3 = str[2];
        String part4 = str[3];
        String part5 = str[4];
        addTransition(part1, part2, part3, part4);
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

    @FXML
    void stepsStateChange_txt(ActionEvent event) {

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

    // Getters & Setters

    public Button getLoad_btn() {
        return load_btn;
    }

    public void setLoad_btn(Button load_btn) {
        this.load_btn = load_btn;
    }

    public Button getSave_btn() {
        return save_btn;
    }

    public void setSave_btn(Button save_btn) {
        this.save_btn = save_btn;
    }

    public TextField getSetName_txt() {
        return setName_txt;
    }

    public void setSetName_txt(TextField setName_txt) {
        this.setName_txt = setName_txt;
    }

    public Button getSetName_btn() {
        return setName_btn;
    }

    public void setSetName_btn(Button setName_btn) {
        this.setName_btn = setName_btn;
    }

    public TextField getSetAlphabet_txt() {
        return setAlphabet_txt;
    }

    public void setSetAlphabet_txt(TextField setAlphabet_txt) {
        this.setAlphabet_txt = setAlphabet_txt;
    }

    public Button getSetAlphabet_btn() {
        return setAlphabet_btn;
    }

    public void setSetAlphabet_btn(Button setAlphabet_btn) {
        this.setAlphabet_btn = setAlphabet_btn;
    }

    public TextField getSetState_txt() {
        return setState_txt;
    }

    public void setSetState_txt(TextField setState_txt) {
        this.setState_txt = setState_txt;
    }

    public Button getSetState_btn() {
        return setState_btn;
    }

    public void setSetState_btn(Button setState_btn) {
        this.setState_btn = setState_btn;
    }

    public TextField getSetTransition_txt() {
        return setTransition_txt;
    }

    public void setSetTransition_txt(TextField setTransition_txt) {
        this.setTransition_txt = setTransition_txt;
    }

    public Button getSetTransition_btn() {
        return setTransition_btn;
    }

    public void setSetTransition_btn(Button setTransition_btn) {
        this.setTransition_btn = setTransition_btn;
    }

    public Button getEditTransition_btn() {
        return editTransition_btn;
    }

    public void setEditTransition_btn(Button editTransition_btn) {
        this.editTransition_btn = editTransition_btn;
    }

    public TableView<?> getTransitionTable_txt() {
        return transitionTable_txt;
    }

    public void setTransitionTable_txt(TableView<?> transitionTable_txt) {
        this.transitionTable_txt = transitionTable_txt;
    }

    public TextField getInput_txt() {
        return input_txt;
    }

    public void setInput_txt(TextField input_txt) {
        this.input_txt = input_txt;
    }

    public Button getStop_btn() {
        return stop_btn;
    }

    public void setStop_btn(Button stop_btn) {
        this.stop_btn = stop_btn;
    }

    public Button getStart_btn() {
        return start_btn;
    }

    public void setStart_btn(Button start_btn) {
        this.start_btn = start_btn;
    }

    public Button getPause_btn() {
        return pause_btn;
    }

    public void setPause_btn(Button pause_btn) {
        this.pause_btn = pause_btn;
    }

    public TableView<?> getOutputTape_txt() {
        return outputTape_txt;
    }

    public void setOutputTape_txt(TableView<?> outputTape_txt) {
        this.outputTape_txt = outputTape_txt;
    }

    public Button getStepBack_btn() {
        return stepBack_btn;
    }

    public void setStepBack_btn(Button stepBack_btn) {
        this.stepBack_btn = stepBack_btn;
    }

    public Button getStepForward_btn() {
        return stepForward_btn;
    }

    public void setStepForward_btn(Button stepForward_btn) {
        this.stepForward_btn = stepForward_btn;
    }

    public TableView<?> getActionsList_txt() {
        return actionsList_txt;
    }

    public void setActionsList_txt(TableView<?> actionsList_txt) {
        this.actionsList_txt = actionsList_txt;
    }

    public TableView<?> getStepsStateChanges_txt() {
        return stepsStateChanges_txt;
    }

    public void setStepsStateChanges_txt(TableView<?> stepsStateChanges_txt) {
        this.stepsStateChanges_txt = stepsStateChanges_txt;
    }

    public TableView<?> getCellidVisits_txt() {
        return CellidVisits_txt;
    }

    public void setCellidVisits_txt(TableView<?> cellidVisits_txt) {
        CellidVisits_txt = cellidVisits_txt;
    }
}
