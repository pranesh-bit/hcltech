package com.insurance.model;

import java.util.Objects;

/**
 * InsuranceProduct
 * 
 * Domain model representing an insurance product catalog offering.
 */
public class InsuranceProduct extends BaseEntity {

    private String productCode;
    private String name;
    private String category; // HEALTH, MOTOR, LIFE
    private double sumInsured;
    private double baseAnnualPremium;
    private String terms;

    public InsuranceProduct(String productCode, String name, String category, double sumInsured, double baseAnnualPremium) {
        super(productCode);
        this.productCode = productCode;
        this.name = name;
        this.category = category;
        this.sumInsured = sumInsured;
        this.baseAnnualPremium = baseAnnualPremium;
        this.terms = String.format("Standard %s coverage up to INR %.2f", category, sumInsured);
    }

    public String getProductCode() { return productCode; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getSumInsured() { return sumInsured; }
    public double getBaseAnnualPremium() { return baseAnnualPremium; }
    public void setBaseAnnualPremium(double baseAnnualPremium) { this.baseAnnualPremium = baseAnnualPremium; }
    public String getTerms() { return terms; }
    public void setTerms(String terms) { this.terms = terms; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceProduct that = (InsuranceProduct) o;
        return Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Category: %s | Sum Insured: INR %.2f | Base: INR %.2f",
                name, productCode, category, sumInsured, baseAnnualPremium);
    }
}
