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
import model.BuildingClass;
import model.DbFonctions;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BuildingController implements Initializable {

    @FXML
    private TableView<BuildingClass> table;

    @FXML
    private TableColumn<BuildingClass, Integer> columnNum;

    @FXML
    private TableColumn<BuildingClass, String> columnName;

    @FXML
    private TableColumn<BuildingClass, Double> columnSurface;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    public BorderPane borderPane ;

    public static ObservableList<BuildingClass> buildingsList = FXCollections.observableArrayList();
    private static int buildingAccessController = 1;
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

    public void addBuilding(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addBuilding.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void removeBuilding(ActionEvent event) throws SQLException {
        ObservableList<BuildingClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(BuildingClass B : temp){
            buildingsList.remove(B);
            DbFonctions.deleteBuilding(LoginController.connection,B.getName());
        }
        for(int i =0 ; i <= buildingsList.size()-1;i++){
            buildingsList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<BuildingClass,Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<BuildingClass, String>("name"));
        columnSurface.setCellValueFactory(new PropertyValueFactory<BuildingClass, Double>("surface"));

        if(buildingAccessController == 1){
            try {
                buildingsList = DbFonctions.loadBuilding(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            buildingAccessController ++ ;
        }

        table.setItems(buildingsList);
    }
}
