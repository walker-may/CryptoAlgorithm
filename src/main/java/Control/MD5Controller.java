package Control;

import Cipher.DES;
import Cipher.MD5;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MD5Controller {
    public TextField MD5plain;
    public Button MD5sure;
    public Button MD5empty;
    public Button MD5exit;
    public TextField MD5cipher;
    private MainApp mainApp;
    private MD5 md5;

    public void MD5sureEvent(ActionEvent event) {
        md5 =new MD5();
        String ciphertext;
        boolean isOk= md5.isOK(MD5plain);
        if(isOk){
            ciphertext= md5.encrypt(MD5plain);
            MD5cipher.setText(ciphertext);
        }
    }

    public void MD5emptyEvent(ActionEvent event) {
        MD5plain.setText(null);
        MD5cipher.setText(null);
    }

    public void MD5exitEvent(ActionEvent event) {
        Stage stage = (Stage) MD5exit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
