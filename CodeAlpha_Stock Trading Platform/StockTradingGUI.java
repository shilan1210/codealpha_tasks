import javax.swing.*;
import java.awt.*;

public class StockTradingGUI {

    private StockMarket market = new StockMarket();
    private User currentUser;
    private Portfolio portfolio;

    private JTextArea outputArea;
    private JTextField symbolField;
    private JTextField quantityField;
    
    public StockTradingGUI() {

    String username = JOptionPane.showInputDialog(
            null,
            "Enter Username:",
            "Login",
            JOptionPane.PLAIN_MESSAGE
    );

    if (username == null || username.trim().isEmpty()) {
        System.exit(0);
    }

    currentUser = new User(username.trim());
    portfolio = currentUser.getPortfolio();
        JFrame frame = new JFrame("Stock Trading Platform - User: " + currentUser.getUsername());
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Output Area
        outputArea = new JTextArea();
outputArea.setEditable(false);

outputArea.append("Welcome, " + currentUser.getUsername() + "!\n\n");

JScrollPane scrollPane = new JScrollPane(outputArea);
frame.add(scrollPane, BorderLayout.CENTER);

        // Top Buttons Panel
        JPanel topPanel = new JPanel(new FlowLayout());

        JButton viewMarketBtn = new JButton("View Market");
        JButton updateMarketBtn = new JButton("Update Market");
        JButton viewPortfolioBtn = new JButton("View Portfolio");
        JButton summaryBtn = new JButton("Portfolio Summary");

        topPanel.add(viewMarketBtn);
        topPanel.add(updateMarketBtn);
        topPanel.add(viewPortfolioBtn);
        topPanel.add(summaryBtn);

        frame.add(topPanel, BorderLayout.NORTH);

        // Bottom Panel (Buy/Sell)
        JPanel bottomPanel = new JPanel(new FlowLayout());

        symbolField = new JTextField(8);
        quantityField = new JTextField(5);

        JButton buyBtn = new JButton("Buy");
        JButton sellBtn = new JButton("Sell");

        bottomPanel.add(new JLabel("Symbol:"));
        bottomPanel.add(symbolField);
        bottomPanel.add(new JLabel("Quantity:"));
        bottomPanel.add(quantityField);
        bottomPanel.add(buyBtn);
        bottomPanel.add(sellBtn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions

        viewMarketBtn.addActionListener(e -> {
            outputArea.setText("");
            market.displayStocks();
            outputArea.append(getMarketText());
        });

        updateMarketBtn.addActionListener(e -> {
            market.updateMarketPrices();
            outputArea.append("\nMarket updated.\n");
        });

        viewPortfolioBtn.addActionListener(e -> {
            outputArea.setText("");
            portfolio.viewPortfolio(market.getAllStocks());
            outputArea.append(getPortfolioText());
        });

        summaryBtn.addActionListener(e -> {
            outputArea.setText("");
            portfolio.showPerformanceSummary(market.getAllStocks());
            outputArea.append(getSummaryText());
        });

        buyBtn.addActionListener(e -> handleBuy());
        sellBtn.addActionListener(e -> handleSell());

        frame.setVisible(true);
    }

    private void handleBuy() {
        try {
            String symbol = symbolField.getText().toUpperCase();
            int qty = Integer.parseInt(quantityField.getText());

            Stock stock = market.getStock(symbol);

            if (stock != null) {
                portfolio.buyStock(stock, qty);
                outputArea.append("Bought " + qty + " " + symbol + "\n");
            } else {
                outputArea.append("Invalid stock symbol!\n");
            }

        } catch (Exception ex) {
            outputArea.append("Invalid input!\n");
        }
    }

    private void handleSell() {
        try {
            String symbol = symbolField.getText().toUpperCase();
            int qty = Integer.parseInt(quantityField.getText());

            Stock stock = market.getStock(symbol);

            if (stock != null) {
                portfolio.sellStock(stock, qty);
                outputArea.append("Sold " + qty + " " + symbol + "\n");
            } else {
                outputArea.append("Invalid stock symbol!\n");
            }

        } catch (Exception ex) {
            outputArea.append("Invalid input!\n");
        }
    }

    private String getMarketText() {
        StringBuilder sb = new StringBuilder();
        for (Stock stock : market.getAllStocks().values()) {
            sb.append(stock.toString()).append("\n");
        }
        return sb.toString();
    }

    private String getPortfolioText() {
        return "Portfolio updated. Check console for detailed breakdown.\n";
    }

    private String getSummaryText() {
        return "Summary displayed in console.\n";
    }

    public static void main(String[] args) {
        new StockTradingGUI();
    }
}