import java.util.Scanner;

public class Chatbot {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Welcome to the Chatbot!");
        System.out.println("Ask me anything.");

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine();
            
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            
            if (userInput.contains("hello")) {
                System.out.println("Chatbot: Hi there!");
            } else if (userInput.contains("how are you")) {
                System.out.println("Chatbot: I'm just a program, but thanks for asking!");
            } else {
                System.out.println("Chatbot: Sorry, I don't understand that.");
            }
        }

        scanner.close();
    }
}
