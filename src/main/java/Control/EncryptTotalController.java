package Control;

import Cipher.Affine;
import View.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import View.MainApp;
import javafx.scene.control.Button;

public class EncryptTotalController {
    public Button keywordEButton;
    public Button AffineEButton;
    public Button MultiliteralEButton;
    public Button VigenereEButton;
    public Button PlayfairEButton;
    public Button AutokeyciphertextEButton;
    public Button AutokeyplaintextEButton;
    public Button DoubleTranspositionEButton;
    public Button PermutationEButton;
    public Button ColumnpermutationEButton;
    public Button RC4EButton;
    public Button DESEButton;
    public Button AESEButton;
    public Button RSAEButton;
    public Button ECCEButton;
    public Button MD5EButton;
    public Button DHEButton;
    @FXML
    private Button btn_6;
    @FXML
    private Button CaesarEButton;

    private MainApp mainApp;

    public void buttonClickEvent6(ActionEvent event){
        Stage stage = (Stage) btn_6.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        Stage primaryStage=new Stage();
        try {
            mainApp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CaesarEEvent(){
        this.mainApp=new MainApp();
        this.mainApp.showCaesarE();
        exit(CaesarEButton);
    }

    void exit(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void keywordEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showKeywordE();
        exit(keywordEButton);
    }

    public void AffineEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAffineE();
        exit(AffineEButton);
    }

    public void MultiliteralEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showMultiliteralE();
        exit(MultiliteralEButton);
    }

    public void VigenereEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showVigenereE();
        exit(VigenereEButton);
    }

    public void PlayfairEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showPlayfairE();
        exit(PlayfairEButton);
    }

    public void AutokeyciphertextEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAutokeyCiphertextE();
        exit(AutokeyciphertextEButton);
    }

    public void AutokeyplaintextEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAutokeyPlaintextE();
        exit(AutokeyplaintextEButton);
    }

    public void DoubleTranspositionEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showDoubleTranspositionE();
        exit(DoubleTranspositionEButton);
    }

    public void PermutationEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showPermutationE();
        exit(PermutationEButton);
    }

    public void ColumnpermutationEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showColumnPermutationE();
        exit(ColumnpermutationEButton);
    }

    public void RC4EEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showRC4E();
        exit(RC4EButton);
    }

    public void DESEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showDESE();
        exit(DESEButton);
    }

    public void AESEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAESE();
        exit(AESEButton);
    }

    public void RSAEEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showRSAE();
        exit(RSAEButton);
    }

    public void ECCEEvent(ActionEvent event) {
    }

    public void MD5EEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showMD5();
        exit(MD5EButton);

    }
    public void DHEEvent(ActionEvent event) {
    }
}
