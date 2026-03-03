import javax.swing.*;
import java.awt.*;

class ChatBotGUI {

    private ChatBotEngine bot = new ChatBotEngine();
    private JTextArea chatArea;
    private JTextField inputField;

    public ChatBotGUI() {

        JFrame frame = new JFrame("AI Chatbot");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel for input
        JPanel bottomPanel = new JPanel(new BorderLayout());

        inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Send button action
        sendButton.addActionListener(e -> sendMessage());

        // Press Enter to send
        inputField.addActionListener(e -> sendMessage());

        frame.setVisible(true);
    }

    private void sendMessage() {

        String userInput = inputField.getText().trim();

        if (userInput.isEmpty()) return;

        chatArea.append("You: " + userInput + "\n");

        chatArea.append("Bot: typing...\n");

Timer timer = new Timer(800, e -> {
    String response = bot.getResponse(userInput);
    chatArea.append("\rBot: " + response + "\n\n");
    chatArea.setCaretPosition(chatArea.getDocument().getLength());
});
timer.setRepeats(false);
timer.start();
        
        inputField.setText("");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}