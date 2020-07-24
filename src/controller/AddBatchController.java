package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.BatchClass;
import model.CustomerClass;
import model.DbFonctions;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddBatchController implements Initializable {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField quantity;

    @FXML
    private JFXTextField buy_price;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXComboBox<String> race;

    @FXML
    private DatePicker date1;

    @FXML
    private JFXComboBox<String> building;

    @FXML
    private JFXComboBox<String> supplier;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addBatch(ActionEvent event) throws SQLException {
        BatchController.batchesList.add(new BatchClass(0,name.getText(),race.getValue(), Integer.parseInt(quantity.getText()),Double.parseDouble(buy_price.getText()), Date.valueOf(date1.getValue()),building.getValue(),supplier.getValue() ));
        for(int i =0 ; i < BatchController.batchesList.size();i++){
            BatchController.batchesList.get(i).setNum(i+1);
        }
        DbFonctions.addBatch(LoginController.connection,name.getText(),race.getValue(), Integer.parseInt(quantity.getText()),Double.parseDouble(buy_price.getText()), Date.valueOf(date1.getValue()),building.getValue(),supplier.getValue());
        name.setText("");
        buy_price.setText("");
        quantity.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            race.setItems(DbFonctions.loadRaceName(LoginController.connection));
            supplier.setItems(DbFonctions.loadSupplierName(LoginController.connection));
            building.setItems(DbFonctions.loadBuildingName(LoginController.connection));

            race.getSelectionModel().selectFirst();
            supplier.getSelectionModel().selectFirst();
            building.getSelectionModel().selectFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
