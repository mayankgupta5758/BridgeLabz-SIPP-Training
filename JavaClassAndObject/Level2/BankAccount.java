public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String holder, String number, double balance) {
        this.accountHolder = holder;
        this.accountNumber = number;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Mayank", "ACC12345", 1000);
        acc.deposit(500);
        acc.withdraw(300);
        acc.displayBalance();
    }
}
