package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class TransactionModelImpl implements TransactionModel {
    private final TransactionRepository transactionRepository;

    public TransactionModelImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addTransaction(String transactionId, String orderId, String buyerUsername, String paymentMethod, double amount, Transaction.Status status) {
        transactionRepository.addTransaction(new Transaction(transactionId, orderId, buyerUsername, paymentMethod, amount, status));
    }

    @Override
    public Transaction getTransaction(String transactionId) {
        return transactionRepository.getTransactionById(transactionId);
    }

    @Override
    public List<Transaction> getTransactionsByBuyer(String buyerUsername) {
        return transactionRepository.getTransactionsByBuyer(buyerUsername);
    }

    @Override
    public String toString() {
        return "TransactionModelImpl{transactionRepository=" + transactionRepository + "}";
    }
}