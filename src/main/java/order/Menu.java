package main.java.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu {
    private final List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
        items.add(new MenuItem("아이스 아메리카노", 1500));
        items.add(new MenuItem("핫 아메리카노", 2000));
        items.add(new MenuItem("아이스 커피라떼", 3000));
        items.add(new MenuItem("핫 커피라떼", 4000));
        items.add(new MenuItem("초코 프라푸라치노", 5000));
        items.add(new MenuItem("핫 자몽허니블랙티", 4500));
        items.add(new MenuItem("아이스 자몽허니블랙티", 4500));
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
