package del.alstrudat.entity;

public class Transaction {
    public enum Status {
        PENDING, PAID, FAILED
    }

    private final String transactionId;
    private final String orderId;
    private final String buyerUsername;
    private final String paymentMethod;
    private final double amount;
    private final Status status;

    public Transaction(String transactionId, String orderId, String buyerUsername, String paymentMethod, double amount, Status status) {
        validateString(transactionId, "Transaction ID");
        validateString(orderId, "Order ID");
        validateString(buyerUsername, "Buyer username");
        validateString(paymentMethod, "Payment method");
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status tidak valid: tidak boleh null.");
        }
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.buyerUsername = buyerUsername;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Transaction{transactionId='" + transactionId + "', orderId='" + orderId + "', buyerUsername='" + buyerUsername + "', amount=" + amount + ", status=" + status + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}