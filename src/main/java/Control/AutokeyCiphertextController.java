package Control;

import Cipher.AutokeyCiphertext;
import Cipher.Vigenere;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AutokeyCiphertextController {
    public TextField AutokeyCiphertextEplain;
    public TextField AutokeyCiphertextEkey;
    public Button AutokeyCiphertextEsure;
    public Button AutokeyCiphertextEempty;
    public TextField AutokeyCiphertextEcipher;
    public Button AutokeyCiphertextEexit;
    public TextField AutokeyCiphertextDkey;
    public Button AutokeyCiphertextDsure;
    public Button AutokeyCiphertextDempty;
    public TextField AutokeyCiphertextDplain;
    public Button AutokeyCiphertextDexit;
    public TextField AutokeyCiphertextDcipher;
    private MainApp mainApp;
    private AutokeyCiphertext autokeyCiphertext;

    public void AutokeyCiphertextEsureEvent(ActionEvent event) {
        autokeyCiphertext=new AutokeyCiphertext();
        String ciphertext;
        boolean isOk= autokeyCiphertext.isOK(AutokeyCiphertextEplain, AutokeyCiphertextEkey);
        if(isOk){
            ciphertext=autokeyCiphertext.encrypt(AutokeyCiphertextEplain, AutokeyCiphertextEkey);
            AutokeyCiphertextEcipher.setText(ciphertext);
        }
    }

    public void AutokeyCiphertextEemptyEvent(ActionEvent event) {
        AutokeyCiphertextEplain.setText(null);
        AutokeyCiphertextEkey.setText(null);
        AutokeyCiphertextEcipher.setText(null);
    }

    public void AutokeyCiphertextEexitEvent(ActionEvent event) {
        Stage stage = (Stage) AutokeyCiphertextEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AutokeyCiphertextDsureEvent(ActionEvent event) {
        autokeyCiphertext=new AutokeyCiphertext();
        String plaintext;
        boolean isOk= autokeyCiphertext.isOK(AutokeyCiphertextDcipher, AutokeyCiphertextDkey);
        if(isOk){
            plaintext=autokeyCiphertext.decrypt(AutokeyCiphertextDcipher, AutokeyCiphertextDkey);
            AutokeyCiphertextDplain.setText(plaintext);
        }
    }

    public void AutokeyCiphertextDemptyEvent(ActionEvent event) {
        AutokeyCiphertextDplain.setText(null);
        AutokeyCiphertextDkey.setText(null);
        AutokeyCiphertextDcipher.setText(null);
    }

    public void AutokeyCiphertextDexitEvent(ActionEvent event) {
        Stage stage = (Stage) AutokeyCiphertextDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
