package designpattern;

/**
 *
 * TL;DR
 * 🔹 Burger = Final product
 * 🔹 builder = Step-by-step builder
 * 🔹 build() = Creates the final burger
 *
 * Builder (Building object step by step)
 * 			✔	Helps construct complex objects step by step
 * 			✔	Avoids messy constructors with too many parameters
 * 			✔	Improves readability → Code looks clean and easy to follow
 * 		if use lombok can easily annotate this class with @Builder
 */
// 1️⃣ The Product - Burger (final object to be built)
class Burger {
    private String bun;
    private String patty;
    private String cheese;
    private String sauce;
    private boolean lettuce;
    private boolean tomato;

    // 🏗 Private constructor (only Builder can create it)
    private Burger(builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.sauce = builder.sauce;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }

    @Override
    public String toString() {
        return "Burger with " + bun + ", " + patty + ", " + (cheese != null ? cheese + ", " : "")
                + (sauce != null ? sauce + ", " : "") + (lettuce ? "lettuce, " : "")
                + (tomato ? "tomato, " : "") + "done!";
    }

    // 2️⃣ Builder Class (Step-by-step construction)
    static class builder {
        private String bun;
        private String patty;
        private String cheese;
        private String sauce;
        private boolean lettuce;
        private boolean tomato;

        // Required fields
        public builder(String bun, String patty) {
            this.bun = bun;
            this.patty = patty;
        }

        // Optional ingredients (chained methods)
        public builder addCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public builder addSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public builder addLettuce() {
            this.lettuce = true;
            return this;
        }

        public builder addTomato() {
            this.tomato = true;
            return this;
        }

        // 🔥 Final build() method to create Burger
        public Burger build() {
            return new Burger(this);
        }
    }
}

// 3️⃣ Usage Example
public class BuilderPatternExample {
    public static void main(String[] args) {
        // Creating a custom burger using the builder
        Burger myBurger = new Burger.builder("Sesame Bun", "Beef Patty")
                .addCheese("Cheddar")
                .addSauce("BBQ")
                .addLettuce()
                .build();

        System.out.println(myBurger);
    }
}
