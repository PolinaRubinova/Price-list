class Data {

    private String name;
    private Price price;

    Data(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;
        Data it = (Data) other;
        return name.equals(it.name) && price.equals(it.price);
    }
}