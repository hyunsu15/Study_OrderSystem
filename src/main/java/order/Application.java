package main.java.order;

public class Application {
  public static void main(String[] args) {
    Reader reader = new Reader();
    Printer printer = new Printer();
    Menu menu = new Menu();
    OrderManager orderManager = new OrderManager();
    SalesCalculator salesCalculator = new SalesCalculator();
    MenuStatistics menuStatistics = new MenuStatistics(orderManager);

    while (true) {
      printer.printMainMenu();
      int choice = reader.readInt();
      switch (choice) {
        case 1:
          printer.printMenu(menu.getItems());
          break;
        case 2:
          printer.printPopularMenu(
                  menuStatistics.getTopN(3)
          );
          break;
        case 3:
          printer.printUnpopularMenu(
                  menuStatistics.getBottomN(3)
          );
          break;
        case 4:
          int total = salesCalculator.calculate(menu, orderManager);
          printer.printSales(total);
          break;
        case 5:
          printer.printExit();
          return;
        default:
          printer.printInvalidInput();
      }
    }
  }
}