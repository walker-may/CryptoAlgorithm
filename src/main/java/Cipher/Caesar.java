package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputControl;

import java.util.Optional;

public class Caesar {
    public boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean informationDialog(Alert.AlertType alterType, String title, String header, String message) {
        // 按钮部分可以使用预设的也可以像这样自己 new 一个
        Alert alert = new Alert(alterType, message, new ButtonType("取消", ButtonBar.ButtonData.CANCEL_CLOSE), new ButtonType("确定", ButtonBar.ButtonData.YES));
        // 设置对话框的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 根据点击结果返回
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// 如果点击了“确定”就返回true
        } else {
            return false;
        }
    }


    public boolean isEncrypt(TextInputControl CaesarEplain,TextInputControl CaesarEkey){
        Caesar caesar=new Caesar();
        char[] plaintext=CaesarEplain.getText().toCharArray();
        char[] key=CaesarEkey.getText().toCharArray();

        if(caesar.isEmpty(CaesarEplain.getText())){
            caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (caesar.isEmpty(CaesarEkey.getText())){
            caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < CaesarEplain.getText().length(); i++) {
            if (!((plaintext[i] <= 'Z' && plaintext[i] >= 'A') || (plaintext[i] <= 'z' && plaintext[i] >= 'a'))) {
                caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入明文不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextInputControl CaesarEplain,TextInputControl CaesarEkey){
        int key=Integer.parseInt(CaesarEkey.getText());
        char[] plaintext=CaesarEplain.getText().toCharArray();
        String ciphertext="";
        for (int i = 0; i < CaesarEplain.getText().length(); i++) {
            char c = plaintext[i];
            if (c <= 'z' && c >= 'a') {// 明文中的小写字符
                c += key % 26;
                if (c < 'a') {// 向左超界
                    c += 26;
                }
                if (c > 'z') {// 向右超界
                    c -= 26;
                }
            }
            if (c <= 'Z' && c >= 'A') {// 明文中的大写字符
                c += key % 26;
                if (c < 'A') {
                    c += 26;
                }
                if (c > 'Z') {
                    c -= 26;
                }
            }
            ciphertext += c;
        }
        return ciphertext;
    }

    public boolean isDecrypt(TextInputControl CaesarDcipher,TextInputControl CaesarDkey){
        Caesar caesar=new Caesar();
        char[] ciphertext=CaesarDcipher.getText().toCharArray();
        char[] key=CaesarDkey.getText().toCharArray();

        if(caesar.isEmpty(CaesarDcipher.getText())){
            caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","密文不能为空");
            return false;
        }
        if (caesar.isEmpty(CaesarDkey.getText())){
            caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < CaesarDcipher.getText().length(); i++) {
            if (!((ciphertext[i] <= 'Z' && ciphertext[i] >= 'A') || (ciphertext[i] <= 'z' && ciphertext[i] >= 'a'))) {
                caesar.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入密文不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String decrypt(TextInputControl CaesarDcipher,TextInputControl CaesarDkey){
        int key=Integer.parseInt(CaesarDkey.getText());
        char[] ciphertext=CaesarDcipher.getText().toCharArray();
        String plaintext="";
        for (int i = 0; i < CaesarDcipher.getText().length(); i++) {
            char c = ciphertext[i];
            if (c <= 'z' && c >= 'a') {// 密文中的小写字符
                c -= key % 26;
                if (c < 'a') {// 向左超界
                    c += 26;
                }
                if (c > 'z') {// 向右超界
                    c -= 26;
                }
            }
            if (c <= 'Z' && c >= 'A') {// 密文中的大写字符
                c -= key % 26;
                if (c < 'A') {
                    c += 26;
                }
                if (c > 'Z') {
                    c -= 26;
                }
            }
            plaintext+= c;
        }
        return plaintext;
    }
}
