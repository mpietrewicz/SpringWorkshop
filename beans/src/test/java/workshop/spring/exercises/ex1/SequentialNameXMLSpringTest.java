package workshop.spring.exercises.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration
public class SequentialNameXMLSpringTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private NameGenerator nameGenerator;

    @Test()
    public void generateSingleName() {

        assertThat(nameGenerator.getNextName()).isEqualTo("customName:1");

    }


    //TODO: try to run only one
    //TODO: change order of a test
    //TODO: use dependsOnMethod
    @Test
    public void generateTwoMoreNames() {
        assertThat(nameGenerator.getNextName()).isEqualTo("customName:2");
        assertThat(nameGenerator.getNextName()).isEqualTo("customName:3");

    }

}
