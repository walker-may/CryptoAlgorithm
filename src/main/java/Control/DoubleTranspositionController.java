package Control;

import Cipher.DoubleTransposition;
import Cipher.Permutation;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DoubleTranspositionController {
    public TextField DoubleTranspositionDcipher;
    public Button DoubleTranspositionDsure;
    public Button DoubleTranspositionDempty;
    public TextField DoubleTranspositionDplain;
    public Button DoubleTranspositionDexit;
    public TextField DoubleTranspositionEplain;
    public Button DoubleTranspositionEsure;
    public Button DoubleTranspositionEempty;
    public TextField DoubleTranspositionEcipher;
    public Button DoubleTranspositionEexit;
    public TextField DoubleTranspositionDkey2;
    public TextField DoubleTranspositionDkey1;
    public TextField DoubleTranspositionEkey1;
    public TextField DoubleTranspositionEkey2;
    private MainApp mainApp;
    private DoubleTransposition doubleTransposition;

    public void DoubleTranspositionDsureEvent(ActionEvent event) {
        doubleTransposition=new DoubleTransposition();
        String plaintext;
        boolean isOk= doubleTransposition.isOK(DoubleTranspositionDcipher, DoubleTranspositionDkey1,DoubleTranspositionDkey2);
        if(isOk){
            plaintext=doubleTransposition.decrypt(DoubleTranspositionDcipher, DoubleTranspositionDkey1,DoubleTranspositionDkey2);
            DoubleTranspositionDplain.setText(plaintext);
        }
    }

    public void DoubleTranspositionDemptyEvent(ActionEvent event) {
        DoubleTranspositionDplain.setText(null);
        DoubleTranspositionDcipher.setText(null);
        DoubleTranspositionDkey1.setText(null);
        DoubleTranspositionDkey2.setText(null);
    }

    public void DoubleTranspositionDexitEvent(ActionEvent event) {
        Stage stage = (Stage) DoubleTranspositionDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DoubleTranspositionEsureEvent(ActionEvent event) {
        doubleTransposition=new DoubleTransposition();
        String ciphertext;
        boolean isOk= doubleTransposition.isOK(DoubleTranspositionEplain, DoubleTranspositionEkey1,DoubleTranspositionEkey2);
        if(isOk){
            ciphertext=doubleTransposition.encrypt(DoubleTranspositionEplain, DoubleTranspositionEkey1,DoubleTranspositionEkey2);
            DoubleTranspositionEcipher.setText(ciphertext);
        }
    }

    public void DoubleTranspositionEemptyEvent(ActionEvent event) {
        DoubleTranspositionEplain.setText(null);
        DoubleTranspositionEcipher.setText(null);
        DoubleTranspositionEkey1.setText(null);
        DoubleTranspositionEkey2.setText(null);
    }

    public void DoubleTranspositionEexitEvent(ActionEvent event) {
        Stage stage = (Stage) DoubleTranspositionEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
