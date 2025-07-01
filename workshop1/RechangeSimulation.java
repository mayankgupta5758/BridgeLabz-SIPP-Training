import java.util.*;

public class RechangeSimulation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<String>> amt = new ArrayList<>();
        String[][] recharge = { { "Airtel", "99", "1GB/day" }, { "Airtel", "199", "1.5GB/day" },
                { "Airtel", "299", "2GB/day" }, { "Jio", "99", "1GB/day" }, { "Jio", "299", "1.5GB/day" },
                { "Jio", "299", "2GB/day" } };

        System.out.print("Emter Your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name + " Welcome To My Phone Recharge Portal...");
        System.out.println();

        while (true) {

            for (String[] i : recharge) {
                System.out.println("Service " + i[0] + " Price " + i[1] + " GB/day.");
            }

            System.out.print("Which Service Recharge You Want: ");
            String service = sc.nextLine();
            System.out.println();

            System.out.print("Which Recharge You Want At Price: ");
            String price = sc.nextLine();
            System.out.println();

            List<String> list = new ArrayList<>();
            list.add(name);
            list.add(service);

            int err = Integer.parseInt(price);
            if (amt.isEmpty()) {
                list.add(price);
            } else {
                String prevAmt = amt.get(amt.size() - 1).get(2);
                int prevAmt1 = Integer.parseInt(prevAmt) + err;
                list.add(String.valueOf(prevAmt1));
            }

            amt.add(new ArrayList<>(list));
            System.out.println("Your Recharge Successfully Done 😀😀.");

            for (int i = 0; i < amt.size(); i++) {
                System.out.println("Your name " + amt.get(i).get(0) + " Your Service " + amt.get(i).get(1)
                        + " And the Total Amount You Paid " + amt.get(i).get(2));
            }
            System.out.println();
            System.out.println("---------------------------------Welcome Again---------------------------------");
            System.out.println();
        }
    }
}
