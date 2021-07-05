package Control;

import Cipher.Affine;
import Cipher.Multiliteral;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MultiliteralController {
    public TextField MultiliteralDcipher;
    public TextField MultiliteralDkey;
    public Button MultiliteralDsure;
    public Button MultiliteralDempty;
    public TextField MultiliteralDplain;
    public Button MultiliteralDexit;
    public TextField MultiliteralEplain;
    public TextField MultiliteralEkey;
    public Button MultiliteralEsure;
    public Button MultiliteralEempty;
    public TextField MultiliteralEcipher;
    public Button MultiliteralEexit;
    private MainApp mainApp;
    private Multiliteral multiliteral;

    public void MultiliteralDsureEvent(ActionEvent event) {
        multiliteral=new Multiliteral();
        String plaintext;
        boolean isOk= multiliteral.isOK(MultiliteralDcipher, MultiliteralDkey);
        if(isOk){
            plaintext=multiliteral.decrypt(MultiliteralDcipher, MultiliteralDkey);
            MultiliteralDplain.setText(plaintext);
        }
    }

    public void MultiliteralDemptyEvent(ActionEvent event) {
        MultiliteralDcipher.setText(null);
        MultiliteralDplain.setText(null);
        MultiliteralDkey.setText(null);
    }

    public void MultiliteralDexitEvent(ActionEvent event) {
        Stage stage = (Stage) MultiliteralDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MultiliteralEsureEvent(ActionEvent event) {
        multiliteral=new Multiliteral();
        String ciphertext;
        boolean isOk= multiliteral.isOK(MultiliteralEplain, MultiliteralEkey);
        if(isOk){
            ciphertext=multiliteral.encrypt(MultiliteralEplain, MultiliteralEkey);
            MultiliteralEcipher.setText(ciphertext);
        }
    }

    public void MultiliteralEemptyEvent(ActionEvent event) {
        MultiliteralEcipher.setText(null);
        MultiliteralEplain.setText(null);
        MultiliteralEkey.setText(null);
    }

    public void MultiliteralEexitEvent(ActionEvent event) {
        Stage stage = (Stage) MultiliteralEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
