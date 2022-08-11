package publishsubscribe;

import static javax.jms.Session.AUTO_ACKNOWLEDGE;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JmsProducer {

  public static void main(String[] args) {
    ConnectionFactory connectionFactory;
    Connection connection = null;

    try {
      // 1. get connection from context
      Context initialContext = new InitialContext();
      connectionFactory = (ConnectionFactory) initialContext.lookup(
          "ConnectionFactory");
      connection = connectionFactory.createConnection();
      connection.start();

      //2. create session, get topic and create temp queue
      Session session = connection.createSession(false, AUTO_ACKNOWLEDGE);
      Destination topic = (Topic) initialContext.lookup("jms.pstopic");
      Destination temporaryQueue = session.createTemporaryQueue();

      // 3. create producer for topic, send message
      MessageProducer messageProducer = session.createProducer(topic);
//      messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//      messageProducer.setTimeToLive(10L);
      Message textMessage = session.createTextMessage("What's going on in TOPIC?");
      textMessage.setJMSReplyTo(temporaryQueue);
      messageProducer.send(textMessage);
      log.info("Message produced");

      // 4. create response consumer and read message
      MessageConsumer messageConsumer = session.createConsumer(temporaryQueue);
      TextMessage responseMessage = (TextMessage) messageConsumer.receive();
      log.info(responseMessage.toString());
      log.info(responseMessage.getText());


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
