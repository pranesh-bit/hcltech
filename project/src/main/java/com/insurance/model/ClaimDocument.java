package com.insurance.model;

public class ClaimDocument extends BaseEntity {

    private final String documentId;
    private final String claimReference;
    private final String originalFilename;
    private final String documentType; // Medical Report, Police FIR, Repair Estimate, Invoice
    private final long fileSizeBytes;

    public ClaimDocument(String documentId, String claimReference, String originalFilename, String documentType, long fileSizeBytes) {
        super(documentId);
        this.documentId = documentId;
        this.claimReference = claimReference;
        this.originalFilename = originalFilename;
        this.documentType = documentType;
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getDocumentId() { return documentId; }
    public String getClaimReference() { return claimReference; }
    public String getOriginalFilename() { return originalFilename; }
    public String getDocumentType() { return documentType; }
    public long getFileSizeBytes() { return fileSizeBytes; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s, %d KB)", documentId, originalFilename, documentType, fileSizeBytes / 1024);
    }
}
