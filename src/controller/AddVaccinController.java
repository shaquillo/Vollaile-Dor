package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.DbFonctions;
import model.VaccinClass;

import java.sql.Date;
import java.sql.SQLException;

public class AddVaccinController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField price;

    @FXML
    private TextArea description;

    @FXML
    private JFXTextField qtyVaccin;

    @FXML
    private JFXTextField qtyFoul;

    @FXML
    private JFXTextField duration;

    @FXML
    private DatePicker period;

    @FXML
    void addVaccin(ActionEvent event) throws SQLException {
        VaccineController.vaccinsList.add(new VaccinClass(0,name.getText(), Date.valueOf(period.getValue()),Integer.parseInt(duration.getText()),qtyVaccin.getText(),Integer.parseInt(qtyFoul.getText()),Double.parseDouble(price.getText()),description.getText()));
        for(int i =0 ; i < VaccineController.vaccinsList.size();i++){
            VaccineController.vaccinsList.get(i).setNum(i+1);
        }
        DbFonctions.addVaccin(LoginController.connection,name.getText(), Date.valueOf(period.getValue()),Integer.parseInt(duration.getText()),qtyVaccin.getText(),Integer.parseInt(qtyFoul.getText()),Double.parseDouble(price.getText()),description.getText());
        name.setText("");
        price.setText("");
        duration.setText("");
        qtyVaccin.setText("");
        qtyFoul.setText("");
        description.setText("");
    }

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }
}
