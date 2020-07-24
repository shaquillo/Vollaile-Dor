package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.DbFonctions;
import model.SicknessClass;

import java.sql.SQLException;

public class AddSicknessController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField duration;

    @FXML
    private TextArea descriptionSickness;

    @FXML
    private TextArea descriptionTreatment;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addSickness(ActionEvent event) throws SQLException {
        SicknessController.sicknessesList.add(new SicknessClass(0,name.getText(),descriptionSickness.getText(),descriptionTreatment.getText(),Integer.parseInt(duration.getText())));
        for(int i =0 ; i < SicknessController.sicknessesList.size();i++){
            SicknessController.sicknessesList.get(i).setNum(i+1);
        }
        DbFonctions.addSickness(LoginController.connection,name.getText(),descriptionSickness.getText(),descriptionTreatment.getText(),Integer.parseInt(duration.getText()));
        name.setText("");
        descriptionSickness.setText("");
        descriptionTreatment.setText("");
        duration.setText("");
    }
}
