package cn.itlz.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/7 0007
 */
public class NioServerEndpoint {

    private Selector selector;

    //初始化服务器
    private void init() throws IOException {
        this.selector = Selector.open();            //创建选择器

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);   //设置为非阻塞

        ServerSocket serverSocket = channel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
        serverSocket.bind(address);

        channel.register(this.selector, SelectionKey.OP_ACCEPT);
    }

    //启动服务器
    private void start() throws IOException {
        while (true) {
            this.selector.select();                //此方法会阻塞，直到至少有一个已注册的事件发生
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    accept(selectionKey);
                } else if (selectionKey.isReadable()) {
                    read(selectionKey);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(this.selector, SelectionKey.OP_READ);
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        String request = new String(byteBuffer.array()).trim();
        System.out.println(request);
        ByteBuffer out = ByteBuffer.wrap(("你发送的请求是" + request).getBytes());
        socketChannel.write(out);

//        key.interestOps(SelectionKey.OP_READ);
    }

    public static void main(String[] args) throws IOException {
        NioServerEndpoint serverEndpoint = new NioServerEndpoint();
        serverEndpoint.init();
        serverEndpoint.start();
    }
}
