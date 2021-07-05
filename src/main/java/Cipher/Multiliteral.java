package Cipher;

import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Multiliteral {
    public static char[][] zimubiao = { { 'a', 'b', 'c', 'd', 'e' }, { 'f', 'g', 'h', 'i', 'k' },
            { 'l', 'm', 'n', 'o', 'p' }, { 'q', 'r', 's', 't', 'u' }, { 'v', 'w', 'x', 'y', 'z' } };

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

    public boolean isOK(TextInputControl text, TextInputControl key){
        Affine affine=new Affine();
        char[] textA=text.getText().toCharArray();
        char[] keyA=key.getText().toCharArray();

        if(affine.isEmpty(text.getText())){
            affine.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (affine.isEmpty(key.getText())){
            affine.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < text.getText().length(); i++) {
            if (!(textA[i] <= 'z' && textA[i] >= 'a')) {
                affine.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是小写字母！");
                return false;
            }
        }
        for (int i = 0; i < key.getText().length(); i++) {
            for (int j = i + 1; j < key.getText().length(); j++) {
                if (keyA[i] == keyA[j]) {
                    affine.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入的密钥有重复的字母！");
                    return false;
                }
            }
        }
        return true;
    }

    public String encrypt(TextField multiliteralEplain, TextField multiliteralEkey) {
        String plaintext=multiliteralEplain.getText();
        String guanjianzi=multiliteralEkey.getText();
        String ciphertext="";
        List<Character> list = new ArrayList<Character>();
        char[] jieguo = new char[2*plaintext.length()+1];

        char[] mingwen = plaintext.toCharArray();// 字符串转化成数组
        char[] key = guanjianzi.toCharArray();
        for (int i = 0; i < plaintext.length(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (mingwen[i] == zimubiao[j][k]) {// 生成密文数组
                        list.add(key[j]);
                        list.add(key[k]);
                    }
                }
            }
        }
        for (int i = 0; i < 2 * plaintext.length(); i++) {// 打印密文
            jieguo[i] = list.get(i);
            //System.out.print(jieguo[i]);
            ciphertext+=jieguo[i];
        }
        return ciphertext;
    }


    public String decrypt(TextField multiliteralDcipher, TextField multiliteralDkey) {
        String plaintext="";
        String keyA=multiliteralDkey.getText();
        String ciphertext=multiliteralDcipher.getText();
        char[] jieguo = new char[99];
        char[] mingwen = ciphertext.toCharArray();
        char[] key = keyA.toCharArray();
        int m=0;
        for (int i = 0; i < ciphertext.length()-1; i += 2) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (key[j] == mingwen[i] && key[k] == mingwen[i + 1]) {// 每两个密文替代一个明文
                        jieguo[m] = zimubiao[j][k];
                        plaintext+=jieguo[m];
                        m++;
                    }
                }
            }
        }
        return plaintext;
    }
}
