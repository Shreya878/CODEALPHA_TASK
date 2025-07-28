import java.util.HashMap;
import java.util.Map;

public class User {
    private String name; // Declaring name variable (should not give an error)
    private double balance;
    private Map<String, Integer> portfolio; // Maps stock symbols to quantities owned

    // Constructor to initialize user data
    public User(String name, double balance) {
        this.name = name; // Assigning the name parameter to the class's name variable
        this.balance = balance;
        this.portfolio = new HashMap<>();
    }

    // Getter for the name variable
    public String getName() {
        return name;
    }

    // Getter for the balance variable
    public double getBalance() {
        return balance;
    }

    // Getter for the portfolio
    public Map<String, Integer> getPortfolio() {
        return portfolio;
    }

    // Method to buy stock
    public void buyStock(String symbol, int quantity) {
        // Assuming you have a method to get stock by symbol
        Stock stock = Stock.getStockBySymbol(symbol);
        if (stock != null) {
            double totalCost = stock.getPrice() * quantity;
            if (balance >= totalCost) {
                balance -= totalCost;
                portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);
                System.out.println("Purchased " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Insufficient funds to buy " + quantity + " shares.");
            }
        } else {
            System.out.println("Stock not found: " + symbol);
        }
    }

    // Method to sell stock
    public void sellStock(String symbol, int quantity) {
        Stock stock = Stock.getStockBySymbol(symbol);
        if (stock != null) {
            int ownedQuantity = portfolio.getOrDefault(symbol, 0);
            if (ownedQuantity >= quantity) {
                double totalRevenue = stock.getPrice() * quantity;
                balance += totalRevenue;
                portfolio.put(symbol, ownedQuantity - quantity);
                System.out.println("Sold " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Not enough shares to sell.");
            }
        } else {
            System.out.println("Stock not found: " + symbol);
        }
    }

    // Method to view the portfolio
    public void viewPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            Stock stock = Stock.getStockBySymbol(entry.getKey());
            System.out.println(stock.getName() + " (" + stock.getSymbol() + "): " + entry.getValue() + " shares");
        }
        System.out.println("Balance: $" + balance);
    }
}