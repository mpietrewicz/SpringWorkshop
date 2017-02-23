package workshop.oop.drive.cars;

import workshop.oop.drive.Vehicle;
import workshop.oop.drive.VehicleParts;

public class Car implements Vehicle {

    public String color;

    public CarType carType;

    public long distanceMeter;

    VehicleParts.SteeringWheel steeringWheel;

    @Override
    public void driveForward(int kilometers) {

    }

}
