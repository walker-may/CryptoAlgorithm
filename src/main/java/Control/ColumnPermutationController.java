package Control;

import Cipher.ColumnPermutation;
import Cipher.Permutation;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ColumnPermutationController {
    public TextField ColumnPermutationDcipher;
    public TextField ColumnPermutationDkey;
    public Button ColumnPermutationDsure;
    public Button ColumnPermutationDempty;
    public TextField ColumnPermutationDplain;
    public Button ColumnPermutationDexit;
    public TextField ColumnPermutationEplain;
    public TextField ColumnPermutationEkey;
    public Button ColumnPermutationEsure;
    public Button ColumnPermutationEempty;
    public TextField ColumnPermutationEcipher;
    public Button ColumnPermutationEexit;
    private MainApp mainApp;
    private ColumnPermutation columnPermutation;

    public void ColumnPermutationDsureEvent(ActionEvent event) {
        columnPermutation=new ColumnPermutation();
        String plaintext;
        boolean isOk= columnPermutation.isOK(ColumnPermutationDcipher, ColumnPermutationDkey);
        if(isOk){
            plaintext=columnPermutation.decrypt(ColumnPermutationDcipher, ColumnPermutationDkey);
            ColumnPermutationDplain.setText(plaintext);
        }
    }

    public void ColumnPermutationDemptyEvent(ActionEvent event) {
        ColumnPermutationDcipher.setText(null);
        ColumnPermutationDplain.setText(null);
        ColumnPermutationDkey.setText(null);
    }

    public void ColumnPermutationDexitEvent(ActionEvent event) {
        Stage stage = (Stage) ColumnPermutationDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ColumnPermutationEsureEvent(ActionEvent event) {
        columnPermutation=new ColumnPermutation();
        String ciphertext;
        boolean isOk= columnPermutation.isOK(ColumnPermutationEplain, ColumnPermutationEkey);
        if(isOk){
            ciphertext=columnPermutation.encrypt(ColumnPermutationEplain, ColumnPermutationEkey);
            ColumnPermutationEcipher.setText(ciphertext);
        }
    }

    public void ColumnPermutationEemptyEvent(ActionEvent event) {
        ColumnPermutationEcipher.setText(null);
        ColumnPermutationEplain.setText(null);
        ColumnPermutationEkey.setText(null);
    }

    public void ColumnPermutationEexitEvent(ActionEvent event) {
        Stage stage = (Stage) ColumnPermutationEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
