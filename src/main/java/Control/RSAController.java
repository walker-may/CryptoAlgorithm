package Control;

import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.security.interfaces.RSAPublicKey;

public class RSAController {
    public TextField RSApublicKey;
    public Button RSAEsure;
    public Button RSAEempty;
    public TextField RSAEcipher;
    public Button RSAEquit;
    public TextField RSADcipher;
    public TextField RSAprivateKey;
    public Button RSADsure;
    public Button RSADempty;
    public TextField RSADplain;
    public Button RSADquit;
    public TextField RSAEplain;
    private MainApp mainApp;

    public void RSAEsureEvent(ActionEvent event) {
    }

    public void RSAEemptyEvent(ActionEvent event) {
        RSAEcipher.setText(null);
        RSApublicKey.setText(null);
        RSAEplain.setText(null);
    }

    public void RSAEqiutEvent(ActionEvent event) {
        Stage stage = (Stage) RSAEquit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RSADsureEvent(ActionEvent event) {
    }

    public void RSADemptyEvent(ActionEvent event) {
        RSADcipher.setText(null);
        RSADplain.setText(null);
        RSAprivateKey.setText(null);
    }

    public void RSADqiutEvent(ActionEvent event) {
        Stage stage = (Stage) RSADquit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
