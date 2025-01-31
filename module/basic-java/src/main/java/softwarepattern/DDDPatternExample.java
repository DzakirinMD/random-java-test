package softwarepattern;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 🎯 TL;DR
 * DDD structures software based on real-world business concepts
 * A BankAccount is an Entity, Money is a Value Object, and Transactions follow business rules
 * A Repository handles data, a Service executes logic, and Events notify changes
 * Just like a real bank, this system ensures structured, maintainable operations! 🏦💰🚀
 */
// 1️⃣ Value Object (Immutable, No Identity)
class Money {
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money subtract(Money other) {
        if (this.amount.compareTo(other.amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        return new Money(this.amount.subtract(other.amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "$" + amount;
    }
}

// 2️⃣ Entity (Has Identity: Account Number)
class BankAccount {
    private final String accountNumber;
    private Money balance;

    public BankAccount(Money initialDeposit) {
        this.accountNumber = UUID.randomUUID().toString();
        this.balance = initialDeposit;
    }

    public String getAccountNumber() { return accountNumber; }
    public Money getBalance() { return balance; }

    public void deposit(Money amount) {
        this.balance = balance.add(amount);
        System.out.println("💰 Deposited " + amount + " into account: " + accountNumber);
    }

    public void withdraw(Money amount) {
        this.balance = balance.subtract(amount);
        System.out.println("💸 Withdrawn " + amount + " from account: " + accountNumber);
    }

    @Override
    public String toString() {
        return "BankAccount{Account='" + accountNumber + "', Balance=" + balance + "}";
    }
}

// 3️⃣ Repository (Simulating Database)
class BankingRepository {
    private Map<String, BankAccount> accountDatabase = new HashMap<>();

    public void save(BankAccount account) {
        accountDatabase.put(account.getAccountNumber(), account);
        System.out.println("📦 Account saved: " + account);
    }

    public BankAccount findByAccountNumber(String accountNumber) {
        return accountDatabase.get(accountNumber);
    }
}

// 4️⃣ Service (Business Logic)
class TransactionService {
    private BankingRepository repository;

    public TransactionService(BankingRepository repository) {
        this.repository = repository;
    }

    public String openAccount(BigDecimal initialDeposit) {
        BankAccount account = new BankAccount(new Money(initialDeposit));
        repository.save(account);
        return account.getAccountNumber();
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        BankAccount account = repository.findByAccountNumber(accountNumber);
        if (account != null) {
            account.deposit(new Money(amount));
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    public void withdraw(String accountNumber, BigDecimal amount) {
        BankAccount account = repository.findByAccountNumber(accountNumber);
        if (account != null) {
            try {
                account.withdraw(new Money(amount));
                System.out.println("✅ Withdrawal successful.");
            } catch (IllegalArgumentException e) {
                System.out.println("❌ " + e.getMessage());
            }
        } else {
            System.out.println("❌ Account not found!");
        }
    }
}

// 5️⃣ Domain Event (Notification System)
interface TransactionEvent {
    void notify(String message);
}

class EmailNotification implements TransactionEvent {
    @Override
    public void notify(String message) {
        System.out.println("📧 Email Sent: " + message);
    }
}

// 6️⃣ Main Class (Simulating Transactions)
public class DDDPatternExample{
    public static void main(String[] args) {
        BankingRepository bankingRepository = new BankingRepository();
        TransactionService transactionService = new TransactionService(bankingRepository);
        EmailNotification notification = new EmailNotification();

        // 1️⃣ Open a new bank account
        String accountNumber = transactionService.openAccount(new BigDecimal("1000.00"));

        // 2️⃣ Deposit money
        transactionService.deposit(accountNumber, new BigDecimal("500.00"));
        notification.notify("Deposited $500.00 into account: " + accountNumber);

        // 3️⃣ Withdraw money
        transactionService.withdraw(accountNumber, new BigDecimal("300.00"));
        notification.notify("Withdrawn $300.00 from account: " + accountNumber);

        // 4️⃣ Attempt to withdraw more than balance
        transactionService.withdraw(accountNumber, new BigDecimal("2000.00"));
        notification.notify("Attempted to withdraw $2000.00 from account: " + accountNumber);
    }
}
