package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class JmsSender {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "QueueHarshad";
   // private static final Logger log = LoggerFactory.getLogger(JmsDemo.class);

    public void showData(){
        try{
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);   //responsible for connection that take broker url
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);    //autoacknowledge means to sent and recieved message
            Destination destination = session.createQueue(QUEUE_NAME);

            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage("Hello Harshad");
            producer.send(message);

            System.out.println("Message sent: " + message.getText());

            session.close();
            connection.close();

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
