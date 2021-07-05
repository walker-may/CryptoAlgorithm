package Cipher;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class MD5 {
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
    public boolean isOK(TextField text) {
        AutokeyPlaintext autokeyPlaintext=new AutokeyPlaintext();
        char[] textA=text.getText().toCharArray();

        if(autokeyPlaintext.isEmpty(text.getText())){
            autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","明文不能为空");
            return false;
        }

        for (int i = 0; i < text.getText().length(); i++) {
            if (!((textA[i] <= 'Z' && textA[i] >= 'A') || (textA[i] <= 'z' && textA[i] >= 'a'))) {
                autokeyPlaintext.informationDialog(Alert.AlertType.WARNING,"提示","警告","输入不是纯英文！");
                return false;
            }
        }
        return true;
    }

    public String encrypt(TextField md5plain) {
        String mingwen=md5plain.getText();
        // 加密对象，指定加密方式
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 准备要加密的数据
        byte[] b = mingwen.getBytes();
        // 加密
        byte[] digest =  md5.digest(b);
        /**
         * public BigInteger(int signum,byte[] magnitude)将 BigInteger 的符号-数量表示形式转换为 BigInteger。
         * 该符号表示为一个正负号整数值：-1 表示负，0 表示零，1 表示正。
         * 该大小是一个 big-endian 字节顺序的 byte 数组：最高有效字节在第零个元素中。
         * 允许零长度数量数组，这会导致 BigInteger 的值为 0，无论其正负号是 -1、0 还是 1。
         * 参数：
         * signum - 该数的正负号（-1 表示负，0 表示零，1 表示正）。
         * magnitude - 该数的大小的 big-endian 二进制表示形式。
         * 抛出：
         * NumberFormatException - signum 不是三个合法值之一（-1、0 和 1），或者 signum 是 0 并且 magnitude 包含一个或多个非零字节。
         * BigInteger.toString(to)  to要转换成的进制
         * public String toString(int radix)返回此 BigInteger 的给定基数的字符串表示形式。
         * 如果该基数超出从 Character.MIN_RADIX 到 Character.MAX_RADIX（包括）这一范围，则其默认值为 10（Integer.toString 就是这种情况）。
         * 使用由 Character.forDigit 提供的从数字到字符的映射，并在需要时在前面加一个负号。（此表示形式与 (String, int) 构造方法兼容。）
         * 参数：
         * radix - 字符串表示形式的基数。
         * 返回：
         * 此 BigInteger 给定基数的字符串表示形式。
         */
        String md5code = new BigInteger(1, digest).toString(16);
        //如果加密后的md5密文不足32位，前面补0
        while (true){
            if (md5code.length()<32){
                md5code = "0" + md5code;
            }else {
                break;
            }
        }
        // 打印加密后的字符串
        //System.out.println(md5code);
        return md5code;
    }
}
