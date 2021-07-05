package Control;

import Cipher.DES;
import Cipher.RC4;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DESController {
    public TextField DESDcipher;
    public TextField DESDkey;
    public Button DESDsure;
    public Button DESDempty;
    public TextField DESDplain;
    public Button DESDexit;
    public TextField DESEplain;
    public TextField DESEkey;
    public Button DESEsure;
    public Button DESEempty;
    public TextField DESEcipher;
    public Button DESEexit;
    public MainApp mainApp;
    private DES des;

    public void DESDsureEvent(ActionEvent event) {
        des=new DES();
        String plaintext;
        boolean isOk= des.isOK(DESDcipher, DESDkey);
        if(isOk){
            plaintext=des.decrypt(DESDcipher, DESDkey);
            DESDplain.setText(plaintext);
        }
    }

    public void DESDemptyEvent(ActionEvent event) {
        DESDcipher.setText(null);
        DESDkey.setText(null);
        DESDplain.setText(null);
    }

    public void DESDexitEvent(ActionEvent event) {
        Stage stage = (Stage) DESDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DESEsureEvent(ActionEvent event) {
        des =new DES();
        String ciphertext;
        boolean isOk= des.isOK(DESEplain, DESEkey);
        if(isOk){
            ciphertext= des.encrypt(DESEplain, DESEkey);
            DESEcipher.setText(ciphertext);
        }
    }

    public void DESEemptyEvent(ActionEvent event) {
        DESEcipher.setText(null);
        DESEkey.setText(null);
        DESEplain.setText(null);
    }

    public void DESEexitEvent(ActionEvent event) {
        Stage stage = (Stage) DESEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
