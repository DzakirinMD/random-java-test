package questions;

class Student{
    int rollno;//instance variable
    String name;
    static String college ="ITS"; //static variable

    //constructor
    Student(int r, String n){
        rollno = r;
        name = n;
    }
    //method to display the values
    void display (){System.out.println(rollno+" "+name+" "+college);}
}

/**
 *  The static keyword in Java is used for memory management mainly.
 *  The static keyword belongs to the class than an instance of the class. Meaning:
 *  Static methods/attributes can be accessed without creating an object of a class.
 */
public class StaticKeyword {

    // Static method
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }

    // Main method
    public static void main(String[ ] args) {
        myStaticMethod(); // Call the static method
        // myPublicMethod(); This would output an error

        StaticKeyword myObj = new StaticKeyword(); // Create an object of Main
        myObj.myPublicMethod(); // Call the public method


        Student s1 = new Student(111,"Zaki");
        Student s2 = new Student(222,"Armen");
        //we can change the college of all objects by the single line of code
        Student.college="ACM";
        s1.display();
        s2.display();
    }
}


