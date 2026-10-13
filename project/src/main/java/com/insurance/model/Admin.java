package com.insurance.model;

public class Admin extends User {
    private String department;

    public Admin(String id, String name, String email, String phone, String department) {
        super(id, name, email, phone, "ADMIN");
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String getRoleDescription() {
        return "System Administrator - Manages products, underwriting rules, and monitors financial reports.";
    }
}
