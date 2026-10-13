# Day 06 - Exception Handling & AI-Assisted Debugging

## Topics Covered

### Exception Handling Architecture
- **Hierarchy:** `Throwable` → `Error` (JVM unrecoverable failures) vs `Exception` (Application-level recoverable issues).
- **Checked vs Unchecked Exceptions:**
  - **Checked Exceptions (extend `Exception`):** Enforced by compiler; used for expected recoverable business errors (`InsufficientStockException`, `CoverageLimitExceededException`).
  - **Unchecked Exceptions (extend `RuntimeException`):** Programming errors, contract violations, invalid arguments (`IllegalArgumentException`, `InvalidQuantityException`).
- **Keywords in Practice:** `try`, `catch`, `finally`, `throw`, `throws`.
- **Multi-Catch (`catch (ExA | ExB e)`):** Handling multiple related exception types in a single block without code duplication.
- **Exception Chaining (`initCause` / `super(message, cause)`):** Preserving the original root cause when translating internal errors to higher-level domain exceptions.
- **`finally` Execution Guarantee:** Ensuring financial audit logs, database connection handles, and file streams are guaranteed to close even on failure.

### AI-Assisted Debugging & Stack Trace Analysis
- Deconstructing stack traces: identifying origin frame, distinguishing root cause from chained wrappers.
- Using IDE AI prompts to diagnose null pointers, index out of bounds, and invalid state transitions.

---

## Daily Hands-on Task: Order Processor (`OrderProcessor.java`)

Demonstrates:
- `InsufficientStockException` (custom checked exception).
- `InvalidQuantityException` (custom unchecked exception).
- `OrderProcessingException` (domain wrapper maintaining root cause via chaining).
- Multi-catch syntax.
- Mandatory execution of transaction audit logging in `finally`.

### Compilation & Execution
```bash
javac OrderProcessor.java
java OrderProcessor
```

---

## Project Task: Insurance Policy & Claims Management System

Created custom domain exception package `com.insurance.exception`:
- `InsuranceException`: Base checked exception for insurance operations.
- `CoverageLimitExceededException`: Thrown when a claim approval exceeds the remaining sum insured.
- `InvalidClaimStatusTransitionException`: Thrown when an illegal state change is attempted (e.g. `SUBMITTED` directly to `SETTLED`).
- `PolicyExpiredException`: Thrown when claim incident date is outside the policy effective dates.
- `PolicyNotFoundException` & `ClaimNotFoundException`: For non-existent resource lookups.
- `DuplicatePolicyException`: Prevent duplicate policy issuance.
