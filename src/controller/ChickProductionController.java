package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ChickProductionController {
    @FXML
    private ImageView home;

    @FXML
    private JFXButton add;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton remove;

    public BorderPane borderPane ;

    public void goToHome(MouseEvent event) throws IOException {
        borderPane = (BorderPane) (((Node)(event.getSource())).getScene()).getRoot();
        Parent root = FXMLLoader.load(getClass().getResource("/view/centerPane.fxml"));
        borderPane.setCenter(root);
    }

    public void addChick(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/view/addChick.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void removeChick(ActionEvent event){

    }
}
