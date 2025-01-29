# random-java-test
Note taking repo 

# Major Principles in Object-Oriented Programming (OOP)

## 1. Encapsulation
- **What it means**: Wrapping data (fields) and methods (functions) that operate on the data into a single unit (class).
- **Why it’s important**: It keeps the data safe from outside interference and misuse by restricting access. Only specific methods (getters and setters) can access or modify the data.
- **Example**: A `BankAccount` class keeps the balance private and provides methods like `deposit()` or `withdraw()` to modify it.

---

## 2. Abstraction / Interface
- **What it means**: Hiding unnecessary details and exposing only the essential features of an object.
- **Why it’s important**: It reduces complexity by focusing on what an object does rather than how it does it.
- **Example**: When you use a car, you only need to know how to drive (steering, brakes) without understanding the engine's mechanics.

---

## 3. Inheritance
- **What it means**: Creating new classes based on existing classes to reuse code and establish a relationship between them.
- **Why it’s important**: It allows for code reuse and the creation of a hierarchy.
- **Example**: A `Vehicle` class can be a parent to `Car` and `Bike` classes, which inherit common attributes like `speed` and methods like `move()`.

---

## 4. Polymorphism
- **What it means**: The ability of different objects to respond to the same method in their unique way.
- **Why it’s important**: It promotes flexibility and makes code more dynamic.
- **Example**: A method `makeSound()` can be implemented differently for a `Dog` (bark) and a `Cat` (meow), but both are called the same way.
