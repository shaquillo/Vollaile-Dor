package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.AlimentClass;
import model.DbFonctions;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddAlimentController {
    @FXML
    private JFXButton add_button;

    @FXML
    private JFXButton close_button;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField price;

    @FXML
    private TextArea description;

    public static ArrayList<AlimentClass> aliments = new ArrayList<AlimentClass>();
    public static String name1;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    public void addAlimentes() throws SQLException {
        AlimentContoller.alimentsList.add(new AlimentClass(0,name.getText(),Double.parseDouble(price.getText()),description.getText()));
        for(int i =0 ; i <= AlimentContoller.alimentsList.size()-1;i++){
            AlimentContoller.alimentsList.get(i).setNum(i+1);
        }
        DbFonctions.addAliment(LoginController.connection,name.getText(),Double.parseDouble(price.getText()),description.getText());
        name.setText("");
        price.setText("");
        description.setText("");
    }
}
