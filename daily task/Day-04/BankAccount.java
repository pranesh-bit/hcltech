import java.util.Objects;

public class BankAccount {

    // Static counter for auto-generating unique account numbers
    private static int accountCounter = 1000;

    // Encapsulated private attributes
    private final String accountNumber;
    private String holderName;
    private double balance;
    private String accountType;

    // Constructor Chaining: Overloaded constructor with default account type
    public BankAccount(String holderName, double initialDeposit) {
        this(holderName, initialDeposit, "Savings");
    }

    // Full Parameterized Constructor with Invariant Validation
    public BankAccount(String holderName, double initialDeposit, String accountType) {
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be blank.");
        }
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.accountNumber = "ACC-" + (++accountCounter);
        this.holderName = holderName.trim();
        this.balance = initialDeposit;
        this.accountType = accountType != null ? accountType : "Savings";
    }

    // Business Methods
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit failed: Amount must be strictly greater than zero.");
            return false;
        }
        this.balance += amount;
        System.out.printf("Deposited INR %.2f into %s. New Balance: INR %.2f\n", amount, accountNumber, balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal failed: Amount must be strictly positive.");
            return false;
        }
        if (amount > balance) {
            System.out.printf("Withdrawal failed: Insufficient funds in %s. Available: INR %.2f\n", accountNumber, balance);
            return false;
        }
        this.balance -= amount;
        System.out.printf("Withdrawn INR %.2f from %s. Remaining Balance: INR %.2f\n", amount, accountNumber, balance);
        return true;
    }

    // Encapsulated Accessor (Getter) Methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        if (holderName != null && !holderName.trim().isEmpty()) {
            this.holderName = holderName.trim();
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public static int getTotalAccountsCreated() {
        return accountCounter - 1000;
    }

    // Overriding equals and hashCode based on identity (accountNumber)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return String.format("BankAccount[No=%s, Holder='%s', Balance=INR %.2f, Type='%s']",
                accountNumber, holderName, balance, accountType);
    }

    // Main demonstration method
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       OOP CONCEPTS: BANK ACCOUNT (DAY 04)        ");
        System.out.println("==================================================");

        BankAccount acc1 = new BankAccount("Pranesh Raj", 50000.0, "Premium Savings");
        BankAccount acc2 = new BankAccount("Anita Sharma", 25000.0);

        System.out.println("Account 1 created: " + acc1);
        System.out.println("Account 2 created: " + acc2);

        System.out.println("\nExecuting transactions:");
        acc1.deposit(15000.0);
        acc1.withdraw(70000.0); // Should fail (insufficient funds)
        acc1.withdraw(20000.0); // Should succeed

        System.out.println("\nTotal Bank Accounts Created: " + BankAccount.getTotalAccountsCreated());
        System.out.println("Testing Equality (acc1.equals(acc2)): " + acc1.equals(acc2));
        System.out.println("==================================================");
    }
}
