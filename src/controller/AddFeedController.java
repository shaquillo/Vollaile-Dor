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
import model.DbFonctions;
import model.FeedClass;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddFeedController implements Initializable {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXComboBox<String> aliment;

    @FXML
    private JFXTextField qtyAliment;

    @FXML
    private JFXComboBox<String> batchName;

    @FXML
    private JFXTextField qtyWater;

    @FXML
    private DatePicker date;

    @FXML
    void addFeed(ActionEvent event) throws SQLException {
        FeedController.feedsList.add(new FeedClass(0,aliment.getValue(), Date.valueOf(date.getValue()), batchName.getValue(), Integer.parseInt(qtyAliment.getText()), Integer.parseInt(qtyWater.getText()) ));
        for(int i =0 ; i < FeedController.feedsList.size();i++){
            FeedController.feedsList.get(i).setNo(i+1);
        }
        DbFonctions.addFeed(LoginController.connection,aliment.getValue(), Date.valueOf(date.getValue()), batchName.getValue(), Integer.parseInt(qtyAliment.getText()), Integer.parseInt(qtyWater.getText()));
        qtyAliment.setText("");
        qtyWater.setText("");
    }

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            aliment.setItems(DbFonctions.loadAlimentName(LoginController.connection));
            batchName.setItems(DbFonctions.loadBatchNames(LoginController.connection));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
