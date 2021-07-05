package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class Permutation {
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
        for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是纯英文！");
                return false;
            }
        }
        for (int i = 0; i < key.getText().length(); i++) {
            if (!((keyA[i] <= 'Z' && keyA[i] >= 'A') || (keyA[i] <= 'z' && keyA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextField permutationEplain, TextField permutationEkey) {
        String plaintext=permutationEplain.getText();
        String ciphertext="";
        String key=permutationEkey.getText();
        int i = 0;
        // 明文长度不是密钥长度的整数倍，补x
        int t = plaintext.length();
        char[] a = plaintext.toCharArray();
        if (t % key.length() != 0) {
            t = ((t / (key.length()) + 1) * key.length());// 取密文长度时密钥整数倍最小的数
        }
        char[] tem = new char[t];
        for (i = 0; i < t; i++) {
            if (i < plaintext.length()) {
                tem[i] = a[i];
            } else
                tem[i] = 'x';
        }
        char[] key0 = new char[key.length()];
        char[] key1 = new char[key.length()];
        char[] key2 = key.toCharArray();
        int[] k = new int[key.length()];
        char temp1;
        for (i = 0; i < key.length(); i++) {// 设置临时数组
            key1[i] = key2[i];
        }
        for (i = 0; i < key1.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (int j = 0; j < key1.length - i - 1; j++) {
                if (key1[j] > key1[j + 1]) {
                    temp1 = key1[j];
                    key1[j] = key1[j + 1];
                    key1[j + 1] = temp1;
                    flag1 = 1;
                }

            }
            if (flag1 == 0) {
                break;
            }
        }
        for (i = 0; i < key.length(); i++) {// 设置临时数组
            key0[i] = key1[i];
        }
        // 对应的密钥顺序
        for (i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if ((key1[j] == key2[i]) && key0[j] != '#') {// #代表去除匹对成功的元素
                    k[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k[i]);// 打印读取顺序
                }
            }
        }
        int m = 0;
        int n = t / key.length();
        char[] mingwen = plaintext.toCharArray();// 将明文保存到数组中
        char[][] jieguo = new char[n][key.length()];// 声明结果数组
        for (i = 0; i < n; i++) {// 打印结果
            for (int j = 0; j < key.length(); j++) {
                jieguo[i][k[j] - 1] = mingwen[m];
                m++;
            }
        }
        for (i = 0; i < n; i++) {
            for (int j = 0; j < key.length(); j++) {
                //System.out.print(jieguo[i][j]);
                ciphertext+=jieguo[i][j];
            }
        }
        return ciphertext;
    }

    public String decrypt(TextField permutationDcipher, TextField permutationDkey) {
        String plaintext="";
        String ciphertext=permutationDcipher.getText();
        String key=permutationDkey.getText();
        int i = 0;
        // 密文长度不是密钥长度的整数倍，补x
        int t = ciphertext.length();
        char[] a = ciphertext.toCharArray();
        if (t % key.length() != 0) {
            t = ((t / (key.length()) + 1) * key.length());// 取密文长度时密钥整数倍最小的数
        }
        char[] tem = new char[t];
        for (i = 0; i < t; i++) {
            if (i < ciphertext.length()) {
                tem[i] = a[i];
            } else
                tem[i] = 'x';
        }
        char[] key0 = new char[key.length()];
        char[] key1 = new char[key.length()];
        char[] key2 = key.toCharArray();
        int[] k = new int[key.length()];
        char temp1;
        for (i = 0; i < key.length(); i++) {// 设置临时数组
            key1[i] = key2[i];
        }
        for (i = 0; i < key1.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (int j = 0; j < key1.length - i - 1; j++) {
                if (key1[j] > key1[j + 1]) {
                    temp1 = key1[j];
                    key1[j] = key1[j + 1];
                    key1[j + 1] = temp1;
                    flag1 = 1;
                }

            }
            if (flag1 == 0) {
                break;
            }
        }
        for (i = 0; i < key.length(); i++) {// 设置临时数组
            key0[i] = key1[i];
        }
        // 对应的密钥顺序
        for (i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if ((key1[j] == key2[i]) && key0[j] != '#') {// #代表去除匹对成功的元素
                    k[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k[i]);// 打印读取顺序
                }
            }
        }
        int n = tem.length / key.length();
        int m =0;
        char[] mingwen = ciphertext.toCharArray();// 将密文保存到数组中
        char[][] jieguo = new char[n][key.length()];// 声明结果数组,使用二维数组
        for (i = 0; i < n; i++) {// 打印结果
            for (int j = 0; j < key.length(); j++) {
                jieguo[i][j] = mingwen[k[j]-1+m*key.length()];
            }
            m++;
        }
        for (i = 0; i < n; i++) {
            for (int j = 0; j < key.length(); j++) {
                //System.out.print(jieguo[i][j]);
                plaintext+=jieguo[i][j];
            }
        }
        return plaintext;
    }
}
