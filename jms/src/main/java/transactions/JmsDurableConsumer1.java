package transactions;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JmsDurableConsumer1 {
  public static void main(String[] args) {
    ConnectionFactory connectionFactory;
    Connection connection = null;

    try {
      // 1. get connection from context
      Context initialContext = new InitialContext();
      connectionFactory = (ConnectionFactory) initialContext.lookup(
          "ConnectionFactory");
      connection = connectionFactory.createConnection();
      connection.setClientID("DurableConsumerClient1");
      connection.start();

      //2. create session, get topic and create temp queue
      Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
      Topic topic = (Topic) initialContext.lookup("jms.pstopic");

      // 3. create consumer
      MessageConsumer messageConsumer = session.createDurableSubscriber(topic, "DurableConsumer1");

      while (true) {
        // 4. consume message
        TextMessage textMessage = (TextMessage) messageConsumer.receive();
        String body = textMessage.getText();
        log.info(body);
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
