public class ConcatenateStringsUsingStringBuffer {
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Java", "is", "fun"};
        System.out.println(concatenate(arr)); // Output: Javaisfun
    }
}
