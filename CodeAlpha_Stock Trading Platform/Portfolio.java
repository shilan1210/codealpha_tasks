import java.util.HashMap;

public class Portfolio {
    private String FILE_NAME;
    private HashMap<String, Integer> holdings;
private HashMap<String, Double> averageBuyPrice;
private java.util.ArrayList<String> transactions;
    private double balance;

    public Portfolio(double initialBalance, String username) {

    holdings = new HashMap<>();
    averageBuyPrice = new HashMap<>();
    transactions = new java.util.ArrayList<>();
    balance = initialBalance;

    FILE_NAME = "portfolio_" + username + ".txt";

    loadFromFile();
}

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int quantity) {

    double totalCost = stock.getPrice() * quantity;

    if (totalCost > balance) {
        System.out.println("Insufficient balance!");
        return;
    }

    balance -= totalCost;

    int existingQty = holdings.getOrDefault(stock.getSymbol(), 0);
    double existingAvg = averageBuyPrice.getOrDefault(stock.getSymbol(), 0.0);

    int newQty = existingQty + quantity;

    double newAvgPrice =
        ((existingQty * existingAvg) + (quantity * stock.getPrice())) / newQty;

    holdings.put(stock.getSymbol(), newQty);
    averageBuyPrice.put(stock.getSymbol(), newAvgPrice);

    System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
transactions.add("BUY " + quantity + " " +
        stock.getSymbol() + " at Rs." + stock.getPrice());
saveToFile();
}

    public void sellStock(Stock stock, int quantity) {

        if (!holdings.containsKey(stock.getSymbol()) ||
            holdings.get(stock.getSymbol()) < quantity) {

            System.out.println("Not enough shares to sell!");
            return;
        }

        holdings.put(stock.getSymbol(),
                holdings.get(stock.getSymbol()) - quantity);

        balance += stock.getPrice() * quantity;

        System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
transactions.add("SELL " + quantity + " " +
        stock.getSymbol() + " at Rs." + stock.getPrice());
saveToFile();
    }
    public void viewTransactionHistory() {

    System.out.println("\n===== TRANSACTION HISTORY =====");

    if (transactions.isEmpty()) {
        System.out.println("No transactions yet.");
        return;
    }

    for (String record : transactions) {
        System.out.println(record);
    }

}
public void showPerformanceSummary(HashMap<String, Stock> marketStocks) {

    double totalInvestment = 0;
    double totalCurrentValue = 0;

    for (String symbol : holdings.keySet()) {

        int quantity = holdings.get(symbol);
        double avgBuy = averageBuyPrice.get(symbol);
        double currentPrice = marketStocks.get(symbol).getPrice();

        totalInvestment += quantity * avgBuy;
        totalCurrentValue += quantity * currentPrice;
    }

    double profitLoss = totalCurrentValue - totalInvestment;
    double percent = totalInvestment == 0 ? 0 :
            (profitLoss / totalInvestment) * 100;

    double netWorth = totalCurrentValue + balance;

    System.out.println("\n===== PORTFOLIO SUMMARY =====");
    System.out.println("Total Invested: Rs." + totalInvestment);
    System.out.println("Current Value: Rs." + totalCurrentValue);
    System.out.println("Profit/Loss: Rs." + Math.round(profitLoss)
            + " (" + String.format("%.2f", percent) + "%)");
    System.out.println("Cash Balance: Rs." + balance);
    System.out.println("Total Net Worth: Rs." + netWorth);
} 
    public void saveToFile() {

    try (java.io.PrintWriter writer =
             new java.io.PrintWriter(FILE_NAME)) {

        writer.println("BALANCE=" + balance);

        for (String symbol : holdings.keySet()) {

            writer.println(symbol + "=" +
                    holdings.get(symbol) + "=" +
                    averageBuyPrice.get(symbol));
        }

    } catch (Exception e) {
        System.out.println("Error saving portfolio.");
    }
}
    public void loadFromFile() {

    try (java.io.BufferedReader reader =
             new java.io.BufferedReader(
                     new java.io.FileReader(FILE_NAME))) {

        String line;

        while ((line = reader.readLine()) != null) {

            if (line.startsWith("BALANCE=")) {
                balance = Double.parseDouble(
                        line.split("=")[1]);
            } else {

                String[] parts = line.split("=");

                String symbol = parts[0];
                int quantity = Integer.parseInt(parts[1]);
                double avgPrice =
                        Double.parseDouble(parts[2]);

                holdings.put(symbol, quantity);
                averageBuyPrice.put(symbol, avgPrice);
            }
        }

    } catch (Exception e) {
        // first run file may not exist
    }
}
    public void viewPortfolio(HashMap<String, Stock> marketStocks) {

    System.out.println("\n===== PORTFOLIO =====");

    double totalInvestment = 0;
    double totalCurrentValue = 0;

    for (String symbol : holdings.keySet()) {

        int quantity = holdings.get(symbol);
        double avgBuy = averageBuyPrice.get(symbol);
        double currentPrice = marketStocks.get(symbol).getPrice();

        double investment = quantity * avgBuy;
        double currentValue = quantity * currentPrice;
        double profitLoss = currentValue - investment;
	double profitPercent = (profitLoss / investment) * 100;

        totalInvestment += investment;
        totalCurrentValue += currentValue;

        System.out.println(symbol +
        " | Shares: " + quantity +
        " | Buy Avg: Rs." + avgBuy +
        " | Current: Rs." + currentPrice +
        " | P/L: Rs." + Math.round(profitLoss) +
        " (" + String.format("%.2f", profitPercent) + "%)");
    }

    System.out.println("Available Balance: Rs." + balance);

    System.out.println("\nTotal Investment: Rs." + totalInvestment);
    System.out.println("Total Current Value: Rs." + totalCurrentValue);
    double overallPL = totalCurrentValue - totalInvestment;
double overallPercent = (overallPL / totalInvestment) * 100;

System.out.println("Overall P/L: Rs." +
        Math.round(overallPL) +
        " (" + String.format("%.2f", overallPercent) + "%)");
}
}