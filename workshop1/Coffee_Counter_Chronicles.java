import java.util.*;

public class Coffee_Counter_Chronicles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("welcome To My Coffee Shop 🫰🏻🫰🏻");

        System.out.println("----------------------------------------------------------------------------------------");
        String[][] coffees = {
                { "1 -->", "Espresso", "120" },
                { "2 -->", "Cappuccino", "150" },
                { "3 -->", "Latte", "160" },
                { "4 -->", "Americano", "130" },
                { "5 -->", "Mocha", "170" },
                { "6 -->", "Macchiato", "140" },
                { "7 -->", "For exit", "0" }
        };

        System.out.println("Coffee Menu:");
        for (String[] coffee : coffees) {
            System.out.println(coffee[0] + " " + coffee[1] + " - For Rs " + coffee[2]);
        }

        System.out.print("Do You Want To Buy Coffee. Enter 1 If You Want. Enter 0 To Exit...   ");
        int num = sc.nextInt();
        if (num != 1) {
            System.out.println("Why You Come Then.");
            return;
        }

        double price = 0.0;
        double gstRate = 10.0;
        int quantity;

        while (true) {

            System.out.print("Please Type Coffee Number That You Want 😋😋😋  ");
            int coffeeType = sc.nextInt();
            System.out.println();

            switch (coffeeType) {
                case 1 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Espresso And It's Price is 120$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                case 2 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Cappuccino And It's Price is 150$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                case 3 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Latte And It's Price is 160$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                case 4 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Americano And It's Price is 130$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                case 5 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Mocha And It's Price is 170$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                case 6 -> {
                    System.out.print("Enter The Quantity of Coffee: ");
                    quantity = sc.nextInt();
                    System.out.println();
                    System.out.println("You Order Macchiato And It's Price is 160$");
                    price += quantity * Integer.parseInt(coffees[0][2]);
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                }
                default -> {
                    double gstAmount = (price * gstRate) / 100;
                    double totalPrice = price + gstAmount;
                    System.out.println("Your Total Amount is: " + price + " And With GST Total Price is: " + totalPrice);
                    return;
                }
            }

            System.out.println(
                    "----------------------------------------------Welcome Again !!!------------------------------------------");
        }
    }
}