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
import model.BatchClass;
import model.CustomerClass;
import model.DbFonctions;
import model.SellBatchClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BatchController implements Initializable {

    @FXML
    private TableView<BatchClass> table;

    @FXML
    private TableColumn<BatchClass, Integer> columnNum;

    @FXML
    private TableColumn<BatchClass, String> columnName;

    @FXML
    private TableColumn<BatchClass, String> columnRace;

    @FXML
    private TableColumn<BatchClass, Integer> columnQty;

    @FXML
    private TableColumn<BatchClass, Double> columnBP;

    @FXML
    private TableColumn<BatchClass, String> columnSP;

    @FXML
    private TableColumn<BatchClass, LocalDate> columnSD;

    @FXML
    private TableColumn<BatchClass, String> columnBuiling;

    @FXML
    private TableColumn<BatchClass, String> columnSupplier;
    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    @FXML
    private JFXButton sick_vaccinated;

    public BorderPane borderPane ;

    public static ObservableList<BatchClass> batchesList = FXCollections.observableArrayList();
    private static int batchAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addBatch(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addBatch.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeBatch(ActionEvent event) throws SQLException {
        ObservableList<BatchClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(BatchClass B : temp){
            batchesList.remove(B);
            DbFonctions.deleteBatch(LoginController.connection,B.getName());
        }
        for(int i =0 ; i < batchesList.size();i++){
            batchesList.get(i).setNum(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if((LoginController.uName).equals("user")){
            add.setVisible(false);
            remove.setVisible(false);
        }
        columnNum.setCellValueFactory(new PropertyValueFactory<BatchClass,Integer>("num"));
        columnName.setCellValueFactory(new PropertyValueFactory<BatchClass,String>("name"));
        columnRace.setCellValueFactory(new PropertyValueFactory<BatchClass,String>("race"));
        columnQty.setCellValueFactory(new PropertyValueFactory<BatchClass,Integer>("qty"));
        columnBP.setCellValueFactory(new PropertyValueFactory<BatchClass,Double>("buyingPrice"));
        columnSP.setCellValueFactory(new PropertyValueFactory<BatchClass,String>("sellingPrice"));
        columnSD.setCellValueFactory(new PropertyValueFactory<BatchClass,LocalDate>("startDate"));
        columnBuiling.setCellValueFactory(new PropertyValueFactory<BatchClass,String>("building"));
        columnSupplier.setCellValueFactory(new PropertyValueFactory<BatchClass,String>("supplier"));

        if(batchAccessController == 1){
            try {
                batchesList = DbFonctions.loadBatch(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            batchAccessController ++ ;
        }

        table.setItems(batchesList);
    }
}
