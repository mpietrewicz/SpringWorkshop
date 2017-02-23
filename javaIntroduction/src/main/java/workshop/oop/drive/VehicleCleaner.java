package workshop.oop.drive;

public class VehicleCleaner {

    public <T extends Vehicle> T clean(T vehicle){
        System.out.println("Cleaning vehicle: "+vehicle);
        return vehicle;
    }
}
