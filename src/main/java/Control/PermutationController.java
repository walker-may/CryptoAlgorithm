package Control;

import Cipher.AutokeyPlaintext;
import Cipher.Permutation;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PermutationController {
    public TextField PermutationEplain;
    public TextField PermutationEkey;
    public Button PermutationEsure;
    public Button PermutationEempty;
    public TextField PermutationEcipher;
    public Button PermutationEexit;
    public TextField PermutationDcipher;
    public TextField PermutationDkey;
    public Button PermutationDsure;
    public Button PermutationDempty;
    public TextField PermutationDplain;
    public Button PermutationDexit;
    private MainApp mainApp;
    private Permutation permutation;

    public void PermutationEsureEvent(ActionEvent event) {
        permutation=new Permutation();
        String ciphertext;
        boolean isOk= permutation.isOK(PermutationEplain, PermutationEkey);
        if(isOk){
            ciphertext=permutation.encrypt(PermutationEplain, PermutationEkey);
            PermutationEcipher.setText(ciphertext);
        }
    }

    public void PermutationEemptyEvent(ActionEvent event) {
        PermutationEcipher.setText(null);
        PermutationEplain.setText(null);
        PermutationEkey.setText(null);
    }

    public void PermutationDexitEvent(ActionEvent event) {
        Stage stage = (Stage) PermutationDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void PermutationDsureEvent(ActionEvent event) {
        permutation=new Permutation();
        String plaintext;
        boolean isOk= permutation.isOK(PermutationDcipher, PermutationDkey);
        if(isOk){
            plaintext=permutation.decrypt(PermutationDcipher, PermutationDkey);
            PermutationDplain.setText(plaintext);
        }
    }

    public void PermutationDemptyEvent(ActionEvent event) {
        PermutationDcipher.setText(null);
        PermutationDplain.setText(null);
        PermutationDkey.setText(null);
    }

    public void PermutationEexitEvent(ActionEvent event) {
        Stage stage = (Stage) PermutationEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
