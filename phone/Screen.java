package phone;

import java.util.ArrayList;

public class Screen {
    private ArrayList<Pixel> pixels;
    private Dimensions dimensions;

    public Screen(int nrPixels, int width, int length, int depth) {
        this.pixels = new ArrayList<>();
        for (int i = 0; i < nrPixels; i++) {
            this.pixels.add(new Pixel());
        }
        this.dimensions = new Dimensions(width, length, depth);
    }

    public void setPixel(int index, String color) {
        this.pixels.get(index).setPixel(color);
    }

    public void colorScreen(String color) {
        for (int i = 0; i < this.pixels.size(); i++) {
            setPixel(i, color);
        }
    }
}
