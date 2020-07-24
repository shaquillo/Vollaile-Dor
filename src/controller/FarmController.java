package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class FarmController {
    @FXML
    private JFXButton race;

    @FXML
    private JFXButton sickness;

    @FXML
    private JFXButton vaccin;

    @FXML
    private JFXButton supplier;

    @FXML
    private JFXButton building;

    @FXML
    private JFXButton typeEgg;

    @FXML
    private ImageView home;

    public BorderPane borderPane ;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void raceClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/race.fxml"));
        borderPane.setCenter(root);
    }

    public void supplierClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/supplier.fxml"));
        borderPane.setCenter(root);
    }

    public void buildingClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/building.fxml"));
        borderPane.setCenter(root);
    }

    public void typeEggClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/typesEgg.fxml"));
        borderPane.setCenter(root);
    }

    public void sicknessClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/sickness.fxml"));
        borderPane.setCenter(root);
    }

    public void vaccinClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/vaccine.fxml"));
        borderPane.setCenter(root);
    }
}
