package del.alstrudat.repository;

import del.alstrudat.entity.*;


public interface WalletRepository {
    void addWallet(Wallet wallet);
    Wallet getWalletByUsername(String username);
    void updateWallet(Wallet wallet);
    void deleteWallet(String username);
}