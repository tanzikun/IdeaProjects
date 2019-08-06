package com.zikun.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class NoPersistenceSender {

    public static void main(String[] args){
        ConnectionFactory ConnectionFactory = new ActiveMQConnectionFactory("tcp://192.168.111.128:61616");
        Connection connection = null;
        Session session = null;
        try {
            connection = ConnectionFactory.createConnection();
            connection.start();

            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("myTopic");
            //Destination destination2 = session.createTopic("");

            MessageProducer producer = session.createProducer(destination);

            for(int i = 0;i < 5 ;i++){
                TextMessage message = session.createTextMessage("myTopic's message: " + i);
                Thread.sleep(1000);
                //通过消息生产者发出消息
                producer.send(message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                session.commit();
                session.close();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }


    }

}
