package Control;

import Cipher.Caesar;
import Cipher.Keyword;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KeywordController {
    public TextField keywordEkey;
    public Button keywordEsure;
    public Button keywordEempty;
    public TextField keywordEcipher;
    public Button keywordEexit;
    public TextField keywordDcipher;
    public TextField keywordDkey;
    public Button keywordDsure;
    public Button keywordDempty;
    public TextField keywordDplain;
    public Button keywordDexit;
    public TextField keywordEplain;
    private MainApp mainApp;
    private Keyword keyword;

    public void keywordEsureEvent(ActionEvent event) {
        keyword=new Keyword();
        String ciphertext;
        boolean isOk= keyword.isEncrypt(keywordEplain, keywordEkey);
        if(isOk){
            ciphertext=keyword.encrypt(keywordEplain, keywordEkey);
            keywordEcipher.setText(ciphertext);
        }
    }

    public void keywordEemptyEvent(ActionEvent event) {
        keywordEplain.setText(null);
        keywordEkey.setText(null);
        keywordEcipher.setText(null);
    }

    public void keywordEexitEvent(ActionEvent event) {
        Stage stage = (Stage) keywordEexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        Stage primaryStage=new Stage();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void keywordDsureEvent(ActionEvent event) {
        keyword=new Keyword();
        String plaintext;
        boolean isOk= keyword.isDecrypt(keywordDcipher, keywordDkey);
        if(isOk){
            plaintext=keyword.decrypt(keywordDcipher, keywordDkey);
            keywordDplain.setText(plaintext);
        }
    }

    public void keywordDemptyEvent(ActionEvent event) {
        keywordDcipher.setText(null);
        keywordDkey.setText(null);
        keywordDplain.setText(null);
    }

    public void keywordDexitEvent(ActionEvent event) {
        Stage stage = (Stage) keywordDexit.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        Stage primaryStage=new Stage();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
