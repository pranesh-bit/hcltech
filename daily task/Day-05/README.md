# Day 05 - Inheritance, Polymorphism & Git Collaboration

## Topics Covered

### Object-Oriented Inheritance & Polymorphism
- **Inheritance (`extends`):** Reusability, is-a relationships, subclass specialization, single inheritance in Java.
- **`super` Keyword:** Invoking superclass parameterized constructors (`super(...)`) and overridden methods (`super.doAction()`).
- **Abstract Classes vs Interfaces:**
  - `abstract class`: Partial implementation, shared mutable state, constructor execution, templates.
  - `interface`: Pure contracts, multiple inheritance of type, default/static methods, decoupling callers from implementations.
- **Polymorphism in Action:**
  - **Compile-time Polymorphism (Method Overloading):** Same method name with different parameter types or arity.
  - **Runtime Polymorphism (Method Overriding & Dynamic Dispatch):** Method execution resolved at runtime based on the actual object instance rather than the reference type.
- **Strategy Design Pattern:** Encapsulating families of algorithms behind a common interface to allow runtime interchangeability without modifying caller classes.

### Advanced Git Collaboration
- Feature branching: `git checkout -b feature/user-roles`
- Git branch integration: `git merge` (fast-forward vs 3-way merge) and `git rebase`
- Resolving merge conflicts manually and verifying clean build
- Pull Request (PR) workflow: Code review, branch protection, CI status checks.

---

## Daily Hands-on Task: Polymorphic Payment System (`PaymentSystem.java`)

Demonstrates:
- `Refundable` interface defining `refund()` contract.
- Abstract superclass `Payment` defining shared state (`transactionId`, `amount`, `timestamp`) and abstract `processPayment()`.
- Concrete subclasses: `CardPayment`, `UPIPayment`, and `CashPayment`.
- Method overloading (`processPayment()` vs `processPayment(double discountPercentage)`).
- Runtime polymorphism using a polymorphic array `Payment[]`.

### Compilation & Execution
```bash
javac PaymentSystem.java
java PaymentSystem
```

---

## Project Task: Insurance Policy & Claims Management System

Implemented:
- `BaseEntity`: Abstract base entity providing common persistence attributes (`id`, `createdAt`, `updatedAt`, `active`).
- User Role Hierarchy: `abstract class User` extended by concrete roles `Admin`, `Agent`, `ClaimsOfficer`, and `Policyholder`.
- Strategy Design Pattern:
  - `PremiumCalculationStrategy` interface.
  - Subclasses: `HealthPremiumStrategy`, `MotorPremiumStrategy`, and `LifePremiumStrategy`.
