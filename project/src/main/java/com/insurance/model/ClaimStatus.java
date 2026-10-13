package com.insurance.model;

import java.util.EnumSet;
import java.util.Set;

/**
 * ClaimStatus
 * 
 * Formal Workflow State Machine for Insurance Claims Processing.
 * Implements Phase 1 & 5 State Transition requirements.
 */
public enum ClaimStatus {
    SUBMITTED,
    UNDER_VERIFICATION,
    MORE_INFO_REQUIRED,
    UNDER_ASSESSMENT,
    PENDING_DECISION,
    APPROVED,
    PARTIALLY_APPROVED,
    REJECTED,
    SETTLED;

    /**
     * Enforces valid workflow transitions.
     * Prevents bypassing stages or regressing to illegal states.
     */
    public boolean canTransitionTo(ClaimStatus target) {
        if (target == null) return false;
        if (this == target) return true; // Idempotent

        return switch (this) {
            case SUBMITTED -> target == UNDER_VERIFICATION;
            case UNDER_VERIFICATION -> target == MORE_INFO_REQUIRED || target == UNDER_ASSESSMENT;
            case MORE_INFO_REQUIRED -> target == UNDER_VERIFICATION;
            case UNDER_ASSESSMENT -> target == PENDING_DECISION;
            case PENDING_DECISION -> target == APPROVED || target == PARTIALLY_APPROVED || target == REJECTED;
            case APPROVED, PARTIALLY_APPROVED -> target == SETTLED;
            case REJECTED, SETTLED -> false; // Terminal states
        };
    }

    public static Set<ClaimStatus> getActiveStatuses() {
        return EnumSet.of(SUBMITTED, UNDER_VERIFICATION, MORE_INFO_REQUIRED, UNDER_ASSESSMENT, PENDING_DECISION);
    }

    public static Set<ClaimStatus> getDecidedStatuses() {
        return EnumSet.of(APPROVED, PARTIALLY_APPROVED, REJECTED, SETTLED);
    }
}
