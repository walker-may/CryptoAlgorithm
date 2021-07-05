package Control;

import Cipher.AutokeyPlaintext;
import Cipher.Playfair;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayfairController {
    public TextField PlayfairDcipher;
    public TextField PlayfairDkey;
    public Button PlayfairDsure;
    public Button PlayfairDempty;
    public TextField PlayfairDplain;
    public Button PlayfairDexit;
    public TextField PlayfairEplain;
    public TextField PlayfairEkey;
    public Button PlayfairEsure;
    public Button PlayfairEempty;
    public TextField PlayfairEcipher;
    public Button PlayfairEexit;
    private MainApp mainApp;
    private Playfair playfair;

    public void PlayfairDsureEvent(ActionEvent event) {
        playfair=new Playfair();
        String plaintext;
        boolean isOk= playfair.isOK(PlayfairDcipher, PlayfairDkey);
        if(isOk){
            plaintext=playfair.decrypt(PlayfairDcipher, PlayfairDkey);
            PlayfairDplain.setText(plaintext);
        }
    }

    public void PlayfairDemptyEvent(ActionEvent event) {
        PlayfairDcipher.setText(null);
        PlayfairDkey.setText(null);
        PlayfairDplain.setText(null);
    }

    public void PlayfairDexitEvent(ActionEvent event) {
        Stage stage = (Stage) PlayfairDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PlayfairEsureEvent(ActionEvent event) {
        playfair=new Playfair();
        String ciphertext;
        boolean isOk= playfair.isOK(PlayfairEplain, PlayfairEkey);
        if(isOk){
            ciphertext=playfair.encrypt(PlayfairEplain, PlayfairEkey);
            PlayfairEcipher.setText(ciphertext);
        }
    }

    public void PlayfairEemptyEvent(ActionEvent event) {
        PlayfairEcipher.setText(null);
        PlayfairEkey.setText(null);
        PlayfairEplain.setText(null);
    }

    public void PlayfairEexitEvent(ActionEvent event) {
        Stage stage = (Stage) PlayfairEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
