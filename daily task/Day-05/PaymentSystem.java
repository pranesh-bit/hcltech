import java.time.LocalDateTime;

// 1. Interface defining contract for refundable payments
interface Refundable {
    boolean refund(double refundAmount);
}

// 2. Abstract Superclass encapsulating shared attributes and behavior
abstract class Payment {
    protected final String transactionId;
    protected final double amount;
    protected final LocalDateTime timestamp;
    protected boolean successful;

    public Payment(String transactionId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero.");
        }
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.successful = false;
    }

    // Abstract method to be overridden polymorphically by subclasses
    public abstract boolean processPayment();

    // Method Overloading: Process payment with promo code discount
    public boolean processPayment(double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            System.out.println("Invalid discount percentage.");
            return false;
        }
        double discountedAmount = amount * (1.0 - (discountPercentage / 100.0));
        System.out.printf("Applying %.1f%% discount. Final amount: INR %.2f\n", discountPercentage, discountedAmount);
        return processPayment();
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public boolean isSuccessful() { return successful; }
}

// 3. Concrete Subclass 1: Card Payment
class CardPayment extends Payment implements Refundable {
    private final String maskedCardNumber;
    private final String cardType;

    public CardPayment(String txId, double amount, String rawCardNumber, String cardType) {
        super(txId, amount);
        this.maskedCardNumber = "XXXX-XXXX-XXXX-" + rawCardNumber.substring(rawCardNumber.length() - 4);
        this.cardType = cardType;
    }

    @Override
    public boolean processPayment() {
        System.out.printf("[Card Gateway] Charging INR %.2f to %s card ending in %s...\n",
                amount, cardType, maskedCardNumber.substring(maskedCardNumber.length() - 4));
        this.successful = true;
        System.out.println(">> Card Payment Successful. Auth Code: AUTH-" + (System.currentTimeMillis() % 100000));
        return true;
    }

    @Override
    public boolean refund(double refundAmount) {
        if (!successful || refundAmount > amount) {
            System.out.println("Refund rejected: Invalid amount or payment not settled.");
            return false;
        }
        System.out.printf(">> Refund of INR %.2f credited back to card %s.\n", refundAmount, maskedCardNumber);
        return true;
    }
}

// 4. Concrete Subclass 2: UPI Payment
class UPIPayment extends Payment implements Refundable {
    private final String upiId;

    public UPIPayment(String txId, double amount, String upiId) {
        super(txId, amount);
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment() {
        System.out.printf("[UPI Switch] Requesting INR %.2f from Virtual Payment Address: %s...\n", amount, upiId);
        this.successful = true;
        System.out.println(">> UPI Payment Approved via NPCI. Reference: UPI-" + (System.currentTimeMillis() % 100000));
        return true;
    }

    @Override
    public boolean refund(double refundAmount) {
        if (!successful || refundAmount > amount) {
            System.out.println("UPI Refund declined.");
            return false;
        }
        System.out.printf(">> Instant UPI refund of INR %.2f initiated to %s.\n", refundAmount, upiId);
        return true;
    }
}

// 5. Concrete Subclass 3: Cash Payment
class CashPayment extends Payment {
    private final String collectionCounter;

    public CashPayment(String txId, double amount, String collectionCounter) {
        super(txId, amount);
        this.collectionCounter = collectionCounter;
    }

    @Override
    public boolean processPayment() {
        System.out.printf("[Cash Desk] Received INR %.2f physical cash at counter %s. Cash receipt generated.\n",
                amount, collectionCounter);
        this.successful = true;
        return true;
    }
}

// Driver Class demonstrating Runtime Polymorphism
public class PaymentSystem {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   POLYMORPHIC PAYMENT PROCESSING SYSTEM (DAY 05) ");
        System.out.println("==================================================");

        // Polymorphic array holding different subtypes under the superclass reference
        Payment[] paymentQueue = {
            new CardPayment("TXN-101", 12500.0, "4111222233334567", "Visa"),
            new UPIPayment("TXN-102", 4800.0, "pranesh@okhdfcbank"),
            new CashPayment("TXN-103", 2500.0, "Counter-03")
        };

        System.out.println("Processing Payments via Runtime Dynamic Dispatch:\n");
        for (Payment p : paymentQueue) {
            System.out.println("--------------------------------------------------");
            System.out.println("Transaction ID: " + p.getTransactionId());
            p.processPayment(); // Dynamically dispatches to CardPayment, UPIPayment, or CashPayment
        }

        System.out.println("\nTesting Method Overloading with Discount:");
        Payment promoPayment = new CardPayment("TXN-104", 10000.0, "5200111122228899", "Mastercard");
        promoPayment.processPayment(10.0); // 10% discount

        System.out.println("\nTesting Interface Implementation (Refundable):");
        if (paymentQueue[0] instanceof Refundable ref) {
            ref.refund(2500.0);
        }
        System.out.println("==================================================");
    }
}
