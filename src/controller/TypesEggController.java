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
import model.EggTypeClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TypesEggController implements Initializable {

    @FXML
    private TableView<EggTypeClass> table;

    @FXML
    private TableColumn<EggTypeClass, Integer> columnNum;

    @FXML
    private TableColumn<EggTypeClass, String> columnName;

    @FXML
    private TableColumn<EggTypeClass, Double> columnPrice;


    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    BorderPane borderPane;

    public static ObservableList<EggTypeClass> typesEggList = FXCollections.observableArrayList();
    private static int typeEggAccessController = 1;

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

    public void addEggType(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addEggType.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeEggType(ActionEvent event) throws SQLException {
        ObservableList<EggTypeClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(EggTypeClass E : temp){
            typesEggList.remove(E);
            DbFonctions.deleteTypeEgg(LoginController.connection,E.getName());
        }
        for(int i =0 ; i < typesEggList.size();i++){
            typesEggList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<EggTypeClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<EggTypeClass, String>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<EggTypeClass, Double>("price"));

        if(typeEggAccessController == 1){
            try {
                typesEggList = DbFonctions.loadTypeEgg(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            typeEggAccessController ++ ;
        }

        table.setItems(typesEggList);
    }
}
