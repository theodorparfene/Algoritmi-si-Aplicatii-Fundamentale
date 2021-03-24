package surprise;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {
    IBag bag;
    int waitTime;

    AbstractGiveSurprises(String type, int waitTime) {
        this.bag = new MakeBag().makeBag(type);
        this.waitTime = waitTime;
    }

    void put(ISurprise newSurprise) {
        this.bag.put(newSurprise);
    }

    void put(IBag surprises) {
        this.bag.put(surprises);
    }

    void give() {
        System.out.println(this.bag.takeOut());
    }

    void giveAll() {

        for (int i = 0; i <= this.bag.size(); i++) {
            this.bag.takeOut();

            // Sleep for X seconds - code snippet
            try {
                TimeUnit.SECONDS.sleep(10); // number of seconds to sleep
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    boolean isEmpty() {
        return this.bag.isEmpty();
    }

    protected abstract void giveWithPassion();

}
