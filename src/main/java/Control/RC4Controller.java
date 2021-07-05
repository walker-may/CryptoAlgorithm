package Control;

import Cipher.Permutation;
import Cipher.RC4;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RC4Controller {
    public TextField RC4Eplain;
    public TextField RC4Ekey;
    public Button RC4Esure;
    public Button RC4Eempty;
    public TextField RC4Ecipher;
    public Button RC4Eexit;
    public TextField RC4Dcipher;
    public TextField RC4Dkey;
    public Button RC4Dsure;
    public Button RC4Dempty;
    public TextField RC4Dplain;
    public Button RC4Dexit;
    private MainApp mainApp;
    private RC4 rc4;

    public void RC4EsureEvent(ActionEvent event) {
        rc4 =new RC4();
        String ciphertext;
        boolean isOk= rc4.isOK(RC4Eplain, RC4Ekey);
        if(isOk){
            ciphertext= rc4.encrypt(RC4Eplain, RC4Ekey);
            RC4Ecipher.setText(ciphertext);
        }
    }

    public void RC4EemptyEvent(ActionEvent event) {
        RC4Ecipher.setText(null);
        RC4Ekey.setText(null);
        RC4Eplain.setText(null);
    }

    public void RC4EexitEvent(ActionEvent event) {
        Stage stage = (Stage) RC4Eexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RC4DsureEvent(ActionEvent event) {
        rc4=new RC4();
        String plaintext;
        boolean isOk= rc4.isOK(RC4Dcipher, RC4Dkey);
        if(isOk){
            plaintext=rc4.decrypt(RC4Dcipher, RC4Dkey);
            RC4Dplain.setText(plaintext);
        }
    }

    public void RC4DemptyEvent(ActionEvent event) {
        RC4Dcipher.setText(null);
        RC4Dkey.setText(null);
        RC4Dplain.setText(null);
    }

    public void RC4DexitEvent(ActionEvent event) {
        Stage stage = (Stage) RC4Dexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
