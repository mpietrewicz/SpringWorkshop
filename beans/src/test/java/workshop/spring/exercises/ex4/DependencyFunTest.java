package workshop.spring.exercises.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import workshop.spring.exercises.ex4.processing.ActivationNeedingProcessor;
import workshop.spring.exercises.ex4.processing.FullyActivatedProcessingMachine;
import workshop.spring.exercises.ex4.processing.SimpleProcessingMachine;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: every dependency needs activation
@Test
@ContextConfiguration
public class DependencyFunTest extends AbstractTestNGSpringContextTests {

    private static final String INJECTED_AS_FIELD = "injected as field";
    private static final String INJECTED_IN_CONSTRUCTOR = "injected in constructor";
    private static final String INJECTED_IN_SETTER = "injected in setter";

    @Configuration
    @ComponentScan(basePackages = "workshop.spring.exercises.ex4")
    public static class TestConfig{

        @Bean(name = QualifierNames.FIELD_INJECTION)
        public ActivationNeedingProcessor fieldProcessor(){
            return new ActivationNeedingProcessor(INJECTED_AS_FIELD);
        }

        @Bean(name = QualifierNames.CONSTRUCTOR_INJECTION)
        public ActivationNeedingProcessor constructorProcessor(){
            return new ActivationNeedingProcessor(INJECTED_IN_CONSTRUCTOR);
        }

        @Bean(name = QualifierNames.SETTER_INJECTION)
        public ActivationNeedingProcessor setterProcessor(){
            return new ActivationNeedingProcessor(INJECTED_IN_SETTER);
        }
    }

    @Autowired
    private SimpleProcessingMachine simpleProcessingMachine;

    @Autowired (required = false)
    private FullyActivatedProcessingMachine fullyActivatedProcessingMachine;

    //TODO what if there is no setter dependency?
    //TODO check what @Required will do
    public void processElementBySimpleMachine(){
        Element element = new Element();
        simpleProcessingMachine.processElement(element);

        assertThat(element.getProcessedBy()).containsExactly(INJECTED_IN_CONSTRUCTOR, INJECTED_IN_SETTER);
    }

    public void processElementByFullyActivatedSimpleMachine(){
        Element element = new Element();
        fullyActivatedProcessingMachine.processElement(element);

        assertThat(element.getProcessedBy()).containsExactly(INJECTED_AS_FIELD, INJECTED_IN_CONSTRUCTOR, INJECTED_IN_SETTER);
    }
}
