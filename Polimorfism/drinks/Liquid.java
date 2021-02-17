package drinks;

public abstract class Liquid {
    private double phLevel;
    private double volume;

    Liquid(double phLevel, double volume) {
        this.phLevel = phLevel;
        this.volume = volume;
    }

    public double getPhLevel() {
        return phLevel;
    }

    public void setPhLevel(double phLevel) {
        this.phLevel = phLevel;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public abstract void showInfo();
}
