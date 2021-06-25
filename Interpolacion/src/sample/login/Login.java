package sample.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

public class Login {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private double xOffset,yOffset;
    public static String nombre = "";
    @FXML TextField txt1,txt2;
    
    public void siguiente(ActionEvent event) throws IOException {
        nombre = txt1.getText();
        if (!nombre.equals("")){
            root = FXMLLoader.load(getClass().getResource("../principal/sample.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setX(65);
            stage.setY(20);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset= event.getSceneX();
                    yOffset= event.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Favor de poner tu nombre");
            alert.show();
        }
    }
    public void cerrar(ActionEvent event){
        System.exit(0);
    }
}
