package phone;

public class Smartphone {
    private Screen theScreen;
    private Case theCase;
    private Speaker theSpeaker;
    private Microphone theMicrophone;

    public Smartphone(int nrPixels, int width, int length, int depth, int speakerMaxVol,
                      int microMaxVol) {
        this.theScreen = new Screen(nrPixels, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol);
        this.theMicrophone = new Microphone(microMaxVol);
    }

    public Smartphone(int nrPixels, int width, int length, int depth, int speakerMaxVol,
                      int speakerCrtVol, int microMaxVol, int microCrtVol) {
        this.theScreen = new Screen(nrPixels, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVol, speakerCrtVol);
        this.theMicrophone = new Microphone(microMaxVol, microCrtVol);
    }

    public void pressPowerButton() {
        this.theCase.pressPowerButton();
    }

    public void pressVolumeUp() {
        this.theCase.pressVolumeUp();
        this.theSpeaker.increaseVolume();
    }

    public void pressVolumeDown() {
        this.theCase.pressVolumeDown();
        this.theSpeaker.decreaseVolume();
    }

    public void setPixel(int index, String color) {
        this.theScreen.setPixel(index, color);
    }

    public void colorScreen(String color) {
        this.theScreen.colorScreen(color);
    }

    public void increaseMicrophoneVolume() {
        this.theMicrophone.increaseVolume();
    }

    public void decreaseMicrophoneVolume() {
        this.theMicrophone.decreaseVolume();
    }

    public void muteMicrophone() {
        this.theMicrophone.muteMicrophone();
    }

    public void setSilenceMode() {
        this.theSpeaker.setSilenceMode();
    }

}
