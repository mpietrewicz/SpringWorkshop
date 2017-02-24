package workshop.spring.exercises.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: strategy should be chosen based on single animal
@Test
@ContextConfiguration
public class HerdStamplerTest extends AbstractTestNGSpringContextTests {

    @Configuration
    @ComponentScan(basePackages = "workshop.spring.exercises.ex5")
    public static class TestConfig{
    }

    @Autowired(required = false)
    private HerdStampler herdStampler;

    public void shouldStampDifferentKindOfAnimals(){

        Cow bigBull = new Cow(Sex.MALE, 500);
        Cow mediumMilkCow = new Cow(Sex.FEMALE, 300);
        Cow smallBull = new Cow(Sex.MALE, 80);
        Cow smallCow = new Cow(Sex.FEMALE, 80);

        herdStampler.stamp(bigBull, mediumMilkCow, smallBull, smallCow);

        assertThat(bigBull.getStamp()).isEqualTo("meat");
        assertThat(mediumMilkCow.getStamp()).isEqualTo("milk");
        assertThat(smallBull.getStamp()).isEqualTo("breeding");
        assertThat(smallCow.getStamp()).isEqualTo("breeding");
    }
}
