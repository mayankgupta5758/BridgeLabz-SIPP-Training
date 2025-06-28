
public class CountNumberOfChar {
    public static void main(String[] args) {
        
        String a = "mayan@12k";
        int count = 0;
        for(char i: a.toCharArray()) {
            if(i >= 'a' && i <= 'z') {
                count++;
            }
        }
        System.out.println(count);
    }
}
