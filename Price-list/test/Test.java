import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

class PriceListTest {

    private PriceList actual = new PriceList();
    private HashMap<String, Data> expected = new HashMap<>();

    //"Milk", new Data(94, 65,50)
    //"Bread", new Data(44, 25,50)
    //"Corn", new Data(25, 10, 90)
    //"Potato", new Data(9, 99, 99)

    @Test
    void add() {
        expected.put("Milk", new Data(94, 65, 50));
        expected.put("Bread", new Data(44, 25,50));

        actual.addToPriceList("Milk", new Data(94, 65, 50));
        actual.addToPriceList("Bread", new Data(44, 25,50));
        Assert.assertEquals(expected, actual.goods);

        actual.addToPriceList("Milk", new Data(94, 65, 50));
        Assert.assertEquals(expected, actual.goods);

        expected.remove("Milk");
        Assert.assertNotEquals(expected, actual.goods);

        expected.put("Milk", new Data(94, 65, 50));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.addToPriceList(null, new Data(94, 65, 50)));
        Assertions.assertThrows(NullPointerException.class, () ->
                actual.addToPriceList("Bread", null));
    }

    @Test
    void delete() {
        expected.put("Milk", new Data(94, 65, 50));

        actual.addToPriceList("Milk", new Data(94, 65, 50));
        Assert.assertEquals(expected, actual.goods);

        actual.addToPriceList("Bread", new Data(44, 25, 50));
        actual.deleteFromPriceList("Milk");
        Assert.assertNotEquals(expected, actual.goods);

        actual.addToPriceList("Milk", new Data(94, 65, 50));
        actual.deleteFromPriceList("Bread");
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.deleteFromPriceList("Corn"));
    }

    @Test
    void changePrice() {
        expected.put("Milk", new Data(94, 49, 99));
        actual.addToPriceList("Milk", new Data(94, 65, 50));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changePrice("Milk", new Data(94, 49, 99));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changePrice("Corn", new Data(25, 10, 90)));
    }

    @Test
    void changeName() {
        expected.put("Meat", new Data(94, 49, 99));
        actual.addToPriceList("Milk", new Data(94, 49, 99));
        Assert.assertNotEquals(expected, actual.goods);

        actual.changeName("Milk","Meat", new Data(94, 49, 99));
        Assert.assertEquals(expected, actual.goods);

        Assertions.assertThrows(NullPointerException.class, () ->
                actual.changeName("Potato", "Corn", new Data(94, 49, 99)));
    }
}
