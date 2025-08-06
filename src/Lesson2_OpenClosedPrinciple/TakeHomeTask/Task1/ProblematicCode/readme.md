### 🔍 Original Design vs SOLID Principle Violation

Let's start with the original Java code that calculates discounts based on the type of product:

```java
enum ProductType {
    ELECTRONICS,
    CLOTHING;
}

class Product {
    ProductType type;
    double price;

    double getPrice() {
        return price;
    }

    ProductType getType() {
        return type;
    }
}

public class DiscountCalculator {
    public double calculateDiscount(Product product) {
        if (product.getType() == ProductType.ELECTRONICS) {
            return product.getPrice() * 0.10;
        } else if (product.getType() == ProductType.CLOTHING) {
            return product.getPrice() * 0.20;
        }
        return 0;
    }
}
```

At first glance, the above design might look clean and simple. However, **it fundamentally violates the Open-Closed Principle (OCP)** — one of the key SOLID principles of object-oriented design.

---

### ✅ What is the Open-Closed Principle?

> “A class should be open for extension but closed for modification.”

In plain words:

* You should be able to **add new features (extensions)** without changing existing code (modifications).
* Your existing, tested, and working code should remain **untouched** when new requirements come in.

---

### 🚫 Problem with the Original Code

The original `DiscountCalculator` uses **explicit condition checks (`if-else`)** to determine the discount based on the product type. This leads to several issues:

* Every time a **new product type** (like `GROCERY`, `FURNITURE`, etc.) is added, the `calculateDiscount` method must be **modified**.
* This violates the **Open-Closed Principle**, because we are **modifying old code** to add new behavior.
* The method becomes **bloated** and hard to maintain.
* The logic becomes **less reusable** and more **error-prone** as the system scales.

**Example of this anti-pattern:**

```java
else if (product.getType() == ProductType.GROCERY) {
    return product.getPrice() * 0.05;
}
```

Imagine having 50 product types — this method will end up with 50 `if-else` conditions. Messy and brittle.

---

### ✅ How to Fix It? (OCP-Compliant Design)

To follow the **Open-Closed Principle**, we **decouple the discount logic from the `DiscountCalculator`** and move it into **separate strategy classes**, each responsible for its own logic.

This is a classic case where the **Strategy Design Pattern** is a perfect fit.

---

### 🔧 Refactored OCP-Friendly Design — Step-by-Step

---

#### 1️⃣ `Product` Class (Simplified)

```java
public class Product {
    private double price;

    public Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
```

✅ **Why is this better?**
We no longer rely on `ProductType` or any enum checks. The `Product` is now **just a data object**, with pricing logic abstracted elsewhere.

---

#### 2️⃣ `DiscountStrategy` Interface

```java
public interface DiscountStrategy {
    double calculateDiscount(Product product);
}
```

✅ **Why do we need this?**
This interface acts as a **contract**. Any class that implements it must provide its own discount logic — ensuring a **common structure** across all product discounts.

---

#### 3️⃣ Strategy Implementations for Each Product Type

```java
public class ElectronicsDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.10; // 10%
    }
}
```

```java
public class ClothingDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.20; // 20%
    }
}
```

✅ **Why is this better?**

* Each product type now has its **own class** for discount logic.
* Adding a new product type (e.g., `GroceryDiscount`) means creating **one new class** — **no existing code is touched.**

---

#### 4️⃣ `DiscountCalculator` Class (Decoupled & Reusable)

```java
public class DiscountCalculator {
    public double calculate(Product product, DiscountStrategy strategy) {
        return strategy.calculateDiscount(product);
    }
}
```

✅ **Why is this awesome?**

* No `if-else` statements.
* It only performs the **calculation**, deferring the logic to the strategy passed in.
* Clean, modular, and **fully follows OCP**.

---

