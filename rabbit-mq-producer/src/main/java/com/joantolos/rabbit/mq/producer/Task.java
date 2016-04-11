package com.joantolos.rabbit.mq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

public class Task {

    private final static String QUEUE_NAME = "my_messages";
    private final static String DELIMITER = " ";
    private final static String HOST = "localhost";

    public static void main(String[] args) throws java.io.IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = getMessage(args);
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }

    private static String getMessage(String[] strings){
        if (strings.length < 1 || strings.length == 0) {
            return "";
        } else {
            StringBuilder words = new StringBuilder(strings[0]);
            for (int i = 1; i < strings.length; i++) {
                words.append(DELIMITER).append(strings[i]);
            }
            return words.toString();
        }
    }

}