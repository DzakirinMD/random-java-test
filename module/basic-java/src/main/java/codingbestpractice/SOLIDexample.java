package codingbestpractice;

// 🟢 S: Single Responsibility Principle (SRP)
// This class only handles user-related operations.
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// 🟢 O: Open/Closed Principle (OCP)
// New notification types can be added without modifying existing code.
interface Notification {
    void send(User user, String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(User user, String message) {
        System.out.println("📧 Sending Email to " + user.getName() + ": " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(User user, String message) {
        System.out.println("📱 Sending SMS to " + user.getName() + ": " + message);
    }
}

// 🟢 L: Liskov Substitution Principle (LSP)
// Any subclass of Notification can be used without breaking the code.
class NotificationService {
    private Notification notification;

    public NotificationService(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser(User user, String message) {
        notification.send(user, message);
    }
}

// 🟢 I: Interface Segregation Principle (ISP)
// Interfaces are small and specific, not forcing unused methods.
interface PaymentProcessor {
    void processPayment(double amount);
}

interface RefundProcessor {
    void processRefund(double amount);
}

class CreditCardPayment implements PaymentProcessor, RefundProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("💳 Processing credit card payment: $" + amount);
    }

    @Override
    public void processRefund(double amount) {
        System.out.println("💰 Processing credit card refund: $" + amount);
    }
}

// 🟢 D: Dependency Inversion Principle (DIP)
// High-level modules depend on abstractions, not concrete classes.
class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(double amount) {
        paymentProcessor.processPayment(amount);
    }
}

// 🏁 Main class to test the SOLID principles
public class SOLIDexample {
    public static void main(String[] args) {
        User user = new User("Zack");

        // OCP & LSP in action 🚀
        NotificationService emailService = new NotificationService(new EmailNotification());
        NotificationService smsService = new NotificationService(new SMSNotification());

        emailService.notifyUser(user, "Welcome to the platform! 🎉");
        smsService.notifyUser(user, "Your OTP is 123456 🔐");

        // DIP & ISP in action 🔄
        PaymentProcessor creditCard = new CreditCardPayment();
        PaymentService paymentService = new PaymentService(creditCard);
        paymentService.makePayment(100.0);
    }
}
