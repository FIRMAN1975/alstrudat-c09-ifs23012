package del.alstrudat.entity;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final String username;
    private double balance;
    private final List<WalletTransaction> transactions;

    public Wallet(String username, double balance) {
        validateString(username, "Username");
        if (balance < 0) {
            throw new IllegalArgumentException("Saldo tidak valid: tidak boleh negatif.");
        }
        this.username = username;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public List<WalletTransaction> getTransactions() {
        return transactions;
    }

    public void addFunds(double amount, String transactionId, String description) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        this.balance += amount;
        transactions.add(new WalletTransaction(transactionId, WalletTransaction.Type.DEPOSIT, amount, description));
    }

    public void deductFunds(double amount, String transactionId, String description) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Saldo tidak cukup.");
        }
        this.balance -= amount;
        transactions.add(new WalletTransaction(transactionId, WalletTransaction.Type.DEBIT, amount, description));
    }

    @Override
    public String toString() {
        return "Wallet{username='" + username + "', balance=" + balance + ", transactions=" + transactions.size() + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}