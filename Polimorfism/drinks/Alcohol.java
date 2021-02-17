package drinks;

public abstract class Alcohol extends Liquid{  // polimorfism dinamic
    private int alcoholLvl;

    Alcohol(double phLevel, double volume, int alcoholLvl) {
        super(phLevel, volume);
        this.alcoholLvl = alcoholLvl;
    }

    public int getAlcoholLvl() {
        return alcoholLvl;
    }

    public void setAlcoholLvl(int alcoholLvl) {
        this.alcoholLvl = alcoholLvl;
    }

    @Override
    public abstract void showInfo();
}
