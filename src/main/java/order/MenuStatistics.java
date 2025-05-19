package main.java.order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MenuStatistics {
    private final OrderManager orders;

    public MenuStatistics(OrderManager orders) {
        this.orders = orders;
    }

    public List<Map.Entry<MenuItem, Integer>> getTopN(int n) {
        return orders.getOrderCounts().entrySet().stream()
                .sorted(Map.Entry.<MenuItem, Integer>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .toList();
    }

    public List<Map.Entry<MenuItem, Integer>> getBottomN(int n) {
        return orders.getOrderCounts().entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(n)
                .toList();
    }
}
