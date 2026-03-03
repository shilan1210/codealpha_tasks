import java.io.*;
import java.util.HashMap;

public class FAQLoader {

    public static HashMap<String, String> loadFAQs(String fileName) {

        HashMap<String, String> faqMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    faqMap.put(parts[0].toLowerCase().trim(),
                               parts[1].trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading FAQ file.");
        }

        return faqMap;
    }
}