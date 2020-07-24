package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DbFonctions;
import model.EmployeeClass;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddEmployeeController implements Initializable {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXComboBox<String> type;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField surname;

    @FXML
    private JFXComboBox<String> gender;

    @FXML
    void addEmployee(ActionEvent event) throws SQLException {
        StaffController.staffList.add(new EmployeeClass(0,name.getText(),surname.getText(),type.getValue(),username.getText(),password.getText(),gender.getValue()));
        for(int i =0 ; i < StaffController.staffList.size() ;i++){
            StaffController.staffList.get(i).setNum(i+1);
        }
        DbFonctions.addStaff(LoginController.connection,name.getText(),surname.getText(),type.getValue(),username.getText(),password.getText(),gender.getValue());
        name.setText("");
        surname.setText("");
        username.setText("");
        password.setText("");
    }


    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genders = FXCollections.observableArrayList();
        ObservableList<String> types = FXCollections.observableArrayList();

        genders.addAll("Male","Female");
        gender.setItems(genders);
        gender.getSelectionModel().selectFirst();

        types.addAll("admin","app user","worker");
        type.setItems(types);
        type.getSelectionModel().selectFirst();

    }
}
