package com.insurance.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Policy
 * 
 * Domain model representing an issued insurance policy contract.
 * Preserves an immutable snapshot of product terms and tracks remaining coverage.
 */
public class Policy extends BaseEntity {

    private final String policyNumber;
    private final Policyholder policyholder;
    private final InsuranceProduct product;
    private final double totalCoverageAmount;
    private double remainingCoverage;
    private final double annualPremium;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private String status; // ACTIVE, EXPIRED, CANCELLED
    private boolean premiumPaid;

    public Policy(String policyNumber, Policyholder policyholder, InsuranceProduct product,
                  double coverageAmount, double annualPremium, LocalDate startDate, LocalDate endDate) {
        super(policyNumber);
        this.policyNumber = policyNumber;
        this.policyholder = policyholder;
        this.product = product;
        this.totalCoverageAmount = coverageAmount;
        this.remainingCoverage = coverageAmount;
        this.annualPremium = annualPremium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "ACTIVE";
        this.premiumPaid = true;
    }

    public String getPolicyNumber() { return policyNumber; }
    public Policyholder getPolicyholder() { return policyholder; }
    public InsuranceProduct getProduct() { return product; }
    public double getTotalCoverageAmount() { return totalCoverageAmount; }
    public double getRemainingCoverage() { return remainingCoverage; }
    public double getAnnualPremium() { return annualPremium; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public boolean isPremiumPaid() { return premiumPaid; }
    public void setPremiumPaid(boolean premiumPaid) { this.premiumPaid = premiumPaid; }

    /**
     * Checks if incident date is covered under the policy validity period.
     */
    public boolean coversIncidentDate(LocalDate incidentDate) {
        if (incidentDate == null) return false;
        return !incidentDate.isBefore(startDate) && !incidentDate.isAfter(endDate);
    }

    /**
     * Atomically deducts approved claim amount from remaining coverage.
     */
    public boolean deductCoverage(double amount) {
        if (amount <= 0 || amount > remainingCoverage) {
            return false;
        }
        this.remainingCoverage -= amount;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return String.format("Policy [%s] - %s | Holder: %s | Remaining Cov: INR %.2f / %.2f | Status: %s",
                policyNumber, product.getName(), policyholder.getName(), remainingCoverage, totalCoverageAmount, status);
    }
}
