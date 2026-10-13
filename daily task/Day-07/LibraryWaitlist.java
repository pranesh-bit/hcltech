import java.util.*;

// Class representing a priority reservation request
class ReservationRequest implements Comparable<ReservationRequest> {
    private final String memberName;
    private final int priorityScore; // 1 = High (Faculty), 2 = Medium (Research), 3 = Low (Student)
    private final String bookTitle;

    public ReservationRequest(String memberName, int priorityScore, String bookTitle) {
        this.memberName = memberName;
        this.priorityScore = priorityScore;
        this.bookTitle = bookTitle;
    }

    public String getMemberName() { return memberName; }
    public int getPriorityScore() { return priorityScore; }
    public String getBookTitle() { return bookTitle; }

    @Override
    public int compareTo(ReservationRequest other) {
        return Integer.compare(this.priorityScore, other.priorityScore); // Lower value = Higher priority
    }

    @Override
    public String toString() {
        String role = priorityScore == 1 ? "Faculty" : priorityScore == 2 ? "Research Scholar" : "Undergrad";
        return String.format("[%s (Score: %d) - %s]", memberName, priorityScore, role);
    }
}

public class LibraryWaitlist {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      COLLECTIONS FRAMEWORK: LIBRARY (DAY 07)     ");
        System.out.println("==================================================");

        // 1. LIST (ArrayList): Fast index-based book catalog access
        List<String> bookCatalog = new ArrayList<>();
        bookCatalog.add("Java: The Complete Reference");
        bookCatalog.add("Effective Java (Joshua Bloch)");
        bookCatalog.add("Clean Code (Robert C. Martin)");
        bookCatalog.add("Designing Data-Intensive Applications");

        System.out.println("\n1. Book Catalog (ArrayList - O(1) random access):");
        for (int i = 0; i < bookCatalog.size(); i++) {
            System.out.printf("   [%d] %s\n", i + 1, bookCatalog.get(i));
        }

        // 2. SET (LinkedHashSet): Preserves insertion order while preventing duplicates
        Set<String> uniqueBorrowers = new LinkedHashSet<>();
        uniqueBorrowers.add("Pranesh Raj");
        uniqueBorrowers.add("Anita Sharma");
        uniqueBorrowers.add("Pranesh Raj"); // Duplicate ignored
        uniqueBorrowers.add("David Miller");

        System.out.println("\n2. Unique Registered Borrowers (LinkedHashSet):");
        System.out.println("   Members: " + uniqueBorrowers + " (Size: " + uniqueBorrowers.size() + ")");

        // 3. QUEUE (ArrayDeque): FIFO General Waitlist
        Queue<String> generalWaitlist = new ArrayDeque<>();
        generalWaitlist.offer("Borrower-A (General)");
        generalWaitlist.offer("Borrower-B (General)");
        generalWaitlist.offer("Borrower-C (General)");

        System.out.println("\n3. FIFO Standard Queue (ArrayDeque):");
        while (!generalWaitlist.isEmpty()) {
            System.out.println("   Dispensing reservation to: " + generalWaitlist.poll());
        }

        // 4. PRIORITY QUEUE: Min-heap based priority requests
        PriorityQueue<ReservationRequest> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new ReservationRequest("Alice (Student)", 3, "Clean Code"));
        priorityQueue.offer(new ReservationRequest("Dr. Raman (Faculty)", 1, "Clean Code"));
        priorityQueue.offer(new ReservationRequest("Karthik (Scholar)", 2, "Clean Code"));

        System.out.println("\n4. Priority Reservation Queue (PriorityQueue - Highest Priority First):");
        while (!priorityQueue.isEmpty()) {
            System.out.println("   Allocating book to: " + priorityQueue.poll());
        }

        // 5. Safe Removal using Iterator.remove()
        List<String> activeLoans = new ArrayList<>(Arrays.asList("Book-101 (Overdue)", "Book-102 (Active)", "Book-103 (Overdue)", "Book-104 (Active)"));
        System.out.println("\n5. Removing Overdue Loans via Iterator.remove():");
        Iterator<String> iterator = activeLoans.iterator();
        while (iterator.hasNext()) {
            String loan = iterator.next();
            if (loan.contains("Overdue")) {
                System.out.println("   Purging overdue entry: " + loan);
                iterator.remove(); // Prevents ConcurrentModificationException
            }
        }
        System.out.println("   Remaining active loans: " + activeLoans);

        // 6. Benchmark Comparison: ArrayList vs LinkedList
        System.out.println("\n6. Performance Benchmark: ArrayList vs LinkedList (100,000 insertions):");
        long start = System.nanoTime();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) arrayList.add(i);
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) linkedList.add(i);
        long linkedListTime = System.nanoTime() - start;

        System.out.printf("   ArrayList append time : %10d ns\n", arrayListTime);
        System.out.printf("   LinkedList append time: %10d ns\n", linkedListTime);
        System.out.println("==================================================");
    }
}
