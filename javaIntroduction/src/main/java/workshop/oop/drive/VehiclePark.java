package workshop.oop.drive;

import workshop.oop.drive.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class VehiclePark {

    public List<Car> cars = new ArrayList<>();
    public List<Bike> bikes = new ArrayList<>();

    VehicleCleaner universalCleaner = new VehicleCleaner();


    public void addVehicle(Car car) {
        cars.add(clean(car));
    }

    private Car clean(Car car) {
        Car cleaned = universalCleaner.clean(car);
        return cleaned;
    }

    public void addVehicle(Bike bike) {
        bikes.add(clean(bike));
    }

    private Bike clean(Bike bike) {
        Bike cleaned = universalCleaner.clean(bike);
        return cleaned;
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.color = "RED";

        VehiclePark vehiclePark = new VehiclePark();

        vehiclePark.addVehicle(car);
        vehiclePark.addVehicle(new Bike());

        System.out.println("Size of cars: " + vehiclePark.cars.size());

        Vehicle vehicle1 = vehiclePark.cars.get(0);

        System.out.println("Firs car:" + vehicle1);

        System.out.println("Size of bikes: " + vehiclePark.bikes.size());

    }

}
