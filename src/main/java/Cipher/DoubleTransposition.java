package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class DoubleTransposition {
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
    public boolean isOK(TextField text, TextField key1,TextField key2) {
        AutokeyPlaintext autokeyPlaintext=new AutokeyPlaintext();
        char[] textA=text.getText().toCharArray();
        char[] keyA=key1.getText().toCharArray();
        char[] keyB=key2.getText().toCharArray();

        if(autokeyPlaintext.isEmpty(text.getText())){
            autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (autokeyPlaintext.isEmpty(key1.getText())){
            autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是纯英文！");
                return false;
            }
        }
        for (int i = 0; i < key1.getText().length(); i++) {
            if (!((keyA[i] <= 'Z' && keyA[i] >= 'A') || (keyA[i] <= 'z' && keyA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不是纯英文！");
                return false;
            }
        }
        for (int i = 0; i < key2.getText().length(); i++) {
            if (!((keyB[i] <= 'Z' && keyB[i] >= 'A') || (keyB[i] <= 'z' && keyB[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextField doubleTranspositionEplain, TextField doubleTranspositionEkey1, TextField doubleTranspositionEkey2) {
        String plaintext=doubleTranspositionEplain.getText();
        String ciphertext="";
        String keyword1=doubleTranspositionEkey1.getText();
        String keyword2=doubleTranspositionEkey2.getText();
        int i = 0;
        int j = 0;
        int t = plaintext.length();
        char[] a = plaintext.toCharArray();
        if (t % keyword1.length() != 0) {
            t = ((t / (keyword1.length()) + 1) * keyword1.length());// 取明文长度时密钥整数倍最小的数
        }
        char[] tem = new char[(t / (keyword1.length()) + 1) * keyword1.length()];
        for (i = 0; i < t; i++) {
            if (i < plaintext.length()) {
                tem[i] = a[i];
            } else
                tem[i] = 'x';
        }

        char[] key0 = new char[keyword1.length()];
        char[] key1 = new char[keyword1.length()];
        char[] key2 = keyword1.toCharArray();
        int[] k = new int[keyword1.length()];
        char temp1;
        for (i = 0; i < keyword1.length(); i++) {// 设置临时数组
            key1[i] = key2[i];
        }
        for (i = 0; i < key1.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (j = 0; j < key1.length - i - 1; j++) {
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
        for (i = 0; i < keyword1.length(); i++) {// 设置临时数组
            key0[i] = key1[i];
        }
        // 对应的密钥顺序
        for (i = 0; i < keyword1.length(); i++) {
            for (j = 0; j < keyword1.length(); j++) {
                if ((key1[j] == key2[i]) && key0[j] != '#') {// #代表去除匹对成功的元素
                    k[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k[i]);// 打印读取顺序
                }
            }
        }
        int m = 0;
        int n = t / keyword1.length();// 矩阵行数
        char[][] mingwen1 = new char[n][keyword1.length()];
        for (i = 0; i < n; i++) {// 打印明文矩阵
            for (j = 0; j < keyword1.length(); j++) {
                mingwen1[i][j] = tem[m];
                m++;
            }
        }
        int q = 0;
        char[] mingwen2 = new char[tem.length];
        for (j = 0; j < keyword1.length(); j++) {
            for (i = 0; i < n; i++) {
                mingwen2[q] = mingwen1[i][(k[j]) - 1];
                //System.out.print(mingwen1[i][(k[j]) - 1] + " ");
                q++;
            }
        }
        int t1 = mingwen2.length;
        if (t1 % keyword2.length() != 0) {
            t1 = ((t1 / (keyword2.length()) + 1) * keyword2.length());// 取明文长度时密钥整数倍最小的数
        }
        char[] tem1 = new char[(t1 / (keyword1.length()) + 1) * keyword1.length()];
        for (i = 0; i < t1; i++) {
            if (i < mingwen2.length) {
                tem1[i] = mingwen2[i];
            } else
                tem1[i] = 'x';
        }
        char[] key00 = new char[keyword2.length()];
        char[] key10 = new char[keyword2.length()];
        char[] key20 = keyword2.toCharArray();
        int[] k0 = new int[keyword2.length()];
        char temp10;
        for (i = 0; i < keyword2.length(); i++) {// 设置临时数组
            key10[i] = key20[i];
        }
        for (i = 0; i < key10.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (j = 0; j < key10.length - i - 1; j++) {
                if (key10[j] > key10[j + 1]) {
                    temp10 = key10[j];
                    key10[j] = key10[j + 1];
                    key10[j + 1] = temp10;
                    flag1 = 1;
                }

            }
            if (flag1 == 0) {
                break;
            }
        }
        for (i = 0; i < keyword2.length(); i++) {// 设置临时数组
            key00[i] = key10[i];
        }
        for (i = 0; i < keyword2.length(); i++) {
            for (j = 0; j < keyword2.length(); j++) {
                if ((key10[j] == key20[i]) && key00[j] != '#') {// #代表去除匹对成功的元素
                    k0[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k0[i]);// 打印读取顺序
                }
            }
        }
        int m2 = 0;
        int n2 = t1 / keyword2.length();// 矩阵行数
        char[][] cipher = new char[n2][keyword2.length()];
        for (i = 0; i < n2; i++) {
            for (j = 0; j < keyword2.length(); j++) {// 二维数组转化为一维数组

                cipher[i][j] = tem1[m2];
                m2++;
            }
        }
        // 加密
        //System.out.print("第二轮加密密文为:");
        for (j = 0; j < keyword2.length(); j++) {// 生成密文
            for (i = 0; i < n2; i++) {
                //System.out.print(cipher[i][(k0[j] - 1)] + " ");
                ciphertext+=cipher[i][(k0[j]-1)];
            }
        }
        return ciphertext;
    }

    public String decrypt(TextField doubleTranspositionDcipher, TextField doubleTranspositionDkey1, TextField doubleTranspositionDkey2) {
        String ciphertext1=doubleTranspositionDcipher.getText();
        String plaintext="";
        String keyword2=doubleTranspositionDkey2.getText();
        String keyword1=doubleTranspositionDkey1.getText();
        int i = 0;
        int j = 0;
        // 密文长度不是密钥长度的整数倍，补x
        int t = ciphertext1.length();
        char[] a = ciphertext1.toCharArray();
        if (t % keyword2.length() != 0) {
            t = ((t / (keyword2.length()) + 1) * keyword2.length());// 取密文长度时密钥整数倍最小的数
        }
        char[] tem = new char[t];// 临时数组
        for (i = 0; i < t; i++) {
            if (i < ciphertext1.length()) {
                tem[i] = a[i];
            } else
                tem[i] = 'x';// 不足位，补x
        }

        char[] key0 = new char[keyword2.length()];
        char[] key1 = new char[keyword2.length()];
        char[] key2 = keyword2.toCharArray();
        int[] k = new int[keyword2.length()];
        char temp1;
        for (i = 0; i < keyword2.length(); i++) {// 设置临时数组
            key1[i] = key2[i];
        }
        for (i = 0; i < key1.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (j = 0; j < key1.length - i - 1; j++) {
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
        for (i = 0; i < keyword2.length(); i++) {// 设置临时数组
            key0[i] = key1[i];
        }
        for (i = 0; i < keyword2.length(); i++) {
            for (j = 0; j < keyword2.length(); j++) {
                if ((key1[j] == key2[i]) && key0[j] != '#') {// #代表去除匹对成功的元素
                    k[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k[i]);// 打印读取顺序
                }
            }
        }
        int m = 0;
        int n = t / keyword2.length();// 矩阵行数
        char[][] mingwen1 = new char[n][keyword2.length()];

        for (i = 0; i < keyword2.length(); i++) {
            // 打印密文矩阵
            for (j = 0; j < n; j++) {
                mingwen1[j][k[i]-1] = tem[m];
                m++;
            }
        }
        int q = 0;
        char[] mingwen2 = new char[tem.length];
        for (i = 0; i < n; i++) {// 生成第二轮解密明文
            for (j = 0; j < keyword2.length(); j++) {
                mingwen2[q] = mingwen1[i][j];
                //System.out.print(mingwen1[i][j] + " ");
                q++;
            }
        }
        char[] key00 = new char[keyword1.length()];
        char[] key10 = new char[keyword1.length()];
        char[] key20 = keyword1.toCharArray();
        int[] k0 = new int[keyword1.length()];
        char temp10;
        for (i = 0; i < keyword1.length(); i++) {// 设置临时数组
            key10[i] = key20[i];
        }
        for (i = 0; i < key10.length - 1; i++) {// 冒泡排序
            int flag1 = 0;// 设定一个标记，若为0，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            for (j = 0; j < key10.length - i - 1; j++) {
                if (key10[j] > key10[j + 1]) {
                    temp10 = key10[j];
                    key10[j] = key10[j + 1];
                    key10[j + 1] = temp10;
                    flag1 = 1;
                }

            }
            if (flag1 == 0) {
                break;
            }
        }
        for (i = 0; i < keyword1.length(); i++) {// 设置临时数组
            key00[i] = key10[i];
        }
        // 对应的密钥顺序
        for (i = 0; i < keyword1.length(); i++) {
            for (j = 0; j < keyword1.length(); j++) {
                if ((key10[j] == key20[i]) && key00[j] != '#') {// #代表去除匹对成功的元素
                    k0[i] = j + 1;
                    key0[j] = '#';
                    //System.out.print(" " + k0[i]);// 打印读取顺序
                }
            }
        }
        int m2 = 0;
        int n2 = t / keyword1.length();// 矩阵行数
        char[][] cipher = new char[n2][keyword1.length()];// 声明二维数组保存解密结果
        for (j = 0; j < keyword1.length(); j++) {// 打印明文矩阵
            for (i = 0; i < n2; i++) {
                cipher[i][k0[j]-1] = mingwen2[m2];
                m2++;
            }
        }

        // 解密
        for (i = 0; i < n2; i++) {// 生成明文
            for (j = 0; j < keyword1.length(); j++) {
                //System.out.print(cipher[i][j] + " ");
                plaintext+=cipher[i][j];
            }
        }
        return plaintext;
    }
}
