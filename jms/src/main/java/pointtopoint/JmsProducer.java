package com.czajor.jms11;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsProducer {

  public static void main(String[] args) {
    ConnectionFactory connectionFactory;
    Connection connection = null;

    try {
      Context initialContext = new InitialContext();
      connectionFactory = (ConnectionFactory) initialContext.lookup(
          "ConnectionFactory");
      Queue queue = (Queue) initialContext.lookup("jms.p2pqueue");

      connection = connectionFactory.createConnection();
      Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);

      MessageProducer messageProducer = session.createProducer( queue);
      messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
//      messageProducer.setTimeToLive(10L);
      TextMessage textMessage = session.createTextMessage("What's going on?");
      messageProducer.send(textMessage);
      System.out.println("Message produced");
    } catch (NamingException e) {
      e.printStackTrace();
    } catch (JMSException e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (JMSException e) {
          throw new RuntimeException(e);
        }
      }
    }

  }
}
