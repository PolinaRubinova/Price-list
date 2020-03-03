class Price {
    private int priceRub;
    private int pricePen;

    Price(int priceRub, int pricePen) {
        if (priceRub <= 0 || pricePen < 0 || pricePen > 99) {
            throw new IllegalArgumentException();
        }
        else {
            this.priceRub = priceRub;
            this.pricePen = pricePen;
        }
    }

    public int getPriceRub() {
        return priceRub;
    }

    public int getPricePen(){
        return pricePen;
    }

    @Override
    public String toString() {
        return priceRub + " рублей " + pricePen + " копеек;";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Price))
            return false;
        Price other = (Price)obj;
        return other.priceRub == priceRub && other.pricePen == pricePen;
    }

    @Override
    public final int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(priceRub);
        result = 31 * result + Integer.hashCode(pricePen);
        return result;
    }
}
