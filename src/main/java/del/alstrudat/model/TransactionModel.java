package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface TransactionModel {
    void addTransaction(String transactionId, String orderId, String buyerUsername, String paymentMethod, double amount, Transaction.Status status);
    Transaction getTransaction(String transactionId);
    List<Transaction> getTransactionsByBuyer(String buyerUsername);
}