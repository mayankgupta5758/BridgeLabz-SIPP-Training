public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int n = 1_000_000;

        long start1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append("hello");
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) sbf.append("hello");
        long end2 = System.nanoTime();

        System.out.println("StringBuilder Time: " + (end1 - start1) + " ns");
        System.out.println("StringBuffer Time: " + (end2 - start2) + " ns");
    }
}
