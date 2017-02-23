package workshop.oop.drive.insurance;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OCInsuranceTest {

    @Test
    public void shouldHaveDefaultInsurance(){
        //given
        OCInsurance ocInsurance = new OCInsurance(300);
        //when

        //then
        assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(300);
    }

    @Test
    public void calculatePriceWithAbsoluteDiscount(){
        //given
        OCInsurance ocInsurance = new OCInsurance(300);
        //when
        ocInsurance.addAbsoluteDiscount(20);

        //then
        assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(280);
    }

    @Test
    public void calculatePriceWithAbsoluteAndRelativeDiscount(){
        //given
        OCInsurance ocInsurance = new OCInsurance(300);
        //when
        ocInsurance.addAbsoluteDiscount(20);
        ocInsurance.addRelativeDiscount(10);

        //then
        assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(252);
    }

    @Test
    public void calculatePriceWithRemovedAbsoluteDiscounts(){
        //given
        OCInsurance ocInsurance = new OCInsurance(300);
        //when
        ocInsurance.addAbsoluteDiscount(20);
        ocInsurance.addRelativeDiscount(10);
        ocInsurance.removeAbsoluteDiscounts();

        //then
        assertThat(ocInsurance.calculateFinalPrice()).isEqualTo(270);
    }

}