package Control;

import Cipher.Affine;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AffineController {
    public TextField AffineEplain;
    public TextField AffineEkey;
    public Button AffineEsure;
    public Button AffineEempty;
    public TextField AffineEcipher;
    public Button AffineEexit;
    public TextField AffineDcipher;
    public TextField AffineDkey;
    public Button AffineDsure;
    public Button AffineDempty;
    public TextField AffineDplain;
    public Button AffineDexit;
    private MainApp mainApp;
    private Affine affine;

    public void AffineEsureEvent(ActionEvent event) {
        affine=new Affine();
        String ciphertext;
        boolean isOk= affine.isOK(AffineEplain, AffineEkey);
        if(isOk){
            ciphertext=affine.encrypt(AffineEplain, AffineEkey);
            AffineEcipher.setText(ciphertext);
        }
    }

    public void AffineEemptyEvent(ActionEvent event) {
        AffineEcipher.setText(null);
        AffineEplain.setText(null);
        AffineEkey.setText(null);
    }

    public void AffineEexitEvent(ActionEvent event) {
        Stage stage = (Stage) AffineEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AffineDsureEvent(ActionEvent event) {
        affine=new Affine();
        String plaintext;
        boolean isOk= affine.isOK(AffineDcipher, AffineDkey);
        if(isOk){
            plaintext=affine.decrypt(AffineDcipher, AffineDkey);
            AffineDplain.setText(plaintext);
        }
    }

    public void AffineDemptyEvent(ActionEvent event) {
        AffineDcipher.setText(null);
        AffineDplain.setText(null);
        AffineDkey.setText(null);
    }

    public void AffineDexitEvent(ActionEvent event) {
        Stage stage = (Stage) AffineDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
