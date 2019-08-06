package com.zikun.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class NoPersistenceReceiver {

    public static void main(String[] args){
        ConnectionFactory ConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.111.128:61616");
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionFactory.createConnection();
            connection.start();

            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("myTopic");
            MessageConsumer consumer = session.createConsumer(destination);

            for(int i = 0;i < 5 ;i++){
                TextMessage message = (TextMessage) consumer.receive();
                session.commit();
                System.out.println("收到消息："+ message.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {

                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }


    }

}
