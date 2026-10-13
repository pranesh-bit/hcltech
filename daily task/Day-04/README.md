# Day 04 - OOP Concepts, Encapsulation, IDE & Debugging

## Topics Covered

### Core OOP Principles
- **Classes & Objects:** Blueprints defining state (instance attributes) and behavior (instance methods).
- **Constructors:**
  - Default constructor vs Parameterized constructors.
  - Constructor overloading.
  - Explicit constructor chaining using `this(...)`.
- **Encapsulation:**
  - Data hiding by declaring fields `private`.
  - Public getter and setter methods with invariant validation.
  - Protecting internal object integrity.
- **Static Members:**
  - `static` fields shared across all class instances (e.g., auto-incrementing identity counters).
  - `static` methods executing in class context without requiring an instantiated object.
- **Object Contract:**
  - Correct implementation of `equals(Object o)` for logical equivalence.
  - Maintaining the `hashCode()` contract (equal objects must share identical hash codes).
  - Overriding `toString()` for meaningful logging and state inspection.

### IDE & Interactive Debugging
- Setting Line Breakpoints and Conditional Breakpoints.
- Stepping actions: Step Over (`F8`), Step Into (`F7`), Step Out (`Shift+F8`), Run to Cursor.
- Variable inspection and dynamic Watch expressions.
- Call Stack traversal across method execution frames.

---

## Daily Hands-on Task: Bank Account (`BankAccount.java`)

An enterprise domain model class demonstrating:
- Strict encapsulation with `private` fields.
- Static account sequence counter generating identifiers (`ACC-1001`, `ACC-1002`).
- Parameterized constructors with input validation (negative deposits rejected).
- Safe deposit and withdrawal operations with status feedback.
- Fully implemented `equals()`, `hashCode()`, and `toString()`.

### Compilation & Execution
```bash
javac BankAccount.java
java BankAccount
```

---

## Project Task: Insurance Policy & Claims Management System

Implemented initial core domain model classes with encapsulation:
- `Policyholder`: Encapsulates customer identity, contact information, PAN card, and policy holdings.
- `InsuranceProduct`: Encapsulates product code, name, category, sum insured limit, and base rate.
- `Policy`: Encapsulates policy number, policyholder reference, product terms, coverage balance, and status.
- `InsuranceClaim`: Encapsulates claim reference, incident date, claimed amount, assessed amount, and workflow status.
