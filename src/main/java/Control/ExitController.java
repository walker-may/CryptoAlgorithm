package Control;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import View.MainApp;

import java.io.IOException;

public class ExitController {
    @FXML
    private Button btn_4;
    @FXML
    private Button btn_5;

    private MainApp mainApp;

    public void buttonClickEvent4(ActionEvent event){
        Stage stage = (Stage) btn_4.getScene().getWindow();
        stage.close();
    }

    public void buttonClickEvent5(ActionEvent event){
        Stage stage = (Stage) btn_5.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        Stage primaryStage=new Stage();
        try {
            mainApp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
