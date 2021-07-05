package Cipher;

import javafx.scene.control.*;

import java.util.Optional;

public class Affine {
    public static String decrypt(TextField affineDcipher, TextField affineDkey) {
        String plaintext="";
        String ciphertext=affineDcipher.getText();
        char[] shuru2 = new char[ciphertext.length()];// 建立数组
        for (int i = 0; i < ciphertext.length(); i++) {// 将字符串保存到数组中
            shuru2[i] = ciphertext.charAt(i);
        }
        int[] shuzi = new int[99];
        for (int i = 0; i < shuru2.length; i++) {
            shuzi[i] = shuru2[i] - 'a';// 字符转化为数字
            shuzi[i] = (9 * (shuzi[i] - 5)) % 26;// 进行解密运算
            shuru2[i] = (char) (shuzi[i] + 'a');// 数字转换成字符
            plaintext+=shuru2[i];
        }
        return plaintext;
    }

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
        /*for (int i = 0; i < key.getText().length(); i++) {
            if (!(keyA[i] <= 'z' && keyA[i] >= 'a')) {
                affine.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入密钥不是小写英文！");
                return false;
            }
        }*/
        return true;
    }


    public String encrypt(TextField affineEplain, TextField affineEkey) {
        String plaintext=affineEplain.getText();
        String ciphertext="";
        char[] shuru1 = new char[plaintext.length()];// 建立数组
        for (int i = 0; i < plaintext.length(); i++) {// 将字符串保存到数组中
            shuru1[i] = plaintext.charAt(i);
            //System.out.print(shuru1[i] + " ");
        }
        int[] shuzi = new int[99];
        for (int i = 0; i < shuru1.length; i++) {
            shuzi[i] = shuru1[i] - 'a';// 字符转化为数字
            shuzi[i] = (3 * shuzi[i] + 5) % 26;// 进行加密运算
            shuru1[i] = (char) (shuzi[i] + 'a');// 数字转换成字符
            ciphertext+=shuru1[i];
        }
        return ciphertext;
    }
}
