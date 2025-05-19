package main.java.order;

import java.util.Map;

public class SalesCalculator {
    public int calculate(Menu menu, OrderManager orders) {
        int sum = 0;
        for (Map.Entry<MenuItem, Integer> entry : orders.getOrderCounts().entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            sum += item.getPrice() * qty;
        }
        return sum;
    }
}
