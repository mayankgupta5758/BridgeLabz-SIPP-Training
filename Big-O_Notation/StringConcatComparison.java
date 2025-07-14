public class StringConcatComparison {
    public static void main(String[] args) {
        int count = 100000;

        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < count; i++) s += "a";
        long end = System.nanoTime();
        System.out.println("String: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) sb.append("a");
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < count; i++) sbuf.append("a");
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1_000_000.0 + " ms");
    }
}
