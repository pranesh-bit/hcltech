import java.util.Scanner;

public class AtmSimulator {

    private static final int CORRECT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("          SECURE ATM SIMULATOR (DAY 03)           ");
        System.out.println("==================================================");

        // 1. PIN Authentication with retry limit using while loop
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your 4-digit ATM PIN (Default demo PIN: 1234): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! PIN must be a 4-digit number.");
                scanner.next(); // Consume invalid token
                attempts++;
                continue;
            }

            int enteredPin = scanner.nextInt();
            attempts++;

            if (enteredPin == CORRECT_PIN) {
                authenticated = true;
                System.out.println("Authentication Successful!\n");
                break;
            } else {
                int remaining = MAX_ATTEMPTS - attempts;
                System.out.printf("Incorrect PIN. Attempts remaining: %d\n", remaining);
            }
        }

        if (!authenticated) {
            System.out.println("ALERT: Maximum attempts exceeded. Your card has been temporarily locked.");
            return;
        }

        // 2. Transaction Menu driven by do-while and switch
        double balance = 25000.00;
        String[] miniStatement = new String[5];
        int txCount = 0;

        int choice = 0;
        do {
            System.out.println("\n----------------- MAIN MENU -----------------");
            System.out.println("1. Check Account Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. View Mini-Statement");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid selection! Please enter an integer between 1 and 5.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current Available Balance: INR %.2f\n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: INR ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Error: Deposit amount must be positive.");
                        break;
                    }
                    balance += depositAmount;
                    miniStatement[txCount % 5] = String.format("CR: +INR %.2f | Bal: INR %.2f", depositAmount, balance);
                    txCount++;
                    System.out.printf("Success! INR %.2f deposited. New Balance: INR %.2f\n", depositAmount, balance);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: INR ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Error: Withdrawal amount must be positive.");
                        break;
                    }
                    if (withdrawAmount > balance) {
                        System.out.printf("Declined: Insufficient balance. Available: INR %.2f\n", balance);
                        break;
                    }
                    balance -= withdrawAmount;
                    miniStatement[txCount % 5] = String.format("DR: -INR %.2f | Bal: INR %.2f", withdrawAmount, balance);
                    txCount++;
                    System.out.printf("Success! Please collect INR %.2f. Remaining Balance: INR %.2f\n", withdrawAmount, balance);
                    break;

                case 4:
                    System.out.println("\n--- Recent Transactions (Mini-Statement) ---");
                    if (txCount == 0) {
                        System.out.println("No transactions recorded during this session.");
                    } else {
                        int entriesToShow = Math.min(txCount, 5);
                        for (int i = 0; i < entriesToShow; i++) {
                            if (miniStatement[i] != null) {
                                System.out.println("[" + (i + 1) + "] " + miniStatement[i]);
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our ATM service. Please remove your card.");
                    break;

                default:
                    System.out.println("Invalid option! Please select between 1 and 5.");
            }

        } while (choice != 5);
    }
}
