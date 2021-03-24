package surprise;

public class MinionToy implements ISurprise {

    private static int minionCounter;
    private String minion;

    MinionToy(String minion) {
        this.minion = minion;
    }

    static MinionToy generate() {
        if (minionCounter >= Minions.getMinions().size()) {
            minionCounter = 0;
        }
        String minion = Minions.getMinions().get(minionCounter++);
        return new MinionToy(minion);
    }

    @Override
    public void enjoy() {
        System.out.println(this.minion);
    }

    @Override
    public String toString() {
        return "Minion : " + this.minion;
    }
}
