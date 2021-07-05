package Control;

import Cipher.Affine;
import Cipher.Vigenere;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VigenereController {
    public TextField VigenereDcipher;
    public TextField VigenereDkey;
    public Button VigenereDsure;
    public Button VigenereDempty;
    public TextField VigenereDplain;
    public Button VigenereDexit;
    public TextField VigenereEplain;
    public TextField VigenereEkey;
    public Button VigenereEsure;
    public Button VigenereEempty;
    public TextField VigenereEcipher;
    public Button VigenereEexit;
    private MainApp mainApp;
    private Vigenere vigenere;

    public void VigenereDsureEvent(ActionEvent event) {
        vigenere=new Vigenere();
        String plaintext;
        boolean isOk= vigenere.isOK(VigenereDcipher, VigenereDkey);
        if(isOk){
            plaintext=vigenere.decrypt(VigenereDcipher, VigenereDkey);
            VigenereDplain.setText(plaintext);
        }
    }

    public void VigenereDemptyEvent(ActionEvent event) {
        VigenereDcipher.setText(null);
        VigenereDkey.setText(null);
        VigenereDplain.setText(null);
    }

    public void VigenereDexitEvent(ActionEvent event) {
        Stage stage = (Stage) VigenereDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VigenereEsureEvent(ActionEvent event) {
        vigenere=new Vigenere();
        String ciphertext;
        boolean isOk= vigenere.isOK(VigenereEplain, VigenereEkey);
        if(isOk){
            ciphertext=vigenere.encrypt(VigenereEplain, VigenereEkey);
            VigenereEcipher.setText(ciphertext);
        }
    }

    public void VigenereEemptyEvent(ActionEvent event) {
        VigenereEcipher.setText(null);
        VigenereEkey.setText(null);
        VigenereEplain.setText(null);
    }

    public void VigenereEexitEvent(ActionEvent event) {
        Stage stage = (Stage) VigenereEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
