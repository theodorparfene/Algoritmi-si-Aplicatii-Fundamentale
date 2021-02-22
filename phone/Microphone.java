package phone;

public class Microphone {
    int maxVolume;
    int crtVolume;

    public Microphone(int maxVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = (int)(maxVolume * (25d / 100d));
    }

    public Microphone(int maxVolume, int crtVolume) {
        this.maxVolume = maxVolume;
        this.crtVolume = crtVolume;
    }

    public boolean increaseVolume() {
        int increaseValue = this.crtVolume + (int)(maxVolume * (3d / 100d)); //increases with 3%
        if (increaseValue <= maxVolume) {
            this.crtVolume = increaseValue;
            return true;
        } else {
            return false;
        }
    }

    public boolean decreaseVolume() {
        int decreaseValue = this.crtVolume - (int)(maxVolume * (3d / 100d)); //decreases with 3%
        if (decreaseValue >= 0) {
            this.crtVolume = decreaseValue;
            return true;
        } else {
            return false;
        }
    }

    public void muteMicrophone() {
        this.crtVolume = 0;
    }
}
