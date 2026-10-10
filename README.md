### Java Thread Test Assignment ###

## Student Information ##
~~~
- **Name:** Apurbo Kumar Roy
- **Department:** Information and Communication Technology (ICT)
- **University:** Mawlana Bhashani Science and Technology University (MBSTU)
~
## 1. Objective ##
~~~
The objective of this assignment is to understand Java multithreading and test the program under different test cases.
~~~
## 2. Project Description
This project demonstrates the use of threads in Java. The program is executed with different test cases to observe and verify its behavior.
~~~
## 3. Technologies Used ##
~~~
- Programming Language: Java
- JDK: Java Development Kit
- IDE/Editor: VS Code / IntelliJ IDEA / any Java-supported editor
~~~
## 4. Project Structure
- `src/` — Java source code
- `outputs/` — Test outputs
- `handwritten-codes/` — Photos or scanned copies of handwritten code
- `README.md` — Project documentation

## 5. How to Run ##
~~~
1. Install the Java Development Kit (JDK).
2. Open a terminal in the source code directory.
3. Compile the Java program:
   ```bash
   javac Main.java
   ```
4. Run the program:
   ```bash
   java Main
   ```

Replace `Main.java` and `Main` with the actual filename and class name used in your project.
~~~
## 6. Test Cases and Results ##
~~~
| Test Case | Input/Condition | Expected Result | Actual Result |
|---|---|---|---|
| Test Case 1 | Normal input | Program executes correctly | Add actual result |
| Test Case 2 | Boundary condition | Program handles the condition correctly | Add actual result |
| Test Case 3 | Additional test condition | Program behaves as expected | Add actual result |

Update this table according to the actual test cases required by the assignment. Do not add invented outputs.
~~~
## 7. Program Output

# Java Thread Test Assignment — Output and Results

## 1. Test Case Summary

The program was tested using seven different test cases. Each test case compares a thread-safe counter implemented with `AtomicLong` against an unsafe counter implemented with a shared `static long`.

### Thread-Safe Results

| Test Case | Threads | Increments per Thread | Expected Count | Actual Count | Difference |
|---|---:|---:|---:|---:|---:|
| TC1 | 1 | 1,000 | 1,000 | 1,000 | 0 |
| TC2 | 2 | 10,000 | 20,000 | 20,000 | 0 |
| TC3 | 5 | 10,000 | 50,000 | 50,000 | 0 |
| TC4 | 10 | 50,000 | 500,000 | 500,000 | 0 |
| TC5 | 20 | 50,000 | 1,000,000 | 1,000,000 | 0 |
| TC6 | 50 | 50,000 | 2,500,000 | 2,500,000 | 0 |
| TC7 | 100 | 50,000 | 5,000,000 | 5,000,000 | 0 |

**Observation:** The thread-safe counter produced the expected count in all seven test cases. The absolute difference and percentage difference were both zero.

---

## 2. TC1: Single-Thread Test

**Configuration**
- Number of threads: 1
- Increments per thread: 1,000
- Expected count: 1,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 1
Increments per thread: 1000
Expected count: 1000
Static count: 1000
Non-static total: 1000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 1,000 | 1,000 | 0 | 0.0000% |
| 2 | 1,000 | 1,000 | 0 | 0.0000% |
| 3 | 1,000 | 1,000 | 0 | 0.0000% |
| 4 | 1,000 | 1,000 | 0 | 0.0000% |
| 5 | 1,000 | 1,000 | 0 | 0.0000% |

**Observation:** No lost increments occurred in this single-thread test.

---

## 3. TC2: Two-Thread Test

**Configuration**
- Number of threads: 2
- Increments per thread: 10,000
- Expected count: 20,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 2
Increments per thread: 10000
Expected count: 20000
Static count: 20000
Non-static total: 20000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 20,000 | 15,633 | 4,367 | 21.8350% |
| 2 | 20,000 | 16,699 | 3,301 | 16.5050% |
| 3 | 20,000 | 13,407 | 6,593 | 32.9650% |
| 4 | 20,000 | 14,243 | 5,757 | 28.7850% |
| 5 | 20,000 | 16,232 | 3,768 | 18.8400% |

**Observation:** The unsafe counter lost increments because multiple threads accessed and updated the shared variable concurrently.

---

## 4. TC3: Five-Thread Test

**Configuration**
- Number of threads: 5
- Increments per thread: 10,000
- Expected count: 50,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 5
Increments per thread: 10000
Expected count: 50000
Static count: 50000
Non-static total: 50000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 50,000 | 33,972 | 16,028 | 32.0560% |
| 2 | 50,000 | 37,145 | 12,855 | 25.7100% |
| 3 | 50,000 | 36,248 | 13,752 | 27.5040% |
| 4 | 50,000 | 37,514 | 12,486 | 24.9720% |
| 5 | 50,000 | 27,688 | 22,312 | 44.6240% |

