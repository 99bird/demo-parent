package cn.itlz.demo.bio;

import java.io.*;
import java.net.Socket;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while (true) {
                str = bufferedReader.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
