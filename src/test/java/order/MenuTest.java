package test.java.order;

import main.java.order.Menu;
import main.java.order.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @Test
    void testMenu(){
        //given
        Menu menu = new Menu();

        //when
        List<MenuItem> items = menu.getItems();

        //then
        assertEquals(7, items.size(), "메뉴는 총 7개여야 한다.");
    }

}
