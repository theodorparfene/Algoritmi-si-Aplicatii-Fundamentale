package surprise;

public class Main {

    public static void main(String[] args) {
        ISurprise sur1 = GatherSurprises.gather();

        GiveSurpriseAndApplause test = new GiveSurpriseAndApplause("random", 3);

        test.put(sur1);
        test.give();

    }
}
