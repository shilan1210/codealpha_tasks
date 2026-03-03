import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockMarket market = new StockMarket();
        Portfolio portfolio = new Portfolio(100000, "default"); // initial ₹1,00,000

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Update Market Prices");
	    System.out.println("6. View Transaction History");
System.out.println("7. Portfolio Summary");
System.out.println("8. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    market.displayStocks();
                    break;

                case 2:
                    market.displayStocks();
                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    Stock buyStock = market.getStock(buySymbol);

                    if (buyStock != null) {
                        portfolio.buyStock(buyStock, buyQty);
                    } else {
                        System.out.println("Invalid stock symbol!");
                    }
                    break;

                case 3:
                    portfolio.viewPortfolio(market.getAllStocks());
                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    Stock sellStock = market.getStock(sellSymbol);

                    if (sellStock != null) {
                        portfolio.sellStock(sellStock, sellQty);
                    } else {
                        System.out.println("Invalid stock symbol!");
                    }
                    break;

                case 4:
                    portfolio.viewPortfolio(market.getAllStocks());
                    break;

                case 5:
                    market.updateMarketPrices();
                    break;

               case 6:
    portfolio.viewTransactionHistory();
    break;

case 7:
    portfolio.showPerformanceSummary(market.getAllStocks());
    break;

case 8:
    System.out.println("Exiting platform...");
    System.exit(0);
            }
        }
    }
}