import main.Main;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testGetDayOfTheWeek() {
        assertEquals("Пон", Main.getDayOfTheWeek(0));
        assertEquals("Вт", Main.getDayOfTheWeek(1));
        assertEquals("Ср", Main.getDayOfTheWeek(2));
        assertEquals("Чт", Main.getDayOfTheWeek(3));
        assertEquals("Пт", Main.getDayOfTheWeek(4));
        assertEquals("Сб", Main.getDayOfTheWeek(5));
        assertEquals("Вс", Main.getDayOfTheWeek(6));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetDayOfTheWeekExc() {
        Main.getDayOfTheWeek(7);
    }

    @Test
    public void testGetString() {
        assertEquals("Сто Один", Main.getString(101));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetStringExc() {
        Main.getString(999999);
    }

    @Test
    public void testGetNumber() {
        assertEquals(101, Main.getNumber("Сто Один"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetNumberExc() {
        Main.getNumber("d d d d");
    }

    @Test
    public void testGetCartesianDistance() {
        assertEquals(4, Main.getCartesianDistance(3, 5, -2, 7));
    }
}
