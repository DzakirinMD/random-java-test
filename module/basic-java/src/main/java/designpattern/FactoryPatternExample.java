package designpattern;

/**
 * 🎯 TL;DR
 * 🔹 Pizza (Product) → Different types of objects
 * 🔹 PizzaFactory (Factory) → Handles object creation
 * 🔹 Client Code → Calls the factory, gets the correct object
 */
// 1️⃣ Product Interface (Pizza) - Common structure for all pizzas
interface Pizza {
    void prepare();
}

// 2️⃣ Concrete Products (Different types of pizzas)
class CheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Cheese Pizza 🍕");
    }
}

class PepperoniPizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza 🍕");
    }
}

class VeggiePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Veggie Pizza 🍕");
    }
}

// 3️⃣ Factory Class - Creates pizzas based on type
class PizzaFactory {
    public static Pizza createPizza(String type) {
        switch (type.toLowerCase()) {
            case "cheese":
                return new CheesePizza();
            case "pepperoni":
                return new PepperoniPizza();
            case "veggie":
                return new VeggiePizza();
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}

// 4️⃣ Client Code - Ordering pizzas without worrying about how they are made
public class FactoryPatternExample {
    public static void main(String[] args) {
        Pizza pizza1 = PizzaFactory.createPizza("cheese");
        pizza1.prepare(); // Output: Preparing Cheese Pizza 🍕

        Pizza pizza2 = PizzaFactory.createPizza("pepperoni");
        pizza2.prepare(); // Output: Preparing Pepperoni Pizza 🍕

        Pizza pizza3 = PizzaFactory.createPizza("veggie");
        pizza3.prepare(); // Output: Preparing Veggie Pizza 🍕
    }
}
