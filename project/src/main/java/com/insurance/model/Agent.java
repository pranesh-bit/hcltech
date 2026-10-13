package com.insurance.model;

public class Agent extends User {
    private String agentLicenseNumber;
    private double commissionRate;

    public Agent(String id, String name, String email, String phone, String agentLicenseNumber, double commissionRate) {
        super(id, name, email, phone, "AGENT");
        this.agentLicenseNumber = agentLicenseNumber;
        this.commissionRate = commissionRate;
    }

    public String getAgentLicenseNumber() { return agentLicenseNumber; }
    public double getCommissionRate() { return commissionRate; }

    @Override
    public String getRoleDescription() {
        return "Insurance Agent - Generates customer quotes and assists policyholders with policy issuance.";
    }
}
