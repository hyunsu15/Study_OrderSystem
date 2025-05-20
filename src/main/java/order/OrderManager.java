package main.java.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private final Map<MenuItem, Integer> counts = new HashMap<>();

    public void addOrder(MenuItem item, int qty) {
        counts.put(item, counts.getOrDefault(item, 0) + qty);
    }

    public Map<MenuItem, Integer> getOrderCounts() {
        return Collections.unmodifiableMap(counts);
    }

    public void processOrder(Reader reader, Printer printer, Menu menu) {

        String orderLine = reader.readLine();

        try {
            Map<Integer, Integer> orderItems = parseOrderInput(orderLine);

            validateOrder(orderItems, menu);

            boolean confirmed = printer.printConfirmOrder(menu, orderItems, reader);

            if (confirmed) {
                for (Map.Entry<Integer, Integer> entry : orderItems.entrySet()) {
                    int menuIndex = entry.getKey();
                    int quantity = entry.getValue();

                    if (menuIndex >= 0 && menuIndex < menu.getItems().size()) {
                        MenuItem item = menu.getItems().get(menuIndex);
                        addOrder(item, quantity);
                        printer.printOrderCompleted(item, quantity);
                    }
                }
            } else {
                printer.printOrderCancelled();
            }
        } catch (IllegalArgumentException e) {
            printer.printOrderError(e.getMessage());
        }
    }
    private Map<Integer, Integer> parseOrderInput(String orderLine) {
        Map<Integer, Integer> orderItems = new HashMap<>();

        if (orderLine == null || orderLine.trim().isEmpty()) {
            throw new IllegalArgumentException("주문이 비어있습니다.");
        }

        String[] orders = orderLine.split(",");
        for (String order : orders) {
            order = order.trim();
            try {
                String[] parts = order.split(" ");
                if (parts.length != 2) {
                    throw new IllegalArgumentException("주문 형식이 잘못되었습니다: " + order);
                }

                int menuNo = Integer.parseInt(parts[0]) - 1;
                int qty = Integer.parseInt(parts[1]);

                if (qty <= 0) {
                    throw new IllegalArgumentException("수량은 1 이상이어야 합니다: " + order);
                }

                orderItems.put(menuNo, qty);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + order);
            }
        }

        return orderItems;
    }

    private void validateOrder(Map<Integer, Integer> orderItems, Menu menu) {
        if (orderItems.isEmpty()) {
            throw new IllegalArgumentException("주문 항목이 없습니다.");
        }

        List<MenuItem> menuItems = menu.getItems();
        for (int menuIndex : orderItems.keySet()) {
            if (menuIndex < 0 || menuIndex >= menuItems.size()) {
                throw new IllegalArgumentException("메뉴 번호가 잘못되었습니다: " + (menuIndex + 1));
            }
        }
    }


}
