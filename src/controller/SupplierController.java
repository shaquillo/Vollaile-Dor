package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DbFonctions;
import model.SuppliersClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupplierController implements Initializable {

    @FXML
    private TableView<SuppliersClass> table;

    @FXML
    private TableColumn<SuppliersClass, Integer> columnNum;

    @FXML
    private TableColumn<SuppliersClass, String> columnName;

    @FXML
    private TableColumn<SuppliersClass, String> columnAddress;

    @FXML
    private TableColumn<SuppliersClass, String> columnTel;

    @FXML
    private TableColumn<SuppliersClass, String> columnEmail;

    @FXML
    private TableColumn<SuppliersClass, String> columnWebsite;

    @FXML
    private TableColumn<SuppliersClass, String> columnType;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    BorderPane borderPane;

    public static ObservableList<SuppliersClass> suppliersList = FXCollections.observableArrayList();
    private static int supplierAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void goBack(ActionEvent event) throws IOException{
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Farm.fxml"));
        borderPane.setCenter(root);
    }

    public void addSupplier(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addSupplier.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeSupplier(ActionEvent event) throws SQLException {
        ObservableList<SuppliersClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(SuppliersClass S : temp){
            suppliersList.remove(S);
            DbFonctions.deleteSupplier(LoginController.connection,S.getName());
        }
        for(int i =0 ; i < suppliersList.size();i++){
            suppliersList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<SuppliersClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("name"));
        columnTel.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("tel"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("email"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("adresse"));
        columnWebsite.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("website"));
        columnType.setCellValueFactory(new PropertyValueFactory<SuppliersClass, String>("pdtType"));

        if(supplierAccessController == 1){
            try {
                suppliersList = DbFonctions.loadSupplier(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            supplierAccessController ++ ;
        }

        table.setItems(suppliersList);
    }
}
