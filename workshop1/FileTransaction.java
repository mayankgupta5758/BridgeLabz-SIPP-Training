import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class FileTransaction {
    static int sum = 0;
    static int max = 0;

    public static void main(String[] args) {

        Path filePath = Path.of("transactions.txt");

        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> {
                try {
                    int amount = Integer.parseInt(line.trim());
                    System.out.println("Transaction: " + amount);
                    sum += amount;
                    max = Math.max(max, amount);
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " is not valid.");
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage() + " is not exist.");
        }

        if (sum != 0) {
            System.out.println("Sum of Transactions: " + sum);
            System.out.println("Max Transaction: " + max);
        }
    }
}
