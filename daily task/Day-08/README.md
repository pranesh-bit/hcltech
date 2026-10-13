# Day 08 - Map Interface & Reporting Analytics

## Topics Covered

### Map Hierarchy & Internal Mechanics
- **`Map<K, V>` Interface:** Key-to-value associations where keys are strictly unique.
- **`HashMap` Internals:**
  - Array of hash buckets (`Node<K, V>[]`).
  - Hashing algorithm: `key.hashCode() ^ (h >>> 16)` and bucket index calculation `(n - 1) & hash`.
  - Collision resolution: Separate chaining via linked list.
  - Treeification: Automatically converts long linked lists to Red-Black trees (`TreeNode`) when bucket count exceeds `TREEIFY_THRESHOLD = 8`.
  - Load factor (default `0.75`) and rehashing.
- **`LinkedHashMap`:** Preserves predictable entry ordering (either insertion order or access order for LRU cache implementation).
- **`TreeMap`:** Implements `NavigableMap` and `SortedMap`; backed by a Red-Black tree providing guaranteed $O(\log N)$ time for `containsKey`, `get`, `put`, and `remove`.
- **Modern Map Methods:** `getOrDefault()`, `putIfAbsent()`, `computeIfAbsent()`, `forEach((k, v) -> ...)`.

---

## Daily Hands-on Task: Transaction Frequency Analyzer (`TransactionFrequencyAnalyzer.java`)

Demonstrates:
- `HashMap` for computing transaction frequency distributions.
- `LinkedHashMap` for chronologically ordered audit logs.
- `TreeMap` for generating sorted financial product ledgers.
- Dynamic category grouping using `computeIfAbsent()`.
- Empirical benchmark quantifying $O(1)$ HashMap access vs $O(\log N)$ TreeMap traversal.

### Compilation & Execution
```bash
javac TransactionFrequencyAnalyzer.java
java TransactionFrequencyAnalyzer
```

---

## Project Task: Insurance Policy & Claims Management System

Implemented:
- Map-based indexing in `InsuranceService.java`:
  - `Map<String, Policy>` for $O(1)$ lookup by policy number.
  - `Map<String, InsuranceClaim>` for $O(1)$ lookup by claim reference.
  - `Map<String, Policyholder>` for customer profiles.
- Completed all Functional Requirements:
  - **FR4:** Premium installment collection and simulated payment outcomes.
  - **FR5:** Validated claim workflow state machine (`SUBMITTED` → `UNDER_VERIFICATION` → `UNDER_ASSESSMENT` → `PENDING_DECISION` → `APPROVED` / `REJECTED` → `SETTLED`).
  - **FR6:** Claims Officer assessment, coverage checking, and deductibles recording.
  - **FR7:** Real-time claim status tracking and audit history timeline.
  - **FR8:** Management analytics reporting: Total policies, active coverage, premiums collected, settled claim payouts, and simplified claims ratio.
