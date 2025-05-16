package del.alstrudat.repository;
import del.alstrudat.entity.*;
import java.util.*;


public interface TransactionRepository {
    void addTransaction(Transaction transaction);
    Transaction getTransactionById(String transactionId);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(String transactionId);
    List<Transaction> getTransactionsByBuyer(String buyerUsername);
}