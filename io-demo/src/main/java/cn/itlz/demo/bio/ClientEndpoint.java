package cn.itlz.demo.bio;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
public class ClientEndpoint {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            printWriter.println(s);
        }

    }
}
