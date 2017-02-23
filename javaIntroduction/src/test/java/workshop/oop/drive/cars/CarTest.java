package workshop.oop.drive.cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    public void carHasBlueColor(){

        Car car = new Car();
        car.color = "blue";
        assertThat(car.color).isEqualTo("Blue");
    }


}
