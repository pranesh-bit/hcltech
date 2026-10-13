package com.insurance.model;

public class ClaimsOfficer extends User {
    private double approvalLimit;

    public ClaimsOfficer(String id, String name, String email, String phone, double approvalLimit) {
        super(id, name, email, phone, "CLAIMS_OFFICER");
        this.approvalLimit = approvalLimit;
    }

    public double getApprovalLimit() { return approvalLimit; }
    public void setApprovalLimit(double approvalLimit) { this.approvalLimit = approvalLimit; }

    @Override
    public String getRoleDescription() {
        return "Claims Officer - Verifies coverage, reviews claim documents, assesses claims, and authorizes decisions.";
    }
}
