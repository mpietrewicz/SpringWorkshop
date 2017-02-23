package workshop.spring.showcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration(classes = BaseSpringTest.TestConfig.class)
public class BaseSpringTest extends AbstractTestNGSpringContextTests {

    @Configuration
    @ComponentScan
    public static class TestConfig{
    }

        @Autowired
        EmailGenerator emailGenerator;

        @Test()
        void testEmailGenerator() {

            String email = emailGenerator.generate();
            System.out.println(email);

            assertThat(email).isNotNull().isEqualTo("feedback@yoursite.com");


        }

}
