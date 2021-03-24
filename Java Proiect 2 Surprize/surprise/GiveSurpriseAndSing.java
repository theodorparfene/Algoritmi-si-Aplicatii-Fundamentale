package surprise;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {

    GiveSurpriseAndSing(String type, int waitTime) {
        super(type, waitTime);
    }

    @Override
    protected void giveWithPassion() {
        System.out.println("Singing a nice song, full of joy and genuine excitement…");
    }

}
