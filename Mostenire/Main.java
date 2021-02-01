public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("3FDS9DFF8FSD7", 4, "Moby");
        vehicle.goTo(2.3,14.2);
        vehicle.addFuel(23.1);
        vehicle.printInfo();

        System.out.println();

        OnRoad car = new OnRoad("FDFL8KMFSDLKM6", 2, "Sporty", 4, 2);
        car.goTo(23.1,41.4);
        car.addFuel(12.9);
        car.printInfo();

        System.out.println();

        OnWater boat = new OnWater("F8GFDG86D87GGD", 20, "Wavess", 2, 2000);
        boat.goTo(111, 25.2);
        boat.addFuel(99);
        boat.printInfo();

        System.out.println();

        OnAir plane = new OnAir("GJR96GDF98DF9ND", 120, "Bluesky",4, true);
        plane.goTo(10,82.3);
        plane.addFuel(321.3);
        plane.printInfo();
    }
}
