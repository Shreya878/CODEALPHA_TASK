import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {
        // Initialize the stock market (optional if you want pre-populated stocks)
        Stock.initializeMarket();

        // Create a user
        User user = new User("Alice", 10000.0); // $10,000 balance for testing
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. Display Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    Stock.displayMarket();
                    break;
                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    user.buyStock(buySymbol, buyQuantity);
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    user.sellStock(sellSymbol, sellQuantity);
                    break;
                case 4:
                    user.viewPortfolio();
                    break;
                case 5:
                    System.out.println("Thank you for using the Stock Trading Platform!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);

        scanner.close();
    }
}
