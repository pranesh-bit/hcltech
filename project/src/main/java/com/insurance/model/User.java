package com.insurance.model;

/**
 * User
 * 
 * Abstract base user class for role hierarchy.
 */
public abstract class User extends BaseEntity {

    protected String name;
    protected String email;
    protected String phone;
    protected String role;

    public User(String id, String name, String email, String phone, String role) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRole() { return role; }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return String.format("%s [ID=%s, Name='%s', Role=%s]", getClass().getSimpleName(), id, name, role);
    }
}
