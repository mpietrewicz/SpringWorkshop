package workshop.oop.drive;

import com.google.common.base.Function;

public class VehicleTrip {

    private final Vehicle vehicle;
    private final int length;

    public VehicleTrip(Vehicle vehicle, int length) {
        this.vehicle = vehicle;
        this.length = length;
    }

    public void doTrip() {

    }

    public <F extends FuelType> int calculateCost(Function<F, Integer> costOfFuel){
        return 0;
    }
}
