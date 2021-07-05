package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.Optional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.CipherOutputStream;

public class DES {
    /**
     * 偏移变量，固定占8位字节
     */
    private final static String IV_PARAMETER = "12345678";
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "DES";
    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";
    /**
     * 默认编码
     */
    private static final String CHARSET = "utf-8";
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
    public boolean isOK(TextField text, TextField key) {
        AutokeyPlaintext autokeyPlaintext=new AutokeyPlaintext();
        char[] textA=text.getText().toCharArray();
        char[] keyA=key.getText().toCharArray();

        if(autokeyPlaintext.isEmpty(text.getText())){
            autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (autokeyPlaintext.isEmpty(key.getText())){
            autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        /*for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是纯英文！");
                return false;
            }
        }*/
        for (int i = 0; i < key.getText().length(); i++) {
            if (!((keyA[i] <= 'Z' && keyA[i] >= 'A') || (keyA[i] <= 'z' && keyA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不是纯英文！");
                return false;
            }
        }
        return true;
    }

    /**
     * 生成key
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key generateKey(String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(password.getBytes(CHARSET));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
    public String decrypt(TextField data, TextField password) {
        if (password== null || password.getText().length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password.getText());
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data.getText().getBytes(CHARSET))), CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
            return data.getText();
        }
    }

    public String encrypt(TextField data, TextField password) {
        if (password == null || password.getText().length() < 8) {
            throw new RuntimeException("加密失败，key不能小于8位");
        }
        if (data == null)
            return null;
        try {
            Key secretKey = generateKey(password.getText());
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes(CHARSET));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] bytes = cipher.doFinal(data.getText().getBytes(CHARSET));

            //JDK1.8及以上可直接使用Base64，JDK1.7及以下可以使用BASE64Encoder
            //Android平台可以使用android.util.Base64
            return new String(Base64.getEncoder().encode(bytes));

        } catch (Exception e) {
            e.printStackTrace();
            return data.getText();
        }
    }
}
