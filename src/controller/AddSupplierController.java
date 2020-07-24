package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DbFonctions;
import model.SuppliersClass;

import java.sql.SQLException;

public class AddSupplierController {
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

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField website;

    @FXML
    private JFXTextField type;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addSupplier(ActionEvent event) throws SQLException {
        SupplierController.suppliersList.add(new SuppliersClass(0,name.getText(),adresse.getText(),tel.getText(),email.getText(),website.getText(),type.getText()));
        for(int i =0 ; i < SupplierController.suppliersList.size();i++){
            SupplierController.suppliersList.get(i).setNum(i+1);
        }
        DbFonctions.addSupplier(LoginController.connection,name.getText(),adresse.getText(),tel.getText(),email.getText(),website.getText(),type.getText());
        name.setText("");
        tel.setText("");
        adresse.setText("");
        email.setText("");
        type.setText("");
        website.setText("");
    }
}
