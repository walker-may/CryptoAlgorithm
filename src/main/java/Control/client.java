package Control;

import java.io.*;
import java.net.Socket;

public class client {

    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 8081;

    public static void main(String [] args)
    {

        try
        {
            System.out.println("连接到主机：" + SERVER_HOST + " ，端口号：" + SERVER_PORT);
            Socket client = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();

            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("server back ： " + in.readUTF());

            client.close();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
