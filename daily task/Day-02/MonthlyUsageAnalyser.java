public class MonthlyUsageAnalyser {

    static final long SLAB_LIMIT = 100;
    static final long SLAB_RATE = 5;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     MONTHLY USAGE & METRICS ANALYSER (DAY 02)   ");
        System.out.println("==================================================");

        // 1-D Array representing 12 months data
        int[] monthlyUsage = {
            120, 150, 90, 200, 180, 160,
            140, 130, 170, 190, 210, 220
        };

        // Use long to avoid 32-bit integer overflow
        long total = 0;
        int max = monthlyUsage[0];
        int min = monthlyUsage[0];

        for (int usage : monthlyUsage) {
            total += usage;
            if (usage > max) {
                max = usage;
            }
            if (usage < min) {
                min = usage;
            }
        }

        // Explicit widening type casting: long to double
        double average = (double) total / monthlyUsage.length;

        // Classification using nested ternary operator
        char grade = average > 180 ? 'A' :
                     average > 140 ? 'B' :
                     average > 100 ? 'C' : 'D';

        System.out.println("Total Usage / Volume : " + total);
        System.out.printf("Average Usage / Month: %.2f\n", average);
        System.out.println("Maximum Recorded     : " + max);
        System.out.println("Minimum Recorded     : " + min);
        System.out.println("Usage Efficiency Tier: " + grade);

        // 2-D Array: 3 Policyholder Households across 4 Quarters
        int[][] householdQuarterlyData = {
            {120, 150, 90, 200},
            {100, 130, 110, 170},
            {200, 220, 190, 210}
        };

        System.out.println("\nQuarterly Breakdown Across Accounts (2D Array):");
        for (int i = 0; i < householdQuarterlyData.length; i++) {
            System.out.print("Account " + (i + 1) + " [Q1-Q4]: ");
            for (int j = 0; j < householdQuarterlyData[i].length; j++) {
                System.out.print(householdQuarterlyData[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================================================");
    }
}
