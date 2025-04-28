package del.alstrudat;

import del.alstrudat.model.*;
import del.alstrudat.repository.*;
import del.alstrudat.view.ECommerceCLI;

/**
 * Main application class for the e-commerce system.
 */
public class App {
    public static void main(String[] args) {
        // Initialize repositories
        UserRepository userRepository = new UserRepositoryImpl();
        ProductRepository productRepository = new ProductRepositoryImpl();
        CartRepository cartRepository = new CartRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        AddressRepository addressRepository = new AddressRepositoryImpl();
        CategoryRepository categoryRepository = new CategoryRepositoryImpl();
        NotificationRepository notificationRepository = new NotificationRepositoryImpl();
        ReviewRepository reviewRepository = new ReviewRepositoryImpl();
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();
        WalletRepository walletRepository = new WalletRepositoryImpl();

        // Initialize models
        UserModel userModel = new UserModelImpl(userRepository);
        ProductModel productModel = new ProductModelImpl(productRepository);
        CartModel cartModel = new CartModelImpl(cartRepository, productModel);
        OrderModel orderModel = new OrderModelImpl(orderRepository);
        AddressModel addressModel = new AddressModelImpl(addressRepository);
        CategoryModel categoryModel = new CategoryModelImpl(categoryRepository);
        NotificationModel notificationModel = new NotificationModelImpl(notificationRepository);
        ReviewModel reviewModel = new ReviewModelImpl(reviewRepository);
        TransactionModel transactionModel = new TransactionModelImpl(transactionRepository);
        WalletModel walletModel = new WalletModelImpl(walletRepository);

        // Initialize CLI
        ECommerceCLI cli = new ECommerceCLI(
                userModel, productModel, cartModel, orderModel, addressModel,
                categoryModel, notificationModel, reviewModel, transactionModel, walletModel
        );

        // Start the application
        cli.start();
    }
}