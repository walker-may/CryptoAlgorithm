package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Keyword {
    public static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

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

    public boolean isEncrypt(TextInputControl keywordEplain, TextInputControl keywordEkey){
        Keyword keyword=new Keyword();
        char[] plaintext=keywordEplain.getText().toCharArray();
        char[] key=keywordEkey.getText().toCharArray();

        if(keyword.isEmpty(keywordEplain.getText())){
            keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (keyword.isEmpty(keywordEkey.getText())){
            keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < keywordEplain.getText().length(); i++) {
            if (!(plaintext[i] <= 'z' && plaintext[i] >= 'a')) {
                keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入明文不是小写英文！");
                return false;
            }
        }
        for (int i = 0; i < keywordEkey.getText().length(); i++) {
            if (!(key[i] <= 'z' && key[i] >= 'a')) {
                keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入密钥不是小写英文！");
                return false;
            }
        }
        return true;
    }

    public boolean isDecrypt(TextInputControl keywordDcipher, TextInputControl keywordDkey){
        Keyword keyword=new Keyword();
        char[] ciphertext=keywordDcipher.getText().toCharArray();
        char[] key=keywordDkey.getText().toCharArray();

        if(keyword.isEmpty(keywordDcipher.getText())){
            keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","密文不能为空");
            return false;
        }
        if (keyword.isEmpty(keywordDkey.getText())){
            keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < keywordDcipher.getText().length(); i++) {
            if (!(ciphertext[i] <= 'z' && ciphertext[i] >= 'a')) {
                keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入密文不是小写英文！");
                return false;
            }
        }
        for (int i = 0; i < keywordDkey.getText().length(); i++) {
            if (!(key[i] <= 'z' && key[i] >= 'a')) {
                keyword.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入密钥不是小写英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextInputControl keywordEplain,TextInputControl keywordEkey){
        char[] jieguo = new char[99];
        List<Character> p = new ArrayList<Character>();
        String plaintext = keywordEplain.getText();// 获取明文
        String key=keywordEkey.getText();
        String ciphertext="";
        p = workkey(key);// 调用
        for (int i = 0; i < 26; i++) {
            if (!p.contains(alphabet[i])) {// 动态数组追加
                p.add(alphabet[i]);
            }
        }
        char[] c = plaintext.toCharArray();
        for (int i = 0; i < plaintext.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (c[i] == alphabet[j]) {
                    jieguo[i] = p.get(j);// 获取动态数组j位置的元素
                }
            }
            ciphertext+=jieguo[i];
        }
        return ciphertext;
    }

    public String decrypt(TextInputControl keywordDcipher,TextInputControl keywordDkey){
        char[] jieguo = new char[99];
        List<Character> p = new ArrayList<Character>();
        String plaintext = "";// 获取明文
        String key=keywordDkey.getText();
        String ciphertext=keywordDcipher.getText();
        p = workkey(key);// 调用
        for (int i = 0; i < 26; i++) {
            if (!p.contains(alphabet[i])) {
                p.add(alphabet[i]);
            }
        }
        char[] c = ciphertext.toCharArray();
        for (int i = 0; i < ciphertext.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (c[i] == p.get(j)) {
                    jieguo[i] = alphabet[j];
                }
            }
            plaintext+=jieguo[i];
        }
        return plaintext;
    }

    public static List<Character> workkey(String key) {
        char[] a = key.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < key.length(); i++) {// 删除重复元素
            if (!list.contains(a[i])) {
                list.add(a[i]);
            }
        }
        return list;
    }

}
