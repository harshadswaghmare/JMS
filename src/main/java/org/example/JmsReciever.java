package org.example;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsReciever {
    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "QueueHarshad";
    // private static final Logger log = LoggerFactory.getLogger(JmsDemo.class);

    public void showData() {
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);   //responsible for connection that take broker url
            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);    //autoacknowledge means to sent and recieved message
            Destination destination = session.createQueue(QUEUE_NAME);

            MessageConsumer consumer = session.createConsumer(destination);

            Message receivedMessage =  consumer.receive();
            System.out.println(receivedMessage);

            if (receivedMessage instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) receivedMessage;
                System.out.println("Received message: " + textMessage.getText());
            }
            session.close();
            connection.close();

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
