import java.io.*;
import java.util.*;

public class CompareAllComponents {
    public static void main(String[] args) throws IOException {
        // StringBuilder
        long sbStart = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) sb.append("hello");
        long sbEnd = System.nanoTime();
        System.out.println("StringBuilder time: " + (sbEnd - sbStart) + " ns");

        // StringBuffer
        long sbfStart = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1_000_000; i++) sbf.append("hello");
        long sbfEnd = System.nanoTime();
        System.out.println("StringBuffer time: " + (sbfEnd - sbfStart) + " ns");

        // FileReader
        int wordCount = 0;
        long frStart = System.nanoTime();
        try (BufferedReader fr = new BufferedReader(new FileReader("largefile.txt"))) {
            String line;
            while ((line = fr.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        long frEnd = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount + ", Time: " + (frEnd - frStart) + " ns");

        // InputStreamReader
        wordCount = 0;
        long isrStart = System.nanoTime();
        try (BufferedReader isr = new BufferedReader(new InputStreamReader(new FileInputStream("largefile.txt")))) {
            String line;
            while ((line = isr.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        }
        long isrEnd = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount + ", Time: " + (isrEnd - isrStart) + " ns");
    }
}
