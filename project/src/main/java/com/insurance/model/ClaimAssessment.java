package com.insurance.model;

public class ClaimAssessment extends BaseEntity {

    private final String assessmentId;
    private final String claimReference;
    private final double assessedAmount;
    private final double deductibleAmount;
    private final String assessmentNotes;

    public ClaimAssessment(String assessmentId, String claimReference, double assessedAmount, double deductibleAmount, String assessmentNotes) {
        super(assessmentId);
        this.assessmentId = assessmentId;
        this.claimReference = claimReference;
        this.assessedAmount = assessedAmount;
        this.deductibleAmount = deductibleAmount;
        this.assessmentNotes = assessmentNotes;
    }

    public String getAssessmentId() { return assessmentId; }
    public String getClaimReference() { return claimReference; }
    public double getAssessedAmount() { return assessedAmount; }
    public double getDeductibleAmount() { return deductibleAmount; }
    public double getNetEligibleAmount() { return Math.max(0.0, assessedAmount - deductibleAmount); }
    public String getAssessmentNotes() { return assessmentNotes; }
}
