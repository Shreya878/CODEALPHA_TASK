import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatbotGUI {

    private JTextArea textArea;
    private JTextField textField;
    private JButton sendButton;

    public ChatbotGUI() {
        JFrame frame = new JFrame("Chatbot");
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER); 
        frame.add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private void sendMessage() {
        String message = textField.getText().trim();

        if (!message.isEmpty()) {
            textArea.append("You: " + message + "\n");

            String response = getResponse(message);

            textArea.append("Bot: " + response + "\n");

            textField.setText("");
        }
    }

    private String getResponse(String message) {
        if (message.equalsIgnoreCase("hello")) {
            return "Hi there! How can I help you today?";
        } else if (message.equalsIgnoreCase("how are you?")) {
            return "I'm just a bot, but I'm doing fine. How about you?";
        } else if (message.equalsIgnoreCase("bye")) {
            return "Goodbye! Have a great day!";
        } else {
            return "Sorry, I didn't understand that.";
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatbotGUI();
            }
        });
    }
}
