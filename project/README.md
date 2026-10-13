# Insurance Policy & Claims Management System

A robust, enterprise-grade Java web application for comprehensive insurance operations: insurance product catalog management, transparent quote calculations, policy issuance, premium installment schedules, multi-stage claims workflow state machine, claims officer assessment, coverage verification, and executive management reporting.

---

## 📌 Project Architecture & Domain Modules

The platform is designed around a modular monolithic architecture with clean separation of concerns:

| Module | Core Responsibilities | Target Service Layer |
| :--- | :--- | :--- |
| **M1. Authentication & Users** | User authentication, JWT tokens, RBAC (Admin, Agent, Claims Officer, Policyholder) | `auth-service` |
| **M2. Product Catalog & Quotes** | Insurance products (Health, Motor, Life), pricing rules, and itemized quotes | `policy-service` |
| **M3. Policy Management** | Quote conversion, policy issuance, coverage snapshots, renewals | `policy-service` |
| **M4. Premiums & Payments** | Installment schedules, payment processing, simulated payment outcomes | `policy-service` |
| **M5. Claims Processing** | Claim intake, incident validation, multi-stage workflow transitions | `claim-service` |
| **M6. Document Management** | Secure document upload, verification, metadata storage, access control | `claim-service` |
| **M7. Settlement Management** | Payout authorization, financial transactions, settlement auditing | `claim-service` |
| **M8. Reports & Analytics** | Portfolio KPIs, simplified claims ratio, and category distribution | `reporting-service` |

---

## 👥 User Roles & Permissions

- **ADMIN:** Manages user role assignments, configures insurance products and coverage limits, views claims ratio analytics, and reviews audit logs.
- **AGENT:** Maintains customer profiles, generates insurance quotes with transparent demonstration formulas, and issues policies upon payment confirmation.
- **POLICYHOLDER:** Browses products, views issued policies and installment schedules, submits claims with incident details and documents, and tracks claim status.
- **CLAIMS_OFFICER:** Verifies submitted claims, assesses eligible amounts, checks contractual coverage limits, approves or rejects claims with mandatory reasons, and authorizes settlements.

---

## 🎯 Functional Requirements (FR1 – FR8)

- **FR1:** Admin manages insurance products across Health, Motor, and Life categories.
- **FR2:** Agent generates itemized quotes based on risk parameters and applicant inputs.
- **FR3:** System converts quotes to active policies with unique policy numbers.
- **FR4:** Policyholder views premium installment schedules and executes simulated payments.
- **FR5:** Policyholder submits insurance claims against active policies with incident documentation.
- **FR6:** Claims Officer verifies claims, assesses damages, and records decisions through valid workflow states.
- **FR7:** Policyholder tracks real-time claim status while system strictly enforces remaining sum insured limits.
- **FR8:** Admin inspects financial reports, claims summaries, and claims ratios.

---

## 🛡️ Non-Functional Requirements (NFRs)

- **NFR-1 (Reference Uniqueness):** Policy numbers (`POL-...`) and Claim references (`CLM-...`) are globally unique across the system, enforced using Java `Set` data structures and database unique constraints.
- **NFR-2 (Workflow State Integrity):** State transitions strictly adhere to the defined state machine (`SUBMITTED` → `UNDER_VERIFICATION` → `UNDER_ASSESSMENT` → `PENDING_DECISION` → `APPROVED` / `REJECTED` → `SETTLED`). Illegal transitions throw domain exceptions.
- **NFR-3 (Coverage Limit Protection):** Claim payouts cannot exceed remaining contractual sum insured coverage.
- **NFR-4 (Historical Snapshot Preservation):** Modifying catalog product rates never retroactively mutates existing issued policies.

---

## 🗓️ 8-Day Training Roadmap

| Day | Core Topics | Daily Hands-on Task | Project Focus Area |
| :---: | :--- | :--- | :--- |
| **Day 1** | Java Platform Basics (JDK, JRE, JVM) & Agile/Scrum | `PlatformInfo.java` | 8 User Stories, Story Points (44 SP), and DoD in [BACKLOG_USER_STORIES.md](docs/BACKLOG_USER_STORIES.md). |
| **Day 2** | Language Fundamentals & Git Essentials | `MonthlyUsageAnalyser.java` | `.gitignore`, project architecture, and `InsuranceConstants.java` business rules with 2D sample data arrays. |
| **Day 3** | Control Flow & Apache Maven Fundamentals | `AtmSimulator.java` | Multi-module ready `pom.xml`, Java 21 build setup, dev/prod profiles, and console menu architecture. |
| **Day 4** | OOP Concepts, Encapsulation, IDE & Debugging | `BankAccount.java` | Encapsulated domain model classes (`Policyholder`, `InsuranceProduct`, `Policy`, `InsuranceClaim`). |
| **Day 5** | Inheritance, Polymorphism & Git Collaboration | `PaymentSystem.java` | `BaseEntity`, User role hierarchy (`Admin`, `Agent`, `ClaimsOfficer`, `Policyholder`), Strategy pattern for premiums. |
| **Day 6** | Exception Handling & AI-Assisted Debugging | `OrderProcessor.java` | Custom domain exception package (`CoverageLimitExceededException`, `InvalidClaimStatusTransitionException`). |
| **Day 7** | Collections Framework (Part 1 - List, Set, Queue) | `LibraryWaitlist.java` | In-memory data structures (`List`, `Set`, `Queue`), and implementations of FR1, FR2, and FR3. |
| **Day 8** | Collections Framework (Part 2 - Map Interface & Analytics) | `TransactionFrequencyAnalyzer.java` | Map-based indexing (`Map<String, Policy>`, `Map<String, InsuranceClaim>`), state machine, and FR8 analytics reporting. |

---

## 🚀 Daily Task Execution

Each daily hands-on task can be independently compiled and run from its respective directory:

```bash
# Day 01: Platform Info
cd "daily task/Day-01" && javac PlatformInfo.java && java PlatformInfo

# Day 02: Monthly Usage Analyser
cd "daily task/Day-02" && javac MonthlyUsageAnalyser.java && java MonthlyUsageAnalyser

# Day 03: ATM Simulator
cd "daily task/Day-03" && javac AtmSimulator.java && java AtmSimulator

# Day 04: Bank Account
cd "daily task/Day-04" && javac BankAccount.java && java BankAccount

# Day 05: Payment System
cd "daily task/Day-05" && javac PaymentSystem.java && java PaymentSystem

# Day 06: Order Processor
cd "daily task/Day-06" && javac OrderProcessor.java && java OrderProcessor

# Day 07: Library Waitlist
cd "daily task/Day-07" && javac LibraryWaitlist.java && java LibraryWaitlist

# Day 08: Transaction Frequency Analyzer
cd "daily task/Day-08" && javac TransactionFrequencyAnalyzer.java && java TransactionFrequencyAnalyzer
```
