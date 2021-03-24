package surprise;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {

    GiveSurpriseAndHug(String type, int waitTime) {
        super(type, waitTime);
    }

    @Override
    protected void giveWithPassion() {
        System.out.println("Warm wishes and a big hug!");
    }
}
