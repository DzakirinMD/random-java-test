package questions.oopconcept;

class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog says: bow wow");
    }
}

/**
 * Inheritance lets us inherit attributes and methods from another class.
 * Polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.
 *
 * For example, think of a superclass called Animal that has a method called animalSound().
 * Subclasses of Animals could be Pigs, Cats, Dogs, Birds - And they also have their own implementation of an
 * animal sound (the pig oinks, and the cat meows, etc.)
 *
 * Why And When To Use "Inheritance" and "Polymorphism"?
 * - It is useful for code re-usability: reuse attributes and methods of an existing class when you create a new class.
 * The difference between inheritance and polymorphism
 *
 * In inheritance, we create new classes that inherit features of the superclass while polymorphism decides what form of
 * method to execute. Inheritance applies to classes, whereas polymorphism applies to methods.
 */
public class Polymorphism {
    public static void main(String[] args) {

        Animal animal = new Animal();
        Animal pig = new Pig();
        Animal dog = new Dog();

        animal.animalSound();
        pig.animalSound();
        dog.animalSound();

    }
}
