package base.oopconcept;

class Vehicle {

    protected String brand = "Proton";
    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

/**
 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. use getter/setter
 *
 * declare class variables/attributes as private
 * provide public get and set methods to access and update the value of a private variable
 */
class Car extends Vehicle {

    private String modelName = "Saga";

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

/**
 * inherit attributes and methods from one class to another. We group the "inheritance concept" into two categories:
 *
 * subclass (child) - the class that inherits from another class
 * superclass (parent) - the class being inherited from
 *
 * To inherit from a class, use the extends keyword.
 * In the example below, the Car class (subclass) inherits the attributes and methods from the Vehicle class (superclass):
 */
public class Inheritance {
    public static void main(String[] args) {

        Car myCar = new Car();
        myCar.honk();
        System.out.println(myCar.brand + " " + myCar.getModelName());
    }
}
