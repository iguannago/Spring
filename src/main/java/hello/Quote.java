package hello;

/**
 * Created by davicres on 31/03/2016.
 */
public final class Quote {

    private String type;
    private Value vatue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getVatue() {
        return vatue;
    }

    public void setVatue(Value vatue) {
        this.vatue = vatue;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", vatue=" + vatue +
                '}';
    }
}
