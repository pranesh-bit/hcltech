# Day 07 - Java Collections Framework (List, Set, Queue)

## Topics Covered

### Collections Framework Hierarchy
- **`List` Interface:**
  - `ArrayList`: Resizable array, $O(1)$ random access read, cache locality.
  - `LinkedList`: Doubly-linked list, $O(1)$ insertions/deletions at head/tail, extra node memory overhead.
- **`Set` Interface:**
  - `HashSet`: Hash table backing, $O(1)$ lookup, unordered.
  - `LinkedHashSet`: Maintains deterministic insertion order via doubly-linked bucket entries.
  - `TreeSet`: Red-Black tree backing, $O(\log N)$ operations, sorted by natural order or `Comparator`.
- **`Queue` & `Deque` Interfaces:**
  - `ArrayDeque`: Resizable array implementation of double-ended queue; faster than `LinkedList` for FIFO and LIFO stacks without memory churn.
  - `PriorityQueue`: Unbounded priority heap order based on natural ordering or `Comparable`.
- **Iteration Integrity:**
  - Using `Iterator.remove()` to eliminate elements during traversal without triggering `ConcurrentModificationException`.

---

## Daily Hands-on Task: Library Waitlist System (`LibraryWaitlist.java`)

Demonstrates:
- `ArrayList` for indexed catalog retrieval.
- `LinkedHashSet` for duplicate-free member registration.
- `ArrayDeque` for standard FIFO queue.
- `PriorityQueue` implementing `Comparable<ReservationRequest>` for role-based reservation ordering.
- Safe removal using `Iterator.remove()`.
- Empirical nanosecond benchmark comparing `ArrayList` and `LinkedList`.

### Compilation & Execution
```bash
javac LibraryWaitlist.java
java LibraryWaitlist
```

---

## Project Task: Insurance Policy & Claims Management System

Implemented in-memory collection management in `InsuranceService.java`:
- `List<InsuranceProduct>`: Product catalog.
- `List<Policy>`: Issued policy records.
- `Set<String>`: Global registry of unique policy numbers and claim references (preventing duplicates).
- `Queue<InsuranceClaim>`: FIFO queue for claims officer review.
- Interactive implementation of **FR1** (Products), **FR2** (Policies), and **FR3** (Claims submission).
