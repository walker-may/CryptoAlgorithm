package Control;

import Cipher.AutokeyCiphertext;
import Cipher.AutokeyPlaintext;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AutokeyPlaintextController {
    public TextField AutokeyPlaintextEplain;
    public TextField AutokeyPlaintextEkey;
    public Button AutokeyPlaintextEsure;
    public Button AutokeyPlaintextEempty;
    public TextField AutokeyPlaintextEcipher;
    public Button AutokeyPlaintextEexit;
    public TextField AutokeyPlaintextDcipher;
    public TextField AutokeyPlaintextDkey;
    public Button AutokeyPlaintextDsure;
    public Button AutokeyPlaintextDempty;
    public TextField AutokeyPlaintextDplain;
    public Button AutokeyPlaintextDexit;
    public MainApp mainApp;
    private AutokeyPlaintext autokeyPlaintext;

    public void AutokeyPlaintextEsureEvent(ActionEvent event) {
        autokeyPlaintext=new AutokeyPlaintext();
        String ciphertext;
        boolean isOk= autokeyPlaintext.isOK(AutokeyPlaintextEplain, AutokeyPlaintextEkey);
        if(isOk){
            ciphertext=autokeyPlaintext.encrypt(AutokeyPlaintextEplain, AutokeyPlaintextEkey);
            AutokeyPlaintextEcipher.setText(ciphertext);
        }
    }

    public void AutokeyPlaintextEemptyEvent(ActionEvent event) {
        AutokeyPlaintextEplain.setText(null);
        AutokeyPlaintextEkey.setText(null);
        AutokeyPlaintextEcipher.setText(null);
    }

    public void AutokeyPlaintextEexitEvent(ActionEvent event) {
        Stage stage = (Stage) AutokeyPlaintextEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AutokeyPlaintextDsureEvent(ActionEvent event) {
        autokeyPlaintext=new AutokeyPlaintext();
        String plaintext;
        boolean isOk= autokeyPlaintext.isOK(AutokeyPlaintextDcipher, AutokeyPlaintextDkey);
        if(isOk){
            plaintext=autokeyPlaintext.decrypt(AutokeyPlaintextDcipher, AutokeyPlaintextDkey);
            AutokeyPlaintextDplain.setText(plaintext);
        }
    }

    public void AutokeyPlaintextDemptyEvent(ActionEvent event) {
        AutokeyPlaintextDplain.setText(null);
        AutokeyPlaintextDkey.setText(null);
        AutokeyPlaintextDcipher.setText(null);
    }

    public void AutokeyPlaintextDexitEvent(ActionEvent event) {
        Stage stage = (Stage) AutokeyPlaintextDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
