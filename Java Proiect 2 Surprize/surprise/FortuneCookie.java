package surprise;

public class FortuneCookie implements ISurprise {

    private String message;

    FortuneCookie(String message) {
        this.message = message;
    }

    static FortuneCookie generate() {
        String message = CookieMessages.getCookieMessages().get(RandomSelector.random.nextInt(CookieMessages.getCookieMessages().size()));
        return new FortuneCookie(message);
    }

    @Override
    public void enjoy() {
        System.out.println(this.message);
    }

    @Override
    public String toString() {
        return "Cookie message : " + this.message;
    }
}
