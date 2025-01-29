package testaccessmodifier;

import base.accessmodifier.AccessModifierExample;

public class TestAccessModifiers {

    public static void main(String[] args) {
        AccessModifierExample example = new AccessModifierExample();

        // Accessing public members
        System.out.println(example.publicField);  // Works
        example.publicMethod();                   // Works

        // Accessing protected, default, and private members
//         System.out.println(example.protectedField); // Error (not in the same package and no inheritance)
//         System.out.println(example.defaultField);   // Error (not in the same package)
//         System.out.println(example.privateField);   // Error (not accessible outside the class)
    }
}
