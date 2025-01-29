package designpattern;

/**
 * 🎯 TL;DR
 * Facade = "ATM Machine" (Handles all banking operations behind the scenes)
 * Users don't need to deal with multiple systems (balance check, transactions, cash dispensing)
 * A single function (withdrawMoney) handles everything
 *
 * The Facade Pattern makes complex systems easy to use—just like withdrawing cash from an ATM!
 */

// 🏧 Client Code (Using Facade)
public class FacadePatternExample {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();

        // Withdraw $500 from an account
        bankingFacade.withdrawMoney("123456789", 500);

        // Attempt to withdraw $2000 (exceeds balance)
        bankingFacade.withdrawMoney("123456789", 2000);
    }
}

// 🎭 Facade Class (BankingFacade)
// Facade: Provides a simple interface for withdrawing money
class BankingFacade {
    private AccountVerification accountVerification;
    private BalanceCheck balanceCheck;
    private TransactionProcessor transactionProcessor;
    private CashDispenser cashDispenser;

    public BankingFacade() {
        this.accountVerification = new AccountVerification();
        this.balanceCheck = new BalanceCheck();
        this.transactionProcessor = new TransactionProcessor();
        this.cashDispenser = new CashDispenser();
    }

    // 🚀 Single method to handle everything
    public void withdrawMoney(String accountNumber, double amount) {
        System.out.println("\n🏦 Starting withdrawal process...");

        if (!accountVerification.verifyAccount(accountNumber)) {
            System.out.println("❌ Account verification failed!");
            return;
        }

        if (!balanceCheck.hasSufficientBalance(accountNumber, amount)) {
            System.out.println("❌ Insufficient balance!");
            return;
        }

        transactionProcessor.processTransaction(accountNumber, amount);
        cashDispenser.dispenseCash(amount);

        System.out.println("✅ Withdrawal successful!");
    }
}


// 🏗 Subsystem Classes (Complex Banking Operations)

// Subsystem 1: Account Verification
class AccountVerification {
    public boolean verifyAccount(String accountNumber) {
        System.out.println("✅ Account " + accountNumber + " verified.");
        return true;
    }
}

// Subsystem 2: Balance Check
class BalanceCheck {
    public boolean hasSufficientBalance(String accountNumber, double amount) {
        System.out.println("💰 Checking balance for account: " + accountNumber);
        return amount <= 1000; // Assume account has $1000 balance
    }
}

// Subsystem 3: Transaction Processor
class TransactionProcessor {
    public void processTransaction(String accountNumber, double amount) {
        System.out.println("💳 Processing withdrawal of $" + amount + " from account " + accountNumber);
    }
}

// Subsystem 4: Cash Dispenser
class CashDispenser {
    public void dispenseCash(double amount) {
        System.out.println("💵 Dispensing $" + amount);
    }
}


