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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.DbFonctions;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddSalesController implements Initializable {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField unitPrice;

    @FXML
    private JFXComboBox<String> product;

    @FXML
    private JFXTextField quantity;

    @FXML
    private Label totalPrice;

    @FXML
    private JFXComboBox<String> batch;

    @FXML
    void addSales(ActionEvent event) {

    }

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> products = FXCollections.observableArrayList();
        products.addAll("Egg", "Foul");
        product.setItems(products);
        try {
            batch.setItems(DbFonctions.loadBatchNames(LoginController.connection));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        product.getSelectionModel().selectFirst();
        batch.getSelectionModel().selectFirst();
    }
}
