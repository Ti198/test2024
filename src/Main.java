import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "text.txt";
        List<String> words = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {

                    String[] lineWords = line.split("\\+");


                    for (String word : lineWords) {
                        word = word.toLowerCase();
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(words);

        for (String word : words) {

        }

        List<String> sortedWords = new ArrayList<>(wordCount.keySet());
        Collections.sort(sortedWords);

        System.out.println("\n Вывод статистики");
        System.out.println("Слово\tЧастота");
        for (String word : sortedWords) {
            System.out.println(word + "\t" + wordCount.get(word));
        }
        int maxFrequency = 0;
        for (int frequency : wordCount.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }
        List<String> mostFrequentWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentWords.add(entry.getKey());
            }
        }
        System.out.println("Слово(а) с максимальной частотой: " + mostFrequentWords);

    }
}




