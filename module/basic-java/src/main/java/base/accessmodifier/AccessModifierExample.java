package base.accessmodifier;

// Class to demonstrate different access modifiers
public class AccessModifierExample {

    // Public variable: accessible from anywhere
    public String publicField = "I am public!";

    // Protected variable: accessible within the same package and subclasses
    protected String protectedField = "I am protected!";

    // Package-private (default) variable: accessible within the same package
    String defaultField = "I have package-private (default) access!";

    // Private variable: accessible only within this class
    private String privateField = "I am private!";

    // Public method: accessible from anywhere
    public void publicMethod() {
        System.out.println("Public Method: " + publicField);
    }

    // Protected method: accessible within the same package and subclasses
    protected void protectedMethod() {
        System.out.println("Protected Method: " + protectedField);
    }

    // Package-private (default) method: accessible within the same package
    void defaultMethod() {
        System.out.println("Default (Package-Private) Method: " + defaultField);
    }

    // Private method: accessible only within this class
    private void privateMethod() {
        System.out.println("Private Method: " + privateField);
    }

    // Method to demonstrate access to all members within the class
    public void showAccess() {
        System.out.println("Accessing all members within the class:");
        System.out.println(publicField);  // Accessible
        System.out.println(protectedField); // Accessible
        System.out.println(defaultField); // Accessible
        System.out.println(privateField); // Accessible
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
