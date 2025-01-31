package base.oopconcept;

// Java encapsulation

class EncapsulatedModel {

    // private variables declared
    // these can only be accessed by
    // public methods of class
    private String myName;
    private int myRoll;
    private int myAge;

    // get method for myName to access
    // private variable myName
    public String getMyName() {
        return myName;
    }

    // set method for myName to access
    // private variable myName
    public void setMyName(String myName) {
        this.myName = myName;
    }

    // get method for myRoll to access
    // private variable myRoll
    public int getMyRoll() {
        return myRoll;
    }

    // set method for myRoll to access
    // private variable myRoll
    public void setMyRoll(int myRoll) {
        this.myRoll = myRoll;
    }

    // get method for myAge to access
    // private variable myAge
    public int getMyAge() {
        return myAge;
    }

    // set method for myAge to access
    // private variable myAge
    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }
}

public class Encapsulation {
    public static void main(String[] args)
    {
        EncapsulatedModel o = new EncapsulatedModel();

        // setting values of the variables
        o.setMyName("Harsh");
        o.setMyAge(19);
        o.setMyRoll(51);

        // Displaying values of the variables
        System.out.println("My name: " + o.getMyName());
        System.out.println("My age: " + o.getMyAge());
        System.out.println("My roll: " + o.getMyRoll());

        // Direct access of myRoll is not possible
        // due to encapsulation
//         System.out.println("My roll: " +
//         o.myRoll);
    }
}
