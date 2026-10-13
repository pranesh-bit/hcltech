# Day 02 - Java Language Fundamentals & Git Essentials

## Topics Covered

### Java Language Fundamentals
- **Primitive Data Types:** Ranges and memory allocation for `byte` (8-bit), `short` (16-bit), `int` (32-bit), `long` (64-bit), `float` (32-bit IEEE 754), `double` (64-bit IEEE 754), `char` (16-bit Unicode), and `boolean`.
- **Variables & Constants:** Declaration, scope, initialization, and immutable state enforcement with `final`.
- **1-D & 2-D Arrays:** Contiguous memory indexing, array bounds validation (`ArrayIndexOutOfBoundsException`), and nested matrix traversal.
- **Operators & Precedence:** Arithmetic (`+`, `-`, `*`, `/`, `%`), Relational (`==`, `!=`, `<`, `>`, `<=`, `>=`), and Logical (`&&`, `||`, `!`).
- **Type Casting:** Widening (lossless automatic promotion) vs Narrowing (explicit cast with potential precision/truncation loss).
- **Integer Overflow:** Mitigating arithmetic wraparound in cumulative counters by promoting variables to 64-bit `long`.
- **Floating-Point Precision:** Binary IEEE 754 precision limits and rationale for using `BigDecimal` in monetary insurance accounting.
- **Ternary Operator:** Concise conditional expressions (`condition ? valIfTrue : valIfFalse`).

### Git Essentials & Remote Repositories
- Core Git Architecture: Working Directory → Staging Area (`Index`) → Local Repository (`HEAD`) → Remote Repository (`origin`).
- Essential Commands: `git init`, `git clone`, `git status`, `git add`, `git commit -m`, `git push`, `git pull`, `git diff`.
- Environment Protection: `.gitignore` rules for ignoring build targets (`target/`, `out/`, `*.class`), IDE configurations (`.idea/`, `.vscode/`), and OS artifacts (`.DS_Store`, `Thumbs.db`).
- Secure Authentication: Configuring SSH keypairs (`ed25519`) and HTTPS Personal Access Tokens.

---

## Daily Hands-on Task: Monthly Usage Analyser (`MonthlyUsageAnalyser.java`)

Demonstrates:
- 12-element `int[]` array containing periodic metrics.
- Constants defined using `static final`.
- Cumulative sum calculated with `long` to guard against integer overflow.
- Average computation with explicit widening casting `(double) total / length`.
- Single-pass min/max calculation.
- Classification grade derived using nested ternary operators.
- 2-D array matrix (`int[][]`) representing quarterly breakdowns across multiple accounts.

### Compilation & Execution
```bash
javac MonthlyUsageAnalyser.java
java MonthlyUsageAnalyser
```

---

## Project Task: Insurance Policy & Claims Management System

Updated project repository with:
- Enterprise `.gitignore` file.
- Project root `README.md` containing architecture, module boundaries, and implementation plan.
- `InsuranceConstants.java` establishing system business rules, product codes, claim status constants, and pre-seeded sample data in 2D arrays.
