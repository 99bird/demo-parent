package cn.itlz.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/23 0023
 */
public class Send {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.88.137");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "hello";
        channel.queueDeclare(queueName, false, false, false, null);
        String message = "Hello world";
        channel.basicPublish("",queueName,null,message.getBytes());
        channel.close();
        connection.close();
    }
}
