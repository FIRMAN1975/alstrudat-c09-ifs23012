package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface WalletModel {
    void createWallet(String username, double initialBalance);
    Wallet getWallet(String username);
    void addFunds(String username, double amount);
    void deductFunds(String username, double amount);
    void transferFunds(String username, String toUsername, double amount);
    List<WalletTransaction> getTransactionHistory(String username);
}