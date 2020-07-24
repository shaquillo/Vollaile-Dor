package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class AddEggController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField no_incubatted;

    @FXML
    private JFXComboBox<?> type;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXComboBox<?> batch_id;

    @FXML
    private JFXTextField price_of_trau;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }
}