**Observation:** The unsafe counter showed a significant difference from the expected count due to race conditions.

---

## 5. TC4: Ten-Thread Test

**Configuration**
- Number of threads: 10
- Increments per thread: 50,000
- Expected count: 500,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 10
Increments per thread: 50000
Expected count: 500000
Static count: 500000
Non-static total: 500000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 500,000 | 361,472 | 138,528 | 27.7056% |
| 2 | 500,000 | 368,979 | 131,021 | 26.2042% |
| 3 | 500,000 | 420,027 | 79,973 | 15.9946% |
| 4 | 500,000 | 373,314 | 126,686 | 25.3372% |
| 5 | 500,000 | 424,449 | 75,551 | 15.1102% |

**Observation:** Concurrent updates caused the unsafe counter to miss a substantial number of increments.

---

## 6. TC5: Twenty-Thread Test

**Configuration**
- Number of threads: 20
- Increments per thread: 50,000
- Expected count: 1,000,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 20
Increments per thread: 50000
Expected count: 1000000
Static count: 1000000
Non-static total: 1000000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 1,000,000 | 808,909 | 191,091 | 19.1091% |
| 2 | 1,000,000 | 780,770 | 219,230 | 21.9230% |
| 3 | 1,000,000 | 762,926 | 237,074 | 23.7074% |
| 4 | 1,000,000 | 833,287 | 166,713 | 16.6713% |
| 5 | 1,000,000 | 861,601 | 138,399 | 13.8399% |

**Observation:** The unsafe counter did not preserve all increments under concurrent execution.

---

## 7. TC6: Fifty-Thread Test

**Configuration**
- Number of threads: 50
- Increments per thread: 50,000
- Expected count: 2,500,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 50
Increments per thread: 50000
Expected count: 2500000
Static count: 2500000
Non-static total: 2500000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 2,500,000 | 2,230,451 | 269,549 | 10.7820% |
| 2 | 2,500,000 | 2,356,533 | 143,467 | 5.7387% |
| 3 | 2,500,000 | 2,153,471 | 346,529 | 13.8612% |
| 4 | 2,500,000 | 2,339,981 | 160,019 | 6.4008% |
| 5 | 2,500,000 | 2,073,817 | 426,183 | 17.0473% |

**Observation:** The unsafe counter continued to lose increments. The amount of error varied between repetitions.

---

## 8. TC7: One-Hundred-Thread Test

**Configuration**
- Number of threads: 100
- Increments per thread: 50,000
- Expected count: 5,000,000

### Thread-Safe Output

```text
Mode: Thread-safe (AtomicLong)
Threads: 100
Increments per thread: 50000
Expected count: 5000000
Static count: 5000000
Non-static total: 5000000
Absolute difference: 0
Percentage difference: 0.0000%
```

### Unsafe Output — 5 Repetitions

| Run | Expected Count | Static Count | Absolute Difference | Percentage Difference |
|---|---:|---:|---:|---:|
| 1 | 5,000,000 | 4,847,560 | 152,440 | 3.0488% |
| 2 | 5,000,000 | 4,622,049 | 377,951 | 7.5590% |
| 3 | 5,000,000 | 4,380,605 | 619,395 | 12.3879% |
| 4 | 5,000,000 | 4,856,305 | 143,695 | 2.8739% |
| 5 | 5,000,000 | 4,488,039 | 511,961 | 10.2392% |

**Observation:** Even with 100 threads, the thread-safe counter returned the expected count. The unsafe counter produced different results across repetitions.

---

## 9. Overall Analysis

The experimental results demonstrate the importance of thread safety in concurrent programming.

- **Thread-safe counter:** The `AtomicLong` counter produced the expected count in every test case.
- **Unsafe counter:** The shared `static long` counter produced incorrect counts in concurrent test cases because incrementing a shared variable is not an atomic operation.
- **Single-thread execution:** TC1 produced the expected result in all five unsafe repetitions because there was only one thread.
- **Concurrent execution:** TC2 through TC7 showed lost increments in all five unsafe repetitions.
- **Repeatability:** The unsafe results varied between runs, demonstrating the nondeterministic nature of race conditions.

## 10. Conclusion

The experiment shows that using a thread-safe counter is essential when multiple threads update shared data. `AtomicLong` provides atomic increment operations and produced the correct count in all seven test cases. In contrast, using a shared `static long` without synchronization resulted in lost updates and incorrect counts during concurrent execution.

**Final Result:** The thread-safe implementation was reliable across all tested thread counts, while the unsafe implementation was affected by race conditions.

## 8. Handwritten Code ##
~~~
Add photos or scanned copies of the handwritten code in the `handwritten-codes/` directory.
~~~
## 9. Conclusion ##
~~~
This assignment helped me understand Java multithreading, program execution, and testing under different conditions.
~~~
