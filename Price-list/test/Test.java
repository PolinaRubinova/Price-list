import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

class PriceListTest {

    private PriceList actual = new PriceList();
    private HashMap<Integer, Data> expected = new HashMap<>();

    //94, new Data("Milk", new Price(65,50))
    //44, new Data("Bread", new Price(25,50))
    //25, new Data("Corn", new Price(10, 90))
    //9, new Data("Potato", new Price(99, 99))

    @Test
    void add() {
        expected.put(94, new Data("Milk", new Price(65,50)));
        expected.put(44, new Data("Bread", new Price(25,50)));

        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        actual.addToPriceList(44, new Data("Bread", new Price(25,50)));
        Assert.assertEquals(expected, actual.goods);

        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        expected.remove(94);
        Assert.assertNotEquals(expected, actual.goods);

        expected.put(94, new Data("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.addToPriceList(null, new Data("Bread", new Price(65, 50))));
        Assertions.assertThrows(NullPointerException.class, () ->
                actual.addToPriceList(94, null));
    }

    @Test
    void delete() {
        expected.put(94, new Data("Milk", new Price(65,50)));

        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        Assert.assertEquals(expected, actual.goods);

        actual.addToPriceList(44, new Data("Bread", new Price(25,50)));
        actual.deleteFromPriceList(94);
        Assert.assertNotEquals(expected, actual.goods);

        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        actual.deleteFromPriceList(44);
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.deleteFromPriceList(10));
    }

    @Test
    void changePrice() {
        expected.put(94, new Data("Milk", new Price(49, 99)));
        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changePrice(94, new Price(49, 99));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changePrice(25, new Price(10, 90)));
    }

    @Test
    void changeName() {
        expected.put(94, new Data("Meat", new Price(49, 99)));
        actual.addToPriceList(94, new Data("Milk", new Price(49, 99)));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changeName(94, "Meat");
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changeName(9, "Potato"));
    }

    @Test
    void cost() {
        actual.addToPriceList(94, new Data("Milk", new Price(65,50)));
        actual.addToPriceList(44, new Data("Bread", new Price(25,55)));

        Assertions.assertEquals(new Price(131, 0), actual.cost(94, 2));
        Assertions.assertEquals(new Price(76, 65), actual.cost(44, 3));
    }
}