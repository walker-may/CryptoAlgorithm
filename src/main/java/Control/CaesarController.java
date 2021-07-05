package Control;

import Cipher.Caesar;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CaesarController {
    @FXML
    public TextField CaesarDcipher;
    @FXML
    public TextField CaesarDkey;
    @FXML
    public Button CaesarEsure;
    @FXML
    public Button CaesarEempty;
    @FXML
    public TextField CaesarEcipher;
    public Button CaesarDsure;
    public TextField CaesarEplain;
    public TextField CaesarEkey;
    public TextField CaesarDplain;
    public Button CaesarDempty;
    @FXML
    private Button btn_8;
    @FXML
    private Button btn_9;

    private MainApp mainApp;

    private Caesar caesar;

    public void buttonClickEvent8(){
        Stage stage = (Stage) btn_8.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showDecrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buttonClickEvent9(){
        Stage stage = (Stage) btn_9.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        try {
            mainApp.showEncrypt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CaesarDsureEvent(ActionEvent event) {
        caesar=new Caesar();
        String plaintext;
        boolean isOk= caesar.isDecrypt(CaesarDcipher, CaesarDkey);
        if(isOk){
            plaintext=caesar.decrypt(CaesarDcipher, CaesarDkey);
            CaesarDplain.setText(plaintext);
        }
    }

    public void CaesarEemptyEvent(ActionEvent event) {
        CaesarEplain.setText(null);
        CaesarEkey.setText(null);
        CaesarEcipher.setText(null);
    }

    public void CaesarEsureEvent(ActionEvent event) {
        caesar=new Caesar();
        String ciphertext;
        boolean isOk= caesar.isEncrypt(CaesarEplain, CaesarEkey);
        if(isOk){
            ciphertext=caesar.encrypt(CaesarEplain, CaesarEkey);
            CaesarEcipher.setText(ciphertext);
        }
    }

    public void CaesarDemptyEvent(ActionEvent event) {
        CaesarDcipher.setText(null);
        CaesarDkey.setText(null);
        CaesarDplain.setText(null);
    }
}
