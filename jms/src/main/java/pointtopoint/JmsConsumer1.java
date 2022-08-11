package com.czajor.jms11;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JmsConsumer1 {
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
      connection.start();

      MessageConsumer messageConsumer = session.createConsumer(queue);
      while (true) {
        TextMessage textMessage = (TextMessage) messageConsumer.receive();

        String body = textMessage.getText();
        System.out.println(body);
      }

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
