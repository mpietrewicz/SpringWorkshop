package workshop.spring.exercises.ex3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import workshop.spring.exercises.ex3.processing.Message;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: Message comming from different sources should be processed differently
@Test
@ContextConfiguration
public class WayInBasedMessageProcessingTest extends AbstractTestNGSpringContextTests {
    @Configuration
    @ComponentScan(basePackages = "workshop.spring.exercises.ex3")
    public static class TestConfig{
    }

    @Autowired(required = false)
    MessageReceiver messageReceiver;

    public void messageSendFromJMS(){
        Message message = new Message();
        messageReceiver.receiveFromJMS(message);
        assertThat(message.getProcessedBy()).isEqualTo("JMS Processor");
    }

    public void messageSendViaMail(){
        Message message = new Message();
        messageReceiver.receiveViaMail(message);
        assertThat(message.getProcessedBy()).isEqualTo("Mail processor");
    }

    public void messageSendFromWS(){
        Message message = new Message();
        messageReceiver.receiveFromWS(message);
        assertThat(message.getProcessedBy()).isEqualTo("WS processor");
    }
}
