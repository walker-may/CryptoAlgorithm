package Control;

import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AESController {
    public TextField AESEplain;
    public TextField AESEkey;
    public Button AESEsure;
    public Button AESEempty;
    public TextField AESEcipher;
    public Button AESEexit;
    public TextField AESDcipher;
    public TextField AESDkey;
    public Button AESDsure;
    public Button AESDempty;
    public TextField AESDplain;
    public Button AESDexit;
    private MainApp mainApp;

    public void AESEsureEvent(ActionEvent event) {
    }

    public void AESEemptyEvent(ActionEvent event) {
    }

    public void AESEexitEvent(ActionEvent event) {
        Stage stage = (Stage) AESEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AESDsureEvent(ActionEvent event) {
    }

    public void AESDemptyEvent(ActionEvent event) {
    }

    public void AESDexitEvent(ActionEvent event) {
        Stage stage = (Stage) AESDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
