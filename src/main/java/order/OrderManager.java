package main.java.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private final Map<MenuItem, Integer> counts = new HashMap<>();

    public void addOrder(MenuItem item, int qty) {
        counts.put(item, counts.getOrDefault(item, 0) + qty);
    }

    public Map<MenuItem, Integer> getOrderCounts() {
        return Collections.unmodifiableMap(counts);
    }
}
