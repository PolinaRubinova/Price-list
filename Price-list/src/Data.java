class Data {

    private Integer code;
    private Integer priceRub;
    private Integer pricePen;

    Data(int code, int priceRub, int pricePen) {
        this.code = code;
        this.priceRub = priceRub;
        this.pricePen = pricePen;
    }

    Integer getCode() {
        return code;
    }

    Integer getPriceRub() {
        return priceRub;
    }

    Integer getPricePen() {
        return pricePen;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        Data it = (Data) other;
        return code.equals(it.code) && priceRub.equals(it.priceRub) && pricePen.equals(it.pricePen);
    }
}