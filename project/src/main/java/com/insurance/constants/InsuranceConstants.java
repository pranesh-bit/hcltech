package com.insurance.constants;

/**
 * InsuranceConstants
 * 
 * Central business rules, financial constants, and seed data arrays.
 * Implements Day 02 Project Requirements.
 */
public final class InsuranceConstants {

    private InsuranceConstants() {
        // Prevent instantiation
    }

    // System-wide Business Constants
    public static final String CURRENCY_CODE = "INR";
    public static final String CURRENCY_SYMBOL = "₹";
    public static final double GST_TAX_RATE = 0.18; // 18% GST on insurance premiums
    public static final int DEFAULT_POLICY_TERM_YEARS = 1;
    public static final int QUOTE_VALIDITY_DAYS = 30;
    public static final double MINIMUM_CLAIM_AMOUNT = 500.0;
    public static final long MAX_DOCUMENT_FILE_SIZE_BYTES = 5 * 1024 * 1024; // 5 MB

    // Reference Code Prefixes
    public static final String POLICY_PREFIX = "POL";
    public static final String CLAIM_PREFIX = "CLM";
    public static final String QUOTE_PREFIX = "QUO";
    public static final String SETTLEMENT_PREFIX = "SET";
    public static final String CUSTOMER_PREFIX = "CUST";

    // Insurance Categories
    public static final String CATEGORY_HEALTH = "HEALTH";
    public static final String CATEGORY_MOTOR = "MOTOR";
    public static final String CATEGORY_LIFE = "LIFE";

    // Pre-configured 2D Array: Default Insurance Products Catalog (Code, Name, Category, Sum Insured, Base Premium)
    public static final String[][] DEFAULT_PRODUCTS_CATALOG = {
        {"PRD-HLT-01", "Health Shield Plus", "HEALTH", "500000.00", "12500.00"},
        {"PRD-HLT-02", "Critical Care Comprehensive", "HEALTH", "1000000.00", "24000.00"},
        {"PRD-MOT-01", "Auto Protect Bumper-to-Bumper", "MOTOR", "750000.00", "14800.00"},
        {"PRD-MOT-02", "Two-Wheeler Third Party & Own Damage", "MOTOR", "150000.00", "3200.00"},
        {"PRD-LIF-01", "Term Life Secure 1 Crore", "LIFE", "10000000.00", "18500.00"},
        {"PRD-LIF-02", "Smart Pension Wealth Builder", "LIFE", "2500000.00", "36000.00"}
    };

    // Pre-configured 2D Array: Sample Policyholders (ID, Full Name, Email, Phone, PAN/ID, City)
    public static final String[][] SAMPLE_POLICYHOLDERS = {
        {"CUST-101", "Pranesh Raj", "pranesh.raj@example.com", "9845012345", "ABCDE1234F", "Chennai"},
        {"CUST-102", "Anita Sharma", "anita.sharma@example.com", "9876543210", "BCDEF2345G", "Bengaluru"},
        {"CUST-103", "Vikram Malhotra", "vikram.m@example.com", "9811122233", "CDEFG3456H", "Mumbai"},
        {"CUST-104", "Sneha Patel", "sneha.patel@example.com", "9822233344", "DEFGH4567I", "Ahmedabad"},
        {"CUST-105", "Rohan Verma", "rohan.verma@example.com", "9833344455", "EFGHI5678J", "Delhi NCR"}
    };

    // Pre-configured 2D Array: Sample Pre-Issued Policies (Policy No, Cust ID, Product Code, Sum Insured, Premium, Status)
    public static final String[][] SAMPLE_INITIAL_POLICIES = {
        {"POL-HLT-1001", "CUST-101", "PRD-HLT-01", "500000.00", "14750.00", "ACTIVE"},
        {"POL-MOT-1002", "CUST-102", "PRD-MOT-01", "750000.00", "17464.00", "ACTIVE"},
        {"POL-LIF-1003", "CUST-103", "PRD-LIF-01", "10000000.00", "21830.00", "ACTIVE"},
        {"POL-HLT-1004", "CUST-104", "PRD-HLT-02", "1000000.00", "28320.00", "ACTIVE"}
    };
}
