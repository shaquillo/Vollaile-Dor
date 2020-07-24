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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SelectionModel;
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
import model.AlimentClass;
import model.DbFonctions;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AlimentContoller implements Initializable{
    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    @FXML
    private TableView<AlimentClass> table;

    @FXML
    private TableColumn<AlimentClass, Integer> columnNum;

    @FXML
    private TableColumn<AlimentClass, String> columnName;

    @FXML
    private TableColumn<AlimentClass, Double> columnPrice;

    @FXML
    private TableColumn<AlimentClass, String> columnDescription;

    //public static ObservableList<AlimentClass> alimentList= FXCollections.observableArrayList();

    public BorderPane borderPane ;

    public static ObservableList<AlimentClass> alimentsList = FXCollections.observableArrayList();
    private  static int alimentAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addAliment(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addAliment.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    public void removeAliment(ActionEvent event) throws SQLException {
        ObservableList<AlimentClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(AlimentClass A : temp){
            alimentsList.remove(A);
            DbFonctions.deleteAliment(LoginController.connection,A.getName());
        }
        for(int i =0 ; i <= alimentsList.size()-1;i++){
            alimentsList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if((LoginController.uName).equals("user")){
            add.setVisible(false);
            remove.setVisible(false);
        }
        columnNum.setCellValueFactory(new PropertyValueFactory<AlimentClass, Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<AlimentClass, String>("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<AlimentClass, Double>("price"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<AlimentClass, String>("description"));

        //table.setSelectionModel(SelectionModel<AlimentClass>()(SelectionMode.MULTIPLE));
        if(alimentAccessController == 1){
            try {
                alimentsList = DbFonctions.loadAliment(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            alimentAccessController ++ ;
        }

        table.setItems(alimentsList);
    }

}
