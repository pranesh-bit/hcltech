# Day 03 - Java Control Flow & Apache Maven Fundamentals

## Topics Covered

### Java Control Flow
- **Decision Making:** `if`, `else if`, `else`, and enhanced `switch` with pattern matching and arrow syntax.
- **Iteration Constructs:**
  - `while`: Entry-controlled loop for indeterminate repetitions (e.g. authentication retry).
  - `do-while`: Exit-controlled loop ensuring menu executes at least once.
  - `for` & enhanced `for-each`: Deterministic indexing and clean array/collection traversal.
- **Branching Controls:** `break` (early loop/switch termination) and `continue` (skip to next iteration).
- **Input Validation:** Guarding against invalid types and negative boundaries.

### Apache Maven Fundamentals
- **Standard Directory Structure:**
  - `src/main/java`: Production source code
  - `src/main/resources`: Application configuration and database migrations
  - `src/test/java`: Unit and integration test suites
  - `pom.xml`: Declarative Project Object Model
- **Maven Coordinates:** `groupId`, `artifactId`, `version`, `packaging`.
- **Core Build Lifecycle Phases:**
  - `validate` → `compile` → `test` → `package` → `verify` → `install` → `deploy`
- **Environment Profiles:** Using `<profiles>` to configure separate build parameters for `dev` and `prod`.

---

## Daily Hands-on Task: ATM Simulator (`AtmSimulator.java`)

A secure console-based ATM banking interface demonstrating:
- PIN authentication with max 3 attempts using `while` loop.
- User menu loop utilizing `do-while` and `switch`.
- Balance check, deposit, and withdrawal operations.
- Boundary condition checks (insufficient balance, negative amounts).
- Transaction mini-statement buffer implemented using a 5-element array and enhanced `for` loop.

### Compilation & Execution
```bash
javac AtmSimulator.java
java AtmSimulator
```

---

## Project Task: Insurance Policy & Claims Management System

### Maven Configuration & Structure
Created enterprise `Project/pom.xml` configured for Java 21, Spring Boot ready coordinates, JUnit Jupiter test engine, and dual `dev` / `prod` build profiles.

### Maven Build Commands
```bash
# Clean previous builds and package project
mvn clean package

# Verify development profile activation
mvn help:evaluate -Dexpression=project.activeProfiles -q -DforceStdout -Pdev

# Verify production profile activation
mvn help:evaluate -Dexpression=project.activeProfiles -q -DforceStdout -Pprod
```

### Functional Requirements Represented in Interactive Console
1. Manage Insurance Products & Coverages (Admin - FR1)
2. Generate Quotes for Applicants (Agent - FR2)
3. Issue Policy with Unique Number (Agent / System - FR3)
4. View Premium Schedules & Record Payment (Policyholder - FR4)
5. Submit Claim with Incident Information (Policyholder - FR5)
6. Assess Claim & Verify Coverage (Claims Officer - FR6)
7. Track Real-time Claim Status & Workflow (Policyholder - FR7)
8. Generate Management Analytics & Claims Ratio Report (Admin - FR8)
