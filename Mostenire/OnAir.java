public class OnAir extends Vehicle {
    private int noTurbines;
    private boolean hasFirstClass;

    public OnAir(String serialNumber, int noPersons) {
        super(serialNumber, noPersons);
        this.noTurbines = 2;
    }

    public OnAir(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
        this.noTurbines = 2;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines) {
        super(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines, boolean hasFirstClass) {
        super(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
        this.hasFirstClass = hasFirstClass;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Flying the aircraft to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the aircraft");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Aircraft properties: " +
                "\n\t - number of turbines: " + this.noTurbines);
        if (hasFirstClass) {
            System.out.println("\t - has first class");
        } else {
            System.out.println("\t - does not have first class");
        }
    }
}
