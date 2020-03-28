import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Biggram {
    public static void main(String[] args) {
        Scanner scanner = null;
        Map<String, Integer> frequency = new LinkedHashMap<String, Integer>();

        try {
            scanner = new Scanner(new File("test-folder/test.txt"));

            String content = "";
            while (scanner.hasNextLine()) {
                content += scanner.nextLine();
            }

            String array[] = content.split(" ");

            // iterate through the words
            for (int i = 0; i < array.length - 1; i++) {
                String word1 = array[i].toLowerCase().replaceAll("[^a-zA-Z]+", "");
                String word2 = array[i + 1].toLowerCase().replaceAll("[^a-zA-Z]+", "");
                String word = word1 + " " + word2;
                if (frequency.containsKey(word)) {

                    // only need to bump up the count
                    Integer j = frequency.get(word);
                    frequency.put(word, j + 1);
                } else {
                    // insert a new binding
                    frequency.put(word, 1);
                }
            }

            // iterate through the key-value bindings, printing them out
            for (Map.Entry<String, Integer> kv : frequency.entrySet()) {
                System.out.printf("\"%s\" %d\n", kv.getKey(), kv.getValue().intValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

