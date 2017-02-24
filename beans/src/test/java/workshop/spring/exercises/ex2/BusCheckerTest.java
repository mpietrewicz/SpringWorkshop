package workshop.spring.exercises.ex2;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import workshop.spring.exercises.ex2.domain.Bus;
import workshop.spring.exercises.ex2.domain.Engine;
import workshop.spring.exercises.ex2.domain.SafetyReport;
import workshop.spring.exercises.ex2.domain.Seat;
import workshop.spring.exercises.ex2.domain.Tire;
import workshop.spring.exercises.ex2.services.BusChecker;

import static org.assertj.core.api.Assertions.assertThat;

@Test
@ContextConfiguration(classes = BusCheckerTest.TestConfig.class)
public class BusCheckerTest extends AbstractTestNGSpringContextTests {

    @Configuration
    @ComponentScan(basePackages = "workshop.spring.exercises.ex2")
    public static class TestConfig{
    }

        @Autowired
        BusChecker busChecker;

        @Test
        void checkNewShinyBus() {

            Bus minibus = createBrandNewBus();

            SafetyReport safetyReport = busChecker.check(minibus);
            assertThat(safetyReport.getThingsToFix()).isEmpty();

        }

    private Bus createBrandNewBus() {
        Bus minibus = new Bus();
        minibus.age = 1;
        minibus.engine = new Engine();
        minibus.engine.condition = Engine.Condition.GOOD;
        minibus.tires = Lists.newArrayList(
                new Tire(),
                new Tire(),
                new Tire(),
                new Tire()
        );
        minibus.seats = Lists.newArrayList(
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat(),
                new Seat()
        );
        return minibus;
    }

    @Test
    void checkOldBrokenBus() {

        Bus minibus = createBrandNewBus();
        minibus.age = 15;
        minibus.engine.condition = Engine.Condition.BAD;
        minibus.tires.get(2).runnerDepth = 3;
        minibus.seats.get(1).howManyHoles = 2;
        minibus.seats.get(3).seatBelt.doItWork = false;

        SafetyReport safetyReport = busChecker.check(minibus);
        assertThat(safetyReport.getThingsToFix()).containsExactlyInAnyOrder(
                minibus,
                minibus.engine,
                minibus.tires.get(2),
                minibus.seats.get(1),
                minibus.seats.get(3).seatBelt
        );
    }

}
