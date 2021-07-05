package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application{
    private Stage primaryStage;
    private AnchorPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("beginning.fxml"));
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("信息加解密系统");

        showBegin();
    }

    public void showBegin() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("beginning.fxml"));
            rootLayout =  loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void showEncrypt(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EncryptTotal.fxml"));
            AnchorPane personOverview = loader.load();


            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDecrypt(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("DecryptTotal.fxml"));
            AnchorPane personOverview =  loader.load();

            dialogStage.initOwner(primaryStage);
            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showExit(){
        try {
            // Load person overview.
            Stage logStage=new Stage();
            logStage.setTitle("退出");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Exit.fxml"));
            AnchorPane persverview =  loader.load();

            logStage.initOwner(primaryStage);
            Scene scene=new Scene(persverview);
            logStage.setScene(scene);
            logStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCaesarE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Caesar加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CaesarEncrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCaesarD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Caesar解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CaesarDecrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showKeywordE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("keyword加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("keywordEncrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showKeywordD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("keyword解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("keywordDecrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAESD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("AES解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AESD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAESE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("AES加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AESE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAffineD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Affine解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AffineDecrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAffineE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Affine加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AffineEncrypt.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAutokeyCiphertextD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Autokey Ciphertext解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AutokeyCiphertextD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAutokeyCiphertextE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Autokey Ciphertext加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AutokeyCiphertextE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAutokeyPlaintextE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Autokey Plaintext加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AutokeyPlaintextE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAutokeyPlaintextD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Autokey Plaintext解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("AutokeyPlaintextD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCAE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("CA加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CAE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showCAD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("CA解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CAD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showColumnPermutationE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Column Permutation加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("ColumnPermutationE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showColumnPermutationD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Column Permutation解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("ColumnPermutationD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDESE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("DES加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("DESE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDESD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("DES解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("DESD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDoubleTranspositionD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Double Transition解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("DoubleTranspositionD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showDoubleTranspositionE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Double Transition加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("DoubleTranspositionE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showMultiliteralD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Multiliteral解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MultiliteralD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showMultiliteralE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Multiliteral加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MultiliteralE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPermutationD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Permutation解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PermutationD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPermutationE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Permutation加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PermutationE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPlayfairD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Playfair解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PlayfairD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showPlayfairE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Playfair加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("PlayfairE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRC4D(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("RC4解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RC4D.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showRC4E(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("RC4加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RC4E.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showVigenereE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Vigenere加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("VigenereE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showVigenereD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("Vigenere解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("VigenereD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMD5(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("MD5报文摘要");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("MD5.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRSAE(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("RSA加密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RSAE.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRSAD(){
        try {
            // Load person overview.
            Stage dialogStage=new Stage();
            dialogStage.setTitle("RSA解密");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RSAD.fxml"));
            AnchorPane personOverview =  loader.load();

            Scene scene=new Scene(personOverview);
            dialogStage.setScene(scene);
            dialogStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