#### 5️⃣ `Main` Class — Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Product electronics = new Product(10000);
        Product clothing = new Product(2000);

        DiscountCalculator calculator = new DiscountCalculator();

        double eDiscount = calculator.calculate(electronics, new ElectronicsDiscount());
        double cDiscount = calculator.calculate(clothing, new ClothingDiscount());

        System.out.println("Electronics Discount: ₹" + eDiscount);
        System.out.println("Clothing Discount: ₹" + cDiscount);
    }
}
```

---

### 💚 Final Benefits — OCP in Action

| Feature                        | ❌ Old Design      | ✅ New Design (OCP-Friendly) |
| ------------------------------ | ----------------- | --------------------------- |
| Adding New Product Type        | Modify old method | Add new class only          |
| Risk of Breaking Existing Code | High              | Low                         |
| Code Readability               | Cluttered if-else | Clean, short                |
| Reusability                    | Tightly coupled   | Highly reusable             |
| Follows Open-Closed Principle  | ❌ Violates OCP    | ✅ Fully complies            |

---

### 🧠 Final Summary (Plain English)

> **Before:**
> All discount logic was bundled into one method using if-else statements.
> Every time a new product type was added, we had to edit and risk breaking old code.

> **After:**
> Each product type now has its **own strategy class**.
> You can add new types **without modifying existing logic** — making your code **cleaner, scalable, and SOLID-compliant**.

---

### Explantion:

Imagine you are building a basic discount system for a shop. You only have two types of products right now: **Electronics** and **Clothing**. So you write a class called `DiscountCalculator` that checks what type of product it is and then applies the discount. If it’s electronics, you give 10% off. If it’s clothing, you give 20% off. You do this using `if` and `else if` conditions. So far, it looks fine and works correctly. But here’s where the problem starts — later, the business grows and more product types are added: **Grocery**, **Furniture**, **Toys**, **Books**, and so on. Now, every time you want to add a new product, you must go back to the same `DiscountCalculator` class and keep adding more `if-else` statements. The class keeps growing longer and more complex. Even worse, each time you touch this class to add something new, there is a small risk you might accidentally break some existing code. For example, a typo in the electronics logic might break all electronics discounts! This makes the code **fragile** (easy to break), **bloated** (too big and messy), and **hard to maintain**. This also means your code is **violating a very important rule in clean software design** called the **Open/Closed Principle**.

The **Open/Closed Principle (OCP)** simply means that:
🧠 *“Your code should be open for extension (you should be able to add new features easily), but closed for modification (you should not have to change existing working code).”*
But in our original case, we're doing the exact opposite. We’re modifying existing code every time we add something new, which is risky and bad for long-term maintenance.

So how do we fix this?
We **restructure** the code using a better design — we apply the idea of **strategy pattern** and interfaces. Instead of putting all the discount logic inside one class that handles all product types, we create **separate classes** for each product type, and we **let each class handle its own discount rule**. So for electronics, we create a new class called `ElectronicsDiscount`, and inside it, we write: "I provide 10% discount." For clothing, we make a `ClothingDiscount` class that says: "I provide 20% discount." Each of these classes will **implement an interface**, like `DiscountStrategy`, which defines a method called `calculateDiscount(product)`. This interface is just a **promise or contract** that says: “If you want to be part of our discount system, you must have a method that calculates discount.”

Now, our main `DiscountCalculator` class becomes very clean. It **no longer decides** how much discount to apply. It just asks: “Hey strategy, how much discount do you provide for this product?” and the strategy (e.g. ElectronicsDiscount or ClothingDiscount) gives the answer. If tomorrow, we want to add a new product type like **Grocery**, we don’t have to touch the old code at all. We simply create a new class `GroceryDiscount` that also implements `DiscountStrategy` and return 5% discount. Done! 🎉 No changes to old logic, no risks of breaking anything.

This is a **perfect example of following the Open/Closed Principle**. You’re not changing existing files; you're just adding new ones. Your code is now more **modular** (each part has its own job), **easy to test**, **easy to maintain**, and **less likely to break**.
It's like giving every product type its **own little brain**, instead of relying on one big brain that handles everything. Each one knows how much discount it should give, and the main calculator doesn’t care who you are — it just uses your logic. This makes your system very **scalable** and **clean**.

---
