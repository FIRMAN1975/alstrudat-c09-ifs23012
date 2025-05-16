package del.alstrudat.view;

import del.alstrudat.entity.*;
import del.alstrudat.model.*;
import java.util.*;

/**
 * Command-Line Interface for the e-commerce application.
 */
public class ECommerceCLI {
    private final Scanner scanner;
    private final UserModel userModel;
    private final ProductModel productModel;
    private final CartModel cartModel;
    private final OrderModel orderModel;
    private final AddressModel addressModel;
    private final CategoryModel categoryModel;
    private final NotificationModel notificationModel;
    private final ReviewModel reviewModel;
    private final TransactionModel transactionModel;
    private final WalletModel walletModel;
    private User currentUser;

    public ECommerceCLI(UserModel userModel, ProductModel productModel, CartModel cartModel,
                        OrderModel orderModel, AddressModel addressModel, CategoryModel categoryModel,
                        NotificationModel notificationModel, ReviewModel reviewModel,
                        TransactionModel transactionModel, WalletModel walletModel) {
        this.scanner = new Scanner(System.in);
        this.userModel = userModel;
        this.productModel = productModel;
        this.cartModel = cartModel;
        this.orderModel = orderModel;
        this.addressModel = addressModel;
        this.categoryModel = categoryModel;
        this.notificationModel = notificationModel;
        this.reviewModel = reviewModel;
        this.transactionModel = transactionModel;
        this.walletModel = walletModel;
        this.currentUser = null;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Sistem E-Commerce ===");
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        login();
                        break;
                    case "2":
                        register();
                        break;
                    case "3":
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        currentUser = userModel.loginUser(username, password);
        System.out.println("Login berhasil! Selamat datang, " + username + " (" + currentUser.getRole() + ").");
        if (currentUser.getRole() == User.Role.BUYER) {
            showBuyerMenu();
        } else if (currentUser.getRole() == User.Role.SELLER) {
            showSellerMenu();
        } else if (currentUser.getRole() == User.Role.ADMIN) {
            showAdminMenu();
        }
    }

    private void register() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        System.out.println("Pilih peran: 1. Pembeli 2. Penjual 3. Admin");
        String roleChoice = scanner.nextLine().trim();
        User.Role role;
        switch (roleChoice) {
            case "1":
                role = User.Role.BUYER;
                break;
            case "2":
                role = User.Role.SELLER;
                break;
            case "3":
                role = User.Role.ADMIN;
                break;
            default:
                throw new IllegalArgumentException("Peran tidak valid.");
        }

