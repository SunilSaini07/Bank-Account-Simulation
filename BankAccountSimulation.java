import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSimulation {
    static class Account {
        private String accountHolder;
        private String accountNumber;
        private double balance;
        private ArrayList<String> transactionHistory;

        public Account(String accountHolder, String accountNumber, double initialBalance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
            this.transactionHistory = new ArrayList<>();
            transactionHistory.add("Account created with balance : " + initialBalance);
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add(" Deposited: " + amount + " | Balance: " + balance);
                System.out.println("Deposit successful");
            } else {
                System.out.println("Invalid deposit amount");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add(" Withdraw: " + amount + " | Balance: " + balance);
                System.out.println("Withdrawal successful");
            } else {
                System.out.println("Insufficient balance ");
            }
        }

        public void showBalance() {
            System.out.println("Current Balance : " + balance);
        }

        public void showTransactionHistory() {
            System.out.println("\n--- Transaction History ---");
            for (String record : transactionHistory) {
                System.out.println(record);
            }
        }

        public void showAccountDetails() {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bank Account Simulation");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter Initial Deposit Amount: ");
        double initialBalance = sc.nextDouble();

        Account account = new Account(name, accNum, initialBalance); 

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.showBalance();
                    break;

                case 4:
                    account.showTransactionHistory();
                    break;

                case 5:
                    account.showAccountDetails();
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Account Simulation");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
