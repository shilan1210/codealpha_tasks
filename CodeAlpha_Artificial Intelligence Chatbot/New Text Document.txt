import java.util.Scanner;

public class ChatBotMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChatBotEngine bot = new ChatBotEngine();

        System.out.println("===== AI Chatbot Started =====");
        System.out.println("Type 'exit' to stop.\n");

        while (true) {

            System.out.print("You: ");
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Bot: Goodbye!");
                break;
            }

            String response = bot.getResponse(userInput);
            System.out.println("Bot: " + response);
        }

        sc.close();
    }
}