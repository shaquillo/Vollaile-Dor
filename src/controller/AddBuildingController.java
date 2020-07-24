package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.BuildingClass;
import model.DbFonctions;

import java.sql.SQLException;

public class AddBuildingController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField surface;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addBatch(ActionEvent event) throws SQLException {
        BuildingController.buildingsList.add(new BuildingClass(0,name.getText(),Double.parseDouble(surface.getText())));
        for(int i = 0; i < BuildingController.buildingsList.size() ; i++){
            BuildingController.buildingsList.get(i).setNum(i+1);
        }
        DbFonctions.addBatiment(LoginController.connection,name.getText(),Double.parseDouble(surface.getText()));
        name.setText("");
        surface.setText("");
    }
}
