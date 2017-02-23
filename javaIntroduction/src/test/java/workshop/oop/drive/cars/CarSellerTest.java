package workshop.oop.drive.cars;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarSellerTest {

    CarSeller carSeller = new CarSeller();

    @Test
    public void describesSingleCar(){
        //given
        Car car = new Car();
        car.carType = CarType.SEDAN;
        car.color = "blue";

        //when
        String description = carSeller.describeMeThisCar(car);

        //then
        assertThat(description).isEqualTo("Car#1 is a blue sedan");
    }

    @Test
    public void describeCoupleOfCars(){
        //given
        Car car1 = new Car();
        car1.carType = CarType.SEDAN;
        car1.color = "blue";

        Car car2 = new Car();
        car2.carType = CarType.COMBI;
        car2.color = "black";


        //when
        String description = null;//carSeller.describeMeThisCar(car1, car2);

        //then
        assertThat(description).isEqualTo("Car#1 is a blue sedan, Car#2 is a black combi");
    }
}
