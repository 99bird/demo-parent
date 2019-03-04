package cn.itlz.demo.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/7 0007
 */
public class NioClientEndpoint {

    private Selector selector;

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private void init() throws IOException {
        this.selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
    }

    private void start() throws IOException {
        while (true) {
            this.selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isConnectable()) {
                    connect(selectionKey);
                } else if (selectionKey.isReadable()) {
                    read(selectionKey);
                } else if (selectionKey.isWritable()) {
                    write(selectionKey);
                }

            }
        }
    }

    private void connect(SelectionKey key) throws IOException {
        //TODO
        SocketChannel socketChannel = (SocketChannel) key.channel();
        if (socketChannel.isConnectionPending()) {
            if (socketChannel.finishConnect()) {
                socketChannel.configureBlocking(false);
                socketChannel.register(this.selector, SelectionKey.OP_WRITE);
//                String request = bufferedReader.readLine();
//                socketChannel.write(ByteBuffer.wrap(request.getBytes()));
            } else {
                key.cancel();
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        //TODO
        SocketChannel socketChannel = (SocketChannel) key.channel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        socketChannel.read(byteBuffer);
        String response = new String(byteBuffer.array()).trim();
        System.out.println("服务端响应:"+response);

        key.interestOps(SelectionKey.OP_WRITE);
    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        String nextRequest = bufferedReader.readLine();

        ByteBuffer outBuffer = ByteBuffer.wrap(nextRequest.getBytes());
        socketChannel.write(outBuffer);

        key.interestOps(SelectionKey.OP_READ);

    }

    public static void main(String[] args) throws IOException {
        NioClientEndpoint clientEndpoint = new NioClientEndpoint();
        clientEndpoint.init();
        clientEndpoint.start();
    }
}
