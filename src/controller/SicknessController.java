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
import model.SicknessClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SicknessController implements Initializable {

    @FXML
    private TableView<SicknessClass> table;

    @FXML
    private TableColumn<SicknessClass, Integer> columnNum;

    @FXML
    private TableColumn<SicknessClass, String> columnName;

    @FXML
    private TableColumn<SicknessClass, String> columnSD;

    @FXML
    private TableColumn<SicknessClass, String> columnST;

    @FXML
    private TableColumn<SicknessClass, Integer> columnTD;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    @FXML
    private JFXButton add;

    BorderPane borderPane;

    public static ObservableList<SicknessClass> sicknessesList = FXCollections.observableArrayList();
    private static int sicknessAccessControl = 1 ;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void goBack(MouseEvent event) throws IOException{
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Farm.fxml"));
        borderPane.setCenter(root);
    }

    public void addSickness(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addSickness.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeSickness(ActionEvent event) throws SQLException {
        ObservableList<SicknessClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(SicknessClass S : temp){
            sicknessesList.remove(S);
            DbFonctions.deleteSickness(LoginController.connection,S.getName());
        }
        for(int i =0 ; i <= sicknessesList.size()-1;i++){
            sicknessesList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<SicknessClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<SicknessClass, String>("name"));
        columnSD.setCellValueFactory(new PropertyValueFactory<SicknessClass, String>("sicknessDescription"));
        columnST.setCellValueFactory(new PropertyValueFactory<SicknessClass, String>("treatmentDescription"));
        columnTD.setCellValueFactory(new PropertyValueFactory<SicknessClass, Integer>("treatmentDuration"));

        if(sicknessAccessControl == 1){
            try {
                sicknessesList = DbFonctions.loadSickness(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sicknessAccessControl++ ;
        }

        table.setItems(sicknessesList);
    }
}
