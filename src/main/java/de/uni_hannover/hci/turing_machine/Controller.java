package de.uni_hannover.hci.turing_machine;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

    public class Controller {

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
        private Button setstate_btn;

        @FXML
        private TextField setTransition_txt;

        @FXML
        private Button setTransition_btn;

        @FXML
        private Button editTransition_btn;

        @FXML
        private TableView<?> transition_txt;

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
        private TableView<?> stepsStatechanges_txt;

        @FXML
        private TableView<?> CellidVisits_txt;

        @FXML
        private Font x3;

        @FXML
        private Color x4;

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

        @FXML
        void new_stepsStatechange_txt(MouseEvent event) {

        }

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
        void setTransiton(ActionEvent event) {

        }

        @FXML
        void setstate(ActionEvent event) {

        }

        @FXML
        void start(ActionEvent event) {

        }

        @FXML
        void stepBack(ActionEvent event) {

        }

        @FXML
        void stepForward(ActionEvent event) {

        }

        @FXML
        void stepsStatechange_txt(ActionEvent event) {

        }

        @FXML
        void stop(ActionEvent event) {

        }



        public Font getX1() {
            return x1;
        }

        public void setX1(Font x1) {
            this.x1 = x1;
        }

        public Color getX2() {
            return x2;
        }

        public void setX2(Color x2) {
            this.x2 = x2;
        }

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

        public Button getSetstate_btn() {
            return setstate_btn;
        }

        public void setSetstate_btn(Button setstate_btn) {
            this.setstate_btn = setstate_btn;
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

        public TableView<?> getTransition_txt() {
            return transition_txt;
        }

        public void setTransition_txt(TableView<?> transition_txt) {
            this.transition_txt = transition_txt;
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

        public TableView<?> getStepsStatechanges_txt() {
            return stepsStatechanges_txt;
        }

        public void setStepsStatechanges_txt(TableView<?> stepsStatechanges_txt) {
            this.stepsStatechanges_txt = stepsStatechanges_txt;
        }

        public TableView<?> getCellidVisits_txt() {
            return CellidVisits_txt;
        }

        public void setCellidVisits_txt(TableView<?> cellidVisits_txt) {
            CellidVisits_txt = cellidVisits_txt;
        }

        public Font getX3() {
            return x3;
        }

        public void setX3(Font x3) {
            this.x3 = x3;
        }

        public Color getX4() {
            return x4;
        }

        public void setX4(Color x4) {
            this.x4 = x4;
        }

    }
