import java.util.HashMap;

class PriceList {

    HashMap<Integer, Data> goods = new HashMap<>();

    void addToPriceList(Integer code, Data nameAndPrice) {
        codeIsNull(code);
        dataIsNull(nameAndPrice);
        if (!goods.containsKey(code)) goods.put(code, nameAndPrice);
    }

    private void codeIsNull(Integer code) {
        if (code == null) throw new NullPointerException();
    }

    private void dataIsNull(Data data) {
        if (data.getName() == null || data.getPrice() == null)
            throw new NullPointerException();
    }

    void deleteFromPriceList(Integer code) {
        if (goods.containsKey(code)) goods.remove(code);
        else throw new NullPointerException();
    }

    void changePrice(Integer code, Price price) {
        codeIsNull(code);
        dataIsNull(new Data(goods.get(code).getName(), price));
        if (goods.containsKey(code)) goods.put(code, new Data(goods.get(code).getName(), price));
        else throw new NullPointerException();
    }

    void changeName(Integer code, String name) {
        codeIsNull(code);
        dataIsNull(new Data(name, goods.get(code).getPrice()));
        if (goods.containsKey(code)) goods.put(code, new Data(name, goods.get(code).getPrice()));
        else throw new NullPointerException();
    }

    public Price cost(Integer code, Integer numberOfGoods) {
        int rub = goods.get(code).getPrice().getPriceRub()  * numberOfGoods +
                goods.get(code).getPrice().getPricePen() * numberOfGoods / 100;
        int pen =  goods.get(code).getPrice().getPricePen() * numberOfGoods % 100;
        return new Price(rub, pen);
    }
}