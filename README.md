# Dining Philosophers Problem - Solution & Implementation

The Dining Philosophers Problem is a classic synchronization problem that illustrates challenges in concurrent algorithm design, such as deadlock and resource starvation.

## Problem Description

Five philosophers dine together at a round table. Each philosopher has their own plate, and there is one fork between each pair of adjacent plates. The philosophers alternate between thinking and eating. To eat, a philosopher must have both the left and right forks. 

### Key Behaviors:
- Think unless the left fork is available; when it is, pick it up.
- Think unless the right fork is available; when it is, pick it up.
- When both forks are held, eat for a fixed amount of time.
- Put the left fork down.
- Put the right fork down.
- Repeat the process.

The challenge is to design an algorithm that ensures all philosophers can eat without deadlock or starvation.

## How to Run
1. **Prerequisites**: Ensure you have Java JDK installed (version 17 or higher).
2. **Compilation**: Compile the Java files using: javac App.java
