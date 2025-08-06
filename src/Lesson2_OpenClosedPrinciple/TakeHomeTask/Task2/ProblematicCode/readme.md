### 🧨 Problem in the Original Code

Let's imagine you are an insurance company developer. You have a method to calculate insurance quotes based on vehicle type. So, you write a method like this:

```java
public InsuranceQuote evaluateInsurance(Vehicle vehicle) {
    if (vehicle instanceof Car) {
        // do car logic
    } else if (vehicle instanceof Truck) {
        // do truck logic
    } else {
        throw new IllegalArgumentException("Unsupported vehicle");
    }
}
```

At first glance, this looks fine, right? But there is a big **design problem** here!

> ✅ This code **violates the Open-Closed Principle** of SOLID.

### What is Open-Closed Principle?

> A class should be **open for extension but closed for modification**.

In simple words:

* You should be able to **add new functionality** without **changing the existing code**.
* Your code should be flexible enough to **extend behavior**, not rewrite it.

---

### 😖 Why this Original Code is BAD?

* Every time a **new vehicle type** is added (e.g. `Bike`, `Bus`, `Scooter`, etc.), you have to go inside the `VehicleInsuranceEvaluator` class and **add a new `if-else` or `instanceof` check**.
* This becomes messy, hard to read, and error-prone.
* It’s like fixing a leaking pipe every time you add a new vehicle — not scalable at all!

Let’s say 5 new vehicle types get added... now you have a long ugly `if-else` chain.
This also **breaks** existing tested logic if someone makes a mistake.

---

### ✅ How Did We Improve It? (The OCP-Friendly Way)

Now, let’s flip the design using **polymorphism**.

> Instead of checking which type of vehicle it is inside the evaluator, we **let each vehicle handle its own insurance logic**.

We made `Vehicle` an **abstract class** and forced every subclass to implement its own insurance logic.

Here’s how we improved it step-by-step:

---

### ✨ Refactored Design Breakdown

#### 🧱 Step 1: Make `Vehicle` Abstract

```java
public abstract class Vehicle {
    public abstract InsuranceQuote evaluateInsurance();
}
```

* This makes sure **every vehicle must define how its insurance will be calculated**.
* No need to rely on external logic for `Car`, `Truck`, etc.

---

#### 🚗 Step 2: Subclasses Handle Their Own Logic

```java
public class Car extends Vehicle {
    @Override
    public InsuranceQuote evaluateInsurance() {
        // Car-specific logic here
        return new InsuranceQuote();
    }
}

public class Truck extends Vehicle {
    @Override
    public InsuranceQuote evaluateInsurance() {
        // Truck-specific logic here
        return new InsuranceQuote();
    }
}
```

* Now each vehicle **owns its behavior**.
* If you want to add a `Bike`, just create a `Bike` class and write its insurance logic — no touching old code!

---

#### ✅ Step 3: Simplify Evaluator

```java
public class VehicleInsuranceEvaluator {
    public InsuranceQuote evaluateInsurance(Vehicle vehicle) {
        return vehicle.evaluateInsurance();
    }
}
```

* The evaluator doesn’t care what type the vehicle is. It just **delegates** the work to the vehicle itself.
* No need for `if-else`, no more modifying code when adding new vehicles!

---

### 🧪 Example Usage

```java
Vehicle car = new Car();
Vehicle truck = new Truck();

VehicleInsuranceEvaluator evaluator = new VehicleInsuranceEvaluator();

InsuranceQuote carQuote = evaluator.evaluateInsurance(car);
InsuranceQuote truckQuote = evaluator.evaluateInsurance(truck);
```

* Easy to understand.
* Add more vehicles in the future? ✅ No problem — the evaluator stays untouched!

---

### 🎯 Final Benefits of the Refactored Code

| ✅ Benefit                  | 📝 Explanation                                                        |
| -------------------------- | --------------------------------------------------------------------- |
| **Follows OCP**            | You can extend with new vehicle types without changing existing code. |
| **No `instanceof` checks** | Cleaner, object-oriented design.                                      |
| **Polymorphism in action** | Vehicles know how to handle themselves.                               |
| **Highly maintainable**    | Future-proof design; easy to scale.                                   |
| **Unit test friendly**     | Each class can be tested independently.                               |

---

### 💬 Explanation

Imagine you're working in an insurance company, and your job is to write a program that calculates insurance quotes based on what kind of vehicle someone owns — like a car or a truck. So, naturally, you might think of writing a method that checks the type of the vehicle using `if-else` statements or `instanceof` checks. For example, if it's a `Car`, do car-related logic; if it's a `Truck`, do truck logic. At first, this seems to work just fine. But here’s the real problem: every time a **new type of vehicle** is introduced, like a `Bike`, `Bus`, or `Scooter`, you’ll have to go back into that same method and **change the original code** by adding more `if-else` blocks. This is exactly what the **Open-Closed Principle (OCP)** says you shouldn’t do. The OCP is one of the SOLID principles of good software design, and it says: your code should be **open for extension**, but **closed for modification**. That means you should be able to **add new things (like new vehicle types)** without having to go back and change existing code that was already working. But in our first version, we are doing the opposite — we are modifying code again and again, which can easily cause bugs and make the system harder to maintain.

To solve this, we used a **better design with polymorphism**. Instead of letting the evaluator decide which type of vehicle it is, we changed the design so that each **vehicle knows how to calculate its own insurance**. So, we made the `Vehicle` class abstract, and inside it, we declared an abstract method like `evaluateInsurance()`. Now, all specific types of vehicles like `Car` and `Truck` **inherit from Vehicle** and provide their **own logic** for calculating insurance. This means that when a new vehicle type like `Bike` is added, you just create a new class `Bike` and implement the `evaluateInsurance()` method — and that’s it! No need to touch or change the old code at all. This way, your `VehicleInsuranceEvaluator` becomes super clean — it just calls `vehicle.evaluateInsurance()` and doesn’t care what type of vehicle it is. So, whether it's a car, truck, or anything new in the future, the evaluator never changes. This makes your system much more **flexible, scalable, and safe**. It also makes your code more **organized and testable** — each class has its own responsibility and doesn’t interfere with others.

To put it simply — in the old version, it’s like a teacher who keeps checking every student’s work by name, and has to learn about new students every time someone new joins. But in the improved version, every student (i.e. vehicle) is smart enough to check their own work — the teacher just says, “Do your thing!” That’s cleaner, faster, and just makes life easier for everyone.

---
