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
import model.DbFonctions;
import model.EmployeeClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    private TableView<EmployeeClass> table;

    @FXML
    private TableColumn<EmployeeClass, Integer> columnNum;

    @FXML
    private TableColumn<EmployeeClass, String> columnName;

    @FXML
    private TableColumn<EmployeeClass, String> columnSurname;

    @FXML
    private TableColumn<EmployeeClass, String> columnType;

    @FXML
    private TableColumn<EmployeeClass, String> columnUser;

    @FXML
    private TableColumn<EmployeeClass, String> columnPassword;

    @FXML
    private TableColumn<EmployeeClass, String> columnGender;


    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton remove;

    @FXML
    private JFXButton back;

    public BorderPane borderPane ;

    public static ObservableList<EmployeeClass> staffList = FXCollections.observableArrayList();
    public static int staffAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addStaff(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addEmployee.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeStaff(ActionEvent event) throws SQLException {
        ObservableList<EmployeeClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(EmployeeClass E : temp){
            staffList.remove(E);
            DbFonctions.deleteStaff(LoginController.connection,E.getName());
        }
        for(int i = 0; i < staffList.size(); i++){
            staffList.get(i).setNum(i+1);
        }
    }

    @FXML
    public void modifyEmployee(ActionEvent event) {
        EmployeeClass temp = table.getSelectionModel().getSelectedItem();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<EmployeeClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("surname"));
        columnType.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("type"));
        columnUser.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("username"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("password"));
        columnGender.setCellValueFactory(new PropertyValueFactory<EmployeeClass, String>("sexe"));

        if(staffAccessController == 1){
            try {
                staffList = DbFonctions.loadStaff(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            staffAccessController ++ ;
        }

        table.setItems(staffList);
    }
}
