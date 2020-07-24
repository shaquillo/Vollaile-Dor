package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.CustomerClass;
import model.DbFonctions;
import model.VaccinClass;

import java.sql.Date;
import java.sql.SQLException;

public class AddCustomerController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField adresse;

    @FXML
    private JFXTextField tel;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    public void addCustomer(ActionEvent event) throws SQLException {
        CustomerController.customerList.add(new CustomerClass(0,name.getText(),adresse.getText(), tel.getText() ));
        for(int i =0 ; i < CustomerController.customerList.size();i++){
            CustomerController.customerList.get(i).setNum(i+1);
        }
        DbFonctions.addCustomer(LoginController.connection,name.getText(), adresse.getText(), tel.getText());
        name.setText("");
        adresse.setText("");
        tel.setText("");
    }
}
