package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public class WalletRepositoryImpl implements WalletRepository {
    private final Map<String, Wallet> wallets;

    public WalletRepositoryImpl() {
        this.wallets = new HashMap<>();
    }

    @Override
    public void addWallet(Wallet wallet) {
        validateWallet(wallet);
        if (wallets.containsKey(wallet.getUsername())) {
            throw new IllegalArgumentException("Dompet sudah ada untuk pengguna ini.");
        }
        wallets.put(wallet.getUsername(), wallet);
    }

    @Override
    public Wallet getWalletByUsername(String username) {
        validateString(username, "Username");
        return wallets.get(username);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        validateWallet(wallet);
        if (!wallets.containsKey(wallet.getUsername())) {
            throw new IllegalArgumentException("Dompet tidak ditemukan.");
        }
        wallets.put(wallet.getUsername(), wallet);
    }

    @Override
    public void deleteWallet(String username) {
        validateString(username, "Username");
        if (wallets.remove(username) == null) {
            throw new IllegalArgumentException("Dompet tidak ditemukan.");
        }
    }

    @Override
    public String toString() {
        return "WalletRepositoryImpl{wallets=" + wallets.size() + "}";
    }

    private void validateWallet(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Dompet tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}