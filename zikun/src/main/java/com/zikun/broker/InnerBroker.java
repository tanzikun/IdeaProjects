package com.zikun.broker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import java.net.URI;

public class InnerBroker {

    public static void main(String[] args) throws Exception {
        //第一种方式
/*        BrokerService broker = new BrokerService();
        broker.setUseJmx(true);
        broker.addConnector("tcp://localhost:61616");
        broker.start();*/

        //这种可以
        String uri = "properties:broker.properties";
        URI u = new URI(uri);
        BrokerService broker1 = BrokerFactory.createBroker(u);
        broker1.addConnector("tcp://localhost:61616");
        broker1.start();

    }

}
