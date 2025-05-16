package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;
import java.util.stream.Collectors;


public class TransactionRepositoryImpl implements TransactionRepository {
    private final Map<String, Transaction> transactions;

    public TransactionRepositoryImpl() {
        this.transactions = new HashMap<>();
    }

    @Override
    public void addTransaction(Transaction transaction) {
        validateTransaction(transaction);
        if (transactions.containsKey(transaction.getTransactionId())) {
            throw new IllegalArgumentException("Transaksi sudah ada.");
        }
        transactions.put(transaction.getTransactionId(), transaction);
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        validateString(transactionId, "Transaction ID");
        return transactions.get(transactionId);
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        validateTransaction(transaction);
        if (!transactions.containsKey(transaction.getTransactionId())) {
            throw new IllegalArgumentException("Transaksi tidak ditemukan.");
        }
        transactions.put(transaction.getTransactionId(), transaction);
    }

    @Override
    public void deleteTransaction(String transactionId) {
        validateString(transactionId, "Transaction ID");
        if (transactions.remove(transactionId) == null) {
            throw new IllegalArgumentException("Transaksi tidak ditemukan.");
        }
    }

    @Override
    public List<Transaction> getTransactionsByBuyer(String buyerUsername) {
        validateString(buyerUsername, "Buyer username");
        return transactions.values().stream()
                .filter(t -> t.getBuyerUsername().equals(buyerUsername))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "TransactionRepositoryImpl{transactions=" + transactions.size() + "}";
    }

    private void validateTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaksi tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}