
// ATMInterface.java - Handles user interactions with the ATM
import java.util.Scanner;

public class ATMInterface {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATMInterface(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Balance: ₹" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000); // Initial balance ₹5000
        ATMInterface atm = new ATMInterface(account);
        atm.start();
    }
}
