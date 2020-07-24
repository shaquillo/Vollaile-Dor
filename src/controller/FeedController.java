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
import model.BatchClass;
import model.DbFonctions;
import model.FeedClass;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class FeedController implements Initializable {
    @FXML
    private TableView<FeedClass> table;

    @FXML
    private TableColumn<FeedClass, Integer> columnNum;

    @FXML
    private TableColumn<FeedClass, String> columnAliment;

    @FXML
    private TableColumn<FeedClass, Date> columnDate;

    @FXML
    private TableColumn<FeedClass, String> columnBatch;

    @FXML
    private TableColumn<FeedClass, Integer> columnQtyAliment;

    @FXML
    private TableColumn<FeedClass, Integer> columnQtyWater;

    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton remove;

    @FXML
    private JFXButton back;

    public BorderPane borderPane ;

    public static ObservableList<FeedClass> feedsList = FXCollections.observableArrayList();
    private static int feedAccessController = 1;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addFeed(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addFeed.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeFeed(ActionEvent event) throws SQLException {
        ObservableList<FeedClass> temp;
        temp = table.getSelectionModel().getSelectedItems();
        for(FeedClass F : temp){
            feedsList.remove(F);
            DbFonctions.deleteFeed(LoginController.connection, DbFonctions.getIdFromString(LoginController.connection,"Aliment","idAliment","nom",F.getAliment(),"",""), DbFonctions.getIdFromString(LoginController.connection,"Bande","idBande","nom",F.getBatch(),"",""));
        }
        for(int i =0 ; i < feedsList.size();i++){
            feedsList.get(i).setNo(i+1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnNum.setCellValueFactory(new PropertyValueFactory<FeedClass, Integer>("no"));
        columnAliment.setCellValueFactory(new PropertyValueFactory<FeedClass, String>("aliment"));
        columnDate.setCellValueFactory(new PropertyValueFactory<FeedClass, Date>("date"));
        columnBatch.setCellValueFactory(new PropertyValueFactory<FeedClass, String>("batch"));
        columnQtyAliment.setCellValueFactory(new PropertyValueFactory<FeedClass, Integer>("qtyAliment"));
        columnQtyWater.setCellValueFactory(new PropertyValueFactory<FeedClass, Integer>("qtyWater"));

        if(feedAccessController == 1){
            try {
                feedsList = DbFonctions.loadFeed(LoginController.connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            feedAccessController ++ ;
        }

        table.setItems(feedsList);
    }
}
