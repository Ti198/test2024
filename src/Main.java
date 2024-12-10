import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "text.txt";
        String outputFilePath = "newTex.txt";

        int vowelCount = 0;
        int consonantCount = 0;
        Pattern vowelPattern = Pattern.compile("[еёиоуыэюяEЁИОУЭЮЯ]");
        Pattern consonantPattern = Pattern.compile("[бвгджзйклнпрстфхцчшщъьБBГДЖЗИКЛНПРСТФХЦЧШЩ]");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
         BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
        StringBuilder modifiedLine = new StringBuilder();
        for (char ch : line.toCharArray()) {
            Matcher vowelMatcher = vowelPattern.matcher((Character.toString(ch)));
            Matcher consonantMatcher = consonantPattern.matcher (Character.toString(ch));

            if (vowelMatcher.matches()) {
                modifiedLine.append('а');
                vowelCount++;
            } else if (consonantMatcher.matches()) {
                modifiedLine.append('м');
                consonantCount++;
            } else {
                modifiedLine.append(ch);
            }
        }
        writer.write(modifiedLine.toString());
        writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Количество гласных:" +vowelCount);
        System.out.println("Количество согласных:" +consonantCount);
    }
}



