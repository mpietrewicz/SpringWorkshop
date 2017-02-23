package workshop.oop.drive;

import workshop.oop.drive.cars.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class VehicleTripTest {

    public void calculateCostOfRidingBike(){
        //given
        VehicleTrip vehicleTrip = new VehicleTrip(new Bike(), 100);

        //when
        vehicleTrip.doTrip();

        //then
        assertThat(vehicleTrip.calculateCost(null)).isEqualTo(0);
    }

    public void calculateCostOfACarRide(){
        //given
        VehicleTrip vehicleTrip = new VehicleTrip(new Car(), 100);

        //when
        vehicleTrip.doTrip();

        //then
        //TODO 100km uses 7liters per 5 zlotys each - implement null
        //assertThat(vehicleTrip.calculateCost(null)).isEqualTo(35);
    }

    public void calculateCostOfAElectricCarRide(){
        //given
        //TODO: set up engine
        VehicleTrip vehicleTrip = new VehicleTrip(new Car(), 100);

        //when
        vehicleTrip.doTrip();

        //then
        //TODO 100km uses 20kWh per 0,5 zlotys each - implement null
        assertThat(vehicleTrip.calculateCost(null)).isEqualTo(10);
    }
}
