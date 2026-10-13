import java.util.*;

public class TransactionFrequencyAnalyzer {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      MAP INTERFACE & ANALYTICS (DAY 08)          ");
        System.out.println("==================================================");

        // 1. HashMap: Fast O(1) Key-Value lookups & frequency counting
        Map<String, Integer> categoryFrequencyMap = new HashMap<>();
        String[] transactionCategories = {
            "Health", "Motor", "Health", "Life", "Health",
            "Motor", "Travel", "Motor", "Life", "Health"
        };

        for (String cat : transactionCategories) {
            // Using getOrDefault to increment frequency cleanly
            categoryFrequencyMap.put(cat, categoryFrequencyMap.getOrDefault(cat, 0) + 1);
        }

        System.out.println("\n1. Transaction Volume by Category (HashMap - O(1)):");
        for (Map.Entry<String, Integer> entry : categoryFrequencyMap.entrySet()) {
            System.out.printf("   Category: %-10s | Transaction Count: %d\n", entry.getKey(), entry.getValue());
        }

        // 2. LinkedHashMap: Preserves chronological insertion order
        Map<String, Double> recentTransactionsLog = new LinkedHashMap<>();
        recentTransactionsLog.put("TXN-501", 12500.00);
        recentTransactionsLog.put("TXN-502", 45000.00);
        recentTransactionsLog.put("TXN-503", 8200.00);
        recentTransactionsLog.put("TXN-504", 19500.00);

        System.out.println("\n2. Recent Audit Trail (LinkedHashMap - Insertion Order):");
        recentTransactionsLog.forEach((txId, amt) ->
                System.out.printf("   Reference: %-8s | Amount: INR %10.2f\n", txId, amt));

        // 3. TreeMap: Sorted alphabetically / naturally by key (O(log N))
        Map<String, Double> sortedFinancialLedger = new TreeMap<>();
        sortedFinancialLedger.put("Premium Health", 125000.00);
        sortedFinancialLedger.put("Auto Comprehensive", 85000.00);
        sortedFinancialLedger.put("Term Life Shield", 210000.00);
        sortedFinancialLedger.put("Critical Care", 95000.00);

        System.out.println("\n3. Sorted Product Ledger (TreeMap - Natural Sort Order):");
        for (Map.Entry<String, Double> entry : sortedFinancialLedger.entrySet()) {
            System.out.printf("   %-22s -> INR %12.2f\n", entry.getKey(), entry.getValue());
        }

        // 4. Advanced Map API: computeIfAbsent for grouping
        Map<String, List<Double>> groupedAmounts = new HashMap<>();
        double[] amounts = {1500.0, 3200.0, 7800.0, 4200.0};
        String[] types = {"Motor", "Health", "Health", "Motor"};

        for (int i = 0; i < types.length; i++) {
            groupedAmounts.computeIfAbsent(types[i], k -> new ArrayList<>()).add(amounts[i]);
        }

        System.out.println("\n4. Grouped Amounts using computeIfAbsent():");
        groupedAmounts.forEach((type, list) -> System.out.printf("   Type: %-8s -> Values: %s\n", type, list));

        // 5. Benchmark: HashMap vs TreeMap (100,000 lookups)
        System.out.println("\n5. Performance Benchmark: HashMap vs TreeMap (100,000 operations):");
        Map<Integer, String> hm = new HashMap<>();
        Map<Integer, String> tm = new TreeMap<>();
        for (int i = 0; i < 100000; i++) {
            hm.put(i, "val" + i);
            tm.put(i, "val" + i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) hm.get(i);
        long hmTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) tm.get(i);
        long tmTime = System.nanoTime() - start;

        System.out.printf("   HashMap lookup time : %10d ns (O(1))\n", hmTime);
        System.out.printf("   TreeMap lookup time : %10d ns (O(log N))\n", tmTime);
        System.out.println("==================================================");
    }
}
