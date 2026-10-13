package com.insurance.model;

import java.util.ArrayList;
import java.util.List;

public class Policyholder extends User {
    private String governmentIdNumber; // PAN or Aadhaar
    private String address;
    private final List<String> enrolledPolicyNumbers;

    public Policyholder(String id, String name, String email, String phone, String governmentIdNumber, String address) {
        super(id, name, email, phone, "POLICYHOLDER");
        this.governmentIdNumber = governmentIdNumber;
        this.address = address;
        this.enrolledPolicyNumbers = new ArrayList<>();
    }

    public String getGovernmentIdNumber() { return governmentIdNumber; }
    public void setGovernmentIdNumber(String governmentIdNumber) { this.governmentIdNumber = governmentIdNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<String> getEnrolledPolicyNumbers() { return enrolledPolicyNumbers; }

    public void addPolicyNumber(String policyNumber) {
        if (!enrolledPolicyNumbers.contains(policyNumber)) {
            enrolledPolicyNumbers.add(policyNumber);
        }
    }

    @Override
    public String getRoleDescription() {
        return "Policyholder - Browses insurance products, purchases policies, pays premiums, and submits claims.";
    }
}
