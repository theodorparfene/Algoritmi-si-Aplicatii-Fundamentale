package surprise;

import java.util.ArrayList;

public final class GatherSurprises {

    private GatherSurprises() {
        //private constructor; does not allow instantiating
    }

    static ArrayList<ISurprise> gather(int n) {
        ArrayList<ISurprise> listOfSurprises = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            listOfSurprises.add(gather());
        }

        return listOfSurprises;
    }

    static ISurprise gather() {
        int random = RandomSelector.random.nextInt(3);

        if (random == 0) {
            return FortuneCookie.generate();
        } else if (random == 1) {
            return Candies.generate();
        } else {
            return MinionToy.generate();
        }
    }
}
