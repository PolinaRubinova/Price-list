package PriceList;

public class NameAndPrice {

    private String name;
    private Price price;

    NameAndPrice(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        NameAndPrice it = (NameAndPrice) other;
        return name.equals(it.name) && price.equals(it.price);
    }

    @Override
    public final int hashCode() {
        int result = 1;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (price != null) {
            result = (31 * result) + price.hashCode();
        }
        return result;
    }
}