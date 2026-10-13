package com.insurance.model;

import java.time.LocalDateTime;

/**
 * BaseEntity
 * 
 * Abstract base persistence entity providing common auditing attributes.
 * Implements Day 05 Project Requirements.
 */
public abstract class BaseEntity {

    protected String id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected boolean active;

    public BaseEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) {
        this.active = active;
        this.updatedAt = LocalDateTime.now();
    }
}
