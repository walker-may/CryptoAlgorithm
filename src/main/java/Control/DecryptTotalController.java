package Control;

import View.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DecryptTotalController {
    public Button keywordDButton;
    public Button AffineDButton;
    public Button MultiliteralDButton;
    public Button VigenereDButton;
    public Button PlayfairDButton;
    public Button AutokeyciphertextDButton;
    public Button AutokeyplaintextDButton;
    public Button DoubleTranspositionDButton;
    public Button PermutationDButton;
    public Button ColumnpermutationDButton;
    public Button RC4DButton;
    public Button DESDButton;
    public Button AESDButton;
    public Button RSADButton;
    public Button ECCDButton;
    public Button MD5DButton;
    public Button DHDButton;
    @FXML
    private Button btn_7;
    @FXML
    private Button CaesarDButton;

    private MainApp mainApp;

    public void buttonClickEvent7(ActionEvent event){
        Stage stage = (Stage) btn_7.getScene().getWindow();
        stage.close();
        mainApp=new MainApp();
        Stage primaryStage=new Stage();
        try {
            mainApp.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CaesarDEvent(){
        this.mainApp=new MainApp();
        this.mainApp.showCaesarD();
        exit(CaesarDButton);
    }

    void exit(Button button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void keywordDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showKeywordD();
        exit(keywordDButton);
    }

    public void AffineDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAffineD();
        exit(AffineDButton);
    }

    public void MultiliteralDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showMultiliteralD();
        exit(MultiliteralDButton);
    }

    public void VigenereDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showVigenereD();
        exit(VigenereDButton);
    }

    public void PlayfairDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showPlayfairD();
        exit(PlayfairDButton);
    }

    public void AutokeyciphertextDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAutokeyCiphertextD();
        exit(AutokeyciphertextDButton);
    }

    public void AutokeyplaintextDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAutokeyPlaintextD();
        exit(AutokeyplaintextDButton);
    }

    public void DoubleTranspositionDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showDoubleTranspositionD();
        exit(DoubleTranspositionDButton);
    }

    public void PermutationDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showPermutationD();
        exit(PermutationDButton);
    }

    public void ColumnpermutationDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showColumnPermutationD();
        exit(ColumnpermutationDButton);
    }

    public void RC4DEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showRC4D();
        exit(RC4DButton);
    }

    public void DESDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showDESD();
        exit(DESDButton);
    }

    public void AESDEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showAESD();
        exit(AESDButton);
    }

    public void RSADEvent(ActionEvent event) {
        this.mainApp=new MainApp();
        this.mainApp.showRSAD();
        exit(RSADButton);
    }

    public void ECCDEvent(ActionEvent event) {
    }

    public void DHDEvent(ActionEvent event) {
    }
}
