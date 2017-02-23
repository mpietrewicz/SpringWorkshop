package workshop.spring.exercises.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration
public class EvenNumberNameXMLSpringTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private NameGenerator nameGenerator;

    @Test()
    public void generatesThreeNextEvenNumberNames() {

        assertThat(nameGenerator.getNextName()).isEqualTo("customName:2");
        assertThat(nameGenerator.getNextName()).isEqualTo("customName:4");
        assertThat(nameGenerator.getNextName()).isEqualTo("customName:6");

    }

}
