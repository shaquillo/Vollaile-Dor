package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CenterPaneController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if ((LoginController.uName).equals("user")) {
            adminPane.setVisible(false);
        }
    }

    @FXML
    private JFXButton sales1;

    @FXML
    private JFXButton eggs1;

    @FXML
    private JFXButton batch1;

    @FXML
    private JFXButton customer1;

    @FXML
    private JFXButton chick1;

    @FXML
    private JFXButton feed1;

    @FXML
    private JFXButton aliment1;

    @FXML
    private Pane adminPane;

    @FXML
    private JFXButton staff1;

    @FXML
    private JFXButton farm1;

    @FXML
    private JFXButton income1;

    public BorderPane borderPane;

    public void salesClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/sales.fxml"));
        borderPane.setCenter(root);
    }

    public void incomeClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/income.fxml"));
        borderPane.setCenter(root);
    }

    public void staffClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/staff.fxml"));
        borderPane.setCenter(root);
    }

    public void farmClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Farm.fxml"));
        borderPane.setCenter(root);
    }

    public void customersClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/customer.fxml"));
        borderPane.setCenter(root);
    }

    public void batchClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/batch.fxml"));
        borderPane.setCenter(root);
    }

    public void eggClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/eggProduction.fxml"));
        borderPane.setCenter(root);
    }

    public void chicksClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/chickProduction.fxml"));
        borderPane.setCenter(root);
    }

    public void alimentClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Aliment.fxml"));
        borderPane.setCenter(root);
    }

    public void feedClicked(ActionEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/feed.fxml"));
        borderPane.setCenter(root);
    }

    public static void removeStyle(JFXButton button1,JFXButton button2,JFXButton button3,JFXButton button4,JFXButton button5,JFXButton button6,JFXButton button7){
        button1.getStyleClass().removeAll("button12");
        button2.getStyleClass().removeAll("button12");
        button3.getStyleClass().removeAll("button12");
        button4.getStyleClass().removeAll("button12");
        button5.getStyleClass().removeAll("button12");
        button6.getStyleClass().removeAll("button12");
        button7.getStyleClass().removeAll("button12");
    }

    public static void removeStyle1(JFXButton button1,JFXButton button2,JFXButton button3,JFXButton button4,JFXButton button5,JFXButton button6,JFXButton button7,JFXButton button8,JFXButton button9,JFXButton button10){
        button1.getStyleClass().removeAll("button12");
        button2.getStyleClass().removeAll("button12");
        button3.getStyleClass().removeAll("button12");
        button4.getStyleClass().removeAll("button12");
        button5.getStyleClass().removeAll("button12");
        button6.getStyleClass().removeAll("button12");
        button7.getStyleClass().removeAll("button12");
        button8.getStyleClass().removeAll("button12");
        button9.getStyleClass().removeAll("button12");
        button10.getStyleClass().removeAll("button12");
    }
}
