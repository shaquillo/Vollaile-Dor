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
import model.VaccinClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class VaccineController implements Initializable {

    @FXML
    private TableView<VaccinClass> table;

    @FXML
    private TableColumn<VaccinClass, Integer> columnNum;

    @FXML
    private TableColumn<VaccinClass, String> columnName;

    @FXML
    private TableColumn<VaccinClass, Date> columnPeriod;

    @FXML
    private TableColumn<VaccinClass, Integer> columnDuration;


    @FXML
    private TableColumn<VaccinClass, String> columnQV;

    @FXML
    private TableColumn<VaccinClass, Integer> columnQF;

    @FXML
    private TableColumn<VaccinClass, Double> columnPrice;

    @FXML
    private TableColumn<VaccinClass, String> columnDescription;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    BorderPane borderPane;

    public static ObservableList<VaccinClass> vaccinsList = FXCollections.observableArrayList();
    private static int vaccinAccessController = 1;

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

    public void addVaccin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addVaccin.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public void removeVaccin(ActionEvent event) throws SQLException {
        ObservableList<VaccinClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(VaccinClass V : temp){
            vaccinsList.remove(V);
            DbFonctions.deleteVaccin(LoginController.connection,V.getName());
        }
        for(int i =0 ; i <= vaccinsList.size()-1;i++){
            vaccinsList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<VaccinClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<VaccinClass, String>("name"));
        columnPeriod.setCellValueFactory(new PropertyValueFactory<VaccinClass, Date>("period"));
        columnDuration.setCellValueFactory(new PropertyValueFactory<VaccinClass, Integer>("duration"));
        columnQV.setCellValueFactory(new PropertyValueFactory<VaccinClass, String>("qtyVaccin"));
        columnQF.setCellValueFactory(new PropertyValueFactory<VaccinClass, Integer>("qtyFoul"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<VaccinClass, Double>("price"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<VaccinClass, String>("description"));

        if(vaccinAccessController == 1){
            try {
                vaccinsList = DbFonctions.loadVaccin(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            vaccinAccessController ++ ;
        }

        table.setItems(vaccinsList);
    }
}
