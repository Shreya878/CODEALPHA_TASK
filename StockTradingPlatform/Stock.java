import java.util.HashMap;
import java.util.Map;

public class Stock {
    private String symbol;
    private String name;
    private double price;

    // Static map to hold all stocks
    public static Map<String, Stock> stocks = new HashMap<>();

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Static method to initialize stock market (can be called in main or wherever
    // needed)
    public static void initializeMarket() {
        stocks.put("AAPL", new Stock("AAPL", "Apple Inc.", 150.0));
        stocks.put("GOOG", new Stock("GOOG", "Google Inc.", 2800.0));
        stocks.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3500.0));
        stocks.put("TSLA", new Stock("TSLA", "Tesla Inc.", 750.0));
    }

    public static Stock getStockBySymbol(String symbol) {
        return stocks.get(symbol);
    }

    public static void displayMarket() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getSymbol() + " (" + stock.getName() + "): $" + stock.getPrice());
        }
    }
}
