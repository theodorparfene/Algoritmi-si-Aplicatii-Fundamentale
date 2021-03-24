package surprise;

import java.util.ArrayList;

public class FIFOContainer implements IBag {

    private ArrayList<ISurprise> bag;

    protected FIFOContainer() {
        this.bag = new ArrayList<>();
    }


    @Override
    public void put(ISurprise newSurprise) {
        this.bag.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while (!bagOfSurprises.isEmpty()) {
            this.bag.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public ISurprise takeOut() {
        ISurprise surprise = this.bag.get(0);
        this.bag.remove(0);
        return surprise;
    }

    @Override
    public boolean isEmpty() {
        return this.bag.size() == 0;
    }

    @Override
    public int size() {
        return this.bag.size();
    }
}
