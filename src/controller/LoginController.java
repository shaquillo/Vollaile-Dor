package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DbFonctions;

import java.sql.*;

import java.io.IOException;

public class LoginController {
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton sign_in;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label message;

    public static String uName, pwd;
    String path="" ;

    @FXML
    public void noMessage(ActionEvent event){
        message.setText("");
    }

    @FXML
    public void noMessage1(MouseEvent event){
        message.setText("");
    }

    public static Connection connection;

    @FXML
    public void login(ActionEvent event) throws IOException,Exception {
        message.setText("");
        uName = username.getText();
        pwd = password.getText();
        username.setText("");
        password.setText("");
        connection = DbFonctions.ConnectToDb("shaq","Shaquillo@18");
        String loginType = DbFonctions.connectUser(uName,pwd,connection);
        if(loginType.equals("admin") || loginType.equals("simple")) {
            if(loginType.equals("admin")){
                    path = "/view/home.fxml";
                } else if(loginType.equals("simple")){
                    path = "/view/home_simple_user.fxml";
                }
                Parent root = FXMLLoader.load(getClass().getResource(path));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage current_stage = (Stage)rootPane.getScene().getWindow() ;
                current_stage.close();
        } else {
            message.setText("Wrong username or password");
        }

    }
}
