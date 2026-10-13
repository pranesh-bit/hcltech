// 1. Custom Checked Exception (Subclass of Exception)
class InsufficientStockException extends Exception {
    private final String itemCode;
    private final int requested;
    private final int available;

    public InsufficientStockException(String itemCode, int requested, int available) {
        super(String.format("Stock shortage for '%s': Requested %d units, but only %d available.",
                itemCode, requested, available));
        this.itemCode = itemCode;
        this.requested = requested;
        this.available = available;
    }

    public String getItemCode() { return itemCode; }
    public int getRequested() { return requested; }
    public int getAvailable() { return available; }
}

// 2. Custom Unchecked Exception (Subclass of RuntimeException)
class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

// 3. Higher-Level Domain Exception with Exception Chaining
class OrderProcessingException extends Exception {
    public OrderProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

// 4. Order Processor Class
public class OrderProcessor {

    private static int availableStock = 15;

    public static void fulfillOrder(String orderId, String itemCode, int quantity) throws OrderProcessingException {
        System.out.println("\n[OrderProcessor] Initiating fulfillment for Order: " + orderId);

        try {
            // Unchecked exception validation
            if (quantity <= 0) {
                throw new InvalidQuantityException("Requested quantity (" + quantity + ") must be greater than zero.");
            }

            // Checked exception validation
            if (quantity > availableStock) {
                throw new InsufficientStockException(itemCode, quantity, availableStock);
            }

            // Successful fulfillment
            availableStock -= quantity;
            System.out.printf(">> SUCCESS: %d units of %s reserved for Order %s. Remaining Stock: %d\n",
                    quantity, itemCode, orderId, availableStock);

        } catch (InsufficientStockException | InvalidQuantityException ex) {
            // Log root cause and chain into domain exception
            System.err.println(">> Business Error Captured: " + ex.getMessage());
            throw new OrderProcessingException("Order fulfillment aborted for Order ID: " + orderId, ex);

        } finally {
            // Audit block executed regardless of outcome
            System.out.println("[Audit Log] Order attempt completed at " + java.time.LocalDateTime.now() +
                    " | Current Inventory Balance: " + availableStock);
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     EXCEPTION HANDLING & ORDER PROCESSOR (DAY 06)");
        System.out.println("==================================================");

        // Scenario 1: Successful Order
        try {
            fulfillOrder("ORD-201", "MED-KIT-01", 5);
        } catch (OrderProcessingException e) {
            System.err.println("Handled: " + e.getMessage());
        }

        // Scenario 2: Unchecked Exception (Invalid Quantity <= 0)
        try {
            fulfillOrder("ORD-202", "MED-KIT-01", -2);
        } catch (OrderProcessingException e) {
            System.out.println("Caught Expected Chained Domain Error:");
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Root Cause: " + e.getCause().getClass().getSimpleName() + " -> " + e.getCause().getMessage());
        }

        // Scenario 3: Checked Exception (Insufficient Stock)
        try {
            fulfillOrder("ORD-203", "MED-KIT-01", 20); // Only 10 remaining
        } catch (OrderProcessingException e) {
            System.out.println("Caught Expected Chained Domain Error:");
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   Root Cause: " + e.getCause().getClass().getSimpleName() + " -> " + e.getCause().getMessage());
        }

        System.out.println("\nAll scenarios processed safely without application crash.");
        System.out.println("==================================================");
    }
}
