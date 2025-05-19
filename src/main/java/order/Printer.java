package main.java.order;

import java.util.*;

public class Printer {
    public void printMainMenu() {
        System.out.println("원조벅스에 오신걸 환영합니다. 어떤 것을 원하십니까?");
        System.out.println("1: 메뉴판 2: 인기 메뉴 3: 비인기 메뉴 4: 매출 5: 종료");
    }

    public void printMenu(List<MenuItem> items) {
        System.out.println("----메뉴----");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " " + item.getPrice() + "원");
        }
        System.out.println("----------");
    }

    public void printPopularMenu(List<Map.Entry<MenuItem, Integer>> list) {
        System.out.println("인기 메뉴 상위 3개");
        for (Map.Entry<MenuItem, Integer> entry : list) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
    }

    public void printUnpopularMenu(List<Map.Entry<MenuItem, Integer>> list) {
        System.out.println("비인기 메뉴 하위 3개");
        for (Map.Entry<MenuItem, Integer> entry : list) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
    }

    public void printSales(int total) {
        System.out.println("오늘의 매출은 " + total + "원입니다");
    }

    public void printExit() {
        System.out.println("종료됐습니다!");
    }

    public void printInvalidInput() {
        System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
    }
}
