import java.util.HashMap;
import java.util.Random;

public class StockMarket {

    private HashMap<String, Stock> stocks;
    private Random random;

    public StockMarket() {

        stocks = new HashMap<>();
        random = new Random();

        // Sample stocks
        stocks.put("TCS", new Stock("TCS", 3500));
        stocks.put("INFY", new Stock("INFY", 1500));
        stocks.put("RELIANCE", new Stock("RELIANCE", 2500));
        stocks.put("HDFC", new Stock("HDFC", 1700));
    }

    public void displayStocks() {

        System.out.println("\n===== MARKET STOCKS =====");

        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol.toUpperCase());
    }

    public HashMap<String, Stock> getAllStocks() {
        return stocks;
    }

    public void updateMarketPrices() {

        for (Stock stock : stocks.values()) {

            double changePercent = (random.nextDouble() * 4) - 2; 
            // -2% to +2% fluctuation

            double newPrice = stock.getPrice() * (1 + changePercent / 100);

            stock.updatePrice(Math.round(newPrice));
        }

        System.out.println("Market prices updated.");
    }
}