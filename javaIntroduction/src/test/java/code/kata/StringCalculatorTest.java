package code.kata;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mpietrewicz on 2017-03-06.
 */
public class StringCalculatorTest {

    @Test
    public void calculateForNoParams() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int calculateResult = calculator.calculate();

        // then
        assertThat(calculateResult).isEqualTo(0);
    }

    @Test
    public void calculateForOneParam() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int calculateResult = calculator.calculate(10);

        // then
        assertThat(calculateResult).isEqualTo(10);
    }

    @Test
    public void calculateForTwoParams() {
        // given
        StringCalculator calculator = new StringCalculator();

        // when
        int calculateResult = calculator.calculate(5, 10);

        // then
        assertThat(calculateResult).isEqualTo(15);
    }



}
