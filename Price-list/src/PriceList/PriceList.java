package PriceList;

import java.util.HashMap;

public class PriceList {

    HashMap<Integer, NameAndPrice> goods = new HashMap<>();

    public NameAndPrice getNameAndPriceByCode(int code) {
        return goods.get(code);
    }

    public void add(Integer code, NameAndPrice nameAndPrice) {
        codeIsNull(code);
        nameAndPriceIsNull(nameAndPrice);
        if (!goods.containsKey(code)) goods.put(code, nameAndPrice);
    }

    private void codeIsNull(Integer code) {
        if (code == null) throw new NullPointerException();
    }

    private void nameAndPriceIsNull(NameAndPrice data) {
        if (data.getName() == null || data.getPrice() == null)
            throw new NullPointerException();
    }

    public void delete(Integer code) {
        goods.remove(code);
    }

    public void changePrice(Integer code, Price price) {
        codeIsNull(code);
        nameAndPriceIsNull(new NameAndPrice(goods.get(code).getName(), price));
        if (goods.containsKey(code)) goods.put(code, new NameAndPrice(goods.get(code).getName(), price));
        else throw new IllegalArgumentException();
    }

    public void changeName(Integer code, String name) {
        codeIsNull(code);
        nameAndPriceIsNull(new NameAndPrice(name, goods.get(code).getPrice()));
        if (goods.containsKey(code)) goods.put(code, new NameAndPrice(name, goods.get(code).getPrice()));
        else throw new IllegalArgumentException();
    }

    public Price cost(Integer code, Integer numberOfGoods) {
        int rub = goods.get(code).getPrice().getPriceRub()  * numberOfGoods +
                goods.get(code).getPrice().getPricePen() * numberOfGoods / 100;
        int pen =  goods.get(code).getPrice().getPricePen() * numberOfGoods % 100;
        return new Price(rub, pen);
    }

    @Override
    public int hashCode() {
        return goods.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object instanceof PriceList) {
            PriceList other = (PriceList) object;
            return goods.equals(other.goods);
        }
        return false;
    }
}