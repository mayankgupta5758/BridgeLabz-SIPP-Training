import java.io.*;

public class CountWordOccurrencesInFile {
    public static void main(String[] args) {
        String target = "Java";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    if (word.equalsIgnoreCase(target)) count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Occurrences of '" + target + "': " + count);
    }
}
