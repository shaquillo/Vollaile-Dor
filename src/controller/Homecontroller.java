package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Homecontroller implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton home;

    @FXML
    private JFXButton staff;

    @FXML
    private JFXButton farm;

    @FXML
    private JFXButton income;

    @FXML
    private JFXButton sales;

    @FXML
    private JFXButton customers;

    @FXML
    private JFXButton batch;

    @FXML
    private JFXButton eggs;

    @FXML
    private JFXButton chicks;

    @FXML
    private JFXButton aliment;

    @FXML
    private JFXButton feed;

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
    private JFXButton staff1;

    @FXML
    private JFXButton farm1;

    @FXML
    private JFXButton income1;


     public void buttonClicked(MouseEvent event){
        ((JFXButton)(event.getSource())).getStyleClass().removeAll("button1, focus");
         ((JFXButton)(event.getSource())).getStyleClass().add("button12");
    }

    public void homeClicked(ActionEvent event) throws IOException {
        home.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,aliment,eggs,chicks,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void salesClicked(ActionEvent event) throws IOException {
        sales.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(home,feed,aliment,eggs,chicks,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/sales.fxml"));
        borderPane.setCenter(root);
    }

    public void incomeClicked(ActionEvent event) throws IOException {
        income.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(home,feed,aliment,eggs,chicks,customers,batch,staff,home,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/income.fxml"));
        borderPane.setCenter(root);
    }

    public void staffClicked(ActionEvent event) throws IOException {
        staff.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(home,feed,aliment,eggs,chicks,customers,batch,home,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/staff.fxml"));
        borderPane.setCenter(root);
    }

    public void farmClicked(ActionEvent event) throws IOException {
         farm.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(home,feed,aliment,eggs,chicks,customers,batch,staff,income,home);
        Parent root = FXMLLoader.load(getClass().getResource("/view/Farm.fxml"));
        borderPane.setCenter(root);
    }

    public void customersClicked(ActionEvent event) throws IOException {
        customers.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,aliment,eggs,chicks,home,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/customer.fxml"));
        borderPane.setCenter(root);
    }

    public void batchClicked(ActionEvent event) throws IOException {
        batch.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,aliment,eggs,chicks,customers,home,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/batch.fxml"));
        borderPane.setCenter(root);
    }

    public void eggClicked(ActionEvent event) throws IOException {
        eggs.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,aliment,home,chicks,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/eggProduction.fxml"));
        borderPane.setCenter(root);
    }

    public void chicksClicked(ActionEvent event) throws IOException {
        chicks.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,aliment,eggs,home,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/chickProduction.fxml"));
        borderPane.setCenter(root);
    }

    public void alimentClicked(ActionEvent event) throws IOException {
        aliment.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,feed,home,eggs,chicks,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/Aliment.fxml"));
        borderPane.setCenter(root);
    }

    public void feedClicked(javafx.event.ActionEvent event) throws IOException {
        feed.getStyleClass().add("button12");
        CenterPaneController.removeStyle1(sales,home,aliment,eggs,chicks,customers,batch,staff,income,farm);
        Parent root = FXMLLoader.load(getClass().getResource("/view/feed.fxml"));
        borderPane.setCenter(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         home.getStyleClass().add("button12");
    }
}
