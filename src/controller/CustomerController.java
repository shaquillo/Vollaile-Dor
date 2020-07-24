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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.CustomerClass;
import model.DbFonctions;
import model.VaccinClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {
    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    @FXML
    private TableView<CustomerClass> table;

    @FXML
    private TableColumn<CustomerClass, Integer> columnNum;

    @FXML
    private TableColumn<CustomerClass, String> columnName;

    @FXML
    private TableColumn<CustomerClass, String> columnAddresse;

    @FXML
    private TableColumn<CustomerClass, String> columnTel;

    public BorderPane borderPane ;

    public static ObservableList<CustomerClass> customerList = FXCollections.observableArrayList();
    private static int customerAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addCustomer(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/addCustomer.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void deleteCustomer(ActionEvent event) throws SQLException {
        ObservableList<CustomerClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(CustomerClass C : temp){
            customerList.remove(C);
            DbFonctions.deleteCustomer(LoginController.connection,C.getName());
        }
        for(int i =0 ; i < customerList.size();i++){
            customerList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<CustomerClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<CustomerClass, String>("name"));
        columnAddresse.setCellValueFactory(new PropertyValueFactory<CustomerClass, String>("adresse"));
        columnTel.setCellValueFactory(new PropertyValueFactory<CustomerClass, String>("tel"));

        if(customerAccessController == 1){
            try {
                customerList = DbFonctions.loadCustomer(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            customerAccessController ++ ;
        }

        table.setItems(customerList);
    }
}
