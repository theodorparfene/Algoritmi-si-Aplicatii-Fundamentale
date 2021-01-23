import java.util.Arrays;

public class Vehicle {
    private static final String producedBy = "DevMind";
    private final int productionYear;
    private final String vin;
    private String plateNumber;
    private double kilometers;
    private int lastSoldOnYear;
    private double positionX;
    private double positionY;

    public Vehicle(int productionYear, String vin) {
        this.productionYear = productionYear;
        this.vin = vin;
    }

    public Vehicle(String plateNumber, double kilometers, int lastSoldOnYear, int productionYear, String vin) {
        this(productionYear, vin);
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.lastSoldOnYear = lastSoldOnYear;
    }

    public Vehicle(double positionX, double positionY, int productionYear, String vin, double kilometers) {
        this("UNDEFINED", kilometers, 0, productionYear, vin);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static String getProducedBy() {
        return producedBy;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getLastSoldOnYear() {
        return lastSoldOnYear;
    }

    public void setLastSoldOnYear(int lastSoldOnYear) {
        this.lastSoldOnYear = lastSoldOnYear;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getKilometers() {
        return this.kilometers;
    }

    public String getVin() {
        return this.vin;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void sellVehicle(String plateNumber, int lastSoldOnYear) {
        this.plateNumber = plateNumber;
        this.lastSoldOnYear = lastSoldOnYear;
    }

    public void moveVehicle(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.kilometers += getDistance(positionX, positionY);
    }

    private double getDistance(double newPositionX, double newPositionY) {
        //√(positionXnew−positionXold)2+(positionYnew−positionYold)2
        return Math.sqrt(Math.pow(newPositionX - this.positionX, 2) + Math.pow(newPositionY - this.positionY, 2));
    }

    public boolean isVinValid(boolean isDrivingInNorthAmerica) {
        if (!isDrivingInNorthAmerica || getVin().length() != 17) {
            System.out.println("VIN invalid!");
            return false;
        } else {
            int[] weight = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] products = new int[17];
            String vin = transliterate(getVin());
            int sumOfProducts = 0;
            for (int i = 0; i < vin.length(); i++) {
                int currentValue = Character.getNumericValue(vin.charAt(i));
                products[i] = weight[i] * currentValue;
                sumOfProducts += products[i];
            }
            if (sumOfProducts % 11 != 10) {
                return true;
            } else {
                System.out.println("Check digit does not match!");
                return false;
            }
        }
    }

    private String transliterate(String vin) {
        vin = vin.toUpperCase();
        //vin = vin.replaceAll("-", "").replaceAll(" ", "");
        for (int i = 0; i < vin.length(); i++) {
            char temp = vin.charAt(i);
            if (Character.isLetter(temp)) {
                switch (temp) {
                    case 'A':
                    case 'J':
                        vin = vin.replace(vin.charAt(i), '1');
                        break;
                    case 'B':
                    case 'K':
                    case 'S':
                        vin = vin.replace(vin.charAt(i), '2');
                        break;
                    case 'C':
                    case 'L':
                    case 'T':
                        vin = vin.replace(vin.charAt(i), '3');
                        break;
                    case 'D':
                    case 'M':
                    case 'U':
                        vin = vin.replace(vin.charAt(i), '4');
                        break;
                    case 'E':
                    case 'N':
                    case 'V':
                        vin = vin.replace(vin.charAt(i), '5');
                        break;
                    case 'F':
                    case 'W':
                        vin = vin.replace(vin.charAt(i), '6');
                        break;
                    case 'G':
                    case 'P':
                    case 'X':
                        vin = vin.replace(vin.charAt(i), '7');
                        break;
                    case 'H':
                    case 'Y':
                        vin = vin.replace(vin.charAt(i), '8');
                        break;
                    case 'R':
                    case 'Z':
                        vin = vin.replace(vin.charAt(i), '9');
                        break;
                    case '_':
                        vin = vin.replace(vin.charAt(i), '0');
                        break;
                }
            }
        }
        return vin;
    }

    public void printVinDecomposed() {
        if (isVinValid(true)) {
            String vin = getVin();
            vin = vin.replace(vin.charAt(8), 'X');
            System.out.println("Identificatorul producatorului: " + vin.substring(0,3) +
                                "\nAtributele vehiculului: " + vin.substring(3,8) +
                                "\nCifra de verificare: " + vin.charAt(8) +
                                "\nAnul productiei modelului: " + vin.charAt(9) +
                                "\nSeria fabricii: " + vin.charAt(10) +
                                "\nIdentificatorul numeric: " + vin.substring(11,17));
        }
    }

    public void display() {
        System.out.println("Produced By: " + getProducedBy() +
                "\nProduction Year: " + this.getProductionYear() +
                "\nVIN: " + this.getVin() +
                "\nPlate Number: " + this.getPlateNumber() +
                "\nKilometers: " + this.getKilometers() +
                "\nLast Sold on Year: " + this.getLastSoldOnYear() +
                "\nPosition of the car: (" + this.getPositionX() + ", " + this.getPositionY() + ")");
    }
}
