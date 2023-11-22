/* 1.Create a class to represent the ATM machine.

2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.

3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().

4. Create a class to represent the user's bank account, which stores the account balance.

5. Connect the ATM class with the user's bank account class to access and modify the account
balance.

6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).

7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions. */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ATM atm = new ATM();
        int choice = 0;
        while (choice != 4) {
            System.out.println("-----* Operations *-----");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your option : ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw : ");
                    double withdrawAmount = input.nextDouble();
                    if (atm.withDraw(withdrawAmount)) {
                        System.out.println("withdrawal Successfully completed");
                    } else {
                        System.out.println("Not efficient balance ! ");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to deposit : ");
                    double depositAmount = input.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you!!");
                    break;
                default:
                    System.out.println("Please Enter the Correct option ! ");
                    break;
            }
        }
    }
}