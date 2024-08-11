package Task3;
import java.util.Scanner;

//Class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public boolean deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         return true;
     }
     return false;
 }

 public boolean withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         return true;
     }
     return false;
 }
}

//Class to represent the ATM machine
class ATM {
 private BankAccount account;
 private Scanner scanner;

 public ATM(BankAccount account) {
     this.account = account;
     this.scanner = new Scanner(System.in);
 }

 public void displayMenu() {
     while (true) {
         System.out.println("\nATM Menu:");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.print("Select an option (1-4): ");
         int option = scanner.nextInt();

         switch (option) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 withdraw();
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 return;
             default:
                 System.out.println("Invalid option. Please choose between 1 and 4.");
         }
     }
 }

 private void checkBalance() {
     System.out.println("Current Balance: $" + account.getBalance());
 }

 private void deposit() {
     System.out.print("Enter the amount to deposit: $");
     double amount = scanner.nextDouble();
     if (account.deposit(amount)) {
         System.out.println("Successfully deposited $" + amount);
     } else {
         System.out.println("Deposit failed. Please enter a valid amount.");
     }
 }

 private void withdraw() {
     System.out.print("Enter the amount to withdraw: $");
     double amount = scanner.nextDouble();
     if (account.withdraw(amount)) {
         System.out.println("Successfully withdrew $" + amount);
     } else {
         System.out.println("Withdrawal failed. Please check if you have sufficient balance or enter a valid amount.");
     }
 }
}

public class ATMSystem {
	public static void main(String[] args) {
		// Initialize the bank account with an initial balance
        BankAccount account = new BankAccount(1000.00); // Starting with $1000
        // Initialize the ATM with the user's bank account
        ATM atm = new ATM(account);
        // Display the ATM menu
        atm.displayMenu();
    }
}
