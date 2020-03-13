import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.HashMap;

class PriceListTest {

    private PriceList actual = new PriceList();
    private HashMap<Integer, NameAndPrice> expected = new HashMap<>();

    //94, new Data("Milk", new Price(65,50))
    //44, new Data("Bread", new Price(25,50))
    //25, new Data("Corn", new Price(10, 90))
    //9, new Data("Potato", new Price(99, 99))

    @Test
    void add() {
        expected.put(94, new NameAndPrice("Milk", new Price(65,50)));
        expected.put(44, new NameAndPrice("Bread", new Price(25,50)));

        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        actual.add(44, new NameAndPrice("Bread", new Price(25,50)));
        Assert.assertEquals(expected, actual.goods);

        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        expected.remove(94);
        Assert.assertNotEquals(expected, actual.goods);

        expected.put(94, new NameAndPrice("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.add(null, new NameAndPrice("Bread", new Price(65, 50))));
        Assertions.assertThrows(NullPointerException.class, () ->
                actual.add(94, null));
    }

    @Test
    void delete() {
        expected.put(94, new NameAndPrice("Milk", new Price(65,50)));

        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        actual.add(44, new NameAndPrice("Bread", new Price(25,50)));
        actual.delete(94);
        Assert.assertNotEquals(expected, actual.goods);

        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        actual.delete(44);
        Assert.assertEquals(expected, actual.goods);
    }

    @Test
    void changePrice() {
        expected.put(94, new NameAndPrice("Milk", new Price(49, 99)));
        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changePrice(94, new Price(49, 99));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changePrice(25, new Price(10, 90)));
    }

    @Test
    void changeName() {
        expected.put(94, new NameAndPrice("Meat", new Price(49, 99)));
        actual.add(94, new NameAndPrice("Milk", new Price(49, 99)));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changeName(94, "Meat");
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changeName(9, "Potato"));
    }

    @Test
    void priceToString() {
        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        actual.add(44, new NameAndPrice("Bread", new Price(25,55)));

        Assertions.assertEquals("65 рублей 50 копеек;", actual.goods.get(94).getPrice().toString());
        Assertions.assertEquals("25 рублей 55 копеек;", actual.goods.get(44).getPrice().toString());
    }

    @Test
    void cost() {
        actual.add(94, new NameAndPrice("Milk", new Price(65,50)));
        actual.add(44, new NameAndPrice("Bread", new Price(25,55)));

        Assertions.assertEquals(new Price(131, 0), actual.cost(94, 2));
        Assertions.assertEquals(new Price(76, 65), actual.cost(44, 3));

        Assertions.assertEquals(new Price(0, 0), actual.cost(94, 0));
    }
}