package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.DbFonctions;
import model.EggTypeClass;

import java.sql.SQLException;

public class AddEggTypeController {
    @FXML
    private JFXButton add;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField price;

    public void closeWindow(ActionEvent event){
        Stage stage = (Stage) (((Node)(event.getSource())).getScene()).getWindow();
        stage.close();
    }

    @FXML
    void addEggType(ActionEvent event) throws SQLException {
        TypesEggController.typesEggList.add(new EggTypeClass(0,name.getText(),Double.parseDouble(price.getText())));
        for(int i =0 ; i < TypesEggController.typesEggList.size() ;i++){
            TypesEggController.typesEggList.get(i).setNum(i+1);
        }
        DbFonctions.addTypeEgg(LoginController.connection,name.getText(),Double.parseDouble(price.getText()));
        name.setText("");
        price.setText("");
    }
}
