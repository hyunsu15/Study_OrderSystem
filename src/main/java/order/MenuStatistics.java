package main.java.order;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MenuStatistics {
    private final OrderManager orders;

    public MenuStatistics(OrderManager orders) {
        this.orders = orders;
    }

    public List<Map.Entry<MenuItem, Integer>> getTopN(int n) {
        return orders.getOrderCounts()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<MenuItem, Integer>> getBottomN(int n) {
        return orders.getOrderCounts().entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(n)
                .collect(Collectors.toList());
    }
}
