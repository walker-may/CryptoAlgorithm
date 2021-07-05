package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Playfair {
    public static char[] zimubiao = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

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
        Playfair playfair=new Playfair();
        char[] textA=text.getText().toCharArray();
        char[] keyA=key.getText().toCharArray();

        if(playfair.isEmpty(text.getText())){
            playfair.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }
        if (playfair.isEmpty(key.getText())){
            playfair.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不能为空");
        }
        for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                playfair.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是纯英文！");
                return false;
            }
        }
        for (int i = 0; i < key.getText().length(); i++) {
            if (!((keyA[i] <= 'Z' && keyA[i] >= 'A') || (keyA[i] <= 'z' && keyA[i] >= 'a'))) {
                playfair.informationDialog(Alert.AlertType.WARNING,"提示","警告","密钥不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextField playfairEplain, TextField playfairEkey) {
        Playfair playfair = new Playfair();
        String plaintext = playfairEplain.getText();
        String ciphertext = "";
        String key = playfairEkey.getText();
        List<Character> list = new ArrayList<Character>();
        List<Character> list1 = new ArrayList<Character>();
        char[] tem = new char[99];
        char[] d = new char[99];
        char[] f = new char[99];
        char[][] juzhen = new char[200][200];
        char[] a = plaintext.toCharArray();
        for (int i = 0; i < plaintext.length(); i++) {// j用i替换
            if (a[i] == 'j') {
                a[i] = 'i';
            }
        }
        int m = 0;
        int n = 0;// 计数器 填了几个q
        for (int i = 0; i < plaintext.length() - 1; i++) {// 建立临时数组
            if (a[i] != a[i + 1]) {
                tem[m] = a[i];
                m++;
            } else {
                tem[m] = a[i];
                tem[m + 1] = 'q';
                m += 2;
                n++;
            }
        }
        for (int i = 0; i < plaintext.length() + n - 1; i++) {// 将临时数组的数据放入动态数组中
            list.add(tem[i]);
        }
        list.add(a[plaintext.length() - 1]);
        if ((list.size() % 2 != 0) && (list.get(list.size() - 1) == 'q')) {// 退出程序
            //System.out.print("明文序列异常");
            playfair.informationDialog(Alert.AlertType.WARNING, "提示", "警告", "明文序列异常");
        }
        if ((list.size() % 2 != 0) && (list.get(list.size() - 1) != 'q')) {// 末尾补q
            list.add(list.size(), 'q');
        }
        char[] temp1 = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {// 从动态数组存入静态数组
            temp1[i] = list.get(i);
        }
        int m2 = 0;
        char[][] mingwen = new char[temp1.length][2];
        for (int i = 0; i < temp1.length / 2; i++) {
            for (int j = 0; j < 2; j++) {
                mingwen[i][j] = temp1[m2];
                //System.out.print(mingwen[i][j]);// 一维数组转化为二维数组
                m2++;
            }
            //System.out.println();
        }
        f = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {// 删除重复元素
            if (!list1.contains(f[i])) {
                if (f[i] != 'j') {
                    list1.add(f[i]);
                }
            }
        }
        for (int i = 0; i < 25; i++) {// 生成密钥一维数组
            if (!(list1.contains(zimubiao[i]))) {
                list1.add(zimubiao[i]);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            d[i] = list1.get(i);
        }
        int n1 = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                juzhen[i][j] = d[n1];
                //System.out.print(juzhen[i][j] + " ");
                n1++;
            }
            //System.out.println();
        }
        int m4 = 0, m5 = 0, m6 = 0, m7 = 0;
        for (int i = 0; i < temp1.length / 2; i++) {
            int j1 = 0;
            for (int m3 = 0; m3 < 5; m3++) {
                for (int n3 = 0; n3 < 5; n3++) {
                    j1 = 0;
                    if (juzhen[m3][n3] == mingwen[i][j1]) {// 存放 行 列 坐标
                        m4 = m3;
                        m5 = n3;
                    }
                    if (juzhen[m3][n3] == mingwen[i][j1 + 1]) {
                        m6 = m3;
                        m7 = n3;
                    }
                }
            }
            if (m4 == m6) {// 行相等
                //System.out.print(juzhen[m4][(m5 + 1) % 5] + " " + juzhen[m4][(m7 + 1) % 5] + " ");
                ciphertext=ciphertext+juzhen[m4][(m5+1)%5]+juzhen[m4][(m7+1)%5];
            } else if (m5 == m7) {// 列相等
                //System.out.print(juzhen[(m4 + 1) % 5][m5] + " " + juzhen[(m6 + 1) % 5][m7] + " ");
                ciphertext=ciphertext+juzhen[(m4+1)%5][m5]+juzhen[(m6+1)%5][m7];
            } else {// 矩形对角线
                //System.out.print(juzhen[m4][m7] + " " + juzhen[m6][m5] + " ");
                ciphertext=ciphertext+juzhen[m4][m7]+juzhen[m6][m5];
            }
        }
        return ciphertext;
    }

    public String decrypt(TextField playfairDcipher, TextField playfairDkey) {
        String plaintext="";
        String ciphertext=playfairDcipher.getText();
        String key=playfairDkey.getText();
        List<Character> list = new ArrayList<Character>();
        List<Character> list1 = new ArrayList<Character>();
        char[] tem = new char[99];
        char[] d = new char[99];
        char[] f = new char[99];
        char[][] juzhen = new char[200][200];
        char[] a = ciphertext.toCharArray();
        for (int i = 0; i < ciphertext.length(); i++) {// j用i替换
            if (a[i] == 'j') {
                a[i] = 'i';
            }
        }
        int m = 0;
        int n = 0;// 计数器 填了几个q
        for (int i = 0; i < ciphertext.length() - 1; i++) {// 建立临时数组
            if (a[i] != a[i + 1]) {
                tem[m] = a[i];
                m++;
            } else {
                tem[m] = a[i];
                tem[m + 1] = 'q';
                m += 2;
                n++;
            }
        }
        for (int i = 0; i < ciphertext.length() + n - 1; i++) {// 将临时数组的数据放入动态数组中
            list.add(tem[i]);
        }
        list.add(a[ciphertext.length() - 1]);
        if ((list.size() % 2 != 0) && (list.get(list.size() - 1) != 'q')) {// 末尾补q
            list.add(list.size(), 'q');
        }
        char[] temp1 = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {// 从动态数组存入静态数组
            temp1[i] = list.get(i);
        }
        int m2 = 0;
        char[][] mingwen = new char[temp1.length][2];
        for (int i = 0; i < temp1.length / 2; i++) {
            for (int j = 0; j < 2; j++) {
                mingwen[i][j] = temp1[m2];
                //System.out.print(mingwen[i][j]);// 一维数组转化为二维数组
                m2++;
            }
            //System.out.println();
        }
        f = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {// 删除重复元素
            if (!list1.contains(f[i])) {
                if (f[i] != 'j') {
                    list1.add(f[i]);
                }
            }
        }
        for (int i = 0; i < 25; i++) {// 生成密钥一维数组
            if (!(list1.contains(zimubiao[i]))) {
                list1.add(zimubiao[i]);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            d[i] = list1.get(i);
        }
        int n1 = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                juzhen[i][j] = d[n1];
                //System.out.print(juzhen[i][j] + " ");
                n1++;
            }
            //System.out.println();
        }
        int m4 = 0, m5 = 0, m6 = 0, m7 = 0;
        //System.out.print("明文为:");
        for (int i = 0; i < temp1.length / 2; i++) {
            int j1 = 0;
            for (int m3 = 0; m3 < 5; m3++) {
                for (int n3 = 0; n3 < 5; n3++) {
                    j1 = 0;
                    if (juzhen[m3][n3] == mingwen[i][j1]) {// 存放 行 列 坐标
                        m4 = m3;
                        m5 = n3;
                    }
                    if (juzhen[m3][n3] == mingwen[i][j1 + 1]) {
                        m6 = m3;
                        m7 = n3;
                    }
                }
            }
            if (m4 == m6) {// 行相等
                //System.out.print(juzhen[m4][(m5 + 4) % 5] + " " + juzhen[m4][(m7 + 4) % 5] + " ");
                plaintext=plaintext+juzhen[m4][(m5+4)%5]+juzhen[m4][(m7+4)%5];
            } else if (m5 == m7) {// 列相等
                //System.out.print(juzhen[(m4 + 4) % 5][m5] + " " + juzhen[(m6 + 4) % 5][m7] + " ");
                plaintext=plaintext+juzhen[(m4+4)%5][m5]+juzhen[(m6+4)%5][m7];
            } else {// 矩形对角线
                //System.out.print(juzhen[m4][m7] + " " + juzhen[m6][m5] + " ");
                plaintext=plaintext+juzhen[m4][m7]+juzhen[m6][m5];
            }
        }
        return plaintext;
    }
}
