package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class Vigenere {
    public static char[][] vigenere = {
            { 'a', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                    'u', 'v', 'w', 'x', 'y', 'z' },
            { 'b', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                    'v', 'w', 'x', 'y', 'z', 'a' },
            { 'c', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                    'w', 'x', 'y', 'z', 'a', 'b' },
            { 'd', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                    'x', 'y', 'z', 'a', 'b', 'c' },
            { 'e', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                    'y', 'z', 'a', 'b', 'c', 'd' },
            { 'f', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                    'z', 'a', 'b', 'c', 'd', 'e' },
            { 'g', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    'a', 'b', 'c', 'd', 'e', 'f' },
            { 'h', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a',
                    'b', 'c', 'd', 'e', 'f', 'g' },
            { 'i', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b',
                    'c', 'd', 'e', 'f', 'g', 'h' },
            { 'j', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c',
                    'd', 'e', 'f', 'g', 'h', 'i' },
            { 'k', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd',
                    'e', 'f', 'g', 'h', 'i', 'j' },
            { 'l', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e',
                    'f', 'g', 'h', 'i', 'j', 'k' },
            { 'm', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f',
                    'g', 'h', 'i', 'j', 'k', 'l' },
            { 'n', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm' },
            { 'o', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                    'i', 'j', 'k', 'l', 'm', 'n' },
            { 'p', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                    'j', 'k', 'l', 'm', 'n', 'o' },
            { 'q', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p' },
            { 'r', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                    'l', 'm', 'n', 'o', 'p', 'q' },
            { 's', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                    'm', 'n', 'o', 'p', 'q', 'r' },
            { 't', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's' },
            { 'u', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't' },
            { 'v', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                    'p', 'q', 'r', 's', 't', 'u' },
            { 'w', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                    'q', 'r', 's', 't', 'u', 'v' },
            { 'x', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
                    'r', 's', 't', 'u', 'v', 'w' },
            { 'y', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                    's', 't', 'u', 'v', 'w', 'x' },
            { 'z', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
                    't', 'u', 'v', 'w', 'x', 'y' } };

    public boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean informationDialog(Alert.AlertType alterType, String title, String header, String message) {
        // ????????????????????????????????????????????????????????? new ??????
        Alert alert = new Alert(alterType, message, new ButtonType("??????", ButtonBar.ButtonData.CANCEL_CLOSE), new ButtonType("??????", ButtonBar.ButtonData.YES));
        // ????????????????????????
        alert.setTitle(title);
        alert.setHeaderText(header);
        // showAndWait() ??????????????????????????????????????????????????????
        Optional<ButtonType> buttonType = alert.showAndWait();
        // ????????????????????????
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)) {
            return true;// ????????????????????????????????????true
        } else {
            return false;
        }
    }

    public boolean isOK(TextField text, TextField key) {
        Vigenere vigenere=new Vigenere();
        char[] textA=text.getText().toCharArray();
        char[] keyA=key.getText().toCharArray();

        if(vigenere.isEmpty(text.getText())){
            vigenere.informationDialog(Alert.AlertType.WARNING,"??????","??????","??????????????????");
            return false;
        }
        if (vigenere.isEmpty(key.getText())){
            vigenere.informationDialog(Alert.AlertType.WARNING,"??????","??????","??????????????????");
        }
        for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                vigenere.informationDialog(Alert.AlertType.WARNING,"??????","??????","????????????????????????");
                return false;
            }
        }
        for (int i = 0; i < key.getText().length(); i++) {
            if (!((keyA[i] <= 'Z' && keyA[i] >= 'A') || (keyA[i] <= 'z' && keyA[i] >= 'a'))) {
                vigenere.informationDialog(Alert.AlertType.WARNING,"??????","??????","????????????????????????");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextField vigenereEplain, TextField vigenereEkey) {
        String plaintext=vigenereEplain.getText();
        String key=vigenereEkey.getText();
        String ciphertext="";
        int j = 0;
        char[] a = plaintext.toCharArray();
        char[] d = key.toCharArray(); // ??????????????????????????????
        char[] key0 = new char[99];
        for (int i = 0; i < plaintext.length(); i++) {// ???????????????????????????
            j = j % key.length();
            key0[i] = d[j];
            j++;
        }

        String temp = new String(key0);
        String keyword = temp.substring(0, plaintext.length());// ???????????????????????????????????????
        for (int i = 0; i < plaintext.length(); i++) {
            int m = key0[i] - 'a';// ???????????????
            int n = a[i] - 'a';// ???????????????
            //System.out.print(vigenere[m][n + 1]);// ????????????27??????????????????????????????+1
            ciphertext+=vigenere[m][n+1];
        }
        return ciphertext;
    }

    public String decrypt(TextField vigenereDcipher, TextField vigenereDkey) {
        int i, j = 0;
        char n;
        char[] mingwen = new char[27];
        String ciphertext = vigenereDcipher.getText();
        String key = vigenereDkey.getText();
        String plaintext = "";
        char[] c = ciphertext.toCharArray();
        char[] d = key.toCharArray(); // ??????????????????????????????
        char[] key0 = new char[ciphertext.length()];
        for (i = 0; i < ciphertext.length(); i++) {// ???????????????????????????
            j = j % key.length();
            key0[i] = d[j];
            j++;
        }
        String temp = new String(key0);// ??????????????????
        String keyword = temp.substring(0, ciphertext.length());// ???????????????????????????????????????
        for (i = 0; i < ciphertext.length(); i++) {
            int m = key0[i] - 'a';
            for (j = 0; j < 26; j++) {
                if (vigenere[m][j + 1] == c[i]) {
                    break;
                }
            }
            n = (char) (j + 'a');
            mingwen[i] = n;// ??????????????????????????????
        }
        for (i = 0; i < mingwen.length; i++) {
            //System.out.print(mingwen[i]);
            plaintext+=mingwen[i];
        }
        return plaintext;
    }
}
