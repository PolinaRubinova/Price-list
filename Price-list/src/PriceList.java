import java.util.HashMap;

class PriceList {

    HashMap<String, Data> goods = new HashMap<>();

    void addToPriceList(String name, Data codeAndPrice) {
        nameIsNull(name);
        dataIsNull(codeAndPrice);
        if (!goods.containsKey(name)) goods.put(name, codeAndPrice);
    }

    private void nameIsNull(String name) {
        if (name == null) throw new NullPointerException();
    }

    private void dataIsNull(Data data) {
        if (data.getCode() == null || data.getPriceRub() == null || data.getPricePen() == null)
            throw new NullPointerException();
    }

    void deleteFromPriceList(String name) {
        if (goods.containsKey(name)) goods.remove(name);
        else throw new NullPointerException();
    }

    void changePrice(String name, Data codeAndPrice) {
        nameIsNull(name);
        dataIsNull(codeAndPrice);
        if (goods.containsKey(name)) goods.put(name, codeAndPrice);
        else throw new NullPointerException();
    }

    void changeName(String name, String newName, Data codeAndPrice) {
        nameIsNull(name);
        nameIsNull(newName);
        if (goods.containsKey(name)) {
            goods.remove(name);
            goods.put(newName, codeAndPrice);
        }
        else throw new NullPointerException();
    }
}