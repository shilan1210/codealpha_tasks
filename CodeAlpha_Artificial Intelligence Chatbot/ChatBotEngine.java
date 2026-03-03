import java.util.HashMap;

public class ChatBotEngine {

    private HashMap<String, String> faqResponses;
    private String userName = null;

    public ChatBotEngine() {
        faqResponses = FAQLoader.loadFAQs("faq.txt");
    }

    public String getResponse(String input) {

    input = input.toLowerCase().trim();

    // Name memory
    if (input.startsWith("my name is")) {
        userName = input.replace("my name is", "").trim();
        return "Nice to meet you, " + userName + "!";
    }

    if (input.contains("what is my name")) {
        if (userName != null)
            return "Your name is " + userName + ".";
        else
            return "I don't know your name yet.";
    }

    // Exact FAQ match
    String cleanedInput = input.replaceAll("[^a-zA-Z0-9 ]", "").trim();

    if (faqResponses.containsKey(cleanedInput)) {
    return faqResponses.get(cleanedInput) + " (Confidence: 100%)";
}

    // Greetings
    if (input.matches(".*(hello|hi|hey).*")) {
        return "Hello! How can I assist you today?";
    }

    if (input.matches(".*(bye|goodbye).*")) {
        return "Goodbye! Have a great day!";
    }
    if (input.contains("sorry")) {
    return "No worries 🙂 How can I assist you?";
}

if (input.contains("who are you")) {
    return "I am a Java-based AI chatbot built using rule-based NLP techniques.";
}

    return "I don't have an answer for that yet. You can ask about topics like Java, AI, or chatbot.";
}
}