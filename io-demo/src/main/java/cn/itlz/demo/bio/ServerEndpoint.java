package cn.itlz.demo.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
public class ServerEndpoint {

    public static void main(String[] args) throws IOException {

        int port = 8080;

        ServerSocket serverSocket;
        Socket socket;

        try{
            serverSocket = new ServerSocket(port);
            System.out.println("服务端启动");

            while (true) {
                socket = serverSocket.accept();
                new Thread(new ServerHandler(socket)).start();
            }
        }finally {

        }
    }
}
