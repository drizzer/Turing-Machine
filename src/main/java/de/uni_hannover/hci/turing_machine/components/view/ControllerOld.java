
package de.uni_hannover.hci.turing_machine.components.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


    public class ControllerOld {

        public Button getLoadBtn() {
            return loadBtn;
        }

        public void setLoadBtn(Button loadBtn) {
            this.loadBtn = loadBtn;
        }

        public Button getSaveBtn() {
            return saveBtn;
        }

        public void setSaveBtn(Button saveBtn) {
            this.saveBtn = saveBtn;
        }

        public Button getStartBtn() {
            return startBtn;
        }

        public void setStartBtn(Button startBtn) {
            this.startBtn = startBtn;
        }

        public Button getStopBtn() {
            return stopBtn;
        }

        public void setStopBtn(Button stopBtn) {
            this.stopBtn = stopBtn;
        }

        public Button getSetAlphabet() {
            return setAlphabet;
        }

        public void setSetAlphabet(Button setAlphabet) {
            this.setAlphabet = setAlphabet;
        }

        public Button getSetState() {
            return setState;
        }

        public void setSetState(Button setState) {
            this.setState = setState;
        }

        public Button getSetMachineName() {
            return setMachineName;
        }

        public void setSetMachineName(Button setMachineName) {
            this.setMachineName = setMachineName;
        }

        public TextField getSetName() {
            return setName;
        }

        public void setSetName(TextField setName) {
            this.setName = setName;
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

        public TextField getSetalphabet_txt() {
            return setalphabet_txt;
        }

        public void setSetalphabet_txt(TextField setalphabet_txt) {
            this.setalphabet_txt = setalphabet_txt;
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

        public Button getStop_btn() {
            return stop_btn;
        }

        public void setStop_btn(Button stop_btn) {
            this.stop_btn = stop_btn;
        }

        public Button getSetalphabet_btn() {
            return setalphabet_btn;
        }

        public void setSetalphabet_btn(Button setalphabet_btn) {
            this.setalphabet_btn = setalphabet_btn;
        }

        public TableView<?> getTransition_txt() {
            return transition_txt;
        }

        public void setTransition_txt(TableView<?> transition_txt) {
            this.transition_txt = transition_txt;
        }

        public Button getSetstate_btn() {
            return setstate_btn;
        }

        public void setSetstate_btn(Button setstate_btn) {
            this.setstate_btn = setstate_btn;
        }

        public Button getSetname_btn() {
            return setname_btn;
        }

        public void setSetname_btn(Button setname_btn) {
            this.setname_btn = setname_btn;
        }

        public TextField getSetstate_txt() {
            return setstate_txt;
        }

        public void setSetstate_txt(TextField setstate_txt) {
            this.setstate_txt = setstate_txt;
        }

        public TextField getSetname_txt() {
            return setname_txt;
        }

        public void setSetname_txt(TextField setname_txt) {
            this.setname_txt = setname_txt;
        }

        public ListView<?> getAction_txt() {
            return action_txt;
        }

        public void setAction_txt(ListView<?> action_txt) {
            this.action_txt = action_txt;
        }

        public TableView<?> getOutputtape_txt() {
            return outputtape_txt;
        }

        public void setOutputtape_txt(TableView<?> outputtape_txt) {
            this.outputtape_txt = outputtape_txt;
        }

        public Button getStepforward_btn() {
            return stepforward_btn;
        }

        public void setStepforward_btn(Button stepforward_btn) {
            this.stepforward_btn = stepforward_btn;
        }

        public Button getStepback_btn() {
            return stepback_btn;
        }

        public void setStepback_btn(Button stepback_btn) {
            this.stepback_btn = stepback_btn;
        }

        public TableView<?> getCellidVisits_txt() {
            return CellidVisits_txt;
        }

        public void setCellidVisits_txt(TableView<?> cellidVisits_txt) {
            CellidVisits_txt = cellidVisits_txt;
        }

        public TableView<?> getStepsStatechanges_txt() {
            return stepsStatechanges_txt;
        }

        public void setStepsStatechanges_txt(TableView<?> stepsStatechanges_txt) {
            this.stepsStatechanges_txt = stepsStatechanges_txt;
        }

        public Color getX2() {
            return x2;
        }

        public void setX2(Color x2) {
            this.x2 = x2;
        }

        @FXML
        private Font x1;

        @FXML
        private Color x2;

        @FXML
        private Button loadBtn;

        @FXML
        private Button saveBtn;

        @FXML
        private Button startBtn;

        @FXML
        private Button stopBtn;

        @FXML
        private Button setAlphabet;

        @FXML
        private Button setState;

        @FXML
        private Button setMachineName;

        @FXML
        private TextField setName;

        @FXML
        private Font x3;

        @FXML
        private Color x4;

        @FXML
        private Button load_btn;

        @FXML
        private Button save_btn;

        @FXML
        private TextField setalphabet_txt;

        @FXML
        private Button start_btn;

        @FXML
        private Button pause_btn;

        @FXML
        private Button stop_btn;

        @FXML
        private Button setalphabet_btn;

        @FXML
        private TableView<?> transition_txt;

        @FXML
        private Button setstate_btn;

        @FXML
        private Button setname_btn;

        @FXML
        private TextField setstate_txt;

        @FXML
        private TextField setname_txt;

        @FXML
        private ListView<?> action_txt;

        @FXML
        private TableView<?> outputtape_txt;

        @FXML
        private Button stepforward_btn;

        @FXML
        private Button stepback_btn;

        @FXML
        private TableView<?> CellidVisits_txt;

        @FXML
        private TableView<?> stepsStatechanges_txt;

        @FXML
        void load(ActionEvent event) {

        }

        @FXML
        void new_CellidVisits_txt(ActionEvent event) {

        }

        @FXML
        void new_actions_txt(ActionEvent event) {

        }

        @FXML
        void new_outputtape_txt(ActionEvent event) {

        }

        @FXML
        void new_setalphabet_txt(ActionEvent event) {

        }

        @FXML
        void new_setname_txt(ActionEvent event) {

        }

        @FXML
        void new_setstate_txt(ActionEvent event) {

        }

        @FXML
        void new_stepsStatechange_txt(MouseEvent event) {

        }

        @FXML
        void new_transition_txt(ActionEvent event) {

        }

        @FXML
        void pause(ActionEvent event) {

        }

        @FXML
        void save(ActionEvent event) {

        }

        @FXML
        void setalphabet(ActionEvent event) {

        }

        @FXML
        void setname(ActionEvent event) {

        }

        @FXML
        void setstate(ActionEvent event) {

        }

        @FXML
        void start(ActionEvent event) {

        }

        @FXML
        void stepback(ActionEvent event) {

        }

        @FXML
        void stepforward(ActionEvent event) {

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
    }
