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
import model.RaceClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RaceController implements Initializable {

    @FXML
    private TableView<RaceClass> table;

    @FXML
    private TableColumn<RaceClass, Integer> columnNum;

    @FXML
    private TableColumn<RaceClass, String> columnName;

    @FXML
    private TableColumn<RaceClass, String> columnDescription;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    BorderPane borderPane;

    public static ObservableList<RaceClass> racesList = FXCollections.observableArrayList();
    private static int raceAccessController = 1;

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

    public void addRace(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addRace.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeRace(ActionEvent event) throws SQLException {
        ObservableList<RaceClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(RaceClass R : temp){
            racesList.remove(R);
            DbFonctions.deleteRace(LoginController.connection,R.getName());
        }
        for(int i =0 ; i < racesList.size();i++){
            racesList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<RaceClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<RaceClass, String>("name"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<RaceClass, String>("description"));

        if(raceAccessController == 1){
            try {
                racesList = DbFonctions.loadRace(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            raceAccessController ++ ;
        }

        table.setItems(racesList);
    }
}
