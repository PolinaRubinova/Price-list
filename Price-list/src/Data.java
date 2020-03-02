class Data {

    private Integer code;
    private Price price;

    Data(int code, Price price) {
        this.code = code;
        this.price = price;
    }

    Integer getCode() {
        return code;
    }

    Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        Data it = (Data) other;
        return code.equals(it.code) && price.equals(it.price);
    }
}