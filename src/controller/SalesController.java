package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.SalesClass;

import java.io.IOException;
import java.util.Date;

public class SalesController {
    @FXML
    private TableView<SalesClass> table;

    @FXML
    private TableColumn<SalesClass, Integer> columnNum;

    @FXML
    private TableColumn<SalesClass, String> columnProduct;

    @FXML
    private TableColumn<SalesClass, String> columnProductType;

    @FXML
    private TableColumn<SalesClass, String> columnBatch;

    @FXML
    private TableColumn<SalesClass, Integer> columnUnitPrice;

    @FXML
    private TableColumn<SalesClass, Integer> columnQty;

    @FXML
    private TableColumn<SalesClass, Integer> columnTotalPrice;

    @FXML
    private TableColumn<SalesClass, Date> date;

    @FXML
    private TableColumn<SalesClass, String> seller;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton modify;

    public BorderPane borderPane ;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addSales(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addSales.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void modifySale(ActionEvent event){

    }
}
