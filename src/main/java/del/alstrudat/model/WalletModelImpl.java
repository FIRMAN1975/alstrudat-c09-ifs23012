package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class WalletModelImpl implements WalletModel {
    private final WalletRepository walletRepository;

    public WalletModelImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void createWallet(String username, double initialBalance) {
        Wallet wallet = new Wallet(username, initialBalance);
        if (initialBalance > 0) {
            wallet.addFunds(initialBalance, UUID.randomUUID().toString(), "Saldo awal");
        }
        walletRepository.addWallet(wallet);
    }

    @Override
    public Wallet getWallet(String username) {
        return walletRepository.getWalletByUsername(username);
    }

    @Override
    public void addFunds(String username, double amount) {
        Wallet wallet = getWallet(username);
        if (wallet == null) {
            throw new IllegalArgumentException("Dompet tidak ditemukan.");
        }
        wallet.addFunds(amount, UUID.randomUUID().toString(), "Top up saldo");
        walletRepository.updateWallet(wallet);
    }

    @Override
    public void deductFunds(String username, double amount) {
        Wallet wallet = getWallet(username);
        if (wallet == null) {
            throw new IllegalArgumentException("Dompet tidak ditemukan.");
        }
        wallet.deductFunds(amount, UUID.randomUUID().toString(), "Pembayaran");
        walletRepository.updateWallet(wallet);
    }

    @Override
    public void transferFunds(String username, String toUsername, double amount) {
        Wallet fromWallet = getWallet(username);
        Wallet toWallet = getWallet(toUsername);
        if (fromWallet == null || toWallet == null) {
            throw new IllegalArgumentException("Dompet tidak ditemukan.");
        }
        fromWallet.deductFunds(amount, UUID.randomUUID().toString(), "Transfer ke " + toUsername);
        toWallet.addFunds(amount, UUID.randomUUID().toString(), "Transfer dari " + username);
        walletRepository.updateWallet(fromWallet);
        walletRepository.updateWallet(toWallet);
    }

    @Override
    public List<WalletTransaction> getTransactionHistory(String username) {
        Wallet wallet = getWallet(username);
        return wallet != null ? wallet.getTransactions() : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "WalletModelImpl{walletRepository=" + walletRepository + "}";
    }
}