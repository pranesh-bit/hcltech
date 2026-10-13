# Insurance Policy & Claims Management System - Agile Backlog & User Stories (Day 01)

## Project Overview
- **Domain:** Insurance & Financial Services (Life, Motor & Health Insurance Operations)
- **Architecture:** Modular Service Design (Targeting Spring Boot & React Micro-Modular Monolith)
- **Target Roles:** Admin, Insurance Agent, Claims Officer, Policyholder

---

## Definition of Done (DoD)
A User Story is considered **Done** only when:
1. **Requirements & Logic:** All acceptance criteria are fully satisfied with strict domain validation (coverage limits, date ranges, and identity checks).
2. **Code Standards:** Code adheres to clean Java conventions, strict encapsulation, meaningful naming, and proper documentation.
3. **Exception Safety:** Business invariants are guarded by custom domain exceptions; invalid user actions return descriptive feedback without crashing the application.
4. **Data Integrity:** Policy numbers and claim references are globally unique (`Set`), state transitions follow the approved state machine (`ClaimStatus`), and historical policy snapshots are immutable.
5. **Testing & Execution:** Unit tests validate normal and edge-case execution paths; console UI flows work end-to-end without unhandled runtime exceptions.
6. **Version Control:** Changes are committed to Git with clear, structured commit messages following conventional commits.

---

## User Stories & Story Point Estimates

| Story ID | Requirement | User Story ("As a <role>, I want ... so that ...") | Story Points | Priority |
| :--- | :--- | :--- | :---: | :---: |
| **US-01** | **FR1** | **As an Admin**, I want to create, configure, and maintain insurance products across Health, Motor, and Life categories with sum insured limits and base terms, **so that** the company maintains a compliant, competitive insurance catalog. | 5 | High |
| **US-02** | **FR2** | **As an Agent**, I want to generate insurance quotes by entering applicant/risk parameters and applying transparent demonstration pricing rules, **so that** prospective policyholders receive itemized premium estimates. | 5 | High |
| **US-03** | **FR3** | **As an Agent / System**, I want to convert an accepted quote into an issued policy with a unique policy number, coverage snapshot, and installment schedule upon payment confirmation, **so that** legal insurance coverage is activated. | 8 | Critical |
| **US-04** | **FR4** | **As a Policyholder**, I want to view premium installment due dates and process simulated premium payments, **so that** my policy remains active and in good standing. | 5 | High |
| **US-05** | **FR5** | **As a Policyholder**, I want to submit an insurance claim against an active policy with incident details, requested amount, and mandatory supporting documents, **so that** my claim can be reviewed for settlement. | 8 | Critical |
| **US-06** | **FR6** | **As a Claims Officer**, I want to verify claim details, record assessment findings, deduct exclusions, and approve/reject claims with mandatory justification, **so that** claim evaluations strictly comply with contractual coverage terms. | 8 | Critical |
| **US-07** | **FR7** | **As a Policyholder**, I want to track real-time claim progress while the system strictly validates that approved amounts never exceed remaining sum insured coverage, **so that** claim decisions are transparent and over-payout is prevented. | 5 | High |
| **US-08** | **FR8** | **As an Admin**, I want to execute payout settlements for approved claims and inspect aggregate financial analytics (total premiums collected, claims ratio, product distribution), **so that** company solvency and operational performance are monitored. | 5 | Medium |

**Total Backlog Story Points:** 44 SP

---

### Detailed Acceptance Criteria per User Story

#### US-01 (FR1 - Insurance Product Catalog Management)
- **Acceptance Criteria:**
  - Admin can list all active insurance products (Health, Motor, Life).
  - Admin can configure product code, name, category, maximum sum insured, and base annual premium.
  - Updating a product rate does not retroactively mutate existing issued policies (historical terms preserved).
  - Sum insured and premium must be strictly greater than zero.

#### US-02 (FR2 - Quote Generation & Calculation)
- **Acceptance Criteria:**
  - Agent selects product category and enters risk parameters:
    - *Health:* Applicant age, medical history factor, insured members count.
    - *Motor:* Vehicle age, cubic capacity (CC), vehicle valuation.
    - *Life:* Age, term length, smoking status.
  - System applies the appropriate `PremiumCalculationStrategy` to return an itemized quote with breakdown (base premium, risk loading, 18% GST).
  - Quote produces an expiration date (30-day validity window).

#### US-03 (FR3 - Policy Issuance & Conversion)
- **Acceptance Criteria:**
  - Policy is issued only upon receiving initial premium payment confirmation.
  - System auto-generates a globally unique policy number (`POL-HEALTH-1001`, `POL-MOTOR-1002`).
  - Takes an immutable snapshot of coverage limits and customer details.
  - Sets policy start date and expiration date (1-year term by default).
  - Initial remaining coverage equals the total sum insured.

#### US-04 (FR4 - Premium Schedule & Payment Collection)
- **Acceptance Criteria:**
  - System generates installment schedule according to chosen frequency (Annual, Quarterly, Monthly).
  - Each installment tracks installment number, due date, amount, and payment status (`PENDING`, `PAID`, `OVERDUE`).
  - Policyholder can trigger simulated payments with reference code generation.

#### US-05 (FR5 - Claim Submission & Document Attachment)
- **Acceptance Criteria:**
  - Policyholder specifies active policy number, incident date, category, incident description, and claimed amount.
  - System validates:
    - Policy exists and is currently in `ACTIVE` status.
    - Incident date falls strictly between policy start date and end date.
    - Claimed amount is positive and does not exceed the policy's remaining coverage.
  - Claim generates a unique reference (`CLM-1001`) and is placed in `SUBMITTED` state into the review queue in FIFO order.

#### US-06 (FR6 - Multi-Stage Claim Workflow & Assessment)
- **Acceptance Criteria:**
  - Claims Officer verifies submitted incident against terms.
  - Transition follows strict state machine: `SUBMITTED` → `UNDER_VERIFICATION` → `UNDER_ASSESSMENT` → `PENDING_DECISION` → `APPROVED` / `PARTIALLY_APPROVED` / `REJECTED`.
  - Officer records assessed eligible amount, itemized exclusions/deductibles, and approved amount.
  - Mandatory decision reason must be provided for all approvals and rejections.

#### US-07 (FR7 - Claim Status Tracking & Coverage Limit Enforcement)
- **Acceptance Criteria:**
  - Policyholder can view real-time claim status and audit remarks by entering Claim Reference.
  - Concurrency & Coverage Safety: Approved claim amount is deducted from the policy's remaining coverage.
  - Any attempt to approve an amount exceeding remaining coverage throws `CoverageLimitExceededException`.

#### US-08 (FR8 - Settlement Processing & Management Analytics)
- **Acceptance Criteria:**
  - System initiates settlement for approved claims, transitioning status to `SETTLED`.
  - Payout cannot exceed the approved claim amount.
  - Admin dashboard displays aggregate KPIs:
    - Total policies issued & active policies.
    - Total premiums collected (INR).
    - Total claims settled (INR).
    - Simplified Paid-Claims-to-Collected-Premiums Ratio: `(Settled Claims / Collected Premiums) * 100`.
    - Claims distribution breakdown by category (Health, Motor, Life).
