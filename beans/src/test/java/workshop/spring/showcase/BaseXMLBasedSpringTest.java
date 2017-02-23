package workshop.spring.showcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class BaseXMLBasedSpringTest extends AbstractTestNGSpringContextTests {

        @Autowired
        BeanInitializedInXML beanInitializedInXML;

        @Test()
        void wrapperWrapsEmail() {

            String email = beanInitializedInXML.generate();
            System.out.println(email);

            assertThat(email)
                    .isNotNull()
                    .isEqualTo("wrapped with [test description]: feedback@yoursite.com");


        }

}
