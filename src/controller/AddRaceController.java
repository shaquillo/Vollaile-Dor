package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.DbFonctions;
import model.RaceClass;

import java.sql.SQLException;

public class AddRaceController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;


    @FXML
    private TextArea description;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addRace(ActionEvent event) throws SQLException {
        RaceController.racesList.add(new RaceClass(0,name.getText(),description.getText()));
        for(int i =0 ; i < RaceController.racesList.size() ;i++){
            RaceController.racesList.get(i).setNum(i+1);
        }
        DbFonctions.addRace(LoginController.connection,name.getText(),description.getText());
        name.setText("");
        description.setText("");
    }

}
