package Control;

import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class beginningController {
    @FXML
    private Button btn_1;
    @FXML
    private Button btn_2;
    @FXML
    private Button btn_3;

    private MainApp mainApp;

    @FXML
    private void buttonClickEvent1(){
        this.mainApp=new MainApp();
        this.mainApp.showEncrypt();
        exit(btn_1);
    }

    @FXML
    private void buttonClickEvent2(){
        this.mainApp=new MainApp();
        this.mainApp.showDecrypt();
        exit(btn_2);
    }

    @FXML
    void buttonClickEvent3(){
        this.mainApp=new MainApp();
        this.mainApp.showExit();
        exit(btn_3);
    }

    void exit(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
