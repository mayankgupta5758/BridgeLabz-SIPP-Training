import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File input = new File("largefile.dat");
        File outputBuffered = new File("copy_buffered.dat");
        File outputUnbuffered = new File("copy_unbuffered.dat");

        try {
            long startBuffered = System.nanoTime();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputBuffered))) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
            long endBuffered = System.nanoTime();
            System.out.println("Buffered copy time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

            long startUnbuffered = System.nanoTime();
            try (FileInputStream fis = new FileInputStream(input);
                 FileOutputStream fos = new FileOutputStream(outputUnbuffered)) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            long endUnbuffered = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
