package test.java.order;

import main.java.order.MenuItem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    void testMenuItemConstructorAndGetters() {
        String expectedName  = "아이스 아메리카노";
        int    expectedPrice = 1500;

        MenuItem menuItem = new MenuItem(expectedName, expectedPrice);

        assertEquals(expectedName, menuItem.getName(), "이름이 같아야 함");
        assertEquals(expectedPrice, menuItem.getPrice(), "가격이 같아야 함");
    }
}
