package surprise;

public class MakeBag implements IBagFactory {

    @Override
    public IBag makeBag(String type) {
        return switch (type.toLowerCase()) {
            case "random" -> new RandomContainer();
            case "fifo" -> new FIFOContainer();
            case "lifo" -> new LIFOContainer();
            default -> throw new IllegalStateException("Unexpected value: " + type.toLowerCase());
        };
    }
}
