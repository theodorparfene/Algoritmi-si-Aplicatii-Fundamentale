package surprise;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {

    GiveSurpriseAndApplause(String type, int waitTime) {
        super(type, waitTime);
    }

    @Override
    protected void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}
