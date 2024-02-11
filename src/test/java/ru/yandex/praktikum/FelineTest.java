package ru.yandex.praktikum;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest extends TestCase {

    private static final int EXPECTED_KITTENS_COUNT_FOR_MOCK = 1;


    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(EXPECTED_KITTENS_COUNT_FOR_MOCK);

        assertEquals("Количество котят не соответствует ожидаемому",
                EXPECTED_KITTENS_COUNT_FOR_MOCK, actual);
    }

    @Test
    public void testGetKittensWithArgs() {
        Assert.assertEquals(3, feline.getKittens(3));
    }
}