        userModel.registerUser(username, password, role);
        walletModel.createWallet(username, 0.0); // Buat dompet saat registrasi
        System.out.println("Registrasi berhasil! Silakan login.");
    }

    private void showBuyerMenu() {
        while (true) {
            System.out.println("\n=== Menu Pembeli ===");
            System.out.println("1. Lihat Semua Produk");
            System.out.println("2. Cari Produk berdasarkan Kategori");
            System.out.println("3. Tambah ke Keranjang");
            System.out.println("4. Lihat Keranjang");
            System.out.println("5. Hapus dari Keranjang");
            System.out.println("6. Checkout");
            System.out.println("7. Lihat Pesanan");
            System.out.println("8. Kelola Dompet");
            System.out.println("9. Kelola Alamat");
            System.out.println("10. Lihat Notifikasi");
            System.out.println("11. Tambah Ulasan");
            System.out.println("12. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        showAllProducts();
                        break;
                    case "2":
                        searchProductsByCategory();
                        break;
                    case "3":
                        addToCart();
                        break;
                    case "4":
                        viewCart();
                        break;
                    case "5":
                        removeFromCart();
                        break;
                    case "6":
                        checkout();
                        break;
                    case "7":
                        viewOrders();
                        break;
                    case "8":
                        manageWallet();
                        break;
                    case "9":
                        manageAddresses();
                        break;
                    case "10":
                        viewNotifications();
                        break;
                    case "11":
                        addReview();
                        break;
                    case "12":
                        currentUser = null;
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showSellerMenu() {
        while (true) {
            System.out.println("\n=== Menu Penjual ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Perbarui Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Lihat Produk Saya");
            System.out.println("5. Lihat Pesanan Pembeli");
            System.out.println("6. Kelola Dompet");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        addProduct();
                        break;
                    case "2":
                        updateProduct();
                        break;
                    case "3":
                        deleteProduct();
                        break;
                    case "4":
                        viewSellerProducts();
                        break;
                    case "5":
                        viewBuyerOrders();
                        break;
                    case "6":
                        manageWallet();
                        break;
                    case "7":
                        currentUser = null;
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n=== Menu Admin ===");
            System.out.println("1. Lihat Semua Pengguna");
            System.out.println("2. Hapus Pengguna");
            System.out.println("3. Tambah Kategori");
            System.out.println("4. Perbarui Kategori");
            System.out.println("5. Hapus Kategori");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        viewAllUsers();
                        break;
                    case "2":
                        deleteUser();
                        break;
                    case "3":
                        addCategory();
                        break;
                    case "4":
                        updateCategory();
                        break;
                    case "5":
                        deleteCategory();
                        break;
                    case "6":
                        currentUser = null;
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void showAllProducts() {
        List<Product> products = productModel.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk tersedia.");
            return;
        }
        System.out.println("\n=== Daftar Produk ===");
        System.out.printf("%-10s %-20s %-10s %-5s %-15s%n", "ID", "Nama", "Harga", "Stok", "Penjual");
        for (Product p : products) {
            System.out.printf("%-10s %-20s %-10.2f %-5d %-15s%n",
                    p.getId(), p.getName(), p.getPrice(), p.getStock(), p.getSellerUsername());
        }
    }

    private void searchProductsByCategory() {
        System.out.println("\n=== Daftar Kategori ===");
        List<Category> categories = categoryModel.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("Tidak ada kategori tersedia.");
            return;
        }
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName() + " (ID: " + categories.get(i).getId() + ")");
        }
        System.out.print("Masukkan ID kategori: ");
        String categoryId = scanner.nextLine().trim();

        List<Product> products = productModel.getProductsByCategory(categoryId);
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk di kategori ini.");
            return;
        }
        System.out.println("\n=== Produk di Kategori ===");
        System.out.printf("%-10s %-20s %-10s %-5s %-15s%n", "ID", "Nama", "Harga", "Stok", "Penjual");
        for (Product p : products) {
            System.out.printf("%-10s %-20s %-10.2f %-5d %-15s%n",
                    p.getId(), p.getName(), p.getPrice(), p.getStock(), p.getSellerUsername());
        }
    }

    private void addToCart() {
        showAllProducts();
        System.out.print("Masukkan ID produk: ");
        String productId = scanner.nextLine().trim();
        System.out.print("Masukkan jumlah: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Jumlah harus berupa angka.");
        }

        cartModel.addToCart(currentUser.getUsername(), productId, quantity);
        System.out.println("Produk berhasil ditambahkan ke keranjang.");
    }

    private void viewCart() {
        Cart cart = cartModel.getCart(currentUser.getUsername());
        if (cart.getItems().isEmpty()) {
            System.out.println("Keranjang kosong.");
            return;
        }
        System.out.println("\n=== Isi Keranjang ===");
        System.out.printf("%-10s %-20s %-10s %-10s%n", "ID Produk", "Nama", "Jumlah", "Harga");
        double total = 0;
        for (CartItem item : cart.getItems()) {
            Product product = productModel.getProduct(item.getProductId());
            if (product != null) {
                System.out.printf("%-10s %-20s %-10d %-10.2f%n",
                        item.getProductId(), product.getName(), item.getQuantity(), product.getPrice());
                total += product.getPrice() * item.getQuantity();
            }
        }
        System.out.println("Total: " + total);
    }

    private void removeFromCart() {
        viewCart();
        System.out.print("Masukkan ID produk untuk dihapus: ");
        String productId = scanner.nextLine().trim();

        cartModel.removeFromCart(currentUser.getUsername(), productId);
        System.out.println("Produk berhasil dihapus dari keranjang.");
    }

    private void checkout() {
        Cart cart = cartModel.getCart(currentUser.getUsername());
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Keranjang kosong. Tambahkan produk terlebih dahulu.");
        }

        double total = 0;
        List<Product> orderProducts = new ArrayList<>();
        Map<String, Integer> productQuantities = new HashMap<>();
        for (CartItem item : cart.getItems()) {
            Product product = productModel.getProduct(item.getProductId());
            if (product == null) {
                throw new IllegalStateException("Produk tidak ditemukan: " + item.getProductId());
            }
            total += product.getPrice() * item.getQuantity();
            productQuantities.put(product.getId(), item.getQuantity());
            for (int i = 0; i < item.getQuantity(); i++) {
                orderProducts.add(product);
            }
        }

        List<Address> addresses = addressModel.getAddresses(currentUser.getUsername());
        if (addresses.isEmpty()) {
            throw new IllegalStateException("Tambahkan alamat terlebih dahulu.");
        }
        System.out.println("\n=== Pilih Alamat Pengiriman ===");
        for (int i = 0; i < addresses.size(); i++) {
            System.out.println((i + 1) + ". " + addresses.get(i).getDetail());
        }
        System.out.print("Masukkan nomor alamat: ");
        int addressIndex;
        try {
            addressIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nomor alamat harus berupa angka.");
        }
        if (addressIndex < 0 || addressIndex >= addresses.size()) {
            throw new IllegalArgumentException("Nomor alamat tidak valid.");
        }

        Wallet wallet = walletModel.getWallet(currentUser.getUsername());
        if (wallet == null) {
            throw new IllegalStateException("Dompet tidak ditemukan. Buat dompet terlebih dahulu.");
        }
        if (wallet.getBalance() < total) {
            throw new IllegalStateException("Saldo dompet tidak cukup. Saldo saat ini: " + wallet.getBalance());
        }

        // Deduct funds from buyer's wallet
        walletModel.deductFunds(currentUser.getUsername(), total);

        // Create order
        String orderId = UUID.randomUUID().toString();
        orderModel.createOrder(orderId, currentUser.getUsername(), orderProducts, true);

        // Create transaction
        String transactionId = UUID.randomUUID().toString();
        transactionModel.addTransaction(transactionId, orderId, currentUser.getUsername(), "Wallet", total, Transaction.Status.PAID);

        // Notify sellers
        for (CartItem item : cart.getItems()) {
            Product product = productModel.getProduct(item.getProductId());
            if (product != null) {
                String message = "Pesanan baru untuk produk " + product.getName() + " (ID: " + orderId + ")";
                notificationModel.addNotification(product.getSellerUsername(), message);
            }
        }

        // Clear cart
        cartModel.clearCart(currentUser.getUsername());

        System.out.println("Checkout berhasil! ID Pesanan: " + orderId);
        System.out.println("Total pembayaran: " + total);
        System.out.println("Alamat pengiriman: " + addresses.get(addressIndex).getDetail());
    }

    private void viewOrders() {
        List<Order> orders = orderModel.getOrdersByBuyer(currentUser.getUsername());
        if (orders.isEmpty()) {
            System.out.println("Tidak ada pesanan.");
            return;
        }
        System.out.println("\n=== Daftar Pesanan ===");
        System.out.printf("%-36s %-15s %-10s %-10s%n", "ID Pesanan", "Jumlah Produk", "Total", "Status");
        for (Order order : orders) {
            System.out.printf("%-36s %-15d %-10.2f %-10s%n",
                    order.getId(), order.getProducts().size(), order.getTotal(), order.isPaid() ? "Dibayar" : "Belum Dibayar");
            System.out.println("Produk:");
            Map<String, Integer> productCounts = new HashMap<>();
            for (Product p : order.getProducts()) {
                productCounts.merge(p.getId(), 1, Integer::sum);
            }
            for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
                Product p = productModel.getProduct(entry.getKey());
                if (p != null) {
                    System.out.printf("  - %s (Jumlah: %d, Harga: %.2f)%n", p.getName(), entry.getValue(), p.getPrice());
                }
            }
        }
    }

    private void manageWallet() {
        while (true) {
            Wallet wallet = walletModel.getWallet(currentUser.getUsername());
            System.out.println("\n=== Kelola Dompet ===");
            System.out.println("Saldo saat ini: " + (wallet != null ? wallet.getBalance() : 0.0));
            System.out.println("1. Tambah Saldo");
            System.out.println("2. Transfer Saldo");
            System.out.println("3. Lihat Riwayat Transaksi");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Masukkan jumlah untuk ditambahkan: ");
                        double amount;
                        try {
                            amount = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Jumlah harus berupa angka.");
                        }
                        walletModel.addFunds(currentUser.getUsername(), amount);
                        System.out.println("Saldo berhasil ditambahkan.");
                        break;
                    case "2":
                        System.out.print("Masukkan username tujuan: ");
                        String toUsername = scanner.nextLine().trim();
                        System.out.print("Masukkan jumlah untuk ditransfer: ");
                        try {
                            amount = Double.parseDouble(scanner.nextLine().trim());
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Jumlah harus berupa angka.");
                        }
                        walletModel.transferFunds(currentUser.getUsername(), toUsername, amount);
                        System.out.println("Transfer berhasil.");
                        break;
                    case "3":
                        List<WalletTransaction> transactions = walletModel.getTransactionHistory(currentUser.getUsername());
                        if (transactions.isEmpty()) {
                            System.out.println("Tidak ada riwayat transaksi.");
                        } else {
                            System.out.println("\n=== Riwayat Transaksi ===");
                            System.out.printf("%-36s %-10s %-10s %-20s%n", "ID Transaksi", "Tipe", "Jumlah", "Deskripsi");
                            for (WalletTransaction t : transactions) {
                                System.out.printf("%-36s %-10s %-10.2f %-20s%n",
                                        t.getTransactionId(), t.getType(), t.getAmount(), t.getDescription());
                            }
                        }
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void manageAddresses() {
        while (true) {
            System.out.println("\n=== Kelola Alamat ===");
            List<Address> addresses = addressModel.getAddresses(currentUser.getUsername());
            if (addresses.isEmpty()) {
                System.out.println("Tidak ada alamat tersedia.");
            } else {
                for (int i = 0; i < addresses.size(); i++) {
                    System.out.println((i + 1) + ". " + addresses.get(i).getDetail());
                }
            }
            System.out.println("1. Tambah Alamat");
            System.out.println("2. Perbarui Alamat");
            System.out.println("3. Hapus Alamat");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Masukkan detail alamat: ");
                        String detail = scanner.nextLine().trim();
                        addressModel.addAddress(currentUser.getUsername(), detail);
                        System.out.println("Alamat berhasil ditambahkan.");
                        break;
                    case "2":
                        System.out.print("Masukkan detail alamat lama: ");
                        String oldDetail = scanner.nextLine().trim();
                        System.out.print("Masukkan detail alamat baru: ");
                        String newDetail = scanner.nextLine().trim();
                        addressModel.updateAddress(currentUser.getUsername(), oldDetail, newDetail);
                        System.out.println("Alamat berhasil diperbarui.");
                        break;
                    case "3":
                        System.out.print("Masukkan detail alamat untuk dihapus: ");
                        String detailToDelete = scanner.nextLine().trim();
                        addressModel.deleteAddress(currentUser.getUsername(), detailToDelete);
                        System.out.println("Alamat berhasil dihapus.");
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Opsi tidak valid. Coba lagi.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void viewNotifications() {
        List<Notification> notifications = notificationModel.getNotifications(currentUser.getUsername());
        if (notifications.isEmpty()) {
            System.out.println("Tidak ada notifikasi.");
            return;
        }
        System.out.println("\n=== Notifikasi ===");
        for (int i = 0; i < notifications.size(); i++) {
            Notification n = notifications.get(i);
            System.out.println((i + 1) + ". " + n.getMessage() + (n.isRead() ? " (Dibaca)" : " (Belum Dibaca)"));
        }
        System.out.print("Masukkan nomor notifikasi untuk ditandai sebagai dibaca (0 untuk kembali): ");
        String choice = scanner.nextLine().trim();
        try {
            int index = Integer.parseInt(choice);
            if (index == 0) {
                return;
            }
            if (index < 1 || index > notifications.size()) {
                throw new IllegalArgumentException("Nomor notifikasi tidak valid.");
            }
            Notification n = notifications.get(index - 1);
            notificationModel.markNotificationAsRead(currentUser.getUsername(), n.getMessage());
            System.out.println("Notifikasi ditandai sebagai dibaca.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Masukkan angka yang valid.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addReview() {
        List<Order> orders = orderModel.getOrdersByBuyer(currentUser.getUsername());
        if (orders.isEmpty()) {
            System.out.println("Anda belum memiliki pesanan untuk diulas.");
            return;
        }
        System.out.println("\n=== Pilih Pesanan untuk Diulas ===");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". Pesanan ID: " + orders.get(i).getId());
        }
        System.out.print("Masukkan nomor pesanan: ");
        int orderIndex;
        try {
            orderIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Nomor pesanan harus berupa angka.");
        }
        if (orderIndex < 0 || orderIndex >= orders.size()) {
            throw new IllegalArgumentException("Nomor pesanan tidak valid.");
        }

        Order order = orders.get(orderIndex);
        System.out.println("\nProduk dalam pesanan:");
        Map<String, Integer> productCounts = new HashMap<>();
        for (Product p : order.getProducts()) {
            productCounts.merge(p.getId(), 1, Integer::sum);
        }
        List<Product> uniqueProducts = new ArrayList<>();
        for (String productId : productCounts.keySet()) {
            Product p = productModel.getProduct(productId);
            if (p != null) {
                uniqueProducts.add(p);
                System.out.println("- " + p.getName() + " (ID: " + p.getId() + ")");
            }
        }
        System.out.print("Masukkan ID produk untuk diulas: ");
        String productId = scanner.nextLine().trim();
        Product product = productModel.getProduct(productId);
        if (product == null || !productCounts.containsKey(productId)) {
            throw new IllegalArgumentException("Produk tidak valid atau tidak ada dalam pesanan.");
        }

        System.out.print("Masukkan rating (1-5): ");
        int rating;
        try {
            rating = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Rating harus berupa angka.");
        }
        System.out.print("Masukkan komentar: ");
        String comment = scanner.nextLine().trim();

        reviewModel.addReview(productId, product, currentUser.getUsername(), rating, comment);
        System.out.println("Ulasan berhasil ditambahkan.");
    }

    private void addProduct() {
        System.out.println("\n=== Daftar Kategori ===");
        List<Category> categories = categoryModel.getAllCategories();
        if (categories.isEmpty()) {
            throw new IllegalStateException("Tidak ada kategori tersedia. Hubungi admin.");
        }
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName() + " (ID: " + categories.get(i).getId() + ")");
        }
        System.out.print("Masukkan ID kategori: ");
        String categoryId = scanner.nextLine().trim();
        if (categoryModel.getCategory(categoryId) == null) {
            throw new IllegalArgumentException("ID kategori tidak valid.");
        }

        System.out.print("Masukkan ID produk: ");
        String productId = scanner.nextLine().trim();
        System.out.print("Masukkan nama produk: ");
        String name = scanner.nextLine().trim();
        System.out.print("Masukkan harga: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Harga harus berupa angka.");
        }
        System.out.print("Masukkan stok: ");
        int stock;
        try {
            stock = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Stok harus berupa angka.");
        }

        productModel.addProduct(productId, name, price, stock, currentUser.getUsername(), categoryId);
        System.out.println("Produk berhasil ditambahkan.");
    }

    private void updateProduct() {
        viewSellerProducts();
        System.out.print("Masukkan ID produk untuk diperbarui: ");
        String productId = scanner.nextLine().trim();
        Product product = productModel.getProduct(productId);
        if (product == null || !product.getSellerUsername().equals(currentUser.getUsername())) {
            throw new IllegalArgumentException("Produk tidak ditemukan atau bukan milik Anda.");
        }

        System.out.println("\n=== Daftar Kategori ===");
        List<Category> categories = categoryModel.getAllCategories();
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName() + " (ID: " + categories.get(i).getId() + ")");
        }
        System.out.print("Masukkan ID kategori baru: ");
        String categoryId = scanner.nextLine().trim();
        if (categoryModel.getCategory(categoryId) == null) {
            throw new IllegalArgumentException("ID kategori tidak valid.");
        }

        System.out.print("Masukkan nama baru: ");
        String name = scanner.nextLine().trim();
        System.out.print("Masukkan harga baru: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Harga harus berupa angka.");
        }
        System.out.print("Masukkan stok baru: ");
        int stock;
        try {
            stock = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Stok harus berupa angka.");
        }

        productModel.updateProduct(productId, name, price, stock, categoryId);
        System.out.println("Produk berhasil diperbarui.");
    }

    private void deleteProduct() {
        viewSellerProducts();
        System.out.print("Masukkan ID produk untuk dihapus: ");
        String productId = scanner.nextLine().trim();
        Product product = productModel.getProduct(productId);
        if (product == null || !product.getSellerUsername().equals(currentUser.getUsername())) {
            throw new IllegalArgumentException("Produk tidak ditemukan atau bukan milik Anda.");
        }

        productModel.deleteProduct(productId);
        System.out.println("Produk berhasil dihapus.");
    }

    private void viewSellerProducts() {
        List<Product> products = productModel.getProductsBySeller(currentUser.getUsername());
        if (products.isEmpty()) {
            System.out.println("Anda belum memiliki produk.");
            return;
        }
        System.out.println("\n=== Produk Saya ===");
        System.out.printf("%-10s %-20s %-10s %-5s %-15s%n", "ID", "Nama", "Harga", "Stok", "Kategori");
        for (Product p : products) {
            Category category = categoryModel.getCategory(p.getCategoryId());
            String categoryName = category != null ? category.getName() : "Tidak Diketahui";
            System.out.printf("%-10s %-20s %-10.2f %-5d %-15s%n",
                    p.getId(), p.getName(), p.getPrice(), p.getStock(), categoryName);
        }
    }

    private void viewBuyerOrders() {
        List<Product> sellerProducts = productModel.getProductsBySeller(currentUser.getUsername());
        if (sellerProducts.isEmpty()) {
            System.out.println("Anda belum memiliki produk yang dipesan.");
            return;
        }
        List<Order> allOrders = orderModel.getOrdersByBuyer(null); // Get all orders
        List<Order> relevantOrders = new ArrayList<>();
        for (Order order : allOrders) {
            for (Product p : order.getProducts()) {
                if (sellerProducts.stream().anyMatch(sp -> sp.getId().equals(p.getId()))) {
                    relevantOrders.add(order);
                    break;
                }
            }
        }
        if (relevantOrders.isEmpty()) {
            System.out.println("Tidak ada pesanan untuk produk Anda.");
            return;
        }
        System.out.println("\n=== Pesanan Pembeli ===");
        System.out.printf("%-36s %-15s %-10s %-10s%n", "ID Pesanan", "Pembeli", "Total", "Status");
        for (Order order : relevantOrders) {
            System.out.printf("%-36s %-15s %-10.2f %-10s%n",
                    order.getId(), order.getBuyerUsername(), order.getTotal(), order.isPaid() ? "Dibayar" : "Belum Dibayar");
            System.out.println("Produk Anda dalam pesanan:");
            Map<String, Integer> productCounts = new HashMap<>();
            for (Product p : order.getProducts()) {
                if (sellerProducts.stream().anyMatch(sp -> sp.getId().equals(p.getId()))) {
                    productCounts.merge(p.getId(), 1, Integer::sum);
                }
            }
            for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
                Product p = productModel.getProduct(entry.getKey());
                if (p != null) {
                    System.out.printf("  - %s (Jumlah: %d, Harga: %.2f)%n", p.getName(), entry.getValue(), p.getPrice());
                }
            }
        }
    }

    private void viewAllUsers() {
        List<User> users = userModel.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Tidak ada pengguna terdaftar.");
            return;
        }
        System.out.println("\n=== Daftar Pengguna ===");
        System.out.printf("%-15s %-10s%n", "Username", "Peran");
        for (User u : users) {
            System.out.printf("%-15s %-10s%n", u.getUsername(), u.getRole());
        }
    }

    private void deleteUser() {
        viewAllUsers();
        System.out.print("Masukkan username untuk dihapus: ");
        String username = scanner.nextLine().trim();
        if (username.equals(currentUser.getUsername())) {
            throw new IllegalArgumentException("Anda tidak dapat menghapus akun Anda sendiri.");
        }
        userModel.updatePassword(username, null); // Simulate deletion by invalidating user
        System.out.println("Pengguna berhasil dihapus.");
    }

    private void addCategory() {
        System.out.print("Masukkan ID kategori: ");
        String id = scanner.nextLine().trim();
        System.out.print("Masukkan nama kategori: ");
        String name = scanner.nextLine().trim();

        categoryModel.addCategory(id, name);
        System.out.println("Kategori berhasil ditambahkan.");
    }

    private void updateCategory() {
        System.out.println("\n=== Daftar Kategori ===");
        List<Category> categories = categoryModel.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("Tidak ada kategori tersedia.");
            return;
        }
        for (Category c : categories) {
            System.out.println(c.getId() + ": " + c.getName());
        }
        System.out.print("Masukkan ID kategori untuk diperbarui: ");
        String id = scanner.nextLine().trim();
        System.out.print("Masukkan nama baru: ");
        String name = scanner.nextLine().trim();

        categoryModel.updateCategory(id, name);
        System.out.println("Kategori berhasil diperbarui.");
    }

    private void deleteCategory() {
        System.out.println("\n=== Daftar Kategori ===");
        List<Category> categories = categoryModel.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("Tidak ada kategori tersedia.");
            return;
        }
        for (Category c : categories) {
            System.out.println(c.getId() + ": " + c.getName());
        }
        System.out.print("Masukkan ID kategori untuk dihapus: ");
        String id = scanner.nextLine().trim();

        categoryModel.deleteCategory(id);
        System.out.println("Kategori berhasil dihapus.");
    }
}