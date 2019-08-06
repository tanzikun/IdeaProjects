package com.zikun.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class PersistenceReceiver {

    public static void main(String[] args){
        ConnectionFactory ConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.111.128:61616");
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionFactory.createConnection();
            connection.setClientID("ccl");


            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("myTopic2");
            TopicSubscriber consumer = session.createDurableSubscriber(topic, "t1");

            connection.start();
            //Destination destination = session.createTopic("myTopic");
            //MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive();
            while (message != null){
                TextMessage msg = (TextMessage) consumer.receive();
                System.out.println("收到消息："+ msg.getText());
                session.commit();
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
