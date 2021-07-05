package Control;

import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CAController {
    public TextField CAEkey;
    public Button CAEsure;
    public Button CAEempty;
    public TextField CAEplain;
    public TextField CAEcipher;
    public Button CAEexit;
    public TextField CADcipher;
    public TextField CADkey;
    public Button CADsure;
    public Button CADempty;
    public TextField CADplain;
    public Button CADexit;
    public MainApp mainApp;

    public void CAEsureEvent(ActionEvent event) {
    }

    public void CAEemptyEvent(ActionEvent event) {
    }

    public void CAEexitEvent(ActionEvent event) {
        Stage stage = (Stage) CAEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CADsureEvent(ActionEvent event) {
    }

    public void CADemptyEvent(ActionEvent event) {
    }

    public void CADexitEvent(ActionEvent event) {
        Stage stage = (Stage) CADexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
