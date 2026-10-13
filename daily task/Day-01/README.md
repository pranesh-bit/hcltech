# Day 01 - Java Platform Basics & Agile/Scrum Fundamentals

## Topics Covered

### Java Platform Architecture
- **JDK (Java Development Kit):** Complete development environment containing compiler (`javac`), runtime environment, archiver (`jar`), disassembler (`javap`), and documentation tools.
- **JRE (Java Runtime Environment):** On-premise execution environment packaging the JVM and Java standard core libraries (`rt.jar` / modular runtime image).
- **JVM (Java Virtual Machine):** The abstract specification and concrete runtime engine executing Java bytecode instructions.
- **JVM Subsystems & Architecture:**
  - **Class Loader Subsystem:** Loading (`Bootstrap`, `Extension/Platform`, `Application`), Linking (`Verification`, `Preparation`, `Resolution`), and Initialization.
  - **JVM Memory Areas:** Method Area (Metaspace), Heap Area (Young/Old Generations), JVM Stacks, PC Registers, and Native Method Stacks.
  - **Execution Engine:** Bytecode Interpreter, JIT (Just-In-Time) Compiler (C1 Client / C2 Server compilers, HotSpot profiling, loop unrolling, inlining), and Garbage Collector (G1 GC, ZGC).
- **Java Compilation Flow:**
  - Source Code (`.java`) → Java Compiler (`javac`) → Bytecode (`.class`) → JVM Class Loader → Bytecode Verifier → Execution Engine (Interpreter + JIT) → Native Machine Instructions.

### Agile & Scrum Engineering
- User Story Anatomy: *"As a `<role>`, I want `<capability>` so that `<business benefit>`."*
- Estimation techniques using **Story Points (Fibonacci scale: 1, 2, 3, 5, 8, 13)**.
- **Acceptance Criteria (AC):** Precise pass/fail criteria validating business requirements.
- **Definition of Done (DoD):** Enterprise quality gates including design adherence, unit testing, exception handling, data integrity, and version control.

---

## Daily Hands-on Task: Platform Diagnostics (`PlatformInfo.java`)

A standalone Java utility querying underlying runtime characteristics from `java.lang.System` and `java.lang.Runtime`.

### Compilation & Execution Commands
```bash
# Compile source file to bytecode
javac PlatformInfo.java

# Run Java program
java PlatformInfo

# Inspect compiled bytecode instructions (Disassemble)
javap -c PlatformInfo

# Trace dynamic class loading lifecycle
java -verbose:class PlatformInfo
```

### Expected Output
```text
==================================================
         JAVA RUNTIME & PLATFORM INFO             
==================================================
Java Version     : 21.x.x
Java Vendor      : Oracle Corporation
Java Home        : C:\Program Files\Java\jdk-21
OS Name          : Windows 11
OS Architecture  : amd64
OS Version       : 10.0
Available Cores  : 8
Max JVM Memory   : 4096 MB
Total JVM Memory : 256 MB
Free JVM Memory  : 245 MB
==================================================
```

---

## Project Task: Insurance Policy & Claims Management System

Formulated **8 comprehensive Agile User Stories** covering Functional Requirements (FR1 to FR8) for the **Insurance Policy & Claims Management System** with story points, acceptance criteria, and DoD.

Full specification is maintained in:
`[BACKLOG_USER_STORIES.md](../../Project/docs/BACKLOG_USER_STORIES.md)`
